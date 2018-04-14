package com.yidu.tencloud.web.controller.system.logcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.log.Log;
import com.yidu.tencloud.biz.system.logbiz.LogBiz;
import com.yidu.tencloud.web.filter.log.OutExcelLog;

/**
 * 日志控制器
 * 
 * @author 邓哲敏
 * @since 2017/11/2
 */
@Controller
public class LogController {
	/**
	 * 注入日志接口
	 */
	@Autowired
	private LogBiz logBiz;

	/**
	 * 设置日志接口
	 * 
	 * @param logBiz
	 *            日志接口
	 */
	public void setLogBiz(LogBiz logBiz) {
		this.logBiz = logBiz;
	}

	/**
	 * 分页查询
	 * 
	 * @param offset
	 *            开始记录数
	 * @param limit
	 *            该页总记录数
	 * @param userName
	 *            操作用户名
	 * @param lowDate
	 *            开始日期
	 * @param highDate
	 *            截止日期
	 * @return 日志集合
	 * @throws Exception
	 *             异常
	 */
	@RequestMapping("/logList")
	@ResponseBody
	public Map<String, Object> logPageQuery(Integer offset, Integer limit, String userName, String lowDate,
			String highDate) throws Exception {
		// 创建一个paramMap接口对象
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 开始记录数
		paramMap.put("offset", offset);
		// 该页的总记录数
		paramMap.put("limit", limit);
		// 操作用户名
		paramMap.put("userName", userName);
		// 开始日期
		paramMap.put("lowDate", lowDate);
		// 截止日期
		paramMap.put("highDate", highDate);
		// 创建一个集合
		List<Log> logList = logBiz.logPageQuery(paramMap);
		// 创建一个map接口对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 调用业务层查询总记录数的方法,并放入map集合中
		map.put("total", logBiz.logCountPageQuery(paramMap));
		// 调用日志的集合放入map中
		map.put("rows", logList);
		// 返回
		return map;
	}

	/**
	 * 删除日志
	 * 
	 * @param logIds
	 * @return 如果删除成功返回success，反之返回fail
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteLogByLogId")
	public String deleteLogByLogId(@RequestParam(value = "logIds[]") String[] logIds) throws Exception {
		// 设置结果
		boolean result = false;
		// 如果
		for (int i = 0; i < logIds.length; i++) {
			// 赋值方法
			result = this.logBiz.deleteLogByLogId(logIds[i]);
		}
		// 如果结果
		if (result) {
			// 返回
			return "success";
		} else {
			// 返回
			return "fail";
		}
	}

	/**
	 * 根据访问资源查找日志
	 * 
	 * @param visitResource
	 *            访问资源
	 * @return 日志集合
	 * @throws Exception
	 */
	@RequestMapping(value = "/findLogByResource")
	public String findLogByResource(Log log) throws Exception {
		// 创建一个paramMap接口对象
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 访问资源
		paramMap.put("visitResource", log.getVisitResource());
		// 创建一个日志集合
		List<Log> logList = logBiz.findLogByResource(paramMap);
		// 如果日志集合不为空
		if (logList != null) {
			// 则成功
			return "success";
			// 反之,
		} else {
			// 失败
			return "fail";
		}

	}

	/**
	 * 导出Excel
	 * 
	 * @param path
	 *            路径
	 * @return 导出结果
	 * @throws IOException
	 *             异常
	 */
	@RequestMapping("/outExcelLog")
	@ResponseBody
	private String outExcelLog(String path) throws IOException {
		// 定义一个变量接收导出文件路径
		String result = OutExcelLog.outExcelLog(logBiz.logPageQuery(null), path);
		// 返回结果
		return result;
	}

}