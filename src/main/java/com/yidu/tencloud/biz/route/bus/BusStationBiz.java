package com.yidu.tencloud.biz.route.bus;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.bus.BusStation;

/**
 * 汽车站逻辑层接口
 * @author 廖晓翠
 * @since 2018/01/05
 */
public interface BusStationBiz {
	/**
	 * 查找所有汽车站的总记录数
	 * @return 总记录数
	 */
	public int countBusStation(Map<String,Object> paramMap);
	
	/**
	 * 查找所有的汽车站并分页
	 * @param paramMap 参数
	 * @return 所有汽车站的集合
	 */
	public List<BusStation> findAllBusStation(Map<String,Object>paramMap);

	/**
	 * 添加汽车站
	 * @param busStation 汽车站对象
	 * @return 如果成功返回true 否则返回false
	 */
	public boolean addBusStation(BusStation busStation);
	
	/**
	 * 删除汽车站
	 * @param busStationId 汽车站Id
	 * @return 如果删除成功返回true 否则返回false
	 */
	public int deleteBusStationById(String busStationId);
	
	/**
	 * 修改汽车站信息
	 * @param paramMap 属性
	 * @return 修改成功返回true 否则返回false
	 */
	public boolean updateBusStationById(Map<String,Object>paramMap);
}
