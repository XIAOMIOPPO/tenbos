package com.yidu.tencloud.web.controller.taketosend.receive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.receive.Receive;
import com.yidu.tencloud.biz.taketosend.receivebiz.ReceiveBiz;

public class ReceiveController {

	/**
	 * 注入签单接收接口
	 */
	@Autowired
	private ReceiveBiz recBiz;

	/**
	 * 设置签单接收接口
	 * 
	 * @param recBiz
	 *            签单接收接口
	 */
	public void setRecBiz(ReceiveBiz recBiz) {
		this.recBiz = recBiz;
	}

	/**
	 * 分页查询
	 * 
	 * @param offset
	 *            开始记录数
	 * @param limit
	 *            该页总记录数
	 * @param returnId
	 *            返单号
	 * @param returnType
	 *            返单类型
	 * @return 签单接收集合
	 * @throws Exception
	 *             异常
	 */
	@RequestMapping("/receive")
	@ResponseBody
	public Map<String, Object> recPageQuery(Integer offset, Integer limit, String returnId, String returnType)
			throws Exception {
		// 创建一个paramMap接口对象
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 开始记录数
		paramMap.put("offset", offset);
		// 该页总记录数
		paramMap.put("limit", limit);
		// 返单号
		paramMap.put("returnId", returnId);
		// 返单类型
		paramMap.put("returnType", returnType);
		// 创建签单接收的集合
		List<Receive> recList = recBiz.recPageQuery(paramMap);
		// 创建一个map接口对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 调用业务层查询总记录数的方法,并放入map集合中
		map.put("total", recBiz.recCountPageQuery(paramMap));
		// 调用签单签收的集合放入map中
		map.put("rows", recList);
		// 返回
		return map;
	}

	/**
	 * 删除
	 * 
	 * @param workIds
	 *            工作Id
	 * @return 如果删除成功返回success，反之返回fail
	 * @throws Exception
	 *             异常
	 */
	@RequestMapping(value = "/deleteRecByWorkId")
	public String deleteRecByWorkId(@RequestParam(value = "workIds[]") String[] workIds) throws Exception {
		// 设置结果
		boolean result = false;
		// 如果
		for (int i = 0; i < workIds.length; i++) {
			// 赋值方法
			result = this.recBiz.deleteRecByWorkId(workIds[i]);
		}
		// 如果结果
		if (result) {
			// 返回正确
			return "success";
		} else {
			// 返回错误
			return "fail";
		}
	}
}