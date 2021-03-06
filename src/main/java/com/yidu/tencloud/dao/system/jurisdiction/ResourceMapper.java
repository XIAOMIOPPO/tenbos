package com.yidu.tencloud.dao.system.jurisdiction;

import java.util.List;

import com.yidu.tencloud.bean.system.jurisdiction.AuthOption;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
/**
 * 资源mapper
 * @author youngboy
 * @since 2017/12/19
 */
public interface ResourceMapper {

	/**
	 * 找到所有资源
	 * @return 资源集合
	 */
	public List<URLResource> findAllResource();
	
	/**
	 * 高兴资源
	 * @param resource 资源对象
	 * @return 修改结果
	 */
	public int updateResource(URLResource resource);
	
	/**
	 * 删除资源
	 * @param resourceId 资源id
	 * @return 删除结果
	 */
	public int deleteResource(String resourceId);
	
	
	/**
	 * 添加资源
	 * @param resource 资源对象
	 * @return 添加结果
	 */
	public int addResource(URLResource resource);
	
	
	/**
	 * 找到所有选项
	 * @return 选项集合
	 */
	public List<AuthOption> findAllOption();
	
	
	/**
	 * 找到所有的父资源
	 * @return 所有父资源
	 */
	List<URLResource> findAllResParent();
	
	
	/**
	 * 通过资源id查找资源
	 * @param resId 资源id
	 * @return 资源集合
	 */
	List<URLResource> findResourceById(String resId);
	
	
	/**
	 * 通过
	 * @param userId 资源
	 * @return 授权过的资源集合
	 */
	List<URLResource> findGrantedResourceByUserId(String userId);
	
	
}
