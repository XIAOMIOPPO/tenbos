package com.yidu.tencloud.biz.taketosend.workSheetSearch.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetSerach.WorkSheetSearch;
import com.yidu.tencloud.biz.taketosend.workSheetSearch.WorkSheetService;
import com.yidu.tencloud.dao.taketosend.workSheetSearch.WorkSheetSearchMapper;
import com.yidu.tencloud.dao.taketosend.worksheetDao.WorkSheetMapper;
/**
 * 工作单查询的业务层实现类
 * @author ct
 * @since 2017/12/11
 */
@Service
public class WorkSheetServiceImpl implements WorkSheetService{
	/**
	 * 保存对数据访问层的依赖
	 */
	@Autowired
	private WorkSheetSearchMapper workSheetSearchMapper;
	
	public void setWorkSheetSearchMapper(WorkSheetSearchMapper workSheetSearchMapper) {
		this.workSheetSearchMapper = workSheetSearchMapper;
	}
	/**
	 * 条件查询部分工作单
	 */
	public List<WorkSheetSearch> findSubJobList(Map<Object,Object> paramMap) {
		return workSheetSearchMapper.findSubJobList(paramMap);
	}
	
	
	public int count(Map<Object,Object> paramMap) {
		return workSheetSearchMapper.count(paramMap);
	}
	@Override
	public int updateStatus(WorkSheet workSheet) {
		return workSheetSearchMapper.updateStatus(workSheet);
	}
	

}
