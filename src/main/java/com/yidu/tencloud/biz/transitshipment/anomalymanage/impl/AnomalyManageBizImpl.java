package com.yidu.tencloud.biz.transitshipment.anomalymanage.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.transitshipment.anomaly.AnomalyManage;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.transitshipment.anomalymanage.AnomalyManageBiz;
import com.yidu.tencloud.dao.transitshipment.anomaly.AnomalyManageMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 异常处理业务逻辑层实现类
 * @author 张建勇
 * @date 2018.01.06
 */
@Service
public class AnomalyManageBizImpl implements AnomalyManageBiz{
	
	@Autowired
	private AnomalyManageMapper anomalyMapper;  
	
	@Autowired
	private EmpBiz empBiz;
	
	
	
	public EmpBiz getEmpBiz() {
		return empBiz;
	}

	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	public AnomalyManageMapper getAnomalyMapper() {
		return anomalyMapper;
	}

	public void setAnomalyMapper(AnomalyManageMapper anomalyMapper) {
		this.anomalyMapper = anomalyMapper;
	}

	@Override
	public boolean addAnomalyManage(AnomalyManage anomalyManage) {
		User user = ShiroUtil.getUser();
		anomalyManage.setEnteringName(user.getUserName());
		anomalyManage.setEnteringTime(new Date());
		anomalyManage.setEnteringUnit(user.getOrgId());
		anomalyManage.setExceptionManageId(IDGenderatorUtil.generateId());
		int result = anomalyMapper.addAnomalyManage(anomalyManage);
		if(result<1){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<AnomalyManage> findAllAnomalyManage() {
		return anomalyMapper.findAllAnomalyManage(empBiz.orgListToString());
	}

	@Override
	public List<AnomalyManage> findAnomalyManageByPage(Integer offset , Integer limit) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("offset", offset);
		paramMap.put("limit", limit);
		paramMap.put("orgList", empBiz.orgListToString());
		return anomalyMapper.findAnomalyManageByPage(paramMap);
	}

	@Override
	public List<AnomalyManage> findAnomalyManageByCondition(Integer offset, Integer limit, String coSourcingNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("offset", offset);
		paramMap.put("limit", limit);
		paramMap.put("coSourcingNo", coSourcingNo);
		return anomalyMapper.findAnomalyManageByCondition(paramMap);
	}

	@Override
	public boolean updateDisposeMessageById(String exceptionManageId ,String result) {
		Map<String, Object> paramMap = new HashMap<>();
		User user = ShiroUtil.getUser();
		paramMap.put("processor", user.getUserName());
		paramMap.put("processingUnit", user.getOrgId());
		paramMap.put("processTime", new Date());
		paramMap.put("result", result);
		paramMap.put("exceptionstatus", "已处理");
		paramMap.put("exceptionManageId", exceptionManageId);
		int results = anomalyMapper.updateDisposeMessage(paramMap);
		if(results < 1){
			return false;
		}else{
			return true;
		}
		
		
	}

	@Override
	public boolean updateAffirmMessageById(String exceptionManageId,String affirmFruit) {
		Map<String, Object> paramMap = new HashMap<>();
		User user = ShiroUtil.getUser();
		paramMap.put("affirmName", user.getUserName());
		paramMap.put("affirmUnit", user.getOrgId());
		paramMap.put("affirmTime", new Date());
		paramMap.put("affirmJobNumber", user.getUserId());
		paramMap.put("affirmFruit", affirmFruit);
		paramMap.put("exceptionstatus", "已确认");
		paramMap.put("exceptionManageId", exceptionManageId);
		int results = anomalyMapper.updateNotarizeMessage(paramMap);
		if(results < 1){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	
}
