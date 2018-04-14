package com.yidu.tencloud.biz.taketosend.dispatch.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.dispatch.Dispatch;
import com.yidu.tencloud.biz.taketosend.dispatch.DispatchBiz;
import com.yidu.tencloud.dao.taketosend.dispatch.DispatchMapper;

/**
 * 调度实现类
 * 
 * @author 邓哲敏
 * @since 2017/11/23
 */
@Service("DispatchBiz")
public class DispatchBizImpl implements DispatchBiz {

	/**
	 * 依赖注入调度mapper接口
	 */
	@Autowired
	private DispatchMapper dispatchMapper;

	/**
	 * 设置调度mapper接口
	 * 
	 * @param dispatchMapper
	 */
	public void setDispatchMapper(DispatchMapper dispatchMapper) {
		this.dispatchMapper = dispatchMapper;
	}

	/**
	 * 分页查询
	 * 
	 * @param pageSize
	 *            页面大小
	 * @param pageNumber
	 *            页面数
	 * @param acceptingUnit
	 *            受理单位
	 * @param empName
	 *            取件员
	 * @return 调度对象
	 */
	public List<Dispatch> dispatchPageQuery(Integer pageSize, Integer pageNumber, String acceptingUnit,
			String empName) {
		// 定义一个Map集合
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 页面大小
		paramMap.put("pageSize", pageSize);
		// 页面数
		paramMap.put("pageNumber", pageNumber);
		// 受理单位
		paramMap.put("acceptingUnit", acceptingUnit);
		// 取件员
		paramMap.put("empName", empName);

		// 返回方法
		return dispatchMapper.dispatchPageQuery(paramMap);
	}

	/**
	 * 计算总记录数
	 */
	public int dispatchCountPageQuery() {
		// 返回方法
		return dispatchMapper.dispatchCountPageQuery();
	}

	/**
	 * 查询调度并分页
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 调度集合
	 */
	public List<Dispatch> dispatchPageQuery(Map<String, Object> paramMap) {
		// 返回方法
		return dispatchMapper.dispatchPageQuery(paramMap);
	}

}