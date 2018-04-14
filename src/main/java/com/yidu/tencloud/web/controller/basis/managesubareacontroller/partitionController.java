package com.yidu.tencloud.web.controller.basis.managesubareacontroller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
import com.yidu.tencloud.biz.basis.managesubareabiz.impl.PartitionBizImpl;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.OutExcel;
import com.yidu.tencloud.util.OutFile;
import com.yidu.tencloud.util.POIUtil;
/**
 * 分区的控制器类
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Controller
public class partitionController {
	/**
	 * 对业务层进行注入
	 */
	@Autowired
	private PartitionBizImpl partitionBiz;

	
	public PartitionBizImpl getPartitionBiz() {
		return partitionBiz;
	}

	public void setPartitionBiz(PartitionBizImpl partitionBiz) {
		this.partitionBiz = partitionBiz;
	}
    /**
     * 查询分区带分页的方法
     * @param paramMap
     * @return map集合
     * @throws Exception
     */
	@RequestMapping(value="partitionPageQuery" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findpartitionPageQuery(@RequestBody Map<String,Object> paramMap) throws Exception{
		//调用分页所需的方法
		paramMap.put("total",partitionBiz.countPartition());
		paramMap.put("rows", partitionBiz.findPartitionQuery(paramMap));
		return paramMap;
	}
	/**
	 * 查找符合标准的分区的分页方法
	 * @param paramMap
	 * @return map集合
	 * @throws Exception
	 */
	@RequestMapping(value="partitionPageQueryWithCriteria" ,method= {RequestMethod.POST})
	@ResponseBody
   public Map<String,Object> findpartitionPageQueryWithCriteria(@RequestBody Map<String,Object> paramMap) throws Exception{
	    Map<String,Object> parMap = new HashMap<>();
	    //调用分页所需的方法
	    parMap.put("total",partitionBiz.countPartitionWithCriteria(paramMap));
	    parMap.put("rows",partitionBiz.findpartitionPageQueryWithCriteria(paramMap));
	   return parMap;
   }
	/**
	 * 添加分区的方法
	 * @param partition 分区对象
	 * @return partition 分区
	 * @throws Exception 异常
	 */
	@RequestMapping("/addPartition")
	@ResponseBody
	public Map<String,String> addPartition(Partition partition) throws Exception{
		Map<String,String> parMap = new HashMap<String,String>();
		//设置分区Id
		partition.setPartitionId(IDGenderatorUtil.generateId());
		//调用添加分区的方法
		if(partitionBiz.addPartition(partition)) {
			//添加成功
			parMap.put("status","success");
		}else {
			//添加失败
			parMap.put("status","filed");
		}
		return parMap;
	}
	/**
	 * 删除分区的方法
	 * @param partitionId 分区Id
	 * @return 是否成功
	 * @throws Exception
	 */
	@RequestMapping("/deletePartition")
	@ResponseBody
    public String deletePartition(String[] partitionId) throws Exception{
		//定义一个变量
	   boolean result = false;
	   //遍历分区Id
	   for (String string : partitionId) {
		 //调用删除方法
		result =partitionBiz.deletePartition(string);
	   }
	   //判断是否删除成功
	   if(result) {
		   //删除成功
		  return "success";
	  }else {
		  //删除失败
		  return "filed";
	  }
    }
	/**
	 * 修改分区
	 * @param partitionId 分区Id
	 * @param property 属性
	 * @return 是否修改成功
	 * @throws Exception 异常
	 */
	@RequestMapping("/updatePartition")
	@ResponseBody
	public Map<String,String> updateproperty(String partitionId,String property) throws Exception{
		//创建一个Map对象
		Map<String,String> parMap = new HashMap<String,String>();
		//设置值
		parMap.put("partitionId",partitionId);
		parMap.put("property",property); 
		//调用修改方法
		boolean result = partitionBiz.updateproperty(partitionId, property);
		//判断是否成功
		if(result) {
			//修改成功
			parMap.put("status","success");
		}else {
			//修改失败
			parMap.put("status","filed");
		}
		return parMap;
	}
	
	/**
	 * 导入Excel文件
	 * @param myFile 文件
	 * @return 是否成功
	 * @throws Exception 异常
	 */
	@RequestMapping("/uploadArea")
	@ResponseBody
	public String uploadArea(MultipartFile myFile) throws Exception{
		//定义一个变量
		String flag = "0";
		try {
			//创建集合，调用工具类中的读取文件的方法
			List<String[]> list = POIUtil.readExcel(myFile);
			//调用导入方法
			partitionBiz.saveBath(list);
		} catch (IOException e) {
			flag = "0";
		}
		return flag;
	}
	
	/**
	 * 导出Excel
	 * @param path 文件路径 
	 * @return 是否成功
	 * @throws Exception 异常
	 */
	@RequestMapping("/outArea")
	@ResponseBody
	public String outArea(String path) throws Exception{
		//调用导出方法
		String result = OutFile.outExcel(partitionBiz.findpartitionPageQueryWithCriteria(null) ,path);
		return result;
	}
}
