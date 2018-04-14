package com.yidu.tencloud.biz.route.bus.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.route.bus.BusLine;
import com.yidu.tencloud.biz.route.bus.BusLineBiz;
import com.yidu.tencloud.dao.route.bus.BusLineMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 汽车线路逻辑实现层
 * @author 廖晓翠
 * @since 2018/01/11
 */
@Service
public class BusLineBizImpl implements BusLineBiz{
	/**
	 * 保留对数据访问层的引用
	 */
	@Autowired
	private BusLineMapper busLineMapper;
	
	public void setBusLineMapper(BusLineMapper busLineMapper) {
		this.busLineMapper = busLineMapper;
	}

	@Override
	public boolean addBusLine(BusLine busLine) {
		busLine.setBusLineId(IDGenderatorUtil.generateId());
		//获得session域里的user对象
		SecurityUtils.getSubject().getSession().getAttribute("user");
		//设置录入人
		busLine.setDrawerName(ShiroUtil.getUser().getUserName());
		//设置录入时间
		busLine.setDrawerTime(new Date(System.currentTimeMillis()));
		//设置录入人所属单位
		busLine.setDrawerCompany(ShiroUtil.getUser().getOrgId());
		int result = busLineMapper.addBusLine(busLine);
		if(result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public int countBusLine(Map<String, Object> paramMap) {
		return busLineMapper.countBusLine(paramMap);
	}

	@Override
	public List<BusLine> findAllBusLine(Map<String, Object> paramMap) {
		return busLineMapper.findAllBusLine(paramMap);
	}

	@Override
	public int deleteBusLineById(String busLineId) {
		int result = busLineMapper.deleteBusLineById(busLineId);
		if(result == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean updateBusLineById(Map<String, Object> paramMap) {
		int result = busLineMapper.updateBusLineById(paramMap);
		if(result == 1) {
			return true;
		}
		return false;
	}

}
