package com.yidu.tencloud.web.controller.basis.regionsetting;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.basis.regionsetting.Area;
import com.yidu.tencloud.biz.basis.regionsettingbiz.RegionService;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.OutExcel;
import com.yidu.tencloud.util.POIUtil;

@Controller
@RequestMapping("/region")
public class RegionController {
	/**
	 * 对业务层进行注入
	 */
	@Autowired
	private RegionService regionSettingBiz;
	
	public void setRegionSettingBiz(RegionService regionSettingBiz) {
		this.regionSettingBiz = regionSettingBiz;
	}
	
	/**
	 * 分页查询，待条件的
	 * @param paramMap map集合
	 * @return map集合
	 */
	@RequestMapping("/findAllArea")
	@ResponseBody
	public Map<String,Object> pageQuery(@RequestBody Map<String,Object> paramMap){
		//调用分页所需的方法
		paramMap.put("total", regionSettingBiz.countArea(paramMap));
		paramMap.put("rows", regionSettingBiz.pageQuery(paramMap));
		//模糊查询的所需方法
		paramMap.put("province", regionSettingBiz.pageQuery(paramMap));
		paramMap.put("city", regionSettingBiz.pageQuery(paramMap));
		paramMap.put("county", regionSettingBiz.pageQuery(paramMap));
		
		return paramMap;
	}

	/**
	 * 添加区域
	 * @param area 区域
	 * @return map集合
	 */
	@RequestMapping("/addArea")
	@ResponseBody
	public Map<String, String> addArea(Area area){
		//创建一个map对象
		Map<String, String> paramMap = new HashMap<String,String>();
		//设置Id和默认的状态“1”
		area.setAreaId(IDGenderatorUtil.generateId());
		area.setIsUse("1");
		//调用添加方法，判断是否添加成功
		if(regionSettingBiz.addArea(area) == 1){
			//添加成功
			paramMap.put("status", "success");
		}else {
			//添加失败
			paramMap.put("status", "failed");
		}
		
		return paramMap;
	}
	
	/**
	 * 删除区域
	 * @param areaId 区域Id
	 * @return 结果
	 */
	@RequestMapping("/deleteArea")
	@ResponseBody
	public String deleteArea(String[] areaId){
		//定义一个变量
		int result =0;
		//遍历区域Id
		for (String area : areaId) {
			//调用删除方法删除区域
			result = regionSettingBiz.deleteArea(area);
		}
		//判断是否成功
		if(result == 1) {
			//删除成功
			return "success";
		}
		return "failed";
	}
	
	/**
	 * 修改区域
	 * @param area 区域对象
	 * @return map集合
	 */ 
	@RequestMapping("/updateArea")
	@ResponseBody
	public Map<String,Object> updateArea(Area area){
		//创建一个map对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//给要修改的字段赋值
		paramMap.put("province", area.getProvince());
		paramMap.put("city", area.getCity());
		paramMap.put("county", area.getCounty());
		paramMap.put("areaId", area.getAreaId());
		//调用业务层的修改方法，判断是否修改成功
		if(regionSettingBiz.updateArea(paramMap) == 1){
			//修改成功
			paramMap.put("status", "success");
		}else {
			//修改失败
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	
	/**
	 * 数据导入
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
			//创建一个集合，调用工具类中的读取文件的方法
			List<String[]> list = POIUtil.readExcel(myFile);
			//调用导入的方法，将读取到的集合放入进去
			regionSettingBiz.saveBath(list);
		} catch (IOException e) {
			flag = "0";
		}
		
		return flag;
	}
	
	/**
	 * 文件导出
	 * @param path 导出的路径
	 * @return 结果
	 * @throws Exception 异常
	 */
	@RequestMapping("/outArea")
	@ResponseBody
	public String outArea(String path) throws Exception{
		//调用工具类中的导出方法
		String result = OutExcel.outExcel(regionSettingBiz.pageQuery(null), path);
		//返回结果
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
