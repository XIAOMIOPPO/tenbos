package com.yidu.tencloud.dao.transitshipment.anomaly;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.transitshipment.anomaly.ChangeEntering;

/**
 * 到付代收变更数据访问层
 * @author 张建勇
 * @date 2018.01.11
 */
public interface ChangeEnteringMapper {
	
	/**
	 * 添加到付代收变更信息
	 * @param changeEntering 要添加的到付代收变更信息对象
	 * @return 受影响的行数
	 */
	public int addChangeEntering(ChangeEntering changeEntering);
	
	/**
	 * 查询所有的到付代收信息
	 * @return 所有的到付代收信息集合
	 */
	public List<ChangeEntering> findAllChangeEntering();
	
	/**
	 * 分页查询到付代收信息
	 * @param parmamMap 条件集合
	 * @return 分页查询到的集合
	 */
	public List<ChangeEntering> findChangeEnteringByPage(Map<String, Object> parmamMap);
	
	/**
	 * 根据工作单号查询工作单
	 * @param workSheetNo 工作单号
	 * @return 查询到的工作单对象
	 */
	public WorkSheet findWorkSheetByWorkSheetNo(String workSheetNo);
	
	/**
	 * 根据Id修改到付代收信息
	 * @param parmamMap 要修改的map集合
	 * @return 受影响的行数
	 */
	public int updateChangeEnteringById(Map<String, Object> parmamMap);
	
}
