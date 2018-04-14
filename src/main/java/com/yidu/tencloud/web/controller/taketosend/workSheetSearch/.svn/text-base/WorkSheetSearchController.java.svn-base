package com.yidu.tencloud.web.controller.taketosend.workSheetSearch;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoiceUtil;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetSerach.WorkSheetSearch;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.taketosend.workSheetSearch.WorkSheetService;
import com.yidu.tencloud.biz.taketosend.worksheetBiz.WorkSheetBiz;

/**
 * 工作单查询控制器层
 * @author ct
 * @since 2017/12/11
 */
@RequestMapping("workSheetSearch")
@Controller
public class WorkSheetSearchController {
	/**
	 * 保留对业务逻辑层的依赖
	 */
	@Autowired
	private WorkSheetService workSheetService;

	public void setWorkSheetService(WorkSheetService workSheetService) {
		this.workSheetService = workSheetService;
	}
	
	@Autowired
	private EmpBiz empBiz;
	
	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}
	
	@Autowired
	private WorkSheetBiz workSheetBiz;
	
	public void setWorkSheetBiz(WorkSheetBiz workSheetBiz) {
		this.workSheetBiz = workSheetBiz;
	}

	@RequestMapping("/findSubJobList")
	@ResponseBody
	public Map<Object,Object> findSubJobList(@RequestBody Map<Object,Object>paramMap) throws Exception{
		//添加一个返回值map并赋值
		Map<Object,Object> map = new HashMap<Object, Object>();
		paramMap.put("orgList", empBiz.orgListToString());
		map.put("total",workSheetService.count(paramMap));
		map.put("rows", workSheetService.findSubJobList(paramMap));
		
		map.put("workSheetNo", workSheetService.findSubJobList(paramMap));
		map.put("integraliyStatus", workSheetService.findSubJobList(paramMap));
		map.put("pickup", workSheetService.findSubJobList(paramMap));
		return map;
	}
	
	@RequestMapping("/updateStatus")
	@ResponseBody
	public String updateStatus(String workSheetNo) throws Exception{
		WorkSheet workSheet = new WorkSheet();
		workSheet.setCancelStatus("作废");
		workSheet.setWorkSheetNo(workSheetNo);
		int result = workSheetService.updateStatus(workSheet);
		if(result==1) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	@RequestMapping("/updateStatusNo")
	@ResponseBody
	public String updateStatusNo(String workSheetNo) throws Exception{
		WorkSheet workSheet = new WorkSheet();
		workSheet.setCancelStatus("不作废");
		workSheet.setWorkSheetNo(workSheetNo);
		int result = workSheetService.updateStatus(workSheet);
		if(result==1) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	@RequestMapping("/print")
	public ModelAndView print(String workSheetNo)throws Exception{
		//创建一个对象，调用根据工作单号连表查询的方法
		WorkSheet workSheet = workSheetBiz.findWorkSheet(workSheetNo);
		//创建一个新的视图对象
		ModelAndView view = new ModelAndView();
		//设置视图名字，跳转到打印页面上
		view.setViewName("/jsps/TakeToSend/workSheetSearch/print");
		view.addObject("workSheet",workSheet);
		//返回视图对象
		return view;
	}
	
}
