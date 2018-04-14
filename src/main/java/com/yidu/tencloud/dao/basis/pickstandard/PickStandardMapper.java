package com.yidu.tencloud.dao.basis.pickstandard;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickstandard.PickStandard;

/**
 * 收派标准的Mapper接口
 * @author 廖晓翠
 * @since 2017/11/02
 */
public interface PickStandardMapper{
	/**
	 * 查找所有的收派标准并分页
	 * @return 收派标准的集合
	 */
	public List<PickStandard> findAllDeliverPageQuery(Map<String,Object>paramMap);
	
	/**
	 * 模糊查找所有的收派标准
	 * @return 收派标准的集合
	 */
	public int countFindAllDeliverCriterion(Map<String,Object>paramMap);
	
	/**
	 * 总记录数
	 * @return 查找的总记录数的结果
	 */
	public int countAllDeliverCriterion();
	
	/**
	 * 添加收派标准
	 * @param deliverCriterion 收派标准
	 * @return 如果添加成功返回1 否则返回0
	 */
	public int addDeliverCriterion(PickStandard deliverCriterion);
	
	
	/**
	 * 根据收派标准Id修改收派标准
	 * @param deliverId 收派标准Id
	 * @return 如果修改成功 返回1 否则返回0
	 */
	public int updateIsUseById(Map<String,Object>paramMap);
	
	/**
	 * 删除收派标准
	 * @param paramMap
	 * @return 如果删除成功返回1 否则返回0
	 */
	public int deleteDeliverCriterion(String deliverId);
	
	/**
	 * 模糊查询带分页
	 * @param paramMap 参数集合
	 * @return 返回收派标准集合
	 */
	public List<PickStandard> criterDeliverCriterion(Map<String,Object>paramMap);
	
	/**
	 * 根据收派标准名查找收派标准
	 * @param paramMap
	 * @return 如果找到返回字符串 否则返回null
	 */
	public String findDeliverCriterioByName(String deliverName);
}
