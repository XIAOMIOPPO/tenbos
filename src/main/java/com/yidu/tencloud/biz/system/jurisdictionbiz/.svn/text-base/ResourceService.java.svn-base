package com.yidu.tencloud.biz.system.jurisdictionbiz;

import java.util.List;

import com.yidu.tencloud.bean.system.jurisdiction.AuthOption;
import com.yidu.tencloud.bean.system.jurisdiction.ResDto;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;

/**
 * 资源接口
 * @author youngboy
 * @since 2017/12/19
 */
public interface ResourceService {

	/**
	 * 找到所有资源
	 * @return 资源聚合
	 */
	List<URLResource> findAllResource();
	
	/**
	 * 高兴资源
	 * @param resource 资源对象
	 * @return 修改结果
	 */
	boolean updateResource(URLResource resource);
	
	/**
	 * 删除资源
	 * @param resourceId 资源id
	 * @return 删除结果
	 */
	boolean deleteResource(String resourceId);
	
	
	/**
	 * 添加资源
	 * @param resource 资源对象
	 * @return 添加结果
	 */
	boolean addResource(URLResource resource);
	
	
	/**
	 * 找到所有的选项
	 * @return 选项集合
	 */
	List<AuthOption> findAllOption();
	
	
	/**
	 * 获取资源树
	 * @return 资源树集合
	 */
	List<URLResource> findResTree();
	
	
	/**
	 * 通过id查找资源
	 * @param id 资源id
	 * @return 资源集合
	 */
	List<URLResource> findResById(String id);
	
	
	/**
	 * dto资源树
	 * @return 资源树集合
	 */
	List<ResDto> findResDtoTree();
	
	
	/**
	 * 获取授权的资源
	 * @return 资源集合
	 */
	List<URLResource> findGrantedResourceByUserId(String userId);
	
}
