package com.yidu.tencloud.web.controller.taketosend.dispatch;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.dispatch.Dispatch;
import com.yidu.tencloud.biz.taketosend.dispatch.DispatchBiz;
import com.yidu.tencloud.web.filter.dispatch.OutExcelDispatch;

/**
 * 调度查询
 * 
 * @author 邓哲敏
 * @since
 */
@Controller
@RequestMapping("/dispatch")
public class DispatchController {

	/**
	 * 保留对service层的引用
	 */
	@Autowired
	private DispatchBiz dispatchBiz;

	/**
	 * service的set方法
	 * 
	 * @param dispatchInquiryService
	 */
	public void setDispatchBiz(DispatchBiz dispatchBiz) {
		this.dispatchBiz = dispatchBiz;
	}

	/**
	 * 调度查询的分页查询
	 * 
	 * @param pageSize
	 *            分页大小
	 * @param pageNumber
	 *            分页页码
	 * @param acceptingUnit
	 *            受理单位
	 * @param empName
	 *            取件员
	 * @return 调度对象
	 * @throws Exception
	 *             异常
	 */
	@RequestMapping(value = "dispatchPageQuery.action")
	public @ResponseBody Map<String, Object> dispatchPageQuery(Integer pageSize, Integer pageNumber,
			String acceptingUnit, String empName) throws Exception {
		// 创建调度集合
		List<Dispatch> dispatchList = dispatchBiz.dispatchPageQuery(pageSize, pageNumber, acceptingUnit, empName);
		// 创建一个resultMap接口对象
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 调用业务层查询总记录数的方法,并放入resultMap集合中
		resultMap.put("total", dispatchBiz.dispatchCountPageQuery());
		// 调用调度集合放入resultMap中
		resultMap.put("rows", dispatchList);
		// 返回对象
		return resultMap;

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
	@RequestMapping("outExcelDispatch.action")
	@ResponseBody
	private String outExcelDispatch(String path) throws IOException {
		// 定义一个变量接收导出文件路径
		String result = OutExcelDispatch.outExcelDispatch(dispatchBiz.dispatchPageQuery(null), path);
		// 返回结果
		return result;
	}
}