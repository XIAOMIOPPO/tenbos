package com.yidu.tencloud.bean.basis.picktime;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

public class Picktime implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 收派时间Id
	 */
	private String drawTimeId;
	/**
	 * 收派时间名称
	 */
	private String timeName;
	/**
	 * 所属单位Id
	 */
	private String orgId;
	/**
	 * 所属单位
	 */
	private String orgName;
	/**
	 * 平常上班时间
	 */
	@Column(name="workTime")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date workTime;
	/**
	 * 平常下班时间
	 */
	@Column(name="offDuty")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date offDuty;
	/**
	 * 周六上班时间
	 */
	@Column(name="satWorkTime")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date satWorkTime;
	/**
	 * 周六下班时间
	 */
	@Column(name="satOffDuty")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date satOffDuty;
	/**
	 * 周日上班时间
	 */
	@Column(name="sunWorkTime")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date sunWorkTime;
	/**
	 * 周日下班时间
	 */
	@Column(name="sunOffDuty")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date sunOffDuty;
	
	private String isUse;

	public Picktime() {}

	public Picktime(String drawTimeId, String timeName, String orgId, String orgName, Date workTime, Date offDuty,
			Date satWorkTime, Date satOffDuty, Date sunWorkTime, Date sunOffDuty, String isUse) {
		super();
		this.drawTimeId = drawTimeId;
		this.timeName = timeName;
		this.orgId = orgId;
		this.orgName = orgName;
		this.workTime = workTime;
		this.offDuty = offDuty;
		this.satWorkTime = satWorkTime;
		this.satOffDuty = satOffDuty;
		this.sunWorkTime = sunWorkTime;
		this.sunOffDuty = sunOffDuty;
		this.isUse = isUse;
	}

	public String getDrawTimeId() {
		return drawTimeId;
	}

	public void setDrawTimeId(String drawTimeId) {
		this.drawTimeId = drawTimeId;
	}

	public String getTimeName() {
		return timeName;
	}

	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}

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

	public Date getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}

	public Date getOffDuty() {
		return offDuty;
	}

	public void setOffDuty(Date offDuty) {
		this.offDuty = offDuty;
	}

	public Date getSatWorkTime() {
		return satWorkTime;
	}

	public void setSatWorkTime(Date satWorkTime) {
		this.satWorkTime = satWorkTime;
	}

	public Date getSatOffDuty() {
		return satOffDuty;
	}

	public void setSatOffDuty(Date satOffDuty) {
		this.satOffDuty = satOffDuty;
	}

	public Date getSunWorkTime() {
		return sunWorkTime;
	}

	public void setSunWorkTime(Date sunWorkTime) {
		this.sunWorkTime = sunWorkTime;
	}

	public Date getSunOffDuty() {
		return sunOffDuty;
	}

	public void setSunOffDuty(Date sunOffDuty) {
		this.sunOffDuty = sunOffDuty;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drawTimeId == null) ? 0 : drawTimeId.hashCode());
		result = prime * result + ((isUse == null) ? 0 : isUse.hashCode());
		result = prime * result + ((offDuty == null) ? 0 : offDuty.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((satOffDuty == null) ? 0 : satOffDuty.hashCode());
		result = prime * result + ((satWorkTime == null) ? 0 : satWorkTime.hashCode());
		result = prime * result + ((sunOffDuty == null) ? 0 : sunOffDuty.hashCode());
		result = prime * result + ((sunWorkTime == null) ? 0 : sunWorkTime.hashCode());
		result = prime * result + ((timeName == null) ? 0 : timeName.hashCode());
		result = prime * result + ((workTime == null) ? 0 : workTime.hashCode());
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
		Picktime other = (Picktime) obj;
		if (drawTimeId == null) {
			if (other.drawTimeId != null)
				return false;
		} else if (!drawTimeId.equals(other.drawTimeId))
			return false;
		if (isUse == null) {
			if (other.isUse != null)
				return false;
		} else if (!isUse.equals(other.isUse))
			return false;
		if (offDuty == null) {
			if (other.offDuty != null)
				return false;
		} else if (!offDuty.equals(other.offDuty))
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
		if (satOffDuty == null) {
			if (other.satOffDuty != null)
				return false;
		} else if (!satOffDuty.equals(other.satOffDuty))
			return false;
		if (satWorkTime == null) {
			if (other.satWorkTime != null)
				return false;
		} else if (!satWorkTime.equals(other.satWorkTime))
			return false;
		if (sunOffDuty == null) {
			if (other.sunOffDuty != null)
				return false;
		} else if (!sunOffDuty.equals(other.sunOffDuty))
			return false;
		if (sunWorkTime == null) {
			if (other.sunWorkTime != null)
				return false;
		} else if (!sunWorkTime.equals(other.sunWorkTime))
			return false;
		if (timeName == null) {
			if (other.timeName != null)
				return false;
		} else if (!timeName.equals(other.timeName))
			return false;
		if (workTime == null) {
			if (other.workTime != null)
				return false;
		} else if (!workTime.equals(other.workTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Picktime [drawTimeId=" + drawTimeId + ", timeName=" + timeName + ", orgId=" + orgId + ", orgName="
				+ orgName + ", workTime=" + workTime + ", offDuty=" + offDuty + ", satWorkTime=" + satWorkTime
				+ ", satOffDuty=" + satOffDuty + ", sunWorkTime=" + sunWorkTime + ", sunOffDuty=" + sunOffDuty
				+ ", isUse=" + isUse + "]";
	}

}
