package com.yidu.tencloud.web.controller.basis.basisrecordcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.basisrecord.BasisFiles;
import com.yidu.tencloud.bean.basis.basisrecord.HelpFiles;
import com.yidu.tencloud.biz.basis.basisrecordbiz.BasisFilesBiz;
/**
 * 基础档案控制器类
 * @author 陈玉娟
 * @since 2017年11月16日09:47:05
 */
@Controller
@RequestMapping("/basisFiles")
public class BasisFilesController {
	/**
	 * 依赖注入basisFilesBiz
	 */
	@Autowired
	private BasisFilesBiz basisFilesBiz;
	public void setBasisFilesBiz(BasisFilesBiz basisFilesBiz) {
		this.basisFilesBiz = basisFilesBiz;
	}
	/**
	 * 查找所有基础档案
	 * @param paramMap参数
	 * @return 查找到的结果
	 */
	@RequestMapping("/findAllBasisFiles")
	@ResponseBody
	public Map<String, Object> findAllBasisFiles(@RequestBody Map<String, Object> paramMap) {
		//创建一个map接口对象
		Map<String, Object> param = new HashMap<>();
		//调用查找所有总数的方法
		param.put("total", basisFilesBiz.countBasisFiles(paramMap));
		//调用查找所有的方法
		param.put("rows", basisFilesBiz.findAllBasisFiles(paramMap));
		//调用查找所有的方法查找基础档案名
		param.put("recordName", basisFilesBiz.findAllBasisFiles(paramMap));
		return param;

	}
	/**
	 * 添加基础档案
	 * @param basisFiles 基础档案对象
	 * @return 返回结果
	 */
	@RequestMapping("/addBasisFiles")
	@ResponseBody
	public Map<String, Object> addBasisFiles(BasisFiles basisFiles) {
		//定义一个map接口
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//判断查找到的基础档案名是否相同,相同返回false
		if(basisFilesBiz.findBasisFilesByRecordName(basisFiles.getRecordName()) == false) {
			//状态 基础档案名称
			paramMap.put("status", "recordName");		
		}else {
			//判断是否添加成功
			if (basisFilesBiz.addBasisFiles(basisFiles) ==1) {
				//操作成功
				paramMap.put("status", "success");
			} else {
				//操作失败
				paramMap.put("status", "failed");
			}
		}	
		return paramMap;
	}
	

	
	/**
	 * 修改基础档案
	 * @param basisFiles 基础档案对象
	 * @return 返回结果
	 */
	@RequestMapping("/updateBasisFiles")
	@ResponseBody
	public Map<String, Object> updateBasisFiles(BasisFiles basisFiles) {
		//定义一个map接口
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//判断基础档案名称是否相同,相同返回false
		if(basisFilesBiz.findBasisFilesByRecordName(basisFiles.getRecordName()) == false) {
			//基础档案名
			paramMap.put("status", "recordName");
		}else {
			//判断是否修改成功
			if(basisFilesBiz.updateBasisFiles(basisFiles)) {
				//操作成功
				paramMap.put("status", "success");
			}else {
				//操作失败
				paramMap.put("status", "failed");
			}
		}
		return paramMap;
	}
	/**
	 * 根据名字查找基础档案
	 * @return 返回结果
	 */
	@RequestMapping("/findAllRecordName")
	@ResponseBody
	public List<BasisFiles> findAllRecordName() {
		//定义一个基础档案集合,调用业务层方法查找所有基础档案名称
		List<BasisFiles> basisFileList = basisFilesBiz.findAllRecordName();
		//返回基础档案集合
		return basisFileList;
	}
	/**
	 * 查找所有辅助档案
	 * @param paramMap参数
	 * @return 返回查找到的结果
	 */
	@RequestMapping("/findAllHelpFiles")
	@ResponseBody
	public Map<String, Object> findAllHelpFiles(@RequestBody Map<String, Object> paramMap) {
		//定义一个map接口
		Map<String, Object> param = new HashMap<>();
		//调用方法查找所有总数
		param.put("total", basisFilesBiz.countHelpFiles(paramMap));
		//调用方法查找所有辅助档案
		param.put("rows", basisFilesBiz.findAllHelpFiles(paramMap));
		//辅助档案名 调用方法查找所有辅助档案
		param.put("fileName", basisFilesBiz.findAllHelpFiles(paramMap));
		//助记码 调用方法查找所有辅助档案
		param.put("mnemonicCode", basisFilesBiz.findAllHelpFiles(paramMap));
		return param;
		

	}
	/**
	 * 添加辅助档案
	 * @param helpFiles 辅助档案对象
	 * @return 返回结果
	 */
	@RequestMapping("/addHelpFiles")
	@ResponseBody
	public Map<String, Object> addHelpFiles(HelpFiles helpFiles) {
		//定义一个map接口
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//判断辅助档案名称是否相同 相同返回false
		if(basisFilesBiz.findHelpFilesByFileName(helpFiles.getFileName()) == false) {
			//辅助档案名称
			paramMap.put("status", "fileName");
		}else {
			//判断是否添加成功
			if (basisFilesBiz.addHelpFiles(helpFiles) == 1) {
				//操作成功
				paramMap.put("status", "success");
			} else {
				//操作失败
				paramMap.put("status", "failed");
			}
		}
		return paramMap;

	}
	/**
	 * 修改辅助档案
	 * @param helpFiles辅助档案对象
	 * @return 返回结果
	 */
	@RequestMapping("/updateHelpFiles")
	@ResponseBody
	public Map<String, Object> updateHelpFiles(HelpFiles helpFiles) {
		//定义一个map集合
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//判断辅助档案名称是否相同 相同返回false
		if(basisFilesBiz.findHelpFilesByFileName(helpFiles.getFileName()) ==false) {
			//辅助档案名称
			paramMap.put("status", "fileName");
		}else {
			//判断是否修改成功
			if(basisFilesBiz.updateHelpFiles(helpFiles)) {
				//操作成功
				paramMap.put("status", "success");
			}else {
				//操作失败
				paramMap.put("status", "failed");
			}
		}
		return paramMap;
	}

	/**
	 * 删除基础档案
	 * @param recordIds 基础档案ID
	 * @return 返回结果
	 */
	@RequestMapping("/deleteBasisFiles")
	@ResponseBody
	public String deleteBasisFiles(String[] recordIds) {
		//定义一个初始变量 初始值为false
		boolean result = false;
		//遍历循环
		for(String recordId:recordIds) {
			//根据ID删除一条档案
			result = basisFilesBiz.deleteBasisFiles(recordId);
		}
		//判断结果是否成功
		if (result) {
			//成功
			return "success";
		} else {
			//失败
			return "failed";
		}
	}
	/**
	 * 删除辅助档案
	 * @param fileIds 辅助档案ID
	 * @return 返回结果
	 */
	@RequestMapping("/deleteHelpFiles")
	@ResponseBody
	public String deleteHelpFiles(String[] fileIds) {
		//定义一个初始变量 赋值为false
		boolean result = false;
		//遍历循环
		for(String fileId:fileIds) {
			//根据ID删除一条档案
			result = basisFilesBiz.deleteHelpFiles(fileId);
		}
		//判断结果是否成功
		if (result) {
			//成功
			return "success";
		} else {
			//失败
			return "failed";
		}
	}
	
	/**
	 * 通过标记找到档案
	 * @param code标记
	 * @return 返回找到的结果
	 */
	@RequestMapping("/options")
	@ResponseBody
	public List<HelpFiles> findOptionByCode(String remarlk) {
		//通过标记找到父类名
		return basisFilesBiz.findFileByParentName(remarlk);
	}

}
