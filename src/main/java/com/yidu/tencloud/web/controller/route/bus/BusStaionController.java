package com.yidu.tencloud.web.controller.route.bus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.route.bus.BusStation;
import com.yidu.tencloud.biz.route.bus.BusStationBiz;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 汽车站的控制器层(基于注解)
 * @author 廖晓翠
 * @since 2018/01/05
 */
@Controller
@RequestMapping("/busStation")
public class BusStaionController {

	//保留逻辑层的引用
	@Autowired
	private BusStationBiz busStationBiz;

	public void setBusStationBiz(BusStationBiz busStationBiz) {
		this.busStationBiz = busStationBiz;
	}
	
	/**
	 * 查找所有汽车站带分页
	 * @param paramMap  参数
	 * @return 所有的汽车站
	 */
	@RequestMapping(value ="/findAllBusStation")
	@ResponseBody
	public Map<String,Object> findAllBusStation(@RequestBody Map<String,Object>paramMap){
		//将总记录数放入集合
		paramMap.put("total", busStationBiz.countBusStation(paramMap));
		//将所有收派标准分页放入集合中
		paramMap.put("rows", busStationBiz.findAllBusStation(paramMap));
		
		paramMap.put("city", busStationBiz.findAllBusStation(paramMap));
		paramMap.put("code", busStationBiz.findAllBusStation(paramMap));
		paramMap.put("busStationName", busStationBiz.findAllBusStation(paramMap));
		paramMap.put("address", busStationBiz.findAllBusStation(paramMap));
		
		//返回结果集
		return paramMap;
	}
	
	/**
	 * 添加汽车站
	 * @param busStation
	 * @return
	 */
	@RequestMapping(value ="/addBusStation")
	@ResponseBody
	public Map<String,Object> addBusStation(BusStation busStation)throws Exception{
		//新建一个结果集
		Map<String,Object> paramMap = new HashMap<String,Object>();
		if(busStationBiz.addBusStation(busStation)) {
			//添加成功
			paramMap.put("status", "success");
		}else {
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	
	/**
	 * 删除汽车站
	 * @param busStationIds 汽车Id数组
	 * @return 如果删除成功返回success 否则返回failed
	 * @throws Exception 处理异常
	 */ 
	@RequestMapping(value ="/deleteBusStationById")
	@ResponseBody
	public String deleteBusStationById(String busStationIds[])throws Exception{
		int result = 0;
		for(String busStationId : busStationIds) {
			result = busStationBiz.deleteBusStationById(busStationId);
		}
		if(result == 1) {
			return "success";
		}
		return "failed";
	}
	
	/**
	 * 根据Id修改汽车站信息
	 * @param busStation 汽车站对象
	 * @return 如果修改成功返回success 否则返回failed
	 * @throws Exception 处理异常
	 */
	@RequestMapping(value ="/updateBusStationById")
	@ResponseBody
	public String updateBusStationById(BusStation busStation)throws Exception{
		//创建一个集合
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//汽车站Id
		paramMap.put("busStationId", busStation.getBusStationId());
		//城市
		paramMap.put("city", busStation.getCity());
		//汽车站名
		paramMap.put("busStationName", busStation.getBusStationName());
		//地址
		paramMap.put("address", busStation.getAddress());
		//联系电话
		paramMap.put("contactNumber", busStation.getContactNumber());
		//备注
		paramMap.put("remark", busStation.getRemark());
		//是否禁用
		paramMap.put("isUse", busStation.getIsUse()); 
		//最后修改人
		paramMap.put("supplementName", ShiroUtil.getUser().getUserName());
		//最后修改时间
		paramMap.put("supplementTime", new Date(System.currentTimeMillis()));
		
		//调用接口层的方法
		boolean result = busStationBiz.updateBusStationById(paramMap);
		if(result) {
			//成功
			return "success";
		}
		//失败
		return "failed";
	}
}
