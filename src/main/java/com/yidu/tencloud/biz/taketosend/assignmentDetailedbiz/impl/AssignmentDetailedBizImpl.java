package com.yidu.tencloud.biz.taketosend.assignmentDetailedbiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.assignmentDetailed.AssignmentDetailed;
import com.yidu.tencloud.biz.taketosend.assignmentDetailedbiz.AssignmentDetailedBiz;
import com.yidu.tencloud.dao.taketosend.assignmentDetailed.AssignmentDetailedMapper;
/**
 * 业务逻辑层的实现类
 * @author 埼玉
 * @since 2017/12/25
 */
@Service
public class AssignmentDetailedBizImpl implements AssignmentDetailedBiz{
	//对受派明细mapper接口进行注入
	@Autowired
	private AssignmentDetailedMapper assignmentDetailedMapper;
	
	/**
	 * 设置受派明细单mapper接口
	 * @param assignmentDetailedMapper mapper接口
	 */
	public void setAssignmentDetailedMapper(AssignmentDetailedMapper assignmentDetailedMapper) {
		this.assignmentDetailedMapper = assignmentDetailedMapper;
	}
    
	/**
	 * 查询所有受派明细单
	 * @param paramMap map接口
	 * @return 受派明细单集合
	 */
	@Override
	public List<AssignmentDetailed> findAssignmentDetailedQuery(Map<String,Object> paramMap){
		return assignmentDetailedMapper.findAssignmentDetailedQuery(paramMap);
	}
	
	/**
	 * 打印受派明细单
	 * @param workSheetNo 工作单编号
	 * @return 是否打印成功
	 */
	@Override
	public AssignmentDetailed PrintAssignmentDetailed(String workSheetNo) {
		return assignmentDetailedMapper.PrintAssignmentDetailed(workSheetNo);
	}
	
	/**
	 * 记录受派明细单总数
	 * @return 总数
	 */
	@Override
	public int countAssignmentDetailed() {
		return assignmentDetailedMapper.countAssignmentDetailed();
	}
	
	/**
	 * 记录受派明细单总数带条件
	 * @param paramMap map接口
	 * @return 受派明细单集合
	 */
	@Override
	public int countAssignmentDetailedWithCriteria(Map<String,Object> paramMap) {
		return assignmentDetailedMapper.countAssignmentDetailedWithCriteria(paramMap);
	} 
	
	/**
	 * 查询所有受派明细单带条件
	 * @param paramMap map接口
	 * @return 受派明细单集合
	 */
	@Override
	public List<AssignmentDetailed> findAssignmentDetailedQueryWithCriteria(Map<String, Object> paramMap) {
		return assignmentDetailedMapper.findAssignmentDetailedQueryWithCriteria(paramMap);
	}
}
