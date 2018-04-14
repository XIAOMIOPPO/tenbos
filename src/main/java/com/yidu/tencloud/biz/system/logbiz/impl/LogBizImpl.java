package com.yidu.tencloud.biz.system.logbiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.dao.system.logdao.LogMapper;
import com.yidu.tencloud.bean.system.log.Log;
import com.yidu.tencloud.biz.system.logbiz.LogBiz;

/**
 * 日志实现类
 * 
 * @author 邓哲敏
 * @since 2017/11/2
 */
@Service
public class LogBizImpl implements LogBiz {
	/**
	 * 依赖注入日志mapper接口
	 */
	@Autowired
	private LogMapper logMapper;

	/**
	 * 设置日志mapper接口
	 * 
	 * @param logMapper
	 */
	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}

	/**
	 * 日志的分页查询
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 日志集合
	 */
	public List<Log> logPageQuery(Map<String, Object> paramMap) {
		// 返回方法
		return logMapper.logPageQuery(paramMap);
	}

	/**
	 * 添加日志
	 * 
	 * @param log
	 *            日志
	 * @return 如果注册成功返回true，反之返回false
	 */
	public boolean addLog(Log log) {
		// 如果添加方法为1,则成功，反之，则失败
		if (1 == logMapper.addLog(log)) {
			// 成功
			return true;
		}
		// 失败
		return false;
	}

	/**
	 * 删除日志
	 * 
	 * @param logId
	 *            日志Id
	 * @return 如果删除成功返回true，反之返回false
	 */
	public boolean deleteLogByLogId(String logId) {
		// 如果添加方法为1,则成功,反之，则失败
		if (1 == logMapper.deleteLogByLogId(logId)) {
			// 成功
			return true;
		}
		// 失败
		return false;
	}

	/**
	 * 查询总记录数
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 返回总记录数
	 */
	public int logCountPageQuery(Map<String, Object> paramMap) {
		// 返回方法
		return logMapper.logCountPageQuery(paramMap);
	}

	/**
	 * 根据访问资源查找所有日志
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 日志集合
	 */
	public List<Log> findLogByResource(Map<String, Object> paramMap) {
		// 返回方法
		return logMapper.findLogByResource(paramMap);
	}

}