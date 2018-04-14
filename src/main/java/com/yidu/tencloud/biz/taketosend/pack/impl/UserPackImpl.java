package com.yidu.tencloud.biz.taketosend.pack.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.pack.UserPack;
import com.yidu.tencloud.biz.taketosend.pack.UserPackBiz;
import com.yidu.tencloud.dao.taketosend.pack.UserPackMapper;

@Service
public class UserPackImpl implements UserPackBiz{

	@Autowired
	private UserPackMapper userPackMapper;
	
	
	public void setUserPackMapper(UserPackMapper userPackMapper) {
		this.userPackMapper = userPackMapper;
	}

	@Override
	public List<UserPack> findAllUserPack() {
		
		return userPackMapper.findAllUserPack();
	}

	@Override
	public List<UserPack> countUserPack(Map<String, Object> ronesUser) {
		return userPackMapper.conttUserPack(ronesUser);
	}

	@Override
	public List<UserPack> listUserPack(Map<String, Object> contMap) {
		return userPackMapper.ronesUserPack(contMap);
	}

}
