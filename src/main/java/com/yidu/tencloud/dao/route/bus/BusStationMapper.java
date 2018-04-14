package com.yidu.tencloud.dao.route.bus;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.bus.BusStation;

/**
 * 汽车站的mapper接口
 * @author 廖晓翠
 * @since 2018/01/05
 */
public interface BusStationMapper {
	/**
	 * 查找汽车站的总记录数
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
	 * @return 如果成功返回1 否则返回0
	 */
	public int addBusStation(BusStation busStation);
	
	/**
	 * 删除汽车站(逻辑删除 作废)
	 * @param busStationId 汽车站Id
	 * @return 如果删除成功返回1 否则返回0
	 */
	public int deleteBusStationById(String busStationId);
	
	/**
	 * 根据Id修改汽车站信息
	 * @param paramMap 属性
	 * @return  修改成功返回1 否则返回0
	 */
	public int updateBusStationById(Map<String,Object>paramMap);
}
