package com.yidu.tencloud.biz.taketosend.delegationStatisticsbiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.delegationStatistics.DelegationStatistics;
/**
 * 业务逻辑层
 * @author 袁棋凡
 * @since 2017/12/25
 */
public interface DelegationStatisticsBiz {
      /**
       * 查询所有委派明细单
       * @param paramMap map接口
       * @return 委派明细单集合
       */
	  public List<DelegationStatistics> findDelegationStatisticsQuery(Map<String,Object> paramMap);
	  /**
	   * 打印委派明细单
	   * @param orgId 组织结构Id
	   * @return 是否打印成功
	   */
	  public DelegationStatistics PrintDelegationStatistics(String orgId);
	  /**
	   * 记录委派明细单的总数
	   * @return 总数
	   */
	  public int countDelegationStatistics();
	  /**
	   * 记录委派明细单的总数带条件
	   * @param paramMap map接口
	   * @return 总数
	   */
	  public int countDelegationStatisticsWithCriteria(Map<String,Object> paramMap);
	  /**
	   * 查询所有委派明细单带条件
	   * @param paramMap map接口
	   * @return 委派明细单集合
	   */
	  public List<DelegationStatistics> findDelegationStatisticsQueryWithCriteria(Map<String,Object> paramMap);
	
}
