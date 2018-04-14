package com.yidu.tencloud.dao.taketosend.assignmentDetailed;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.assignmentDetailed.AssignmentDetailed;

/**
 * 受派明细的数据访问层的接口类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public interface AssignmentDetailedMapper {
     /**
      * 查询所有受派明细单
      * @param paramMap map接口
      * @return 受派明细单集合
      */
	  public List<AssignmentDetailed> findAssignmentDetailedQuery(Map<String,Object> paramMap);
	  /**
	   * 打印受派明细单
	   * @param workSheetNo 工作单编号
	   * @return 是否打印成功
	   */
	   public AssignmentDetailed PrintAssignmentDetailed(String workSheetNo);
	   /**
	    * 记录受派明细单的总数
	    * @return 总数
	    */
	   public int countAssignmentDetailed();
	   /**
	    * 记录受派明细单的总数带条件
	    * @param paramMap map接口
	    * @return 总数
	    */
	   public int countAssignmentDetailedWithCriteria(Map<String,Object> paramMap);
	   /**
	    * 查询所有受派明细单带条件
	    * @param paramMap map接口
	    * @return 受派明细单集合
	    */
	   public List<AssignmentDetailed> findAssignmentDetailedQueryWithCriteria(Map<String,Object> paramMap);
}
