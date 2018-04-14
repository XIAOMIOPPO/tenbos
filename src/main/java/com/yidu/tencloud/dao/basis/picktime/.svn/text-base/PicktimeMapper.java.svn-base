package com.yidu.tencloud.dao.basis.picktime;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.picktime.Picktime;
import com.yidu.tencloud.bean.system.organizationchart.Organization;

public interface PicktimeMapper {
	/**
	 * 添加
	 * @param picktime 
	 * @return
	 */
	public int addPicktime(Picktime picktime);
	
	/**
	 * 查询所有收派时间的记录数
	 * @return
	 */
	public int countPickTime();
	/**
	 * 获取所有收派时间的集合
	 * @param paramMap
	 * @return
	 */
	public List<Picktime> findPickTimePagenation(Map<String,Integer> paramMap);
	
	/**
	 * 查询满足条件收派时间的记录数
	 * @param paramMap 
	 * @return
	 */
	public int countPickTimeWithCriteria(Map<String, Object> paramMap);
	/**
	 * 获取满足条件收派时间的集合
	 * @param paramMap
	 * @return
	 */
	public List<Picktime> findPickTimePagenationWithCriteria(Map<String, Object> paramMap);
	/**
	 * 删除
	 * @param times
	 * @return
	 */
	public int deletePickTime(List<String> times);
	/**
	 * 修改收派时间
	 * @param picktime
	 * @return
	 */
	public int updatePickTime(Picktime picktime);
	/**
	 * 查询组织结构表
	 * @param organization
	 * @return
	 */
	public List<Organization> findAllOrganization(Organization organization);
	
}
