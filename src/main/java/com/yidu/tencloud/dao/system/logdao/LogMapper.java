package com.yidu.tencloud.dao.system.logdao;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.system.log.Log;
/**
 * 日志的mapper接口
 * @author 邓哲敏
 * @since 2017/11/2
 */
public interface LogMapper {
	/**
	 * 分页查询
	 * @param paramMap 参数集合
	 * @return List<Log> 日志集合
	 */
	public abstract List<Log> logPageQuery(Map<String,Object> paramMap);
	
	/**
	 * 添加日志
	 * @param log 日志
	 * @return 如果添加成功返回1，反之返回0
	 */
	public abstract int addLog(Log log);
	
	/**
	 * 删除用户
	 * @param logId 日志Id
	 * @return 如果删除成功返回1，反之返回0
	 */
	public abstract int deleteLogByLogId(String logId);
	
	/**
	 * 查询总记录数
	 * @param paramMap 参数集合
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