package com.yidu.tencloud.web.controller.taketosend.delegationStatistics;

import java.util.ArrayList;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.tencloud.bean.taketosend.delegateDetailed.DelegateDetailed;
import com.yidu.tencloud.bean.taketosend.delegationStatistics.DelegationStatistics;
import com.yidu.tencloud.biz.taketosend.delegationStatisticsbiz.DelegationStatisticsBiz;
/**
 * 委派明细统计的控制器层
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Controller
@RequestMapping("/delegationStatistics")
public class DelegationStatisticsController {
	/**
	 * 对委派明细统计的业务层进行注入
	 */
	@Autowired
	private DelegationStatisticsBiz delegationStatisticsBiz;
    /**
     * 设置业务层
     * @param delegationStatisticsBiz 业务层对象
     */
	public void setDelegationStatisticsBiz(DelegationStatisticsBiz delegationStatisticsBiz) {
		this.delegationStatisticsBiz = delegationStatisticsBiz;
	}
	  
	/**
	 * 查询所有委派明细统计的方法
	 * @param paramMap map接口
	 * @return 委派明细统计集合
	 * @throws Exception
	 */
	@RequestMapping(value="/delegationStatisticsQuery" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findDelegationStatisticsQuery(@RequestBody Map<String,Object> paramMap) throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total",delegationStatisticsBiz.countDelegationStatistics());
		//调用查询分页的方法
		paramMap.put("rows",delegationStatisticsBiz.findDelegationStatisticsQuery(paramMap));
		//返回map
		return paramMap;
	}   
	/**
	 * 查询所有委派明细统计带条件的方法
	 * @param paramMap map接口
	 * @return 委派明细统计集合
	 * @throws Exception
	 */
	@RequestMapping(value="/delegationStatisticsQueryWithCriteria" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findDelegationStatisticsQueryWithCriteria(Map<String,Object> paramMap) throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total", delegationStatisticsBiz.countDelegationStatisticsWithCriteria(paramMap));
		//调用查询分页的方法
		paramMap.put("rows", delegationStatisticsBiz.findDelegationStatisticsQueryWithCriteria(paramMap));
		//返回map
		return paramMap;
	}
	
	/**
     * 打印委派明细统计单的方法
     * @param orgId 网点代码
     * @param request 请求
     * @return 模型视图
     * @throws Exception
     */
	@RequestMapping("/printDelegationStatistics")
	public ModelAndView PrintDelegationStatistics(@RequestParam(value="orgId[]") String[] orgId,HttpServletRequest request) throws Exception{
		//创建一个委派明细统计集合对象
		List<DelegationStatistics> delegateList = new ArrayList<DelegationStatistics>();
		//使用增强的循环，遍历网点代码
		for (String string : orgId) {
			//创建一个委派明细统计对象，并调用打印方法进行打印
			DelegationStatistics delegationStatistics = delegationStatisticsBiz.PrintDelegationStatistics(string);
			//往委派明细统计集合对象中添加一条记录
			delegateList.add(delegationStatistics);
		}
		//建立连接
		request.getSession().setAttribute("DelegationStatistics", delegateList);
		//创建一个modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		//设置路径
		modelAndView.setViewName("/jsps/TakeToSend/delegationStatistics/delegationPrint");
		//返回模型对象
		return modelAndView;
	}
	
	
    
}
