package com.yidu.tencloud.biz.route.busAaction;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.aviation.BusAaction;

public interface BusAactionBiz {

	/**
	 * 查询
	 * @return
	 */
	List<BusAaction> findAllBusAction();
	/**
	 * 删除
	 * @param planeStationId
	 * @return
	 */
	boolean deleteBusAction(String planeStationId);
	/**
	 * 修改
	 * @param busAaction
	 * @return
	 */
	boolean updateBusAction(BusAaction busAaction);
	/**
	 * 添加
	 * 
	 * @param busAaction
	 * @return
	 */
	boolean addBusAaction(BusAaction busAaction);
	/**
	 * 分页
	 * @param ronesUser
	 * @return
	 */
	int countAaction(Map<String,Object> ronesAaction);
	/**
	 * 模糊查询
	 * @param contMap
	 * @return
	 */
	List<BusAaction> listBusAaction(Map<String, Object> contMap);
}
