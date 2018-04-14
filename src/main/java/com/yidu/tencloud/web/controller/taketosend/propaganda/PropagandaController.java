package com.yidu.tencloud.web.controller.taketosend.propaganda;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.propaganda.Propaganda;
import com.yidu.tencloud.biz.taketosend.propagandabiz.PropagandaBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
/**
 * 宣传任务的控制器层
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Controller
@RequestMapping("/propaganda")
public class PropagandaController {
	/**
	 * 对宣传任务的业务层进行注入
	 */
	@Autowired
	private PropagandaBiz propagandaBiz;
	/**
     * 设置业务层
     * @param propagandaBiz 业务层对象
     */ 
	public void setPropagandaBiz(PropagandaBiz propagandaBiz) {
		this.propagandaBiz = propagandaBiz;
	} 
	
	/**
	 * 查询所有宣传任务的方法
	 * @param paramMap map接口
	 * @return 责任网点设置集合
	 * @throws Exception
	 */
	@RequestMapping(value="/propagandaPageQuery" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findPropagandaQuery(@RequestBody Map<String,Object> paramMap) throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total", propagandaBiz.countPropaganda());
		//调用查询分页的方法
		paramMap.put("rows", propagandaBiz.findPropagandaQuery(paramMap));
		//返回map
		return paramMap;
	}
	
	/**
	 * 查询所有宣传任务带条件的方法
	 * @param paramMap map接口
	 * @return 宣传任务集合
	 * @throws Exception
	 */
	@RequestMapping(value="/partitionPageQueryWithCriteria" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findPropagandaQueryWithCriteria(@RequestBody Map<String,Object> paramMap)throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total", propagandaBiz.countPropagandaWithCriteria(paramMap));
		//调用查询分页的方法
		paramMap.put("rows", propagandaBiz.findPropagandaQueryWithCriteria(paramMap));
		//返回map
		return paramMap;
	}
	
	/**
	 * 添加宣传任务的方法
	 * @param PreleaseTime 发布时间
	 * @param PfailureTime 失效时间
	 * @param PupdateTime 更新时间
	 * @param propaganda 宣传任务对象
	 * @return Map接口对象
	 * @throws Exception
	 */
	@RequestMapping("/addPropaganda")
	@ResponseBody
	public Map<String,String> addPropaganda(String PreleaseTime,String PfailureTime,String PupdateTime,Propaganda propaganda) throws Exception{
		//设置宣传任务Id，调用工具类自动生成Id
		propaganda.setPropagandaId(IDGenderatorUtil.generateId());
		//设置发布时间
		propaganda.setReleaseTime(new Date(Timestamp.valueOf(PreleaseTime).getTime()));
		//设置失效时间
		propaganda.setFailureTime(new Date(Timestamp.valueOf(PfailureTime).getTime()));
		//设置更新时间
		propaganda.setUpdateTime(new Date(Timestamp.valueOf(PupdateTime).getTime()));
		//创建一个map接口对象
		Map<String,String> parMap = new HashMap<String,String>();
		//判断是否添加成功
		if(propagandaBiz.addPropaganda(propaganda)) {
			//添加成功
			parMap.put("status", "success");
		}else {
			//添加失败
			parMap.put("status", "filed");
		}
		//返回map
		return parMap;
	}
	
	/**
	 * 删除宣传任务的方法
	 * @param propagandaId 宣传任务Id
	 * @return 字符串
	 * @throws Exception
	 */
	@RequestMapping("/deletePropaganda")
	@ResponseBody
	public String deletePropaganda(String[] propagandaId) throws Exception{
		//设置一个布尔型的变量，默认为false
		boolean result = false;
		//遍历宣传任务Id
		for(String string:propagandaId) {
			//调用删除方法，用设置的变量接收
			result = propagandaBiz.deletePropaganda(string);
		}
		//判断是否删除成功
		if(result) {
			//删除成功
			return "success";
		}else {
			//删除失败
			return "filed";
		}
	}
	/**
	 * 修改宣传任务的方法
	 * @param propagandaId 宣传任务Id
	 * @param publicityOutline 宣传概要
	 * @param releaseTime 发布时间
	 * @param failureTime 失效时间
	 * @param status 状态
	 * @param propagandaContent 宣传内容
	 * @return Map接口对象
	 * @throws Exception
	 */
	@RequestMapping("/updatePropaganda")
	@ResponseBody
	public Map<String,Object> updatePropaganda(String propagandaId,String publicityOutline,String releaseTime,String failureTime,String status,String propagandaContent) throws Exception {
		//创建一个map接口对象
		Map<String,Object> parMap = new HashMap<String,Object>();
		//格式化时间
		SimpleDateFormat time = new SimpleDateFormat("yyyy-mm-dd");
		//使用map接口为宣传任务Id赋值
		parMap.put("propagandaId", propagandaId);
		//使用map接口为宣传概要赋值
		parMap.put("publicityOutline", publicityOutline);
		//使用map接口为发布时间赋值
		parMap.put("releaseTime", new Date(Timestamp.valueOf(releaseTime).getTime()));
		//使用map接口为失效时间赋值
		parMap.put("failureTime", new Date(Timestamp.valueOf(failureTime).getTime()));
		//使用map接口为状态赋值
		parMap.put("status", status);
		//使用map接口为宣传内容赋值
		parMap.put("propagandaContent", propagandaContent);
		//调用业务层的修改宣传任务方法
		boolean result = propagandaBiz.updatePropaganda(parMap);
		//判断是否修改成功
		if(result) {
			//修改成功
			parMap.put("status", "success");
		}else {
			//修改失败
			parMap.put("status", "filed");
		}
		//返回map
		return parMap;
	}
	
	/**
	 * 查询一星期内的宣传任务
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findWeekPropaganda")
	@ResponseBody
	public int findWeekPropaganda() throws Exception{
		return propagandaBiz.findWeekPropaganda();
	}
}
