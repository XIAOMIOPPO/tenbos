package com.yidu.tencloud.biz.taketosend.consultbiz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.Consult;
import com.yidu.tencloud.biz.taketosend.consultbiz.ConsultBiz;
import com.yidu.tencloud.dao.taketosend.consult.ConsultMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 咨询业务逻辑层实现类
 * @author 张建勇
 * @date 2017.12.08
 */
@Service
public class ConsultBizImpl implements ConsultBiz{
	
	@Autowired
	private ConsultMapper consultMapper;
	
	
	
	public ConsultMapper getConsultMapper() {
		return consultMapper;
	}



	public void setConsultMapper(ConsultMapper consultMapper) {
		this.consultMapper = consultMapper;
	}



	@Override
	public boolean addConsult(Consult consult) {
		consult.setConsultId(IDGenderatorUtil.generateId());
		int result = consultMapper.addConsult(consult);
		if(result<1){
			return false;
		}else{
			return true;
		}
		
	}



	@Override
	public List<Consult> findBusReConsult() {
		return consultMapper.findBusReConsult();
	}
	
	@Override
	public List<Consult> findWorkOrderConsult() {
		return consultMapper.findWorkOrderConsult();
	}



	@Override
	public List<Consult> findAllConsultByPage(Integer limit,Integer offset ,String consultType) {
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("limit", limit);
		parmMap.put("offset", offset);
		parmMap.put("consultType", consultType);
		return consultMapper.findAllConsultByPage(parmMap);
	}



	@Override
	public List<String> findBusinessRecsiptNoByClient(String phoneNum) {
		return consultMapper.findBusinessRecsiptNoByClient(phoneNum);
	}



	@Override
	public List<String> findWorkOrderNoByClient(String phoneNum) {
		return consultMapper.findWorkOrderNoByClient(phoneNum);
	}

}
