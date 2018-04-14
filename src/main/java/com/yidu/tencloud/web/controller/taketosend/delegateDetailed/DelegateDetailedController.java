package com.yidu.tencloud.web.controller.taketosend.delegateDetailed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.tencloud.bean.taketosend.delegateDetailed.DelegateDetailed;
import com.yidu.tencloud.biz.taketosend.delegateDetailedbiz.DelegateDetailedBiz;
/**
 * 委派明细的控制器层
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Controller
@RequestMapping("/delegateDetailed")
public class DelegateDetailedController {
	/**
	 * 对委派明细业务层进行注入
	 */
	@Autowired
	private DelegateDetailedBiz delegateDetailedBiz;
    /**
     * 设置业务层
     * @param delegateDetailedBiz 业务层对象
     */
	public void setDelegateDetailedBiz(DelegateDetailedBiz delegateDetailedBiz) {
		this.delegateDetailedBiz = delegateDetailedBiz;
	}
	  
	/**
	 * 查询所有的委派明细的方法
	 * @param paramMap map接口
	 * @return 委派明细集合
	 * @throws Exception
	 */
	@RequestMapping(value="/delegateDetailedQuery" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findDelegateDetailedQuery(@RequestBody Map<String,Object> paramMap) throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total", delegateDetailedBiz.countDelegateDetailed());
		//调用查询分页的方法
		paramMap.put("rows", delegateDetailedBiz.findDelegateDetailedQuery(paramMap));
		//返回map
		return paramMap;
	}
	/**
	 * 查询所有的委派明细带条件的方法
	 * @param paramMap map接口
	 * @return 委派明细集合
	 * @throws Exception
	 */
	@RequestMapping(value="/delegateDetailedQueryWithCriteria" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findDelegateDetailedQueryWithCriteria(@RequestBody Map<String,Object> paramMap) throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total", delegateDetailedBiz.countDelegateDetailedWithCriteria(paramMap));
		//调用查询分页的方法
		paramMap.put("rows", delegateDetailedBiz.findDelegateDetailedQueryWithCriteria(paramMap));
		return paramMap;
	}
    /**
     * 打印委派明细单的方法
     * @param workSheetNo 工作单编号
     * @param request 请求
     * @return 模型视图
     * @throws Exception
     */
	@RequestMapping("/printDelegateDetailed")
	public ModelAndView PrintDelegateDetailed(@RequestParam(value="workSheetNo[]") String[] workSheetNo,HttpServletRequest request) throws Exception{
		//创建一个委派明细集合对象
		List<DelegateDetailed> delegateList = new ArrayList<DelegateDetailed>();
		//使用增强的循环，遍历工作单编号
		for (String string : workSheetNo) {
			//创建一个委派明细对象，并调用打印方法进行打印
			DelegateDetailed delegateDetailed = delegateDetailedBiz.PrintDelegateDetailed(string);
			//往委派明细集合对象中添加一条记录
			delegateList.add(delegateDetailed);
		}
		//建立连接
		request.getSession().setAttribute("DelegateDetailed", delegateList);
		//创建一个modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		//设置路径
		modelAndView.setViewName("/jsps/TakeToSend/delegateDetailed/delegatePrint");
		//返回模型对象
		return modelAndView;
	}
	
}
