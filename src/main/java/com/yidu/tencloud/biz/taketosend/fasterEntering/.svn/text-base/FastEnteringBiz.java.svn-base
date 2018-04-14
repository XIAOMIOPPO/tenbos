package com.yidu.tencloud.biz.taketosend.fasterEntering;

import java.util.List;

import com.yidu.tencloud.bean.taketosend.fastEntering.FastEntering;


public interface FastEnteringBiz {
	/**
	 * 根据基础档案名查找配载要求
	 * @param recordName 基础档案名
	 * @return 如果找到返回配载要求 否则返回null
	 */
	public List<String> findStowageRequirement(String recordName);
	
	/**
	 * 根据工作单号查找工作单号
	 * @param workSheetNo 工作单号
	 * @return 如果找到返回true 否则返回false
	 */
	public boolean findWorkSheetNoByWorkSheetNo(String workSheetNo);
	
	/**
	 * 快速录入的添加
	 * @param fastEntering 快速录入对象
	 * @return 添加成功返回1 否则返回0
	 */
	public int addWorkSheet(FastEntering fastEntering);
}
