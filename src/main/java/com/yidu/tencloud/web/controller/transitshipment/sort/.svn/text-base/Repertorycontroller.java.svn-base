package com.yidu.tencloud.web.controller.transitshipment.sort;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.biz.transitshipment.sort.RepertoryBiz;

/**
 * 存库控制器
 * @author 刘艺钿
 *
 */
@Controller
@RequestMapping("/repertory")
public class Repertorycontroller {
	@Autowired
	private RepertoryBiz repertorybiz;

	public RepertoryBiz getRepertorybiz() {
		return repertorybiz;
	}

	public void setRepertorybiz(RepertoryBiz repertorybiz) {
		this.repertorybiz = repertorybiz;
	}
	
	/**
	 * 查询分页库存信息
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value="/findRepertoryPagenation",method= {RequestMethod.POST})
	public Map<String,Object> findRepertoryPagenation(@RequestBody Map<String,Object> map){
		Map<String,Object> house = new HashMap<String,Object>();
		house.put("total", repertorybiz.outRepertorycount());
		house.put("rows", repertorybiz.findRepertoryPagenation(map));
		return house;
		
	}
	/**
	 * 分页模糊查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findreperToryPagenationWithCriteria",method={RequestMethod.POST})
	public Map<String, Object> findreperToryPagenationWithCriteria(@RequestBody Map<String, Object> map){

		Map<String, Object> fingappmap =new HashMap<String,Object>();	
		fingappmap.put("total",repertorybiz.reperTorycountWithCriteria(map));
		fingappmap.put("rows", repertorybiz.findRepertoryPagenationWithCriteria(map));
		
		return fingappmap;
		
	}

}
