package com.yidu.tencloud.dao.taketosend.fastEntering;

import java.util.List;

import com.yidu.tencloud.bean.taketosend.fastEntering.FastEntering;

/**
 * 快速录入接口
 * @author 廖晓翠
 * @since 2017-12-1 16:20:22
 */
public interface FastEnteringMapper {
	/**
	 * 查找配载要求
	 * @return 配载要求集合
	 */
	public List<String> findStowageRequirement(String recordName);
	
	/**
	 * 根据工作单编号查找工作单编号
	 * @param workSheetNo 工作单编号
	 * @return 如果找到返回字符串 否则返回null
	 */
	public List<String> findWorkSheetNoByWorkSheetNo(String workSheetNo);
	
	/**
	 * 添加工作单快速录入对象
	 * @param fastEntering  工作单快速录入对象
	 * @return 入股成功返回1 否则返回0
	 */
	public int addWorkSheet(FastEntering fastEntering);
	
	/**
	 * 添加规则
	 * @param fastEntering 快速录入对象
	 * @return 如果添加成功返回1 否则返回0
	 */
	public int addRule(FastEntering fastEntering);
}
