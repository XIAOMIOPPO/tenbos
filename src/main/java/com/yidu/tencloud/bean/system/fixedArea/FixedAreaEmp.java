package com.yidu.tencloud.bean.system.fixedArea;

import java.io.Serializable;

/**
 * 定区职员实体类
 * @author 陈涛
 *
 */
public class FixedAreaEmp implements Serializable{

	/**
	 * 定区Id
	 */
	private String fixedAreaId;
	/**
	 * 定区名
	 */
	private String fixedAreaName;
	/**
	 * 职员Id
	 */
	private String empId;
	/**
	 * 职员名
	 */
	private String empName;
	/**
	 * 无参数的构造方法
	 */
	public FixedAreaEmp() {}

	/**
	 * 构造方法
	 * @param fixedAreaId   定区Id
	 * @param fixedAreaName 定区名
	 * @param empId 职员Id
	 * @param empName 职员名
	 */
	public FixedAreaEmp(String fixedAreaId, String fixedAreaName, String empId, String empName) {
		super();
		this.fixedAreaId = fixedAreaId;
		this.fixedAreaName = fixedAreaName;
		this.empId = empId;
		this.empName = empName;
	}

	public String getFixedAreaId() {
		return fixedAreaId;
	}

	public void setFixedAreaId(String fixedAreaId) {
		this.fixedAreaId = fixedAreaId;
	}

	public String getFixedAreaName() {
		return fixedAreaName;
	}

	public void setFixedAreaName(String fixedAreaName) {
		this.fixedAreaName = fixedAreaName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "FixedAreaEmp [fixedAreaId=" + fixedAreaId + ", fixedAreaName=" + fixedAreaName + ", empId=" + empId
				+ ", empName=" + empName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((fixedAreaId == null) ? 0 : fixedAreaId.hashCode());
		result = prime * result + ((fixedAreaName == null) ? 0 : fixedAreaName.hashCode());
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
		FixedAreaEmp other = (FixedAreaEmp) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (fixedAreaId == null) {
			if (other.fixedAreaId != null)
				return false;
		} else if (!fixedAreaId.equals(other.fixedAreaId))
			return false;
		if (fixedAreaName == null) {
			if (other.fixedAreaName != null)
				return false;
		} else if (!fixedAreaName.equals(other.fixedAreaName))
			return false;
		return true;
	};
	
	
}
