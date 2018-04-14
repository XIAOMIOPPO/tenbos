package com.yidu.tencloud.web.controller.route.bus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.route.bus.BusLine;
import com.yidu.tencloud.biz.route.bus.BusLineBiz;

/**
 * 班车线路控制器
 * @author 廖晓翠
 * @since 2018/01/11
 */
@Controller
@RequestMapping("/busLine")
public class BusLineController {
	/**
	 * 保留对逻辑层的引用
	 */
	@Autowired
	private BusLineBiz busLineBiz;

	public void setBusLineBiz(BusLineBiz busLineBiz) {
		this.busLineBiz = busLineBiz;
	}
	
	/**
	 * 添加班车线路
	 * @param busLine 班车线路
	 * @return 如果成功返回success 否则返回failed
	 * @throws Exception 处理异常
	 */
	@RequestMapping(value ="/addBusLine")
	@ResponseBody
	public Map<String,Object> addBusLine(BusLine busLine) throws Exception{
		Map<String,Object>paramMap = new HashMap<String,Object>();
		if(busLineBiz.addBusLine(busLine)) {
			paramMap.put("status", "success");
		}else {
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	
	/**
	 * 查找所有汽车路线带分页
	 * @param paramMap  参数
	 * @return 所有的汽车路线
	 */
	@RequestMapping(value ="/findAllBusLine")
	@ResponseBody
	public Map<String,Object> findAllBusLine(@RequestBody Map<String,Object>paramMap){
		paramMap.put("total", busLineBiz.countBusLine(paramMap));
		paramMap.put("rows", busLineBiz.findAllBusLine(paramMap));
		paramMap.put("circuitType", busLineBiz.findAllBusLine(paramMap));
		paramMap.put("busLineName", busLineBiz.findAllBusLine(paramMap));
		paramMap.put("startCity", busLineBiz.findAllBusLine(paramMap));
		paramMap.put("arriveCity", busLineBiz.findAllBusLine(paramMap));
		paramMap.put("busLineCode", busLineBiz.findAllBusLine(paramMap));
		return paramMap;
	}
	
	/**
	 * 根据Id删除汽车线路
	 * @param busLineIds 汽车Id数组
	 * @return 删除成功返回1 否则返回0
	 * @throws Exception 处理异常
	 */
	@RequestMapping(value ="/deleteBusLineById")
	@ResponseBody
	public String deleteBusLineById(String busLineIds[]) throws Exception {
		int result = 0;
		for(String busLineId : busLineIds) {
			result = busLineBiz.deleteBusLineById(busLineId);
		}
		if(result == 1) {
			return "success";
		}
		return "failed";
	}
	
	/**
	 * 根据Id修改线路信息
	 * @param busLine 线路对象
	 * @return 修改成功返回success 否则返回failed
	 * @throws Exception 处理异常
	 */
	@RequestMapping(value ="/updateBusLineById")
	@ResponseBody
	public String updateBusLineById(BusLine busLine) throws Exception{
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("busLineId", busLine.getBusLineId());
		paramMap.put("circuitType", busLine.getCircuitType());
		paramMap.put("busLineName", busLine.getBusLineName());
		paramMap.put("busLineCode", busLine.getBusLineCode());
		paramMap.put("startCity", busLine.getStartCity());
		paramMap.put("arriveCity", busLine.getArriveCity());
		paramMap.put("countMileage", busLine.getCountMileage());
		paramMap.put("remark", busLine.getRemark());
		paramMap.put("isUse", busLine.getIsUse());
		
		boolean result = busLineBiz.updateBusLineById(paramMap);
		if(result) {
			return "success";
		}
		return "failed";
	}
}
