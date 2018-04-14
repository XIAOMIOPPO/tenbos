package com.yidu.tencloud.dao.transitshipment.anomaly;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.transitshipment.anomaly.AnomalyManage;

/**
 * 异常录入Mapper接口(数据访问层)
 * @author 张建勇
 *
 */
public interface AnomalyManageMapper {
	
	/**
	 * 添加一条异常信息
	 * @param anomalyManage 要添加的异常信息
	 * @return 受影响的行数
	 */
	public int addAnomalyManage(AnomalyManage anomalyManage);
	
	/**
	 * 查询登录的人下的异常信息，带数据权限查询所有
	 * @param orgList 登录用户的部门及子部门集合
	 * @return 查询到的异常信息集合
	 */
	public List<AnomalyManage> findAllAnomalyManage(List<String> orgList);
	
	/**
	 * 分页查询登录的人下的异常信息，带数据权限查询所有
	 * @param paramMap 条件集合
	 * @return查询到的异常信息集合
	 */
	public List<AnomalyManage> findAnomalyManageByPage(Map<String, Object> paramMap);
	
	/**
	 * 条件搜索异常信息
	 * @param paramMap 搜索条件集合
	 * @return 查询到的集合
	 */
	public List<AnomalyManage> findAnomalyManageByCondition(Map<String, Object> paramMap);
	
	/**
	 * 修改异常处理的信息
	 * @param paramMap 要修改的条件集合
	 * @return 受影响的行数
	 */
	public int updateDisposeMessage(Map<String, Object> paramMap);
	
	/**
	 * 修改异常确认信息
	 * @param paramMap 要修改的条件集合
	 * @return 受影响的行数
	 */
	public int updateNotarizeMessage(Map<String, Object> paramMap);
	
	
	
	
}
