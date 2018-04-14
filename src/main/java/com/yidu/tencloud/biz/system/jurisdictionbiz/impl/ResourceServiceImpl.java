package com.yidu.tencloud.biz.system.jurisdictionbiz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.jurisdiction.AuthOption;
import com.yidu.tencloud.bean.system.jurisdiction.CommBean;
import com.yidu.tencloud.bean.system.jurisdiction.ResDto;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
import com.yidu.tencloud.biz.system.jurisdictionbiz.ResourceService;
import com.yidu.tencloud.dao.system.jurisdiction.ResourceMapper;
import com.yidu.tencloud.dao.system.jurisdiction.RoleResMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 资源业务实现类
 * @author youngboy
 * @since 2017/12/19
 */
@Service
public class ResourceServiceImpl implements ResourceService{

	/**
	 * 资源mapper接口
	 */
	@Autowired
	private ResourceMapper resourceMapper;
	
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}
	
	/**
	 * 资源mapper
	 */
	@Autowired
	private RoleResMapper mapper;
	
	
	/**
	 * 获取mapper
	 * @return 角色资源id
	 */
	public RoleResMapper getMapper() {
		return mapper;
	}

	
	/**
	 * 设置mapper
	 * @param mapper 资源mapper
	 */
	public void setMapper(RoleResMapper mapper) {
		this.mapper = mapper;
	}
	

	@Override
	public List<URLResource> findAllResource() {
		//找到所有资源
		return resourceMapper.findAllResource();
	}

	
	@CacheEvict(value="redisCache",key="#resource.getResourceId()")
	@Override
	public boolean updateResource(URLResource resource) {
		//更新资源
		return resourceMapper.updateResource(resource)>0?true:false;
	}

	@CacheEvict(value="redisCache")
	@Override
	public boolean deleteResource(String resourceId) {
		//删除资源
		return resourceMapper.deleteResource(resourceId)>0?true:false;
	}

	
	@CachePut(value="redisCache",key="#resource.getResourceId()")
	@Override
	public boolean addResource(URLResource resource) {
		//添加资源
		if(resourceMapper.addResource(resource)>0) {
			//添加成功 给admin角色授权
			List<CommBean> commBeans = new ArrayList<CommBean>();
			//创建实体类
			CommBean cbean = new CommBean();
			//设置ID
			cbean.setPrimaryId(IDGenderatorUtil.generateId());
			//设置角色ID
			cbean.setBeanId(ShiroUtil.ADMINID);
			//设置资源ID
			cbean.setObeanId(resource.getResourceId());
			commBeans.add(cbean);
			//返回授权结果
			return mapper.addRoleRes(commBeans)>0?true:false;
		}else {
			//添加失败
			return false;
		}
		
	}

	@Override
	public List<AuthOption> findAllOption() {
		//找到所有选项
		return resourceMapper.findAllOption();
	}


	@Cacheable(value="redisCache")
	@Override
	public List<URLResource> findResTree() {
		//获取所有额父类
		List<URLResource> presources = resourceMapper.findAllResParent();
		//要转化的集合
		List<ResDto> dtoList = new ArrayList<ResDto>();
		
		//遍历所有的父类元素生成树
		for (URLResource urlResource : presources) {
			//创建dto对象
			ResDto dto = new ResDto();
			//设置id
			dto.setId(urlResource.getResourceId());
			//设置text
			dto.setText(urlResource.getResourceName());
			//调用生成树的方法
			createTree(dto);
		}
		//返回转换的dto对象
		return presources;
	}
	
	
	/**
	 * 资源dto树
	 * @return 资源dto树
	 */
	public List<ResDto> findResDtoTree() {
		//获取所有额父类
		List<URLResource> presources = resourceMapper.findAllResParent();
		//dto集合
		List<ResDto> dtoList = new ArrayList<ResDto>();
		//遍历所有的父类元素生成树
		for (URLResource urlResource : presources) {
			//创建dto对象
			ResDto dto = new ResDto();
			//设置id
			dto.setId(urlResource.getResourceId());
			//设置text
			dto.setText(urlResource.getResourceName());
			//调用生成树的方法
			createTree(dto);
			//添加dto对象
			dtoList.add(dto);
		}
		//返回dto集合
		return dtoList;
	}
	
	
	
	/**
	 * 生成树的方法
	 * @param resDto dto对象
	 */
	public void createTree(ResDto resDto) {
		//通过id查找集合
		List<URLResource> fres = resourceMapper.findResourceById(resDto.getId());
		//判断集合是否为空
		if(!fres.isEmpty()) {
			//创建dto集合
			List<ResDto> dtoList = new ArrayList<ResDto>();
			//遍历资源集合
			for (URLResource urlResource : fres) {
				//创建dto对象
				ResDto dto = new ResDto();
				//设置id
				dto.setId(urlResource.getResourceId());
				//设置text
				dto.setText(urlResource.getResourceName());
				//添加dto对象
				dtoList.add(dto);
			}
			//设置子节点
			resDto.setNodes(dtoList);
			//遍历子节点递归生成子节点
			for (ResDto dto : resDto.getNodes()) {
				//递归调用
				createTree(dto);
			}
		}
				
		
	}

	
	@Cacheable(value="redisCache")
	@Override
	public List<URLResource> findResById(String id) {
		//通过id找到资源
		return resourceMapper.findResourceById(id);
	}

	@Cacheable(value="redisCache")
	@Override
	public List<URLResource> findGrantedResourceByUserId(String userId) {
		//所有的资源集合
		List<URLResource> resList = resourceMapper.findGrantedResourceByUserId(userId);
		//返回树集合
		return listToTree(resList);
	}
	
	
	
	/**
	 * 生成树集合
	 * @param listData 数据集合
	 * @return 树集合
	 */
	public List<URLResource> listToTree(List<URLResource> listData){
		//挑出父节点和字节点
		List<URLResource> parentNode = new ArrayList<URLResource>();
		//子节点
		List<URLResource> childrenNode = new ArrayList<URLResource>();
		//分离子节点和父节点
		for (URLResource resource : listData) {
			//获取父类资源id
			String pname = resource.getParentResId();
			//判断父类资源id是否为空
			if (pname==null||pname.equals("")) {
				//添加父类节点
				parentNode.add(resource);
			} else {
				//提交子类节点
				childrenNode.add(resource);
			}
		}
		
		//递归生成树
		for (URLResource resource : parentNode) {
			//获取资源id
			String primaryKey = resource.getResourceId();
			//调用getChildren获取子类集合并设置子集合
			resource.setResList(getChildren(primaryKey, childrenNode));
		}
		//返回集合
		return parentNode;
	}

	
	
	/**
	 * 获取子类的方法
	 * @param primaryKey 主键
	 * @param childrenNode 子类集合
	 * @return 子类集合
	 */
	private List<URLResource> getChildren(String primaryKey, List<URLResource> childrenNode) {
		//子集合
		List<URLResource> cNode = new ArrayList<URLResource>();
		//遍历集合寻找符合主键的记录
		for (URLResource resource : childrenNode) {
			//获取父类资源id
			String pname = resource.getParentResId();
			//判断是否匹配主键
			if(pname.equals(primaryKey)) {
				//添加资源
				cNode.add(resource);
			}
		}
		
		//递归子集合
		for (URLResource resource : cNode) {
			//设置资源集合
			resource.setResList(getChildren(resource.getResourceId(), childrenNode));
		}
		
		//判断cNode是否为0
		if(cNode.size()==0) {
			return null;
		}
		
		//返回节点
		return cNode;
		
	}
	

	
}
