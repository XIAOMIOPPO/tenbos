package com.yidu.tencloud.biz.taketosend.dispatch;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.dispatch.Dispatch;

/**
 * 调度接口
 * @author 邓哲敏
 * @since 2017/11/23
 */
@Service("DispatchBiz")
public interface DispatchBiz {  
	/**
	 * 分页查询
	 * @param pageSize 页面大小
	 * @param pageNumber 页面数
	 * @param acceptingUnit 受理单位
	 * @param empName 取件员
	 * @return 调度对象
	 */
	List<Dispatch> dispatchPageQuery(Integer pageSize, Integer pageNumber, String acceptingUnit, String empName);

	/**
	 * 计算总记录数
	 */
	int dispatchCountPageQuery();

	/**
	 * 查询调度并分页
	 * @param paramMap 参数集合
	 * @return 调度集合
	 */
	List<Dispatch> dispatchPageQuery(Map<String,Object> paramMap);
}
