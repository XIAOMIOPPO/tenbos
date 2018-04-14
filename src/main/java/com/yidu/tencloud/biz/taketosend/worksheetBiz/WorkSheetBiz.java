package com.yidu.tencloud.biz.taketosend.worksheetBiz;
import java.text.ParseException;
import java.util.Date;
/**
 * 业务逻辑层接口
 * @author 陈涛
 */
import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
/**
 * 业务层接口
 * @author 陈涛
 *
 */
public interface WorkSheetBiz {
	/**
	 * 找到所有的工作单信息
	 * @param integraliyStatus 工作单完整性
	 * @param workSheetSource  工作单来源
	 * @return 工作单集合
	 */
    public Map<String,Object> findAllWorkSheet(String integraliyStatus,String workSheetSource,String drawerTime);
	
    /**
     * 找到业务通知单编号
     * @param workSheetNo 工作单编号
     * @return 编号集合
     */
	public List<String> findBusinessNoticeNo(Map<String,Object> workSheetNo);
	
	/**
	 * 找到业务通知单信息
	 * @param businessNoticeNo 业务通知单编号
	 * @return 业务通知单对象
	 */
	public BusinessRecsipt findBusinessRecsiptByBus(String businessNoticeNo);
	
	/**
	 * 找到工单信息
	 * @param businessNoticeNo 业务通知单编号
	 * @return 工单对象
	 */
	public WorkOrder findWorkOrderByBus(String businessNoticeNo);
	
	/**
	 * 找到基础档案信息
	 * @param recordName 辅助档案名
	 * @return 字符集合
	 */
	public List<String> findHelpFile(String recordName);
	
	/**
	 * 找到工作单信息
	 * @param workSheetNo 工作单编号
	 * @return 工作单对象
	 */
	public WorkSheet findWorkSheet(String workSheetNo); 
	
	/**
	 * 工作单编号唯一校验
	 * @param workSheetNo 工作单编号
	 * @return 工作单编号
	 */
	public String findWorkSheetNoByWorkSheetNo(String workSheetNo);
	
	/**
	 * 添加工作单
	 * @param workSheet 工作单对象
	 * @param sender 寄件人对象
	 * @param addresses 收件人对象
	 * @param rule 规则对象
	 * @return 字符
	 */
	public String addWorkSheet(WorkSheet workSheet,Sender sender,Addresses addresses,Rule rule);
	
	/**
	 * 修改工作单信息
	 * @param workSheet 工作单对象
	 * @param addresses 寄件人对象
	 * @param sender 收件人对象
	 * @param rule 规则对象
	 * @return 字符
	 */
    public String updateWorksheet(WorkSheet workSheet,Addresses addresses,Sender sender,Rule rule);

	List<Integer> creatBar() throws ParseException;
	
}
