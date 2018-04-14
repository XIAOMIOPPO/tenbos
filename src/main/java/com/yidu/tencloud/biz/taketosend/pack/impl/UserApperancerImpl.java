package com.yidu.tencloud.biz.taketosend.pack.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.pack.Appearance;
import com.yidu.tencloud.bean.taketosend.pack.UserPack;
import com.yidu.tencloud.biz.taketosend.pack.UserPackApperancerBiz;
import com.yidu.tencloud.dao.taketosend.pack.UserApperanceMapper;
@Service
public class UserApperancerImpl implements UserPackApperancerBiz{

	@Autowired
	private UserApperanceMapper userApperancer;
	

	public void setUserApperancer(UserApperanceMapper userApperancer) {
		this.userApperancer = userApperancer;
	}

	@Override
	public Appearance findAllUserApperancer(String workSheetNo){
		return userApperancer.findAllUserApperancer(workSheetNo);
	}

	
}
