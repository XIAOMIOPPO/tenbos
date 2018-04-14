package com.yidu.tencloud.biz.route.train.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.route.train.Station;
import com.yidu.tencloud.biz.route.train.TrainBiz;
import com.yidu.tencloud.dao.route.train.TrainMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;
@Service
public class TrainBizImpl implements TrainBiz {
	@Autowired
	private TrainMapper trainMapper;
	
	public void setTrainMapper(TrainMapper trainMapper) {
		this.trainMapper = trainMapper;
	}

	@Override
	public int countTrain(Map<String, Object> param) {
		return trainMapper.countTrain(param);
	}

	@Override
	public List<Station> findAllTrain(Map<String, Object> paramMap) {
		return trainMapper.findAllTrain(paramMap);
	}

	@Override
	public boolean addTrain(Station station) {
		station.setStationId(IDGenderatorUtil.generateId());
		station.setDrawerName(ShiroUtil.getUser().getUserName());
		station.setDrawerCompany(ShiroUtil.getUser().getOrgId());
		station.setDrawerTime(new Date(System.currentTimeMillis()));
		int result = trainMapper.addTrain(station);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateTrain(Station station) {
		station.setSupplementName(ShiroUtil.getUser().getUserName());
		station.setSupplementTime(new Date(System.currentTimeMillis()));
		int result = trainMapper.updateTrain(station);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}

}
