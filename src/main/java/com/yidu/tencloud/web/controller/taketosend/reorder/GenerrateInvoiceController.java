package com.yidu.tencloud.web.controller.taketosend.reorder;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoice;
import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoiceUtil;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.taketosend.reorder.GenerrateInvoiceBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 控制器
 * @author 醉琴抚芳
 * 
 */
@Controller
@RequestMapping("/generrateI")
public class GenerrateInvoiceController {
	
	@Autowired
	private GenerrateInvoiceBiz generratB;
	
	@Autowired
	private EmpBiz empBiz;
	
	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	public void setGenerratB(GenerrateInvoiceBiz generratB) {
		this.generratB = generratB;
	}
	
	/**
	 * 删除
	 * @param workSheetNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteGenerrateInvoice")
	@ResponseBody
	public Map<String, String> deleteGenerrateInvoice(@RequestParam(value="workSheetNo[]") String[] workSheetNo)throws Exception{
		Map<String, String> paramMap = new HashMap<>();
		if(generratB.deleteGenerrateInvoice(workSheetNo)){
			paramMap.put("status", "success");
		}else {
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	
	/**
	 * 分页查询
	 * @param paramMap
	 * @return
	 */
	@RequestMapping(value="/findGenerrateInvoicePagenation",method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> findGenerrateInvoicePagenation(@RequestBody Map<String, Integer> paramMap)throws Exception{
		Map<String, Object> pickMap = new HashMap<>();
		//获得满足条件的返货标准记录数，存入响应Map中 pickMap
		pickMap.put("orgList", empBiz.orgListToString());
		pickMap.put("total",generratB.countGenerrateInvoice());
		//获得满足条件的返货记录集合，存入响应Map中 pickMap
		pickMap.put("rows", generratB.findGenerrateInvoicePagenation(paramMap));
		return pickMap;
	}
	
	/**
	 * 带条件分页查询
	 * @param paramMap
	 * @return
	 */
	@RequestMapping(value="/findGenerrateInvoicePagenationWithCriteria",method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> findGenerrateInvoicePagenationWithCriteria(@RequestBody Map<String, Object> paramMap)throws Exception{
		Map<String, Object> pickMap = new HashMap<>();
		//获得满足条件的收派标准记录数，存入响应Map中 pickMap
		pickMap.put("orgList", empBiz.orgListToString());
		pickMap.put("total",generratB.countGenerrateInvoiceWithCriteria());
		//获得满足条件的收派标准记录集合，存入响应Map中 pickMap
		pickMap.put("rows", generratB.findGenerrateInvoicePagenationWithCriteria(paramMap));
		return pickMap;
	}
	
	/**
	 * 生成返单
	 * @param generrateInvoice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addGenerrateInvoice")
	@ResponseBody
	public Map<String, Object> addGenerrateInvoice(GenerrateInvoice generrateInvoice)throws Exception{
		Map<String, Object> pickMap = new HashMap<>();
		//调用添加的方法进行判断
		if(generratB.addGenerrateInvoice(generrateInvoice)){
			pickMap.put("status", "success");
		}else {
			pickMap.put("status", "failed");
		}
		return pickMap;
	}
	
	/**
	 * 查找工作单信息
	 * @param workSheetNo 工作单编号
	 * @return 工作单对象
	 * @throws Exception
	 */
	@RequestMapping("/findSender")
	public @ResponseBody Sender findSender(String workSheetNo)throws Exception{
		Sender workSheet = generratB.findSenderByWorksheetNo(workSheetNo);
		return workSheet;
	}
	
	/**
	 * 查找工作单信息
	 * @param workSheetNo 工作单编号
	 * @return 工作单对象
	 * @throws Exception
	 */
	@RequestMapping("/findAddresses")
	public @ResponseBody Addresses findAddresses(String workSheetNo)throws Exception{
		Addresses workSheet = generratB.findAddressesByWorkSheetNo(workSheetNo);
		return workSheet;
	}

	/**
	 * 查找工作单信息
	 * @param workSheetNo 工作单编号
	 * @return 工作单对象
	 * @throws Exception
	 */
	@RequestMapping("/findDrawer")
	public @ResponseBody Drawer findDrawer(String workSheetNo)throws Exception{
		Drawer workSheet = generratB.findDrawerByWorkSheetNo(workSheetNo);
		return workSheet;
	}

	/**
	 * 查找工作单信息
	 * @param workSheetNo 工作单编号
	 * @return 工作单对象
	 * @throws Exception
	 */
	@RequestMapping("/findRule")
	public @ResponseBody Rule findRule(String workSheetNo)throws Exception{
		Rule workSheet = generratB.findRuleByWorkSheetNo(workSheetNo);
		return workSheet;
	}
	
	/**
	 * 将选中的数据传递到打印页面
	 * @param workSheetNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/print")
	public ModelAndView print(String workSheetNo)throws Exception{
		//创建一个对象，调用根据工作单号连表查询的方法
		GenerrateInvoiceUtil obj = generratB.findGenByWorkNo(workSheetNo);
		//创建一个新的视图对象
		ModelAndView view = new ModelAndView();
		//设置视图名字，跳转到打印页面上
		view.setViewName("/jsps/TakeToSend/return/print");
		view.addObject("gen",obj);
		//返回视图对象
		return view;
	}
	
	/**
	 * 将选中的数据传递到标签页面
	 * @param workSheetNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/labelPrinting")
	public ModelAndView labelPrinting(String workSheetNo)throws Exception{
		GenerrateInvoiceUtil obj = generratB.findGenByWorkNo(workSheetNo);
		System.out.println(obj);
		ModelAndView view = new ModelAndView();
		view.setViewName("/jsps/TakeToSend/return/labelPrinting");
		view.addObject("gens",obj);
		return view;
	}
	
	/**
	 * 根据工作单号修改相关信息
	 * @param workSheetNo
	 * @return
	 * @throws Excepion
	 */
	@RequestMapping("/upateReceiverByNo")
	public Map<String, Object> upateReceiverByNo(String workSheetNo)throws Exception{
		Map<String , Object> pickMap = new HashMap<>();
		if(generratB.updateReceiverByNo(workSheetNo)) {
			pickMap.put("status", "success");
		}else {
			pickMap.put("status", "failed");
		}
		return pickMap;
	}

	/**
	 * 高级查询
	 * @param paramMap
	 * @return
	 */
	@RequestMapping(value="/findGenerrateInvoiceUtilByWith")
	@ResponseBody
	public Map<String, Object> findGenerrateInvoiceUtilByWith(@RequestBody Map<String, Object> paramMap)throws Exception{
		Map<String, Object> pickMap = new HashMap<>();
		//获得满足条件的收派标准记录数，存入响应Map中 pickMap
		pickMap.put("total",generratB.countGenerrateInvoiceUtilByWith());
		//获得满足条件的收派标准记录集合，存入响应Map中 pickMap
		System.err.println(paramMap);
		pickMap.put("rows", generratB.findGenerrateInvoiceUtilByWith(paramMap));
		return pickMap;
	}
	
	/**
	 * 返货饼图统计
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/creatPie")
	public @ResponseBody List<Integer> creatPie()throws Exception{
		return generratB.creatPie();
	}
	
	/**
	 * 当日已返货的数量
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/countApplygoodsByStatus")
	public @ResponseBody int countApplygoodsByStatus(String status)throws Exception{
		return generratB.countApplyGoodsByStatus(status);
	};
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
