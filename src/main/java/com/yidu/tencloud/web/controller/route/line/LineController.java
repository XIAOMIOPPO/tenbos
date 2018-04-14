package com.yidu.tencloud.web.controller.route.line;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.route.line.Line;
import com.yidu.tencloud.biz.route.line.LineBiz;
@RequestMapping("line")
@Controller
public class LineController {
	@Autowired
	private LineBiz lineBiz;

	public void setLineBiz(LineBiz lineBiz) {
		this.lineBiz = lineBiz;
	}

	@RequestMapping("/findAllLine")
	@ResponseBody
	public Map<String,Object> findAllLine(@RequestBody Map<String,Object>paramMap) throws Exception{
		//添加一个返回值map并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",lineBiz.countLine(paramMap));
		map.put("rows", lineBiz.findAllLine(paramMap));
		
		map.put("startingCity", lineBiz.findAllLine(paramMap));
		map.put("arriveCity", lineBiz.findAllLine(paramMap));
		map.put("startingStation", lineBiz.findAllLine(paramMap));
		map.put("arriveStation", lineBiz.findAllLine(paramMap));
		return map;
	}
	
	@RequestMapping("/addLine")
	@ResponseBody
	public Map<String,Object> addLine(Line line) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		boolean result = lineBiz.addLine(line);
		if(result) {
			map.put("status", "success");
		}else {
			map.put("status", "failed");
		}
		return map;
	}
	
	@RequestMapping("/updateLine")
	@ResponseBody
	public Map<String,Object> updateLine(Line line) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		boolean result = lineBiz.updateLine(line);
		if(result) {
			map.put("status", "success");
		}else {
			map.put("status", "failed");
		}
		return map;
	}
}
