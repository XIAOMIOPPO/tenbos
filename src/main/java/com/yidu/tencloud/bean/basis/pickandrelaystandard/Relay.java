package com.yidu.tencloud.bean.basis.pickandrelaystandard;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 替班实体类
 * 
 * @author 张建勇
 * @date 2017.11.02
 */
public class Relay implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -3382284103572520409L;

	/**
	 * 替班ID
	 */
	private String relayId;

	/**
	 * 替班职员ID
	 */
	private String replaceId;

	/**
	 * 被替班职员ID
	 */
	private String replacedId;

	/**
	 * 替班开始时间
	 */
	@Column(name="startTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
	 * 替班结束时间
	 */
	@Column(name="endTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
	 * 替班职员名字
	 */
	private String replaceName;

	/**
	 * 被替班职员名字
	 */
	private String replacedName;

	/**
	 * 是否作废
	 */
	private String isUse;

	/**
	 * 备注
	 */
	private String remake;

	public Relay() {

	}

	public Relay(String relayId, String replaceId, String replacedId, Date startTime, Date endTime, String replaceName,
			String replacedName, String isUse, String remake) {
		super();
		this.relayId = relayId;
		this.replaceId = replaceId;
		this.replacedId = replacedId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.replaceName = replaceName;
		this.replacedName = replacedName;
		this.isUse = isUse;
		this.remake = remake;
	}

	@Override
	public String toString() {
		return "Relay [relayId=" + relayId + ", replaceId=" + replaceId + ", replacedId=" + replacedId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", replaceName=" + replaceName + ", replacedName=" + replacedName
				+ ", isUse=" + isUse + ", remake=" + remake + "]";
	}

	public String getRelayId() {
		return relayId;
	}

	public void setRelayId(String relayId) {
		this.relayId = relayId;
	}

	public String getReplaceId() {
		return replaceId;
	}

	public void setReplaceId(String replaceId) {
		this.replaceId = replaceId;
	}

	public String getReplacedId() {
		return replacedId;
	}

	public void setReplacedId(String replacedId) {
		this.replacedId = replacedId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getReplaceName() {
		return replaceName;
	}

	public void setReplaceName(String replaceName) {
		this.replaceName = replaceName;
	}

	public String getReplacedName() {
		return replacedName;
	}

	public void setReplacedName(String replacedName) {
		this.replacedName = replacedName;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((isUse == null) ? 0 : isUse.hashCode());
		result = prime * result + ((relayId == null) ? 0 : relayId.hashCode());
		result = prime * result + ((remake == null) ? 0 : remake.hashCode());
		result = prime * result + ((replaceId == null) ? 0 : replaceId.hashCode());
		result = prime * result + ((replaceName == null) ? 0 : replaceName.hashCode());
		result = prime * result + ((replacedId == null) ? 0 : replacedId.hashCode());
		result = prime * result + ((replacedName == null) ? 0 : replacedName.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Relay other = (Relay) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (isUse == null) {
			if (other.isUse != null)
				return false;
		} else if (!isUse.equals(other.isUse))
			return false;
		if (relayId == null) {
			if (other.relayId != null)
				return false;
		} else if (!relayId.equals(other.relayId))
			return false;
		if (remake == null) {
			if (other.remake != null)
				return false;
		} else if (!remake.equals(other.remake))
			return false;
		if (replaceId == null) {
			if (other.replaceId != null)
				return false;
		} else if (!replaceId.equals(other.replaceId))
			return false;
		if (replaceName == null) {
			if (other.replaceName != null)
				return false;
		} else if (!replaceName.equals(other.replaceName))
			return false;
		if (replacedId == null) {
			if (other.replacedId != null)
				return false;
		} else if (!replacedId.equals(other.replacedId))
			return false;
		if (replacedName == null) {
			if (other.replacedName != null)
				return false;
		} else if (!replacedName.equals(other.replacedName))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

}
