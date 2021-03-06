package com.yidu.tencloud.web.controller.system.jurisdictioncontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.jurisdiction.AuthOption;
import com.yidu.tencloud.bean.system.jurisdiction.ResDto;
import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
import com.yidu.tencloud.biz.system.jurisdictionbiz.AuthorizeService;
import com.yidu.tencloud.biz.system.jurisdictionbiz.ResourceService;
import com.yidu.tencloud.biz.system.jurisdictionbiz.RoleService;
import com.yidu.tencloud.util.IDGenderatorUtil;


/**
 * 权限处理器
 * @author youngboy
 * @since 2017/12/19
 */
@Controller
@RequestMapping("/auth")
public class AuthorityAction {
	
	/**
	 * 角色业务对象
	 */
	@Autowired
	private RoleService roleService;
	
	/**
	 * 资源业务对象
	 */
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 授权业务对象
	 */
	@Autowired
	private AuthorizeService authService;
	
	

	public AuthorizeService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthorizeService authService) {
		this.authService = authService;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	
	/**
	 * 查询所有角色
	 * @return 角色json字符串
	 */
	@RequestMapping("/allrole")
	@ResponseBody
	public List<Role> queryAllRole(){
		return roleService.findAllRole();
	}
	
	/**
	 * 查询所有资源
	 * @return 所有资源json字符串
	 */
	@RequestMapping("/allres")
	@ResponseBody
	public List<URLResource> queryAllRes(){
		return resourceService.findAllResource();
	}
	
	/**
	 * 查询所有选项
	 * @return 选项json字符串
	 */
	@RequestMapping("/alloption")
	@ResponseBody
	public List<AuthOption> alloption(){
		return resourceService.findAllOption();
	}
	
	/**
	 * 修改资源
	 * @param resource 资源对象
	 * @return 添加结果字符串
	 */
	@RequestMapping("/ures")
	@ResponseBody
	public Map<String,String> updateRes(URLResource resource){
		boolean result = resourceService.updateResource(resource);
		return writeResult(result);
	}
	
	/**
	 * 修改角色
	 * @param role 资源对象
	 * @return 添加结果字符串
	 */
	@RequestMapping("/urole")
	@ResponseBody
	public Map<String,String> updateRole(Role role){
		boolean result = roleService.updateRole(role);
		return writeResult(result);
	}
	
	/**
	 * 添加角色
	 * @param role 角色对象
	 * @return ▂
	 */
	@RequestMapping("/arole")
	@ResponseBody
	public Map<String,String> addRole(Role role){
		role.setRoleId(IDGenderatorUtil.generateId());
		System.out.println(role);
		boolean result =roleService.addRole(role);
		return writeResult(result);
	}
	
	/**
	 * 添加资源表
	 * @param resource 资源对象
	 * @return 添加结果字符串
	 */
	@RequestMapping("/ares")
	@ResponseBody
	public Map<String,String> addRes(URLResource resource){
		resource.setResourceId(IDGenderatorUtil.generateId());
		boolean result = resourceService.addResource(resource);
		return writeResult(result);
	}
	
	
	/**
	 * 添加资源角色
	 * @param resId 资源id数组
	 * @param roleId 角色id数组
	 * @return 添加结果
	 */
	@RequestMapping("/aresrole")
	@ResponseBody
	public Map<String,String> addResRole(@RequestParam(required = true, value = "resId[]") String[] resId,@RequestParam(required = true, value = "roleId[]") String[] roleId){
		boolean result = authService.addResRole(resId, roleId);
		return writeResult(result);
	}
	
	/**
	 * 添加用户对象角色
	 * @param userId 用户id数组
	 * @param roleId 角色id数组
	 * @return 添加结果
	 */
	@RequestMapping("/auserole")
	@ResponseBody
	public Map<String,String> addUserRole(@RequestParam(required = true, value = "userId[]") String[] userId,@RequestParam(required = true, value = "roleId[]") String[] roleId){
		boolean result = authService.addUserRole(userId, roleId);
		return writeResult(result);																																											
	}
	
	
	/**
	 * 通过id查找选项
	 * @param orgId 组织结构id
	 * @return 选线json字符串
	 */
	@RequestMapping("/roletype")
	@ResponseBody
	public List<AuthOption> findOrgById(String orgId){
		return roleService.findAllRoleType();
	}
	
	
	/**
	 * 删除资源
	 * @param resId 资源id
	 * @return 删除结果
	 */
	@RequestMapping("/delres")
	@ResponseBody
	public Map<String, String> delres(String resId){
		authService.delResById(resId);
		boolean result = resourceService.deleteResource(resId);
		return writeResult(result);
	}
	
	
	/**
	 * 删除角色
	 * @param roleId 角色id
	 * @return 删除结果
	 */
	@RequestMapping("/delrole")
	@ResponseBody
	public Map<String, String> delrole(String roleId){
		authService.delRoleById(roleId);
		boolean result = roleService.deleteRole(roleId);
		return writeResult(result);
	}
	
	/**
	 * 通过用户找角色
	 * @param userId 用户id
	 * @return 角色集合
	 */
	@RequestMapping("/rolebyuid")
	@ResponseBody
	public List<Role> rolebyuid(String userId){
		
		return authService.findRoleIdByUserId(userId);
	}
	
	/**
	 * 通过角色找资源
	 * @param roleId 角色id
	 * @return 资源集合
	 */
	@RequestMapping("/resbyroleid")
	@ResponseBody
	public List<URLResource> resbyroleid(String roleId){
		return authService.findResIdByRoleId(roleId);
	}
	
	/**
	 * 资源树
	 * @return 资源树json字符串···
	 */
	@RequestMapping("/restree")
	@ResponseBody
	public List<ResDto> restree(){
		return resourceService.findResDtoTree();
	}
	
	
	/**
	 * 返回结果
	 * @param result 布尔类型
	 * @return Map格式数据
	 */
	private Map<String, String> writeResult(boolean result) {
		Map<String,String> resultJSON = new HashMap<String,String>();
		if (result) {
			resultJSON.put("status", "success");
		} else {
			resultJSON.put("status", "failed");
		}
		return resultJSON;
	}
	
	
	
	
	
}
