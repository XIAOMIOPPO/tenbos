package com.yidu.tencloud.biz.basis.bussetingbiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.busseting.Bus;

/**
 * 业务层接口
 * @author ZhangZhenhao
 * @since 2017/11/17
 */
public interface BusSetingBiz {
	
	/**
	 * 获得班车记录数
	 * @param paramMap
	 * @return
	 */
	public int countBus();
	
	/**
	 * 分页查询所有班车
	 * @param paramMap
	 * @return
	 */
	public List<Bus> findBusPagenation(Map<String,Integer> paramMap);
	
	/**
	 * 满足条件查询的班车记录数
	 * @param paramMap
	 * @return	
	 */
	public int countBusWithCriteria(Map<String,Object> paramMap);
	
	/**
	 * 带条件的分页查询
	 * @param paramMap
	 * @return
	 */
	public List<Bus> findBusPagenationWithCriteria(Map<String,Object> paramMap);
	
	/**
	 * 添加班车
	 * @param bus
	 * @return
	 */
	public boolean addBus(Bus bus);
	
	/**
	 * 修改班车
	 * @param bus
	 * @return
	 */
	public boolean updateBus(Bus bus);
	
	/**
	 * 删除
	 * @param busId
	 * @return
	 */
	public boolean deleteBus(String busId);
	
	/**
	 * 查询所有员工
	 * @return
	 */
	List<String> findEmp();
	

}
