package com.yidu.tencloud.biz.route.line.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.route.line.Line;
import com.yidu.tencloud.biz.route.line.LineBiz;
import com.yidu.tencloud.dao.route.line.LineMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
@Service
public class LineBizImpl implements LineBiz {
	@Autowired
	private LineMapper lineMapper;
	
	public void setLineMapper(LineMapper lineMapper) {
		this.lineMapper = lineMapper;
	}

	@Override
	public int countLine(Map<String, Object> param) {
		return lineMapper.countLine(param);
	}

	@Override
	public List<Line> findAllLine(Map<String, Object> paramMap) {
		return lineMapper.findAllLine(paramMap);
	}

	@Override
	public boolean addLine(Line line) {
		line.setLineId(IDGenderatorUtil.generateId());
		int result = lineMapper.addLine(line);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateLine(Line line) {
		int result = lineMapper.updateLine(line);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}

}
