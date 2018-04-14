package com.yidu.tencloud.web.controller.taketosend.worksheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.biz.taketosend.worksheetBiz.WorkSheetBiz;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.Num;
/**
 * 控制器
 * @author 陈涛
 *
 */
@RequestMapping("workSheet")
@Controller
public class WorkSheetController {
    /**
     * 引用业务逻辑层
     */
	@Autowired
	private WorkSheetBiz workSheetBiz;

	/**
	 * 赋值
	 * @param workSheetBiz
	 */
	public void setWorkSheetBiz(WorkSheetBiz workSheetBiz) {
		this.workSheetBiz = workSheetBiz;
	}

	/**
	 * 找到业务通知单编号集合
	 * @param workSheetNo 工作单编号
	 * @return  业务通知单集合
	 * @throws Exception
	 */
	@RequestMapping("/findBusinessNoticeNo")
	public @ResponseBody List<String> findBusinessNoticeNo(String workSheetNo)throws Exception{
		//创建map集合
		Map<String,Object> param = new HashMap<String,Object>();
		//把工作单编号放入map集合
		param.put("workSheetNo", workSheetNo);
		//找到业务通知单编号集合
		List<String> businessNoticeNoList = workSheetBiz.findBusinessNoticeNo(param);
		return businessNoticeNoList;
	}
	
	/**
	 * 查找辅助档案名
	 * @param recordName 基础档案民
	 * @return 辅助档案名集合
	 * @throws Exception
	 */
	@RequestMapping("/findHelpFile")
	public @ResponseBody List<String> findHelpFile(String recordName)throws Exception{
		//找到辅助档案名集合
		List<String> fileNameList = workSheetBiz.findHelpFile(recordName);
		return fileNameList;
	}
	
	/**
	 * 根据业务通知单查找相关信息
	 * @param businessNoticeNo 业务通知单编号
	 * @return 业务通知单对象
	 * @throws Exception
	 */
	@RequestMapping("/findBusinessRecsiptByBus")
	public @ResponseBody BusinessRecsipt findBusinessRecsiptByBus(String businessNoticeNo)throws Exception{
		//找到业务通知单对象
		BusinessRecsipt businessRecsipt = workSheetBiz.findBusinessRecsiptByBus(businessNoticeNo);
		return businessRecsipt;
	}
	
	/**
	 * 根据业务通知单查找工单
	 * @param businessNoticeNo 业务通知单编号
	 * @return 工单对象
	 * @throws Exception
	 */
	@RequestMapping("/findWorkOrderByBus")
	public @ResponseBody WorkOrder findWorkOrderByBus(String businessNoticeNo)throws Exception{
		//找到工单对象
		WorkOrder workOrder = workSheetBiz.findWorkOrderByBus(businessNoticeNo);
		return workOrder;
	}
	/**
	 * 查找工作单信息
	 * @param workSheetNo 工作单编号
	 * @return 工作单对象
	 * @throws Exception
	 */
	@RequestMapping("/findWorkSheet")
	public @ResponseBody WorkSheet findWorkSheet(String workSheetNo)throws Exception{
		//找到工作单对象
		WorkSheet workSheet = workSheetBiz.findWorkSheet(workSheetNo);
		return workSheet;
	}
	/**
	 * 添加工作单
	 * @param workSheet 工作单对象
	 * @return  字符
	 * @throws Exception
	 */
	@RequestMapping("/addWorkSheet")
	public @ResponseBody String addWorkSheet(WorkSheet workSheet,Sender sender,Addresses addresses,Rule rule)throws Exception{
		return workSheetBiz.addWorkSheet(workSheet, sender, addresses, rule);
	}
	
	/**
	 * 校验工作单唯一
	 * @param workSheetNo 工作单编号
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/validate")
	public @ResponseBody String validate(String workSheetNo)throws Exception{
		return workSheetBiz.findWorkSheetNoByWorkSheetNo(workSheetNo);
	} 
	
	/**
	 * 生成业务通知单
	 * @return 业务通知单号
	 * @throws Exception
	 */
	@RequestMapping("/createYW")
	public @ResponseBody String createYW()throws Exception{
		//流水号生成类f
		return FlowOddNumber.AtomicRangeInteger("业务通知单");
	} 
	
	/**
	 * 生成客户编号
	 * @return 客户编号
	 * @throws Exception
	 */
	@RequestMapping("/createKH")
	public @ResponseBody String createKH(String str)throws Exception{
		//编号生成类n
		return Num.creatNum(str);
	}
	
	/**
	 * 修改工作单
	 * @param workSheet 工作单对象
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/updateWorkSheet")
	public @ResponseBody String updateWorksheet(WorkSheet workSheet,Addresses addresses,Sender sender,Rule rule)throws Exception{
		return workSheetBiz.updateWorksheet(workSheet, addresses, sender, rule);
	}
	
	/**
	 * 找到所有工作单信息
	 * @param integraliyStatus 工作单完整性状态
	 * @param workSheetSource 工作单来源
	 * @return 工作单集合
	 * @throws Exception
	 */
	@RequestMapping("/findAllWorkSheet")
	public @ResponseBody Map<String,Object> findAllWorkSheet(String integraliyStatus,String workSheetSource,String drawerTime)throws Exception{
		return workSheetBiz.findAllWorkSheet(integraliyStatus,workSheetSource,drawerTime);
	}
	
	/**
	 * 画图
	 * @return 工作单数量
	 * @throws Exception
	 */
	@RequestMapping("/bargraph")
	public @ResponseBody List<Integer> bargraph()throws Exception{
		return workSheetBiz.creatBar();
	}
	
	
}
