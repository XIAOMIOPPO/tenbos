package com.yidu.tencloud.biz.transitshipment.changeentering.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.transitshipment.anomaly.ChangeEntering;
import com.yidu.tencloud.biz.transitshipment.changeentering.ChangeEnteringBiz;
import com.yidu.tencloud.dao.transitshipment.anomaly.ChangeEnteringMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 到付代收变更信息业务逻辑层实体类
 * @author 张建勇
 * @date 2018.01.5
 */
@Service
public class ChangeEnteringBizImpl  implements ChangeEnteringBiz{
	
	@Autowired
	private ChangeEnteringMapper changeEnteringMapper;

	public ChangeEnteringMapper getChangeEnteringMapper() {
		return changeEnteringMapper;
	}

	public void setChangeEnteringMapper(ChangeEnteringMapper changeEnteringMapper) {
		this.changeEnteringMapper = changeEnteringMapper;
	}

	@Override
	public boolean addChangeEntering(ChangeEntering changeEntering) {
		changeEntering.setRecordId(IDGenderatorUtil.generateId());
		User user = ShiroUtil.getUser();
		changeEntering.setEnteringMan(user.getUserName());
		changeEntering.setEnteringTime(new Date());
		changeEntering.setCancelStatus("0");
		
		int result = changeEnteringMapper.addChangeEntering(changeEntering);
		if(result < 1){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<ChangeEntering> findAllChangeEntering() {
		return changeEnteringMapper.findAllChangeEntering();
	}
	
	@Override
	public List<ChangeEntering> findChangeEnteringByPage(Integer offset, Integer limit) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("offset", offset);
		paramMap.put("limit", limit);
		return changeEnteringMapper.findChangeEnteringByPage(paramMap);
	}

	@Override
	public WorkSheet findWorkSheetByWorkSheetNo(String workSheetNo) {
		WorkSheet workSheet = changeEnteringMapper.findWorkSheetByWorkSheetNo(workSheetNo);
		if(workSheet == null){
			return null;
		}else{
			return workSheet;
		}
	}

	@Override
	public boolean updateupdateChangeEnteringById(String sendee, String sendeeUnit, Date sendeeTime,
			String sendeeStatus, String recordId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("sendee", sendee);
		paramMap.put("sendeeUnit", sendeeUnit);
		paramMap.put("sendeeTime", sendeeTime);
		paramMap.put("sendeeStatus", sendeeStatus);
		paramMap.put("recordId", recordId);
		int result = changeEnteringMapper.updateChangeEnteringById(paramMap);
		
		if(result<1){
			return false;
		}else{
			return true;
		}
	}

}
