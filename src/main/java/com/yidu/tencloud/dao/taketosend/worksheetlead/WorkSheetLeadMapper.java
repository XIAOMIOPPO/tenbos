package com.yidu.tencloud.dao.taketosend.worksheetlead;

import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLead;
/**
 * 工作单导入mapper接口
 * @author 陈玉娟
 * @since 2017年12月20日16:02:20
 */
public interface WorkSheetLeadMapper {
	/**
	 * 添加工作单
	 * @param workSheetLead 工作单对象
	 * @return 返回添加好的结果
	 */
	int addWorkSheetLead(WorkSheetLead workSheetLead);
	/**
	 * 添加基础工作单表
	 * @param workSheet 基础工作单对象
	 * @return 返回添加好的基础工作单结果
	 */
	int addWorkSheet(WorkSheet workSheet);
	/**
	 * 添加规格表
	 * @param rule 规格对象
	 * @return 返回添加好的结果
	 */
	int addRule (Rule rule);
	/**
	 * 添加寄件人表
	 * @param sender寄件人对象
	 * @return 返回添加好的结果
	 */
	int addSender(Sender sender);
	/**
	 * 添加收件人表
	 * @param addresses收件人对象
	 * @return 返回添加好的结果
	 */
	int addAddresses(Addresses addresses);
	
}
