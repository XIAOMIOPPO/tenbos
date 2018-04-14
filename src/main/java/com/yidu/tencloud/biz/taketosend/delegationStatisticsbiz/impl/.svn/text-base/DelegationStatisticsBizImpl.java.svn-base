package com.yidu.tencloud.biz.taketosend.delegationStatisticsbiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.delegateDetailed.DelegateDetailed;
import com.yidu.tencloud.bean.taketosend.delegationStatistics.DelegationStatistics;
import com.yidu.tencloud.biz.taketosend.delegationStatisticsbiz.DelegationStatisticsBiz;
import com.yidu.tencloud.dao.taketosend.delegationstatistics.DelegationStatisticsMapper;
/**
 * 业务逻辑层实现类
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Service
public class DelegationStatisticsBizImpl implements DelegationStatisticsBiz{
	//对责任网点mapper接口进行注入
	@Autowired
	private DelegationStatisticsMapper delegationStatisticsMapper;
	
	/**
	 * 设置委派明细单mapper接口
	 * @param delegationStatisticsMapper mapper接口
	 */
	public void setDelegationStatisticsMapper(DelegationStatisticsMapper delegationStatisticsMapper) {
		this.delegationStatisticsMapper = delegationStatisticsMapper;
	}
	
	/**
	 * 查询所有委派明细单
	 * @param paramMap map接口
	 * @return 委派明细单集合
	 */
	@Override
	public List<DelegationStatistics> findDelegationStatisticsQuery(Map<String,Object> paramMap){
		return delegationStatisticsMapper.findDelegationStatisticsQuery(paramMap);
	}
	/**
	 * 打印委派明细单
	 * @param orgId 组织结构Id
	 * @return 是否打印成功
	 */
	@Override
	public DelegationStatistics PrintDelegationStatistics(String orgId) {
		return delegationStatisticsMapper.PrintDelegationStatistics(orgId);
	}
	/**
	 * 记录委派明细单总数
	 * @return 总数
	 */
	@Override
	public int countDelegationStatistics() {
		return delegationStatisticsMapper.countDelegationStatistics();
	}
	
	/**
	 * 记录委派明细单总数带条件
	 * @param paramMap map接口
	 * @return 委派明细单集合
	 */
	@Override
	public int countDelegationStatisticsWithCriteria(Map<String,Object> paramMap) {
		return delegationStatisticsMapper.countDelegationStatisticsWithCriteria(paramMap);
	}
	
	/**
	 * 查询所有委派明细单带条件
	 * @param paramMap map接口
	 * @return 委派明细单集合
	 */
	@Override
	public List findDelegationStatisticsQueryWithCriteria(Map<String,Object> paramMap) {
		return delegationStatisticsMapper.findDelegationStatisticsQueryWithCriteria(paramMap);
	}
	
}
