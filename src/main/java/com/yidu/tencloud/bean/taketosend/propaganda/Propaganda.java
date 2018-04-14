package com.yidu.tencloud.bean.taketosend.propaganda;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 宣传任务的实体类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public class Propaganda {
	/**
	 * 宣传任务Id
	 */
    private String propagandaId;
    /**
     * 宣传任务概要
     */
	private String publicityOutline;
	/**
	 * 宣传内容
	 */
	private String propagandaContent;
	/**
	 * 发布时间
	 */
	@Column(name="releaseTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseTime; 
	/**
	 * 失效时间
	 */
	@Column(name="failureTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date failureTime;
	/**
	 * 更新时间
	 */
	@Column(name="updateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;
	/**
	 * 更新单位
	 */
	private String updateUnit;
	/**
	 * 更新人
	 */
	private String userId;
	/**
	 * 状态
	 */
	private String status;
	
	public  Propaganda(){
		
	}

	public String getPropagandaId() {
		return propagandaId;
	}

	public void setPropagandaId(String propagandaId) {
		this.propagandaId = propagandaId;
	}

	public String getPublicityOutline() {
		return publicityOutline;
	}

	public void setPublicityOutline(String publicityOutline) {
		this.publicityOutline = publicityOutline;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Date getFailureTime() {
		return failureTime;
	}

	public void setFailureTime(Date failureTime) {
		this.failureTime = failureTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUnit() {
		return updateUnit;
	}

	public void setUpdateUnit(String updateUnit) {
		this.updateUnit = updateUnit;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPropagandaContent() {
		return propagandaContent;
	}

	public void setPropagandaContent(String propagandaContent) {
		this.propagandaContent = propagandaContent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((failureTime == null) ? 0 : failureTime.hashCode());
		result = prime * result + ((propagandaContent == null) ? 0 : propagandaContent.hashCode());
		result = prime * result + ((propagandaId == null) ? 0 : propagandaId.hashCode());
		result = prime * result + ((publicityOutline == null) ? 0 : publicityOutline.hashCode());
		result = prime * result + ((releaseTime == null) ? 0 : releaseTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUnit == null) ? 0 : updateUnit.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Propaganda other = (Propaganda) obj;
		if (failureTime == null) {
			if (other.failureTime != null)
				return false;
		} else if (!failureTime.equals(other.failureTime))
			return false;
		if (propagandaContent == null) {
			if (other.propagandaContent != null)
				return false;
		} else if (!propagandaContent.equals(other.propagandaContent))
			return false;
		if (propagandaId == null) {
			if (other.propagandaId != null)
				return false;
		} else if (!propagandaId.equals(other.propagandaId))
			return false;
		if (publicityOutline == null) {
			if (other.publicityOutline != null)
				return false;
		} else if (!publicityOutline.equals(other.publicityOutline))
			return false;
		if (releaseTime == null) {
			if (other.releaseTime != null)
				return false;
		} else if (!releaseTime.equals(other.releaseTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUnit == null) {
			if (other.updateUnit != null)
				return false;
		} else if (!updateUnit.equals(other.updateUnit))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Propaganda [propagandaId=" + propagandaId + ", publicityOutline=" + publicityOutline + ", releaseTime="
				+ releaseTime + ", failureTime=" + failureTime + ", updateTime=" + updateTime + ", updateUnit="
				+ updateUnit + ", userId=" + userId + ", status=" + status + ", propagandaContent=" + propagandaContent
				+ "]";
	}

	public Propaganda(String propagandaId, String publicityOutline, Date releaseTime, Date failureTime, Date updateTime,
			String updateUnit, String userId, String status, String propagandaContent) {
		super();
		this.propagandaId = propagandaId;
		this.publicityOutline = publicityOutline;
		this.releaseTime = releaseTime;
		this.failureTime = failureTime;
		this.updateTime = updateTime;
		this.updateUnit = updateUnit;
		this.userId = userId;
		this.status = status;
		this.propagandaContent = propagandaContent;
	}
    
	
	
}
