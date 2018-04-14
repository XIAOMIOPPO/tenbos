package com.yidu.tencloud.dao.transitshipment.anomaly;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.transitshipment.anomaly.Anomaly;

/**
 * 异常处理数据访问层接口类
 * @author 张建勇
 * @date 2018.01.03
 */
public interface AnomalyMapper {
	
	/**
	 * 添加一条异常信息
	 * @param anomaly 要添加的异常信息
	 * @return 受影响的行数
	 */
	public int addAnomaly(Anomaly anomaly);
	
	/**
	 * 查询所有的异常信息
	 * @return 所有的异常信息集合
	 */
	public List<Anomaly> findAllAnomaly();
	
	/**
	 * 分页查询异常信息
	 * @param paremMap 分页条件集合
	 * @return 每一页的异常信息集合
	 */
	public List<Anomaly> findAllAnomalyByPage(Map<String, Integer> paremMap);
	
	/**
	 * 模糊查询异常信息并且分页
	 * @param paremMap 查询条件集合
	 * @return 查询到的异常信息集合
	 */
	public List<Anomaly> findAnomalyByConditionVague(Map<String, Object> paremMap);
	
	/**
	 * 根据异常信息Id作废异常信息
	 * @param exceptionId 异常信息Id
	 * @return 受影响的行数
	 */
	public int deleteAnomalyById(String exceptionId);
	
	/**
	 * 查询所有的异常编号
	 * @return 查询到的异常编号
	 */
	public List<String> findAllExceptionNo();
	
	/**
	 * 查询所有的异常类型
	 * @return 查询到的异常类型
	 */
	public List<String> findAllExceptionType();
	
	
}
