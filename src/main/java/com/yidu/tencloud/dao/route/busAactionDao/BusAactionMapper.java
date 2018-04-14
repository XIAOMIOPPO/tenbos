package com.yidu.tencloud.dao.route.busAactionDao;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.aviation.BusAaction;

public interface BusAactionMapper {
	/**
	 * 查询
	 * @return
	 */
	public List<BusAaction> findAllBusAaction();
	/**
	 * 删除
	 * @param planeStationId
	 * @return
	 */
	public int deleteBusAaction(String planeStationId);
	/**
	 * 修改
	 * @param busAaction
	 * @return
	 */
	public int updateBusAaction(BusAaction busAaction);
	/**
	 * 添加
	 * @param busAaction
	 * @return
	 */
	public int addBusAaction(BusAaction busAaction);
	/**
	 * 分页
	 * @param contMap
	 * @return
	 */
	public List<BusAaction> conttBusAaction(Map<String, Object> contMap);
	/**
	 * 模糊查询
	 * @param contMap
	 * @return
	 */
	public int ronesBusAaction(Map<String, Object> contMap);

}
