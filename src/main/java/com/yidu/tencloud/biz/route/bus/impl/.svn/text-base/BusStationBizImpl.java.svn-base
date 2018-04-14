package com.yidu.tencloud.biz.route.bus.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.route.bus.BusStation;
import com.yidu.tencloud.biz.route.bus.BusStationBiz;
import com.yidu.tencloud.dao.route.bus.BusStationMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 汽车站的业务逻辑实现层
 * @author 廖晓翠
 * @since 2018/01/05
 */
@Service
public class BusStationBizImpl implements BusStationBiz{
	/**
	 * 保留对数据接口层的保留
	 */
	@Autowired
	private BusStationMapper busStationMapper;
	
	public void setBusStationMapper(BusStationMapper busStationMapper) {
		this.busStationMapper = busStationMapper;
	}

	@Override
	public int countBusStation(Map<String,Object> paramMap) {
		// 返回数据接口层的方法
		return busStationMapper.countBusStation(paramMap);
	}

	@Override
	public List<BusStation> findAllBusStation(Map<String, Object> paramMap) {
		// 返回数据接口层的方法
		return busStationMapper.findAllBusStation(paramMap);
	}

	@Override
	public boolean addBusStation(BusStation busStation) {
		//设置汽车站Id
		busStation.setBusStationId(IDGenderatorUtil.generateId());
		//设置城市编码
		busStation.setCode(IDGenderatorUtil.generateId());
		//获得session域里的user对象
		SecurityUtils.getSubject().getSession().getAttribute("user");
		//设置录入人
		busStation.setDrawerName(ShiroUtil.getUser().getUserName());
		//设置录入时间
		busStation.setDrawerTime(new Date(System.currentTimeMillis()));
		//设置录入人所属单位
		busStation.setDrawerCompany(ShiroUtil.getUser().getOrgId());
		
		//调用数据接口层的方法
		int result = busStationMapper.addBusStation(busStation);
		if(result == 1) {
			//成功
			return true;
		}
		//失败
		return false;
	}

	@Override
	public int deleteBusStationById(String busStationId) {
		int result = busStationMapper.deleteBusStationById(busStationId);
		if(result == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean updateBusStationById(Map<String, Object> paramMap) {
		int result = busStationMapper.updateBusStationById(paramMap);
		if(result == 1) {
			return true;
		}
		return false;
	}

}
