package com.yidu.tencloud.dao.taketosend.workSheetSearch;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetSerach.WorkSheetSearch;
/**
 * 工作单查询的数据访问层接口
 * @author ct
 * @since 2017/12/11
 */
public interface WorkSheetSearchMapper {
	/**
	 * 查询所有工作单 
	 * @return 工作单集合
	 */
	public List<WorkSheetSearch> findSubJobList(Map<Object,Object> paramMap);
	
    public int count(Map<Object,Object> paramMap);
    
    public int updateStatus(WorkSheet workSheet);

}
