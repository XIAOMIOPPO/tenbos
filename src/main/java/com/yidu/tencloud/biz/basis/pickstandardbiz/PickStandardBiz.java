package com.yidu.tencloud.biz.basis.pickstandardbiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickstandard.PickStandard;

/**
 * 收派标准Biz接口
 * 
 * @author 廖晓翠
 * @since 2017/11/06
 */
public interface PickStandardBiz {
	/**
	 * 所有带条件的收派标准的总记录数
	 * 
	 * @return 收派标准集合
	 */
	public int countFindAllDeliverCriterion(Map<String,Object>paramMap);
	
	/**
	 * 根据收派名称查找收派标准
	 * @param paramMap
	 * @return
	 */
	public boolean findDeliverCriterioByName(String deliverName);
	
	/**
	 * 所有收派标准的总记录数
	 */
	public int countAllDeliverCriterion();
	
	/**
	 * 查找所有的收派标准并分页
	 * @param paramMap 参数集合
	 * @return 返回收派标准集合
	 */
	public List<PickStandard> findAllDeliverPageQuery(Map<String,Object>paramMap);
	/**
	 * 模糊查询带分页
	 * 
	 * @return 集合
	 */
	public List<PickStandard> criterDeliverCriterion(Map<String,Object>paramMap);
	
	/**
	 * 添加收派标准
	 * @param deliverCriter 收派标准对象
	 * @return 收派标准对象
	 */
	public boolean  addDeliverCriterion(PickStandard deliverCriter);
	
	/**
	 * 根据收派Id修改状态
	 * @param isUse 状态
	 * @param deliverId 收派Id
	 * @return 如果修改成功 返回true 否则返回false
	 */
	public boolean updateIsUseById(Map<String,Object>paramMap);
	/**
	 * 逻辑删除收派标准
	 * @param paramMap
	 * @return
	 */
	public int deleteDeliverCriterion(String deliverId);
}
