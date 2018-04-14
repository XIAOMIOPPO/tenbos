package com.yidu.tencloud.web.controller.basis.pickstandardcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.pickstandard.PickStandard;
import com.yidu.tencloud.biz.basis.pickstandardbiz.PickStandardBiz;

/**
 * 收派标准控制器(基于注解)
 * 
 * @author 廖晓翠
 * @since 2017/11/06
 */
@Controller
@RequestMapping("/deliverCriterion")
public class PickStandardController {
	//保留对逻辑层的引用
	@Autowired
	private PickStandardBiz deliverCriterionBiz;

	public void setDeliverCriterionBiz(PickStandardBiz deliverCriterionBiz) {
		this.deliverCriterionBiz = deliverCriterionBiz;
	}
	
	/**
	 * 查找所有带分页
	 * @param paramMap 参数
	 * @return 返回结果
	 * @throws Exception 异常
	 */
	@RequestMapping(value = "/findAllDeliverCriterionPageQuery.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String,Object> findAllDeliverCriterionPageQuery(@RequestBody Map<String,Object>paramMap)throws Exception{
		//将总记录数放入集合
		paramMap.put("totals", deliverCriterionBiz.countAllDeliverCriterion());
		//将所有收派标准分页放入集合中
		paramMap.put("rows", deliverCriterionBiz.findAllDeliverPageQuery(paramMap));
		//返回结果集
		return paramMap;
	}
	
	/**
	 * 模糊查询带分页
	 * @param map参数
	 * @return 返回接口
	 * @throws Exception 异常
	 */
	@RequestMapping(value = "/criterDeliverCriterion.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> criterDeliverCriterion(@RequestBody Map<String,Object>map) throws Exception {
		//创建一个结果集
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//将模糊查找的总记录数放入结果集
		paramMap.put("total", deliverCriterionBiz.countAllDeliverCriterion());
		//将所有模糊查找到的收派标准分页放入结果集
		paramMap.put("rows", deliverCriterionBiz.criterDeliverCriterion(map));
		//返回结果集
		return paramMap;
		
	}
	
	/**
	 * 添加收派标准
	 * @param deliverCriterion 收派标准对象
	 * @return 返回参数集合
	 */
	@RequestMapping("/addDeliverCriterion.action")
	@ResponseBody
	public Map<String,Object> addDeliverCriterion(PickStandard deliverCriterion){
		//新建一个结果集
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//如果收派标准名相同
		if(deliverCriterionBiz.findDeliverCriterioByName(deliverCriterion.getDeliverName()) == false) {
			//将状态放入结果集
			paramMap.put("status", "Name");
		}else {
			//添加
			if(deliverCriterionBiz.addDeliverCriterion(deliverCriterion)) {
				//添加成功
				paramMap.put("status", "success");
			}else {
				//添加失败
				paramMap.put("status", "failed");
			}
		}
		//返回结果集
		return paramMap;
	}
	
	/**
	 * 根据Id修改收派标准
	 * @param deliverCriterion 收派标准对象
	 * @return 返回结果
	 * @throws Exception 异常
	 */
	@RequestMapping(value = "/updateIsUseById.action")
	@ResponseBody
	public String updateIsUseById(PickStandard deliverCriterion) throws Exception{
		//创建一个结果集
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//将收派标准Id放sU入结果集
		paramMap.put("deliverId", deliverCriterion.getDeliverId());
		//将是否禁用放入结果集
		paramMap.put("isUse", deliverCriterion.getIsUse());
		//调用逻辑层的修改方法
		boolean result = deliverCriterionBiz.updateIsUseById(paramMap);
		//修改
		if(result){
			//修改成功
			return "success";
		}else {
			//修改失败
			return "failed";
		}
	}
	
	/**
	 * 根据Id删除收派标准
	 * @param deliverIds 收派标准Id的数组
	 * @return 返回结果
	 * @throws Exception 异常
	 */
	@RequestMapping(value = "/deleteDeliverCriterion.action")
	@ResponseBody
	public String deleteDeliverCriterion(String[] deliverIds) throws Exception{
		//定义一个数字类型的遍历
		int result = 0;
		//遍历所有的收派标准Id
		for(String deliverId : deliverIds) {
			//调用逻辑层的方法
			result = deliverCriterionBiz.deleteDeliverCriterion(deliverId);
		}
		//删除的结果
		if(result == 1) {
			//删除成功
			return "success";
		}
		//删除失败
		return "failed";
	}
}
