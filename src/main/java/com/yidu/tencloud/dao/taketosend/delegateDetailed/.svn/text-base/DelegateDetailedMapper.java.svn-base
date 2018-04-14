package com.yidu.tencloud.dao.taketosend.delegateDetailed;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.delegateDetailed.DelegateDetailed;
/**
 * 委派明细的数据访问层的接口类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public interface DelegateDetailedMapper {
	  /**
       * 查询所有委派明细单
       * @param paramMap map接口
       * @return 委派明细单集合
       */
	   public List<DelegateDetailed> findDelegateDetailedQuery(Map<String,Object> paramMap);
	   /**
	    * 打印委派明细单
	    * @param workSheetNo 工作单编号
	    * @return 是否打印成功
	    */
	   public DelegateDetailed PrintDelegateDetailed(String workSheetNo);
	   /**
	    * 记录委派明细单的总数
	    * @return 总数
	    */
	   public int countVotes();
	   /**
	    * 记录委派明细单的总票数
	    * @return
	    */
	   public int countDelegateDetailed();
	   /**
	    * 记录委派明细单的总数带条件
	    * @param paramMap map接口
	    * @return 总数
	    */
	   public int countDelegateDetailedWithCriteria(Map<String,Object> paramMap);
	   /**
	    * 查询所有委派明细单带条件
	    * @param paramMap map接口
	    * @return 委派明细单集合
	    */
	   public List<DelegateDetailed> findDelegateDetailedQueryWithCriteria(Map<String,Object> paramMap);
}
