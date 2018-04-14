package com.yidu.tencloud.biz.transitshipment.anomalymanage;

import java.util.List;

import com.yidu.tencloud.bean.transitshipment.anomaly.AnomalyManage;
/**
 * 异常信息录入业务逻辑层
 * @author 张建勇
 * @date 2018.01.06
 */
public interface AnomalyManageBiz {

	
	/**
	 * 添加一条异常信息
	 * @param anomalyManage 要添加的异常信息
	 * @return 受影响的行数
	 */
	public boolean addAnomalyManage(AnomalyManage anomalyManage);
	
	/**
	 * 查询登录的人下的异常信息，带数据权限查询所有
	 * @param orgList 登录用户的部门及子部门集合
	 * @return 查询到的异常信息集合
	 */
	public List<AnomalyManage> findAllAnomalyManage();
	
	/**
	 * 分页查询登录的人下的异常信息，带数据权限查询所有
	 * @param paramMap 条件集合
	 * @return查询到的异常信息集合
	 */
	public List<AnomalyManage> findAnomalyManageByPage(Integer offset , Integer limit);
	
	/**
	 * 条件搜索异常信息
	 * @param paramMap 搜索条件集合
	 * @return 查询到的集合
	 */
	public List<AnomalyManage> findAnomalyManageByCondition(Integer offset , Integer limit,String coSourcingNo);

	/**
	 * 修改异常处理的信息
	 * @param paramMap 要修改的条件集合
	 * @return 受影响的行数
	 */
	public boolean updateDisposeMessageById(String exceptionManageId , String result);
	
	/**
	 * 修改异常确认信息
	 * @param paramMap 要修改的条件集合
	 * @return 受影响的行数
	 */
	public boolean updateAffirmMessageById(String exceptionManageId,String affirmFruit);


	
}
