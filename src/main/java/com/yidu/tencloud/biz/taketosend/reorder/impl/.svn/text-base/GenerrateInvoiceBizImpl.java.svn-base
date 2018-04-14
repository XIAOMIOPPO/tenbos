package com.yidu.tencloud.biz.taketosend.reorder.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoice;
import com.yidu.tencloud.bean.taketosend.reorder.GenerrateInvoiceUtil;
import com.yidu.tencloud.bean.taketosend.returnGoods.ApplyGoods;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.biz.taketosend.reorder.GenerrateInvoiceBiz;
import com.yidu.tencloud.dao.taketosend.reorder.GenerrateInvoiceMapper;
import com.yidu.tencloud.dao.taketosend.worksheetDao.WorkSheetMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
@Service
public class GenerrateInvoiceBizImpl implements GenerrateInvoiceBiz{
	@Autowired
	private GenerrateInvoiceMapper generrate;
	@Autowired
	private WorkSheetMapper workMapper;
	
	@Override
	public List<GenerrateInvoiceUtil> findGenerrateInvoicePagenation(Map<String, Integer> paramMap) {
		return generrate.findGenerrateInvoicePagenation(paramMap);
	}
	
	public void setWorkMapper(WorkSheetMapper workMapper) {
		this.workMapper = workMapper;
	}

	@Override
	public int countGenerrateInvoice() {
		return generrate.countGenerrateInvoice();
	}

	@Override
	public List<GenerrateInvoiceUtil> findGenerrateInvoicePagenationWithCriteria(Map<String, Object> paramMap) {
		System.err.println(paramMap);
		return generrate.findGenerrateInvoicePagenationWithCriteria(paramMap);
	}

	@Override
	public int countGenerrateInvoiceWithCriteria() {
		return generrate.countGenerrateInvoiceWithCriteria();
	}

	@Override
	public boolean deleteGenerrateInvoice(String[] workSheetNo) {
		List<String> items = new ArrayList<>();
		for (String item : workSheetNo) {
			items.add(item);
		}
		return generrate.deleteGenerrateInvoice(items)>0 ? true : false;
	}

	@Override
	public boolean addGenerrateInvoice(GenerrateInvoice generrateInvoice) {
		//创建一个工作单对象
		WorkSheet work = new WorkSheet();
		//给返货标志设值
		work.setWorkSheetNo(generrateInvoice.getWorkSheetNo());
		work.setCargoReturnSign("是");
		workMapper.updateWorksheet(work);
		generrateInvoice.setGenerateInvoiceId(IDGenderatorUtil.generateId());
		return generrate.addGenerrateInvoice(generrateInvoice) > 0 ? true : false;
	}
	
	@Override
	public GenerrateInvoiceUtil findGenByWorkNo(String workSheetNo){
		return generrate.findGenByWorkNo(workSheetNo);
	}

	@Override
	public Addresses findAddressesByWorkSheetNo(String workSheetNo) {
		return generrate.findAddressesByWorkSheetNo(workSheetNo);
	}

	@Override
	public Drawer findDrawerByWorkSheetNo(String workSheetNo) {
		return generrate.findDrawerByWorkSheetNo(workSheetNo);
	}

	@Override
	public Rule findRuleByWorkSheetNo(String workSheetNo) {
		return generrate.findRuleByWorkSheetNo(workSheetNo);
	}

	@Override
	public Sender findSenderByWorksheetNo(String workSheetNo) {
		return generrate.findSenderByWorkSheetNo(workSheetNo);
	}

	@Override
	public boolean updateReceiverByNo(String workSheetNo) {
		return generrate.updateReceiverByNo(workSheetNo) > 0 ? true : false;
	}

	@Override
	public List<GenerrateInvoiceUtil> findGenerrateInvoiceUtilByWith(Map<String, Object> paramMap) {
		return generrate.findGenerrateInvoiceUtilByWith(paramMap);
	}
	
	/**
	 * 查询生成返货单的数据的总记录数
	 */
	@Override
	public int countGenerrateInvoiceUtilByWith() {
		return generrate.countGenerrateInvoiceUtilByWith();
	}

	/**
	 * 查询申请返货表
	 */
	public Map<String, Object> findAllApplyGoods(Map<String, Object> paramMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",generrate.findAllApplyGoods(paramMap).size());
		map.put("rows", generrate.findAllApplyGoods(paramMap));
		return map;
	}

	/**
	 * 饼状统计图
	 */
	public List<Integer> creatPie() throws ParseException {
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("status", "1");//未执行
		int num1 = generrate.findAllApplyGoods(map1).size();
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("status", "2");//已返货
		int num2 = generrate.findAllApplyGoods(map2).size();
		Map<String,Object> map3 = new HashMap<String, Object>();
		map3.put("status", "3");//已转发
		int num3 = generrate.findAllApplyGoods(map3).size();
		int num = num1+num2+num3;
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(num1);
		ints.add(num2);
		ints.add(num3);
		ints.add(num);
		return ints;
	}

	@Override
	public int countApplyGoodsByStatus(String status) {
		Session session = SecurityUtils.getSubject().getSession();
		int num = generrate.countApplyGoodsByStatus("2");
		return num;
	}

}
