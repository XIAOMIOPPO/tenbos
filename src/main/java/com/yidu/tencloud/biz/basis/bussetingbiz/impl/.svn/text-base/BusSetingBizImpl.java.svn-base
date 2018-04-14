package com.yidu.tencloud.biz.basis.bussetingbiz.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.busseting.Bus;
import com.yidu.tencloud.biz.basis.bussetingbiz.BusSetingBiz;
import com.yidu.tencloud.dao.basis.busseting.BusMapper;

/**
 * 业务层
 * @author ZhangZhenhao
 * @since 2017/11/17
 */
@Service
public class BusSetingBizImpl implements BusSetingBiz{
	
	@Autowired
	private BusMapper busMapper;
	
	public void setBusMapper(BusMapper busMapper) {
		this.busMapper = busMapper;
		
	}
	
	@Override
	public boolean addBus(Bus bus) {
		return busMapper.addBus(bus)>0?true:false;
	}

	@Override
	public int countBus() {
		return busMapper.countBus();
	}

	@Override
	public List<Bus> findBusPagenation(Map<String, Integer> paramMap) {
		return busMapper.findBusPagenation(paramMap);
	}

	@Override
	public int countBusWithCriteria(Map<String, Object> paramMap) {
		return busMapper.countBusWithCriteria(paramMap);
	}

	@Override
	public List<Bus> findBusPagenationWithCriteria(Map<String, Object> paramMap) {
		return busMapper.findBusPagenationWithCriteria(paramMap);
	}

	@Override
	public boolean updateBus(Bus bus) {
		return busMapper.updateBus(bus)>0?true:false;
	}

	@Override
	public boolean deleteBus(String busId) {
		if(busMapper.deleteBus(busId)==1){
			return true;
		}
		return false;
	}

	@Override
	public List<String> findEmp() {
		return busMapper.findEmp();
	}
}