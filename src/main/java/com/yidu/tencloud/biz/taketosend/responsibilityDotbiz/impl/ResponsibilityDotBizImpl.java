package com.yidu.tencloud.biz.taketosend.responsibilityDotbiz.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.responsibilityDot.ResponsibilityDot;
import com.yidu.tencloud.biz.taketosend.responsibilityDotbiz.ResponsibilityDotBiz;
import com.yidu.tencloud.dao.system.organizationchartdao.OrganizationMapper;
import com.yidu.tencloud.dao.taketosend.responsibilityDot.ResponsibilityDotMapper;

/**
 * 业务逻辑层实现类
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Service
public class ResponsibilityDotBizImpl implements ResponsibilityDotBiz{
	//对责任网点mapper接口进行注入
	@Autowired
	private ResponsibilityDotMapper responsibilityDotMapper;
    
	/**
	 * 设置责任网点mapper接口
	 * @param responsibilityDotMapper mapper接口
	 */
	public void setResponsibilityDotMapper(ResponsibilityDotMapper responsibilityDotMapper) {
		this.responsibilityDotMapper = responsibilityDotMapper;
	}

	 /**
	 * 查询所有责任网点
	 * @param paramMap map接口
	 * @return 责任网点集合
	 */
	@Override
	public List<ResponsibilityDot> findResponsibilityDotQuery(Map<String, Object> paramMap) {
		//查询所有的责任网点
		return responsibilityDotMapper.findResponsibilityDotQuery(paramMap);
	}

	/**
	 *添加责任网点
	 *@param responsibilityDot 责任网点对象
	 *@return 是否添加成功
	 */
	@Override
	public boolean addResponsibilityDot(ResponsibilityDot responsibilityDot) { 
		//判断添加一条责任网点是否成功
        if(responsibilityDotMapper.addResponsibilityDot(responsibilityDot)==1) {
        	//添加成功
        	return true;
        }
        //添加失败
        return false;
	}
	
	/**
	 * 删除责任网点通过Id
	 * @param responsibilityDotId 责任网点ID
	 * @return 是否成功
	 */
	@Override
	public boolean deleteResponsibilityDot(String responsibilityDotId) {
		//判断是否删除一条数据成功
        if(responsibilityDotMapper.deleteResponsibilityDot(responsibilityDotId)==1) {
        	//删除成功
        	return true;
        }
        //删除失败
		return false;
	}

	/**
	 * 修改责任网点信息
	 * @param paramMap map接口
	 * @return 是否成功
	 */
	@Override
	public boolean updateResponsibilityDot(Map<String, Object> paramMap) {
		//判断修改一条数据是否成功
        if(responsibilityDotMapper.updateResponsibilityDot(paramMap)==1) {
        	//修改成功
        	return true;
        }
        //修改失败
		return false;
	}

	/**
	 * 记录责任网点总数的方法
	 */
	@Override
	public int countResponsibilityDot() {
		//记录责任网点的总数
		return responsibilityDotMapper.countResponsibilityDot();
	}

	/**
	 * 记录责任网点总数带条件
	 * @param paramMap map接口
	 * @return 总数
	 */
	@Override
	public int countResponsibilityDotWithCriteria(Map<String, Object> paramMap) {
		//记录责任网点的总数带条件
		return responsibilityDotMapper.countResponsibilityDotWithCriteria(paramMap);
	}

	/**
	 * 查询所有的责任网点带条件查询
	 * @param paramMap map接口
	 * @return 责任网点集合
	 */
	@Override
	public List<ResponsibilityDot> findResponsibilityDotQueryWithCriteria(Map<String, Object> paramMap) {
		//查询所有的责任网点带条件查询
		return responsibilityDotMapper.findResponsibilityDotQueryWithCriteria(paramMap);
	}
    
	/**
	 * 通过组织结构Id查询所有组织
	 * @return 字符串 
	 */ 
	public List<String> findOrganizationWithOrgId() {
		//查询所有组织结构
		return responsibilityDotMapper.findOrganizationWithOrgId();
	}
}