package com.yidu.tencloud.biz.basis.picktimebiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.picktime.Picktime;
import com.yidu.tencloud.bean.system.organizationchart.Organization;

public interface PickTimeBiz {

	/**
	 * 带条件的分页查询 返回满足条件的收派时间集合
	 * @param paramMap
	 * @return 满足条件的收派时间集合
	 */
	public List<Picktime> findPickTimePagenationWithCriteria(Map<String,Object> paramMap);
	
	/**
	 * 查询满足条件的收派时间的记录数
	 * @param paramMap
	 * @return 满足条件的收派时间的记录数
	 */
	public int countPickTimeWithCriteria(Map<String,Object> paramMap);
	
	/**
	 * 分页查询 返回指定页面的收派时间集合
	 * @param paramMap
	 * @return
	 */
	public  List<Picktime> findPickTimePagenation(Map<String,Integer> paramMap);
	
	/**
	 * 获得收派时间的记录数
	 * @return 收派时间的记录数
	 */
	public int countPickTime();
	
	/**
	 * 添加收派时间数据
	 * @param picktime
	 * @return
	 */
	public boolean addPicktime(Picktime picktime);
	/**
	 * 根据收派时间Id删除数据
	 * @param drawTimeId
	 * @return
	 */
	public boolean deletePickTime(String[] drawTimeId);
	/**
	 * 根据收派时间Id修改数据
	 * @param picktime
	 * @return
	 */
	public boolean updatePickTime(Picktime picktime);
	
	public List<Organization> findAllOrganization(Organization organization);
}
