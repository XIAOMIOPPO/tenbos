package com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Relay;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.RelayBiz;
import com.yidu.tencloud.dao.basis.pickandrelaystandard.RelayMapper;

@Service
public class RelayBizImpl implements RelayBiz{
	
	@Autowired
	private RelayMapper relayMapper;
	
	@Autowired
	private EmpBiz empBiz;
	
	public EmpBiz getEmpBiz() {
		return empBiz;
	}

	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	@Override
	public List<Relay> findAllRelay() {
		return relayMapper.findAllRelay();
	}

	@Override
	public boolean addRealy(Relay relay) {
		int result = relayMapper.addRelay(relay);
		if(result<1){
			return false;
		}else{
			return true;
		}
	}

	public RelayMapper getRelayMapper() {
		return relayMapper;
	}

	public void setRelayMapper(RelayMapper relayMapper) {
		this.relayMapper = relayMapper;
	}

	@Override
	public String findEmpIdByEmpName(String empName) {
		return relayMapper.findEmpIdByEmpName(empName);
	}

	@Override
	public List<Relay> findRealyByPage(Map<String, Integer> paremMap) {
		return relayMapper.findRealyByPage(paremMap);
	}

	@Override
	public List<Relay> findRealyByCoiny(Map<String, Object> paramCriteriaMap) {
		return relayMapper.findRelayByCondition(paramCriteriaMap);
	}

	@Override
	public List<String> findAllEmpName() {
		return relayMapper.findAllEmpName(empBiz.orgListToString());
	}

	@Override
	public boolean delRelay(String relayId) {
		if(relayMapper.delRelay(relayId) == 1){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean updateRelay(String relayId, String replaceId, String replacedId, Date startTime,
			Date endTime, String replaceName, String replacedName,String remake) {
		Relay relay = new Relay();
		relay.setRelayId(relayId);
		relay.setReplaceId(replaceId);
		relay.setReplacedId(replacedId);
		relay.setReplaceName(replaceName);
		relay.setReplacedName(replacedName);
		relay.setStartTime(startTime);
		relay.setEndTime(endTime);
		relay.setRemake(remake);
		if(relayMapper.updateRelay(relay) == 1){
			return true;
		}else{
			return false;
		}
		
	}


	

	
}