package com.yidu.tencloud.dao.taketosend.reorder;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoice;
import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoiceUtil;
import com.yidu.tencloud.bean.taketosend.returnGoods.ApplyGoods;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;

public interface GenerrateInvoiceMapper {
	/**
	 * 分页查询
	 * @param paramMap
	 * @return
	 */
	public List<GenerrateInvoiceUtil> findGenerrateInvoicePagenation(Map<String, Integer> paramMap);
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public int countGenerrateInvoice();
	
	/**
	 * 带条件分页查询
	 * @param paramMap
	 * @return
	 */
	public List<GenerrateInvoiceUtil> findGenerrateInvoicePagenationWithCriteria(Map<String, Object> paramMap);
	
	/**
	 * 带条件查询总记录数
	 * @return
	 */
	public int countGenerrateInvoiceWithCriteria();
	
	/**
	 * 根据工作单号查找相关信息
	 * @param workSheetNo
	 * @return
	 */
	public GenerrateInvoiceUtil findGenByWorkNo(String workSheetNo);
	
	/**
	 * 
	 * @param workSheetId
	 * @return
	 */
	public Sender findSenderByWorkSheetNo(String workSheetNo);
	
	/**
	 * 
	 * @param workSheetId
	 * @return
	 */
	public Addresses findAddressesByWorkSheetNo(String workSheetNo);

	/**
	 * 
	 * @param workSheetId
	 * @return
	 */
	public Drawer findDrawerByWorkSheetNo(String workSheetNo);

	/**
	 * 根据工作单Id查找相关信息
	 * @param workSheetId
	 * @return
	 */
	public Rule findRuleByWorkSheetNo(String workSheetNo);
	
	/**
	 * 添加
	 * @return
	 */
	public int addGenerrateInvoice(GenerrateInvoice generrateInvoice);
	
	/**
	 * 删除
	 * @return
	 */
	public int deleteGenerrateInvoice(List<String> items);
	
	/**
	 * 转移
	 * @param workSheetNo
	 * @return
	 */
	public int updateReceiverByNo(String workSheetNo);

	/**
	 * 高级查询
	 * @return
	 */
	public List<GenerrateInvoiceUtil> findGenerrateInvoiceUtilByWith(Map<String, Object> paramMap);

	/**
	 * 高级查询总记录数
	 * @return
	 */
	public int countGenerrateInvoiceUtilByWith();
	
	/**
	 * 查询所有的返货申请表
	 * @return
	 */
	public List<ApplyGoods> findAllApplyGoods(Map<String, Object> paramMap); 
	
	/**
	 * 根据返货状态查询已返货的数量
	 * @param status
	 * @return
	 */
	public int countApplyGoodsByStatus(String status);
	
}
