package com.yidu.tencloud.dao.basis.busseting;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.busseting.Bus;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;

/**
 * 班车设置Dao层
 * @author ZhangZhenhao
 * @since 2017/11/17
 */
public interface BusMapper {
	
	/**
	 * 查询所有班车的记录数
	 * @return
	 */
	public int countBus();
	
	/**
	 * 获取所有班车的集合
	 * @param paramMap
	 * @return
	 */
	public List<Bus> findBusPagenation(Map<String, Integer> paramMap);
	
	/**
	 * 满足条件的班车记录数
	 * @param paramMap
	 * @return
	 */
	public int countBusWithCriteria(Map<String,Object> paramMap);
	
	/**
	 * 满足条件的班车集合
	 * @param paramMap
	 * @return
	 */
	public List<Bus> findBusPagenationWithCriteria(Map<String,Object> paramMap);
	
	/**
	 * 添加班车
	 * @param bus	班车对象
	 * @return	班车
	 */
	public int addBus(Bus bus);
	
	/**
	 * 修改班车
	 * @param bus	班车对象
	 * @return	班车
	 */
	public int updateBus(Bus bus);
	
	/**
	 * 删除班车
	 * @param busId		班车Id
	 * @return
	 */
	public int deleteBus(String busId);
	
	/**
	 * 查询员工表
	 * @return  员工集合 List<Emp>
	 */
	List<String> findEmp();
}
