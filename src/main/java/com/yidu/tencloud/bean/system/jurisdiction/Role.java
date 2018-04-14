package com.yidu.tencloud.bean.system.jurisdiction;
/**
 * 角色bean
 * @author youngboy
 * @since 2017/12/19
 */
public class Role {
	
	/**
	 * 角色id
	 */
	private String roleId;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色编码
	 */
	private String roleCode;
	
	/**
	 * 角色类型 参考 基础档案表
	 */
	private String roleTypeId;
	
	/**
	 * 角色类型名
	 */
	private String roleTypeName;
	
	

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(String roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public String getRoleTypeName() {
		return roleTypeName;
	}

	public void setRoleTypeName(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((roleTypeId == null) ? 0 : roleTypeId.hashCode());
		result = prime * result + ((roleTypeName == null) ? 0 : roleTypeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleCode == null) {
			if (other.roleCode != null)
				return false;
		} else if (!roleCode.equals(other.roleCode))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (roleTypeId == null) {
			if (other.roleTypeId != null)
				return false;
		} else if (!roleTypeId.equals(other.roleTypeId))
			return false;
		if (roleTypeName == null) {
			if (other.roleTypeName != null)
				return false;
		} else if (!roleTypeName.equals(other.roleTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + ", roleTypeId="
				+ roleTypeId + ", roleTypeName=" + roleTypeName + "]";
	}
	
	
	
	
	
}
