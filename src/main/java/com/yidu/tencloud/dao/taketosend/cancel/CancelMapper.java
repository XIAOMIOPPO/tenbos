package com.yidu.tencloud.dao.taketosend.cancel;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.cancel.Cancel;

public interface CancelMapper {
	/**
	 * 分页查询 
	 * @param paramMap 参数集合
	 * @return 签单接收集合
	 */
	public abstract List<Cancel> cancelPageQuery(Map<String,Object> paramMap);
	
	/**
	 * 添加
	 * @param receive 签单接收对象
	 * @return 如果注册成功返回true，反之返回false
	 */
	public abstract boolean addCancel(Cancel cancel);
	
	/**
	 * 删除
	 * @param workId 工作单号
	 * @return 如果删除成功返回true，反之返回false
	 */
	public abstract boolean deleteCancelByWorkId(String workId);	
	
	/**
	 * 查询总记录数
	 * @param paramMap  参数集合
	 * @return  返回总记录数 
	 */
	public abstract int cancelCountPageQuery(Map<String,Object> paramMap);

}
