package com.yidu.tencloud.web.controller.route.train;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.route.train.RLine;
import com.yidu.tencloud.bean.route.train.Route;
import com.yidu.tencloud.bean.route.train.Station;
import com.yidu.tencloud.biz.route.train.RouteBiz;
import com.yidu.tencloud.biz.route.train.TrainBiz;

@RequestMapping("route")
@Controller
public class RouteController {
	@Autowired
	private RouteBiz routeBiz;

	public void setRouteBiz(RouteBiz routeBiz) {
		this.routeBiz = routeBiz;
	}

	@RequestMapping("/findRoute")
	@ResponseBody
	public Map<String,Object[]> findRoute() throws Exception{
		//添加一个返回值map并赋值
		Map<String,Object[]> map = new HashMap<String, Object[]>();
		for (Route routes : routeBiz.findRoute()) {
			String str = routes.getName();
			Object[] obj = {routes.getLongitude(),routes.getLatitude()};
			map.put(str, obj);
		}
		return map;
	}
	
	@RequestMapping("/findLineStation")
	@ResponseBody
	public List<RLine> findLineStation() throws Exception{
		//添加一个返回值map并赋值
		return routeBiz.findLineStation();
	}
	
	
}
