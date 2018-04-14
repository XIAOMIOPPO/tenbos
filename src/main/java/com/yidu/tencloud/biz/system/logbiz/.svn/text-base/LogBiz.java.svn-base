package com.yidu.tencloud.biz.system.logbiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.system.log.Log;

/**
 * 日志接口
 * @author 邓哲敏
 * @since 2017/11/2
 */
public interface LogBiz {
	/**
	 * 分页查询 
	 * @param paramMap 参数集合
	 * @return 日志集合
	 */
	public abstract List<Log> logPageQuery(Map<String,Object> paramMap);
	
	/**
	 * 添加日志
	 * @param log 日志
	 * @return 如果注册成功返回true，反之返回false
	 */
	public abstract boolean addLog(Log log);
	
	/**
	 * 删除日志
	 * @param logId 日志Id
	 * @return 如果删除成功返回true，反之返回false
	 */
	public abstract boolean deleteLogByLogId(String logId);	
	
	/**
	 * 查询总记录数
	 * @param paramMap  参数集合
	 * @return  返回总记录数 
	 */
	public abstract int logCountPageQuery(Map<String,Object> paramMap);
	
	/**
	 * 根据访问资源查找所有日志
	 * @param paramMap  参数集合
	 * @return  日志集合
	 */
	public abstract List<Log> findLogByResource(Map<String,Object> paramMap);
	
}