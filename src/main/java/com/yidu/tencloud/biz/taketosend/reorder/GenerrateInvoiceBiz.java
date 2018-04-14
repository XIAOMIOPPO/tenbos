package com.yidu.tencloud.biz.taketosend.reorder;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoice;
import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoiceUtil;
import com.yidu.tencloud.bean.taketosend.returnGoods.ApplyGoods;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;

public interface GenerrateInvoiceBiz {

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
	 * 分页查询
	 * @param paramMap
	 * @return
	 */
	public List<GenerrateInvoiceUtil> findGenerrateInvoicePagenationWithCriteria(Map<String, Object> paramMap);
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public int countGenerrateInvoiceWithCriteria();
	
	/**
	 * 
	 * @param workSheetId
	 * @return
	 */
	public Sender findSenderByWorksheetNo(String workSheetNo);
	
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
	 * 根据工作单号查找相关信息
	 * @param workSheetNo
	 * @return
	 */
	public GenerrateInvoiceUtil findGenByWorkNo(String workSheetNo);
	
	/**
	 * 添加
	 * @return
	 */
	public boolean addGenerrateInvoice(GenerrateInvoice generrateInvoice);
	
	/**
	 * 作废
	 * @return
	 */
	public boolean deleteGenerrateInvoice(String[] packAges);
	
	/**
	 * 根据工作单号更改接收单位
	 * @return
	 */
	public boolean updateReceiverByNo(String workSheetNo);
	
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
	public Map<String, Object> findAllApplyGoods(Map<String, Object> paramMap); 
	
	/**
	 * 统计图
	 * @return
	 * @throws ParseException
	 */
	List<Integer> creatPie()throws ParseException;
	
	/**
	 * 根据返货状态查询已返货的数量
	 * @param status
	 * @return
	 */
	public int countApplyGoodsByStatus(String status);
}
