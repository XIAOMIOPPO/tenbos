package com.yidu.tencloud.web.controller.route.train;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.route.train.Station;
import com.yidu.tencloud.biz.route.train.TrainBiz;

@RequestMapping("train")
@Controller
public class TrainController {
	@Autowired
	private TrainBiz trainBiz;

	public void setTrainBiz(TrainBiz trainBiz) {
		this.trainBiz = trainBiz;
	}

	@RequestMapping("/findAllTrain")
	@ResponseBody
	public Map<String,Object> findAllTrain(@RequestBody Map<String,Object>paramMap) throws Exception{
		//添加一个返回值map并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",trainBiz.countTrain(paramMap));
		map.put("rows", trainBiz.findAllTrain(paramMap));
		
		map.put("city", trainBiz.findAllTrain(paramMap));
		map.put("code", trainBiz.findAllTrain(paramMap));
		map.put("name", trainBiz.findAllTrain(paramMap));
		map.put("address", trainBiz.findAllTrain(paramMap));
		return map;
	}
	
	@RequestMapping("/addTrain")
	@ResponseBody
	public Map<String,Object> addTrain(Station station) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		boolean result = trainBiz.addTrain(station);
		if(result) {
			map.put("status", "success");
		}else {
			map.put("status", "failed");
		}
		return map;
	}
	
	@RequestMapping("/updateTrain")
	@ResponseBody
	public Map<String,Object> updateTrain(Station station) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		boolean result = trainBiz.updateTrain(station);
		if(result) {
			map.put("status", "success");
		}else {
			map.put("status", "failed");
		}
		return map;
	}
}
