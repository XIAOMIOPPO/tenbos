package com.yidu.tencloud.biz.transitshipment.changeentering;

import java.util.Date;
import java.util.List;

import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.transitshipment.anomaly.ChangeEntering;

/**
 * 到付代收信息业务逻辑层
 * @author 张建勇
 * @date 2018.01.5
 */
public interface ChangeEnteringBiz {
	/**
	 * 添加到付代收变更信息
	 * @param changeEntering 要添加的到付代收变更信息对象
	 * @return 是否添加成功
	 */
	public boolean addChangeEntering(ChangeEntering changeEntering);
	
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
	public List<ChangeEntering> findChangeEnteringByPage(Integer offset,Integer limit);
	
	/**
	 * 根据工作单号查询工作单
	 * @param workSheetNo 工作单号
	 * @return 查询到的工作单对象
	 */
	public WorkSheet findWorkSheetByWorkSheetNo(String workSheetNo);
	
	/**
	 * 根据Id修改
	 * @param sendee 接受人
	 * @param sendeeUnit 接收单位
	 * @param sendeeTime 接收时间
	 * @param sendeeStatus 接受状态
	 * @param recordId 到付代收信息Id
	 * @return 是否修改成功
	 */
	public boolean updateupdateChangeEnteringById(String sendee ,String sendeeUnit, Date sendeeTime ,String sendeeStatus,String recordId);
}
