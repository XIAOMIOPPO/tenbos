package com.yidu.tencloud.web.controller.taketosend.responsibilityDot;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.propaganda.Propaganda;
import com.yidu.tencloud.bean.taketosend.responsibilityDot.ResponsibilityDot;
import com.yidu.tencloud.biz.taketosend.responsibilityDotbiz.ResponsibilityDotBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;
/**
 * 责任网点设置的控制器层
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Controller
@RequestMapping("/responsibilityDot")
public class ResponsibilityDotController {
	/**
	 * 对责任网点设置的业务层进行注入
	 */
    @Autowired
	private ResponsibilityDotBiz responsibilityDotBiz;

    /**
     * 设置业务层
     * @param responsibilityDotBiz 业务层对象
     */
	public void setResponsibilityDotBiz(ResponsibilityDotBiz responsibilityDotBiz) {
		this.responsibilityDotBiz = responsibilityDotBiz;
	}

	/**
	 * 查询所有责任网点设置的方法
	 * @param paramMap map接口
	 * @return 责任网点设置集合
	 * @throws Exception
	 */
	@RequestMapping(value="/responsibilityDotQuery" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findResponsibilityDotQuery(@RequestBody Map<String,Object> paramMap) throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total", responsibilityDotBiz.countResponsibilityDot());
		//调用查询分页的方法
		paramMap.put("rows", responsibilityDotBiz.findResponsibilityDotQuery(paramMap));
		//返回map
		return paramMap;
	}
	
	/**
	 * 查询所有责任网点设置带条件的方法
	 * @param paramMap map接口
	 * @return 责任网点设置集合
	 * @throws Exception
	 */
	@RequestMapping(value="/responsibilityDotQueryWithCriteria" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findResponsibilityDotQueryWithCriteria(@RequestBody Map<String,Object> paramMap) throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total", responsibilityDotBiz.countResponsibilityDotWithCriteria(paramMap));
		//调用查询分页的方法
		paramMap.put("rows", responsibilityDotBiz.findResponsibilityDotQueryWithCriteria(paramMap));
		//返回map
		return paramMap;
	}
	
	/**
	 * 添加责任网点设置的方法
	 * @param operatingTime 操作时间
	 * @param responsibilityDot 责任网点对象
	 * @return Map接口对象
	 * @throws Exception
	 */
	@RequestMapping("/addresponsibilityDot")
	@ResponseBody
	public Map<String,String> addResponsibilityDot(String operatingTime,ResponsibilityDot responsibilityDot) throws Exception{
		//设置责任网点Id,使用工具类自动生成Id
		responsibilityDot.setResponsibilityDotId(IDGenderatorUtil.generateId());
		//设置操作时间
		responsibilityDot.setOperatingTime(new Date(Timestamp.valueOf(operatingTime).getTime()));
		//创建一个Map接口对象
		Map<String,String> parMap = new HashMap<String,String>();
		//判断是否添加成功
		if(responsibilityDotBiz.addResponsibilityDot(responsibilityDot)) {
			//操作成功
			parMap.put("status", "success");
		}else {
			//操作失败
			parMap.put("status", "filed");
		}     
		//返回map
		return parMap;
	}
	
	/**
	 * 删除责任网点方法
	 * @param responsibilityDotId 责任网点Id
	 * @return 字符串
	 * @throws Exception
	 */
	@RequestMapping("/deleteresponsibilityDot")
	@ResponseBody
	public String deleteResponsibilityDot(String[] responsibilityDotId) throws Exception{
		//设置一个布尔型的变量，默认为false
		boolean result = false;
		//遍历责任网点Id
		for (String string : responsibilityDotId) {
			//调用删除方法，用设置的变量接收
			result = responsibilityDotBiz.deleteResponsibilityDot(string);
		}
		//判断是否删除成功
		if(result) {
			//删除成功
			return "success";
		}
		//删除失败
		return "filed";
	}
	
	/**
	 * 修改责任网点的方法
	 * @param responsibilityDotId 责任网点Id
	 * @param franchiseeCode 加盟商代码
	 * @param franchisee 加盟商
	 * @param lateStandard 晚点标准
	 * @param cancelSign 作废标志
	 * @param operator 操作人
	 * @param operatingTime 操作时间
	 * @return Map接口对象
	 * @throws Exception
	 */
	@RequestMapping("/updateresponsibilityDot")
	@ResponseBody
	public Map<String,Object> updateResponsibilityDot(String responsibilityDotId,String franchiseeCode,String franchisee,Integer lateStandard,String cancelSign,String operator,String operatingTime) throws Exception {
		//创建一个map接口对象
		Map<String,Object> parMap = new HashMap<String,Object>();
		//格式化时间
		SimpleDateFormat time = new SimpleDateFormat("yyyy-mm-dd");
		//使用map接口为责任网点Id赋值
		parMap.put("responsibilityDotId", responsibilityDotId);
		//使用map接口为加盟商代码赋值
		parMap.put("franchiseeCode", franchiseeCode);
		//使用map接口为加盟商赋值
		parMap.put("franchisee", franchisee);
		//使用map接口为晚点标准赋值
		parMap.put("lateStandard", lateStandard);
		//使用map接口为作废标志赋值
		parMap.put("cancelSign", cancelSign);
		//使用map接口为操作人赋值
		parMap.put("operator", operator);
		//使用map接口为操作时间赋值
		parMap.put("operatingTime", new Date(Timestamp.valueOf(operatingTime).getTime()));
		//调用业务层的修改责任网点方法
		boolean result = responsibilityDotBiz.updateResponsibilityDot(parMap);
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
	 * 查询组织结构方法
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findOrganId")
	@ResponseBody
	public List<String> findOrganizationId() throws Exception{
		return responsibilityDotBiz.findOrganizationWithOrgId();
	}
	
	/**
	 * 查询登录角色
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findUser")
	@ResponseBody
	public String findUser() throws Exception{
		//调用工具类获得登录角色名
		return ShiroUtil.getUser().getUserName();
	}
}