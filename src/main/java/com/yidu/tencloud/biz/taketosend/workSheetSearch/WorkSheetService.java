package com.yidu.tencloud.biz.taketosend.workSheetSearch;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetSerach.WorkSheetSearch;
/**
 * 工作单查询的业务逻辑层接口
 * @author ct
 * @since 2017/12/11
 */

public interface WorkSheetService {
	/**
	 * 条件查找部分工作单
	 * @param basicJobList 工作单对象
	 * @return 工作单集合
	 */
	public List<WorkSheetSearch> findSubJobList(Map<Object,Object> paramMap);


	public int count(Map<Object,Object> paramMap);
	
	public int updateStatus(WorkSheet workSheet);
	
}
