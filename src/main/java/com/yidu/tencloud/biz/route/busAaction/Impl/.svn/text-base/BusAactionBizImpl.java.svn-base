package com.yidu.tencloud.biz.route.busAaction.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.route.aviation.BusAaction;
import com.yidu.tencloud.biz.route.busAaction.BusAactionBiz;
import com.yidu.tencloud.dao.route.busAactionDao.BusAactionMapper;
@Service
public class BusAactionBizImpl implements BusAactionBiz {
	@Autowired
	public BusAactionMapper busAactionMapper;
	
	
	public void setBusAactionMapper(BusAactionMapper busAactionMapper) {
		this.busAactionMapper = busAactionMapper;
	}
	/**
	 * 查询
	 */
	@Override
	public List<BusAaction> findAllBusAction() {
		
		return busAactionMapper.findAllBusAaction();
	}

	/**
	 * 删除
	 */
	@Override
	public boolean deleteBusAction(String planeStationId) {
		BusAaction aaction = new BusAaction();
		aaction.setPlaneStationId(planeStationId);
		aaction.setRemark("0");
		return busAactionMapper.updateBusAaction(aaction)>0?true:false;
	}
	
	/**
	 * 修改
	 */
	@Override
	public boolean updateBusAction(BusAaction busAaction) {
		return busAactionMapper.updateBusAaction(busAaction)>0?true:false;
	}
	
	/**
	 * 添加
	 */
	@Override
	public boolean addBusAaction(BusAaction busAaction) {
		return busAactionMapper.addBusAaction(busAaction)>0?true:false;
	}
	/**
	 * 模糊查询
	 */
	@Override
	public int countAaction(Map<String, Object> ronesAaction) {
		return busAactionMapper.ronesBusAaction(ronesAaction);
	}
	/**
	 * 分页
	 */
	@Override
	public List<BusAaction> listBusAaction(Map<String, Object> contMap) {
		return busAactionMapper.conttBusAaction(contMap);
	}


}
