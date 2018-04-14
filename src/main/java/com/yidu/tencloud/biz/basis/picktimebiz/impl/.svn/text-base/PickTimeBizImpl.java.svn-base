package com.yidu.tencloud.biz.basis.picktimebiz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.picktime.Picktime;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.basis.picktimebiz.PickTimeBiz;
import com.yidu.tencloud.dao.basis.picktime.PicktimeMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
@Service
public class PickTimeBizImpl implements PickTimeBiz{
	@Autowired
	private PicktimeMapper pickTimeMapper;

	public void setPickTimeMapper(PicktimeMapper pickTimeMapper) {
		this.pickTimeMapper = pickTimeMapper;
	}

	/**
	 * 添加收派时间
	 */
	public boolean addPicktime(Picktime picktime) {
		picktime.setDrawTimeId(IDGenderatorUtil.generateId());
		return pickTimeMapper.addPicktime(picktime)> 0 ? true:false;
	}
	
	/**
	 * 带条件的分页查询
	 */
	public List<Picktime> findPickTimePagenationWithCriteria(Map<String, Object> paramMap) {
		
		return pickTimeMapper.findPickTimePagenationWithCriteria(paramMap);
	}

	/**
	 * 带条件的查询总记录数
	 */
	public int countPickTimeWithCriteria(Map<String, Object> paramMap) {
		return pickTimeMapper.countPickTimeWithCriteria(paramMap);
	}

	/**
	 * 分页查询
	 */
	public List<Picktime> findPickTimePagenation(Map<String, Integer> paramMap) {
		return pickTimeMapper.findPickTimePagenation(paramMap);
	}

	/**
	 * 总记录数
	 */
	public int countPickTime() {
		return pickTimeMapper.countPickTime();
	}

	/**
	 * 删除
	 */
	public boolean deletePickTime(String[] drawTimeId) {
		List<String> times = new ArrayList<String>();
		for (String time : drawTimeId) {
			times.add(time);
		}
		return pickTimeMapper.deletePickTime(times)> 0 ? true:false;
	}

	/**
	 * 修改
	 */
	public boolean updatePickTime(Picktime picktime) {
		return pickTimeMapper.updatePickTime(picktime)> 0 ? true:false;
	}

	/**
	 * 组织结构表查询所有
	 */
	public List<Organization> findAllOrganization(Organization organization) {
		return pickTimeMapper.findAllOrganization(organization);
	}

}
