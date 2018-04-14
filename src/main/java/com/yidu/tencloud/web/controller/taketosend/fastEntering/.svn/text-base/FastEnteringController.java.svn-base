package com.yidu.tencloud.web.controller.taketosend.fastEntering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yidu.tencloud.bean.taketosend.fastEntering.FastEntering;
import com.yidu.tencloud.biz.taketosend.fasterEntering.FastEnteringBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 快速录入控制器类(基于注解)
 * @author 廖晓翠
 * @since 2017-12-2 09:03:48
 */
@Controller
@RequestMapping("/fastEntering")
public class FastEnteringController {
	/**
	 * 保留对业务逻辑层的引用
	 */
	@Autowired
	private FastEnteringBiz fastEnteringBiz;

	public void setFastEnteringBiz(FastEnteringBiz fastEnteringBiz) {
		this.fastEnteringBiz = fastEnteringBiz;
	}

	/**
	 * 查找配载要求
	 * @param recordName
	 * @return
	 */
	@RequestMapping("/findStowageRequirement.action")
	@ResponseBody
	public List<String> findStowageRequirement(String recordName){
		//接收业务层的方法
		List<String> helpFilesList = fastEnteringBiz.findStowageRequirement(recordName);
		//返回结果
		return helpFilesList;
	}
	
	/**
	 * 添加工作单快速录入
	 * @param workSheet 工作单对象
	 * @param rule 规则对象
	 * @return    结果集
	 * @throws Exception 异常
	 */
	@RequestMapping("/addWorkSheet")
	@ResponseBody
	public  Map<String, Object> addWorkSheet(String fastEntering)throws Exception{
		//新创一个对象集合
		ObjectMapper mapper = new ObjectMapper();
		//将这个集合转换为Java类型的对象数组
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, FastEntering.class);
		//将对象数组转换为Java对象
		List<FastEntering> fastEnterings = mapper.readValue(fastEntering, javaType);
		//创一个结果集
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//创一个错误集合
		List<String> errors = new ArrayList<String>();
		//创一个单号重复集合
		List<String> renos = new ArrayList<String>();
		
		//遍历这个Java对象
		for(FastEntering fastItem:fastEnterings) {
			//设置工作单Id
			fastItem.setWorkSheetId(IDGenderatorUtil.generateId());
			//设置工作单来源
			fastItem.setWorkSheetSource("快速录入");
			//设置规则Id
			fastItem.setRuleId(IDGenderatorUtil.generateId());
			//如果工作单编号不重复
			if(fastEnteringBiz.findWorkSheetNoByWorkSheetNo(fastItem.getWorkSheetNo())) {
				//添加
				int result = fastEnteringBiz.addWorkSheet(fastItem);
				//如果添加结果<=0
				if(result<=0) {
					//添加失败
					errors.add(fastItem.getWorkSheetNo());
				}
			}else {
				//添加失败 工作单号重复
				renos.add(fastItem.getWorkSheetNo());
			}
		}
		//将错误集合放入结果集
		resultMap.put("errors", errors);
		//将单号重复集合放入结果集
		resultMap.put("renos", renos);
		//返回结果集
		return resultMap;
	}
}
