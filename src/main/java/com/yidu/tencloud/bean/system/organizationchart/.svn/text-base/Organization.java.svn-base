package com.yidu.tencloud.bean.system.organizationchart;

import java.io.Serializable;
import java.util.List;


/**
 * 组织结构实体类
 * 
 * @author 64429
 *
 */
public class Organization implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1221608262945785690L;

	/**
	 * 组织结构Id
	 */
	private String orgId;

	/**
	 * 组织结构名
	 */
	private String orgName;

	/**
	 * 组织结构类型(参考辅助档案类)
	 */
	private String orgType;

	/**
	 * 组织结构类型名
	 */
	private String fileName;

	/**
	 * 负责人
	 */
	private String empName;

	/**
	 * 父类Id(参考本类)
	 */
	private String parendOrgId;

	/**
	 * 地址
	 */
	private String location;

	/**
	 * 序号
	 */
	private int orgindex;

	/**
	 * 资源集合
	 */
	private List<Organization> resList;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getParendOrgId() {
		return parendOrgId;
	}

	public void setParendOrgId(String parendOrgId) {
		this.parendOrgId = parendOrgId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getOrgindex() {
		return orgindex;
	}

	public void setOrgindex(int orgindex) {
		this.orgindex = orgindex;
	}

	public List<Organization> getResList() {
		return resList;
	}

	public void setResList(List<Organization> resList) {
		this.resList = resList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
		result = prime * result + orgindex;
		result = prime * result + ((parendOrgId == null) ? 0 : parendOrgId.hashCode());
		result = prime * result + ((resList == null) ? 0 : resList.hashCode());
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
		Organization other = (Organization) obj;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (orgType == null) {
			if (other.orgType != null)
				return false;
		} else if (!orgType.equals(other.orgType))
			return false;
		if (orgindex != other.orgindex)
			return false;
		if (parendOrgId == null) {
			if (other.parendOrgId != null)
				return false;
		} else if (!parendOrgId.equals(other.parendOrgId))
			return false;
		if (resList == null) {
			if (other.resList != null)
				return false;
		} else if (!resList.equals(other.resList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgName=" + orgName + ", orgType=" + orgType + ", fileName="
				+ fileName + ", empName=" + empName + ", parendOrgId=" + parendOrgId + ", location=" + location
				+ ", orgindex=" + orgindex + ", resList=" + resList + "]";
	}

	public Organization(String orgId, String orgName, String orgType, String fileName, String empName,
			String parendOrgId, String location, int orgindex, List<Organization> resList) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgType = orgType;
		this.fileName = fileName;
		this.empName = empName;
		this.parendOrgId = parendOrgId;
		this.location = location;
		this.orgindex = orgindex;
		this.resList = resList;
	}

	public Organization() {

	}

}
