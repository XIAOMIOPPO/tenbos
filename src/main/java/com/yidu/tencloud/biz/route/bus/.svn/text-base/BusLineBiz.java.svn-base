package com.yidu.tencloud.biz.route.bus;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.bus.BusLine;

/**
 * 班车线路资源逻辑接口层
 * @author 廖晓翠
 * @since 2018/01/11
 */
public interface BusLineBiz {
	/**
	 * 添加汽车线
	 * @param busLine 汽车线路
	 * @return 如果成功返回true 否则返回false
	 */
	public boolean addBusLine(BusLine busLine);
	
	/**
	 * 查找总记录数
	 * @param paramMap 查找条件
	 * @return 查找返回实际记录数 否则为0
	 */
	public int countBusLine(Map<String,Object> paramMap);
	
	/**
	 * 查找所有的班车线路
	 * @param paramMap 查找条件
	 * @return 如果找就返回该集合 否则返回null
	 */
	public List<BusLine> findAllBusLine(Map<String,Object> paramMap);
	
	/**
	 * 根据线路Id删除班车线路
	 * @param busLineId 线路Id
	 * @return 如果删除成功返回1 否则返回0
	 */
	public int deleteBusLineById(String busLineId);
	
	/**
	 * 根据线路Id修改线路信息
	 * @param paramMap 查找条件
	 * @return 修改成功返回true 否则返回false
	 */
	public boolean updateBusLineById(Map<String,Object> paramMap);
}
