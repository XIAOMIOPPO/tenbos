package com.yidu.tencloud.web.controller.basis.picktimecontroller;
/**
 * 控制器
 * @author 醉芳抚琴
 *
 */

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.picktime.Picktime;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.basis.picktimebiz.PickTimeBiz;
@Controller
@RequestMapping("/pick")
public class PicktimeController {

	@Autowired
	private PickTimeBiz pickTimeBiz;
	
	public void setPickTimeBiz(PickTimeBiz pickTimeBiz) {
		this.pickTimeBiz = pickTimeBiz;
	}
	
	
/*	@RequestMapping(value="/findAllPicktime",method={RequestMethod.POST})
	@ResponseBody
	public List<Picktime> findAllPicktime(){
		return pickTimeBiz.findAllPicktime();
	}*/
	
	/**
	 * 添加
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addPicktime",method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> addPicktime(Picktime picktime)throws Exception{
		Map<String, Object> pickMap = new HashMap<>();
		if(pickTimeBiz.addPicktime(picktime)){
			pickMap.put("status", "success");
		}else {
			pickMap.put("status", "failed");
		}
		return pickMap;
	} 
	
	/**
	 * 带条件的分页查询
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/findPickTimePagenationWithCriteria",method={RequestMethod.POST})
	public Map<String, Object> findPickTimePagenationWithCriteria(@RequestBody Map<String, Object> paramMap) throws Exception{
		Map<String, Object> pickMap = new HashMap<>();
		//获得满足条件的收派标准记录数，存入响应Map中 pickMap
		pickMap.put("total",pickTimeBiz.countPickTimeWithCriteria(paramMap) );
		//获得满足条件的收派标准记录集合，存入响应Map中 pickMap
		pickMap.put("rows", pickTimeBiz.findPickTimePagenationWithCriteria(paramMap));
		return pickMap;
	}
	/**
	 * 删除
	 * @param drawTimeId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/deletePickTime",method={RequestMethod.POST})
	public Map<String, String> deletePickTime(@RequestParam(required=true,value="drawTimeId[]") String[] drawTimeId)throws Exception{
		Map<String, String> paramMap = new HashMap<>();
		if(pickTimeBiz.deletePickTime(drawTimeId)){
			paramMap.put("status", "success");
		}else {
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	/**
	 * 修改
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/updatePickTime",method={RequestMethod.POST})	
	public Map<String,Object> updatePickTime(Picktime picktime)throws Exception{
		Map<String, Object> uPickMap = new HashMap<>();
		if(pickTimeBiz.updatePickTime(picktime)) {
			uPickMap.put("status", "success");
		}else {
			uPickMap.put("status", "failed");
		}
		return uPickMap;
	}
	
	
	/**
	 * 分页查询所有收派时间
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/findPickTimePagenation",method={RequestMethod.POST})
	public Map<String, Object> findPickTimePagenation(@RequestBody Map<String, Integer> paramMap) throws Exception{
		Map<String, Object> pickMap = new HashMap<>();
		//获得收派标准记录数，存入响应Map中 pickMap
		pickMap.put("total",pickTimeBiz.countPickTime());
		//获得指定页面的收派标准记录集合，存入响应Map中 pickMap
		pickMap.put("rows", pickTimeBiz.findPickTimePagenation(paramMap));
		return pickMap;
	}
	/**
	 * 
	 * @param organization
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/findAllOrganization")
	public List<Organization> findAllOrganization(Organization organization)throws Exception{
		List<Organization> oList = pickTimeBiz.findAllOrganization(organization);
		return oList;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
