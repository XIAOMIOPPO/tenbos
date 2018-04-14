package com.yidu.tencloud.dao.route.bus;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.bus.BusLine;

/**
 * 汽车线路接口
 * @author 廖晓翠
 * @since 2018/01/11
 */
public interface BusLineMapper {
	/**
	 * 添加线路资源 
	 * @param busLine 汽车线路
	 * @return 如果添加成功 返回1 否则返回0
	 */
	public int addBusLine(BusLine busLine);
	
	/**
	 * 查找所有汽车线路的总记录数
	 * @param paramMap 查询条件
	 * @return 如果找到返回记录数 否则返回0
	 */
	public int countBusLine(Map<String,Object> paramMap);
	
	/**
	 * 查找所有的汽车路线
	 * @param paramMap 查询条件
	 * @return 如果找到就返回该集合 否则返回null
	 */
	public List<BusLine> findAllBusLine(Map<String,Object> paramMap);
	
	/**
	 * 根据汽车线路Id删除汽车线路(逻辑删除 作废)
	 * @param busLineId 汽车线路Id
	 * @return 如果删除成功返回1 否则返回0
	 */
	public int deleteBusLineById(String busLineId);
	
	/**
	 * 根据Id修改汽车线路信息
	 * @param paramMap 查询条件
	 * @return 修改成功返回1 否则返回0
	 */
	public int updateBusLineById(Map<String,Object> paramMap);
}
