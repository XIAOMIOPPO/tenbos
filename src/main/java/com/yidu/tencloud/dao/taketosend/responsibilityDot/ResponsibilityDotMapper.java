package com.yidu.tencloud.dao.taketosend.responsibilityDot;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.responsibilityDot.ResponsibilityDot;
/**
 * 责任网点设置的数据访问层的接口类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public interface ResponsibilityDotMapper {
	/**
     * 查询所有责任网点设置
     * @param paramMap map接口
     * @return 责任网点设置集合
     */
    public List<ResponsibilityDot> findResponsibilityDotQuery(Map<String,Object>paramMap);
    /**
	 * 添加责任网点
	 * @param responsibilityDot 责任网点对象
	 * @return 是否添加成功
	 */
	public int addResponsibilityDot(ResponsibilityDot responsibilityDot);
	/**
	 * 删除责任网点
	 * @param responsibilityDotId 责任网点ID
	 * @return 是否成功
	 */
	public int deleteResponsibilityDot(String responsibilityDotId);
	/**
	 * 修改责任网点信息
	 * @param paramMap map接口
	 * @return 是否成功
	 */
	public int updateResponsibilityDot(Map<String,Object> paramMap);
	/**
	 * 记录责任网点的总数
	 * @return 总数
	 */
	public int countResponsibilityDot();
	/**
	 * 记录责任网点的总数带条件
	 * @param paramMap map接口
	 * @return 总数
	 */
	public int countResponsibilityDotWithCriteria(Map<String,Object> paramMap);
	/**
	 * 查询所有的责任网点带条件
	 * @param paramMap map接口
	 * @return 责任网点集合
	 */
	public List<ResponsibilityDot> findResponsibilityDotQueryWithCriteria(Map<String,Object>paramMap);
	/**
	 * 通过组织Id查询所有组织结构
	 * @return 字符串集合
	 */
	public List<String> findOrganizationWithOrgId();
}
