package com.yidu.tencloud.web.controller.basis.bussetingcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.busseting.Bus;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.biz.basis.bussetingbiz.BusSetingBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ResultUtil;
/**
 * 班车设置控制器层
 * @author ZhangZhenhao
 * @since 2018/1/19
 */
@Controller
@RequestMapping("/bus")
public class BusController {
	
	
	@Autowired
	private BusSetingBiz busB;

	public void setBusB(BusSetingBiz busB) {
		this.busB = busB;
	}

	
	/**
	 * 分页查询所有班车
	 * @param paramMap 所有班车集合
	 * @return  Map集合
	 */
	@RequestMapping(value="/findBusPagenation",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findBusPagenation(@RequestBody Map<String,Integer> paramMap){
		//创建Map集合
		Map<String,Object> busMap = new HashMap<>();
		//添加总数
		busMap.put("total",busB.countBus());
		//添加行数
		busMap.put("rows", busB.findBusPagenation(paramMap));
		//返回Map集合
		return busMap;
	}
	
	/**
	 * 带条件的分页查询
	 * @param paramMap 符合条件的班车集合
	 * @return	Map集合
	 */
	@RequestMapping(value="/findBusPagenationWithCriteria",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findBusPagenationWithCriteria(@RequestBody Map<String,Object> paramMap){
		//创建Map集合
		Map<String,Object> busMap = new HashMap<>();
		//添加总数
		busMap.put("total",busB.countBusWithCriteria(paramMap));
		//添加行数
		busMap.put("rows", busB.findBusPagenationWithCriteria(paramMap));
		//返回Map集合
		return busMap;
	}
	
	/**
	 * 添加
	 * @param bus 班车信息
	 * @return 添加结果
	 */
	@RequestMapping("/addBus")
	@ResponseBody
	public Map<String,String> addBus(Bus bus){
		//设置班车ID
		bus.setBusId(IDGenderatorUtil.generateId());
		//添加Bus
		boolean result = busB.addBus(bus);
		//返回结果
 		return ResultUtil.writeResult(result);
	}
	/**
	 * 修改
	 * @param bus 班车信息
	 * @return  修改结果
	 */
	@ResponseBody
	@RequestMapping("/updateBus")
	public Map<String,String> updateBus(Bus bus){
		//修改Bus
		boolean result = busB.updateBus(bus);
		//返回结果
		return ResultUtil.writeResult(result);
	}
	
	/**
	 * 删除班车
	 * @param busId 班车编号
	 * @return 删除结果
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping("/deleteBus")
	public Map<String,String> deleteBus(String[] busId)throws Exception{
		//创建一个布尔型变量并赋值为false
		boolean result = false;
		//遍历集合
		for(String string : busId){
			//返回结果
			result = busB.deleteBus(string);
		}
		return ResultUtil.writeResult(result);
	}

	/**
	 * 查询员工表
	 * @return 员工集合List<Emp>
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/allEmp")
	public List<String> findAllEmpName() throws Exception{
		//返回结果
		return busB.findEmp();
	}
}