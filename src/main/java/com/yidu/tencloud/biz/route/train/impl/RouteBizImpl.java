package com.yidu.tencloud.biz.route.train.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.route.train.RLine;
import com.yidu.tencloud.bean.route.train.Route;
import com.yidu.tencloud.biz.route.train.RouteBiz;
import com.yidu.tencloud.dao.route.train.RouteMapper;
@Service
public class RouteBizImpl implements RouteBiz {
	@Autowired
    private RouteMapper routeMapper;

	public void setRouteMapper(RouteMapper routeMapper) {
		this.routeMapper = routeMapper;
	}

	@Override
	public List<Route> findRoute() {
		return routeMapper.findRoute();
	}

	@Override
	public List<RLine> findLineStation() {
		return routeMapper.findLineStation();
	}
	
	

}
