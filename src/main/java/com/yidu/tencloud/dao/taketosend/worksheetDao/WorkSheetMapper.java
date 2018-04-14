package com.yidu.tencloud.dao.taketosend.worksheetDao;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.Supplement;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkTime;

/**
 * 数据访问层
 * @author 陈涛
 *
 */
public interface WorkSheetMapper {
	/**
	 * 找到所有工作单信息
	 * @param param 参数map
	 * @return 工作单集合
	 */
	public List<WorkTime> findAllWorkSheet(Map<String,Object> param);
	
	/**
	 * 找到业务通知单编号
	 * @param workSheetNo 工作单编号
	 * @return 业务通知单编号集合
	 */
	public List<String> findBusinessNoticeNo(Map<String,Object> workSheetNo);
	
	/**
	 * 找到业务通知单信息
	 * @param businessNoticeNo 业务通知单编号
	 * @return 业务通知单对象
	 */
	public BusinessRecsipt findBusinessRecsiptByBus(String businessNoticeNo);
	
	/**
	 * 找到基础档案名
	 * @param recordName 辅助档案名
	 * @return 基础档案名集合
	 */
	public List<String> findHelpFile(String recordName);
	
	/**
	 * 找到工单信息
	 * @param businessNoticeNo 业务通知单编号
	 * @return 工单对象
	 */
	public WorkOrder findWorkOrderByBus(String businessNoticeNo);
	
	/**
	 * 找到工作单信息
	 * @param workSheetNo 工作单编号
	 * @return 工作单对象
	 */
	public WorkSheet findWorkSheet(String workSheetNo);
	
	/**
	 * 找到工作单及所属信息
	 * @return 工作单集合
	 */
	public List<WorkSheet> findFour();
	
	/**
	 * 添加工作单
	 * @param workSheet 工作单对象
	 * @return 受影响行数
	 */
	public int addWorkSheet(WorkSheet workSheet);
	
	/**
	 * 添加寄件人
	 * @param sender 寄件人对象
	 * @return 受影响行数
	 */
	public int addSender(Sender sender);
	
	/**
	 * 添加收件人
	 * @param addresses 收件人对象
	 * @return 受影响行数
	 */
	public int addAddresses(Addresses addresses);
	
	/**
	 * 添加规则
	 * @param rule 规则对象
	 * @return 受影响行数
	 */
	public int addRule(Rule rule);
	
	/**
	 * 添加开单人
	 * @param drawer 开单人对象
	 * @return 受影响行数
	 */
	public int addDrawer(Drawer drawer);
	
	/**
	 * 添加补单人
	 * @param supplement 补单人对象
	 * @return 受影响行数
	 */
	public int addSupplement(Supplement supplement);
	
	/**
	 * 修改完整性状态
	 * @param workSheet 工作单对象
	 * @return 受影响行数
	 */
	public int updateStatus(WorkSheet workSheet);
	
	/**
	 * 修改工作单
	 * @param workSheet 工作单对象
	 * @return 受影响行数
	 */
	public int updateWorksheet(WorkSheet workSheet);
	
	/**
	 * 添加寄件人
	 * @param sender 寄件人对象
	 * @return 受影响行数
	 */
	public int updateSender(Sender sender);
	
	/**
	 * 添加收件人
	 * @param addresses 收件人对象
	 * @return 受影响行数
	 */
	public int updateAddresses(Addresses addresses);
	
	/**
	 * 修改规则
	 * @param rule 规则对象
	 * @return 受影响行数
	 */
	public int updateRule(Rule rule);
	
	/**
	 * 修改补单人
	 * @param supplement 补单人对象
	 * @return 受影响行数
	 */
	public int updateSupplement(Supplement supplement); 
}
