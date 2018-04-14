package com.yidu.tencloud.web.controller.taketosend.assignmentDetailed;

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

import com.yidu.tencloud.bean.taketosend.assignmentDetailed.AssignmentDetailed;
import com.yidu.tencloud.bean.taketosend.delegateDetailed.DelegateDetailed;
import com.yidu.tencloud.biz.taketosend.assignmentDetailedbiz.AssignmentDetailedBiz;

/**
 * 受派明细的控制器层
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Controller
@RequestMapping("/assignmentDetailed")
public class AssignmentDetailedController {
	/**
	 * 对受派明细的业务层进行注入
	 */
	@Autowired
	 private AssignmentDetailedBiz assignmentDetailedBiz;
    /**
     * 设置业务层
     * @param assignmentDetailedBiz 业务层对象
     */
	public void setAssignmentDetailedBiz(AssignmentDetailedBiz assignmentDetailedBiz) {
		this.assignmentDetailedBiz = assignmentDetailedBiz;
	}
	 
	/**
	 * 查询所有受派明细的方法
	 * @param paramMap map接口
	 * @return 受派明细集合
	 * @throws Exception
	 */
	@RequestMapping(value="/assignmentDetailedQuery" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findAssignmentDetailedQuery(@RequestBody Map<String,Object> paramMap)throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total",assignmentDetailedBiz.countAssignmentDetailed());
		//调用查询分页的方法
		paramMap.put("rows",assignmentDetailedBiz.findAssignmentDetailedQuery(paramMap));
		//返回map
		return paramMap;
	}
	/**
	 * 查询所有受派明细带条件的方法
	 * @param paramMap map接口
	 * @return 受派明细集合
	 * @throws Exception
	 */
	@RequestMapping(value="/assignmentDetailedQueryWithCriteria" ,method= {RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findAssignmentDetailedQueryWithCriteria(@RequestBody Map<String,Object> paramMap)throws Exception{
		//调用查询记录数的方法，对查询到的数据进行记录
		paramMap.put("total",assignmentDetailedBiz.countAssignmentDetailedWithCriteria(paramMap));
		//调用查询分页的方法
		paramMap.put("rows",assignmentDetailedBiz.findAssignmentDetailedQueryWithCriteria(paramMap));
		//返回map
		return paramMap;
	}
	
	/**
     * 打印受派明细单的方法
     * @param workSheetNo 工作单编号
     * @param request 请求
     * @return 模型视图
     * @throws Exception
     */
	@RequestMapping("/printAssignmentDetailed")
	@ResponseBody
	public ModelAndView PrintAssignmentDetailed(@RequestParam(value="workSheetNo[]")String[] workSheetNo,HttpServletRequest request) throws Exception{
		//创建一个受派明细集合对象
				List<AssignmentDetailed> assignmentList = new ArrayList<AssignmentDetailed>();
				//使用增强的循环，遍历工作单编号
				for (String string : workSheetNo) {
					//创建一个受派明细对象，并调用打印方法进行打印
					AssignmentDetailed assignmentDetailed = assignmentDetailedBiz.PrintAssignmentDetailed(string);
					//往受派明细集合对象中添加一条记录
					assignmentList.add(assignmentDetailed);
				}
				//建立连接
				request.getSession().setAttribute("AssignmentDetailed", assignmentList);
				//创建一个modelAndView对象
				ModelAndView modelAndView = new ModelAndView();
				//设置路径
				modelAndView.setViewName("/jsps/TakeToSend/assignmentDetailed/assignmentPrint");
				//返回模型对象
				return modelAndView;
   }
}
