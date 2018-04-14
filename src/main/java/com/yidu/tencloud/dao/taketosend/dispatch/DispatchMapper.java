package com.yidu.tencloud.dao.taketosend.dispatch;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.dispatch.Dispatch;

public interface DispatchMapper {

	/**
	 * 查询调度并分页
	 * @param paramMap 参数集合
	 * @return 返回调度集合
	 */
	List<Dispatch> dispatchPageQuery(Map<String, Object> paramMap);

	/**
	 * 计算调度的总记录数
	 * @return 
	 */
	int dispatchCountPageQuery();
}
