package com.yidu.tencloud.biz.system.jurisdictionbiz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.jurisdiction.CommBean;
import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
import com.yidu.tencloud.biz.system.jurisdictionbiz.AuthorizeService;
import com.yidu.tencloud.dao.system.jurisdiction.RoleResMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 授权业务实现类
 * @author youngboy
 * @since 2017/12/19
 */
@Service
public class AuthorizeServiceImpl implements AuthorizeService{

	/**
	 * 资源mapper
	 */
	@Autowired
	private RoleResMapper mapper;
	
	
	/**
	 * 获取mapper
	 * @return mapper对象
	 */
	public RoleResMapper getMapper() {
		return mapper;
	}

	
	/**
	 * 设置mapper
	 * @param mapper mapper对象
	 */
	public void setMapper(RoleResMapper mapper) {
		this.mapper = mapper;
	}


	@Override
	public boolean deleteResRole(String id) {
		//调用输出方法
		return mapper.deleteRoleRes(id)>0?true:false;
	}

	@Override
	public boolean deleteUserRole(String id) {
		//调用角色删除方法
		return mapper.deleteUserRole(id)>0?true:false;
	}

	@Override
	public boolean addResRole(String[] resId, String[] roleId) {
		//删除已经存在的数据
		deleteResByRoleId(roleId);
		//创建对象集合
		List<CommBean> commBeans = new ArrayList<CommBean>();
		//生成对象
		for (int i=0;i<roleId.length;i++) {
			for (int j = 0; j < resId.length; j++) {
				//创建权限对象
				CommBean cbean = new CommBean();
				//设置主键
				cbean.setPrimaryId(IDGenderatorUtil.generateId());
				//设置beanId
				cbean.setBeanId(roleId[i]);
				//设置obeanId
				cbean.setObeanId(resId[j]);
				//添加bean
				commBeans.add(cbean);
			}
		}
		//添加角色资源
		return mapper.addRoleRes(commBeans)>0?true:false;
	}

	@Override
	public boolean addUserRole(String[] userId, String[] roleId) {
		//删除已经添加的数据
		deleteRoleByUserId(userId);
		//创建对象集合
		List<CommBean> commBeans = new ArrayList<CommBean>();
		//生成对象
		for (int i=0;i<userId.length;i++) {
			for (int j = 0; j < roleId.length; j++) {
				//创建权限对象
				CommBean cbean = new CommBean();
				//设置主键
				cbean.setPrimaryId(IDGenderatorUtil.generateId());
				//设置beanid
				cbean.setBeanId(roleId[j]);
				//设置obeanid
				cbean.setObeanId(userId[i]);
				//添加cbean
				commBeans.add(cbean);
			}
		}
		//添加用户角色
		return mapper.addUserRole(commBeans)>0?true:false;
	}
	
	
	
	/**
	 * 通过用户id删除角色
	 * @param userId 用户id
	 */
	private void deleteRoleByUserId(String[] userId) {
		//创建ids集合
		List<String> ids = new ArrayList<String>();
		//遍历集合
		for (String id : userId) {
			//添加id
			ids.add(id);
		}
		//调用mapper删除角色
																																																				mapper.delRoleByUserId(ids);
	}
	
	
	/**
	 * 通过角色id删除资源
	 * @param roleId 角色id
	 */
	private void deleteResByRoleId(String[] roleId) {
		//创建id集合
		List<String> ids = new ArrayList<String>();
		//遍历角色集合
		for (String id : roleId) {
			//添加id
			ids.add(id);
		}
		//通过角色id删除资源
		mapper.deleteResByRoleId(ids);
	}
	

	@Override
	public boolean delRoleByRoleIdInRes(String id) {
		//删除角色
		return mapper.delRoleByRoleIdInRes(id)>0?true:false;
	}

	@Override
	public boolean delRoleByRoleId(String id) {
		//删除角色
		return mapper.delRoleByRoleId(id)>0?true:false;
	}

	@Override
	public boolean delResByResId(String id) {
		//删除资源
		return mapper.delResByResId(id)>0?true:false;
	}

	@Override
	public boolean delRoleById(String id) {
		//删除角色
		delRoleByRoleIdInRes(id);
		//删除角色通过角色id
		delRoleByRoleId(id);
		return true;
	}

	@Override
	public boolean delResById(String id) {
		//删除资源通过id
		delResByResId(id);
		return true;
	}

	@Override
	public List<Role> findRoleIdByUserId(String userId) {
		//找到角色id通过用户id
		return mapper.selectRoleIdByUserId(userId);
	}

	@Override
	public List<URLResource> findResIdByRoleId(String roleId) {
		//通过角色id找到资源id
		return mapper.selectResIdByRoleId(roleId);
	}

}
