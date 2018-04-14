package com.yidu.tencloud.biz.taketosend.pack.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.pack.UserPack;
import com.yidu.tencloud.bean.taketosend.pack.UserUncl;
import com.yidu.tencloud.biz.taketosend.pack.UserUnclBiz;
import com.yidu.tencloud.dao.taketosend.pack.UserUnclMapper;
@Service
public class UserUnclImpl implements UserUnclBiz{

	@Autowired
	private UserUnclMapper userUnclMapper;
	
	@Override
	public List<UserUncl> contUserUncl(Map<String, Object> contMap) {
		return userUnclMapper.contUserUncl(contMap);
	}

	@Override
	public List<UserUncl> ronesUserUncl(Map<String, Object> ronesMap) {
		return userUnclMapper.ronseUserUncl(ronesMap);
	}

	@Override
	public List<UserPack> findAllUserUncl() {
		return userUnclMapper.findAllUserUncl();
	}

	
}
