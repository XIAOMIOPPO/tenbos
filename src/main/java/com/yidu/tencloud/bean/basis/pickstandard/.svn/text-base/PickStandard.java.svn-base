package com.yidu.tencloud.bean.basis.pickstandard;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 收派标准实体类
 * @author 廖晓翠
 * @since 2017/11/02
 */
public class PickStandard implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -2385213826498326411L;
	
	/**
	 * 收派标准Id
	 */
	private String deliverId;
	/**
	 * 收派标准名称
	 */
	private String deliverName;
	/**
	 * 最小重量
	 */
	private BigDecimal minWeight;
	/**
	 * 最大重量
	 */
	private BigDecimal maxWeight;
	/**
	 * 最小长度
	 */
	private BigDecimal minLength;
	/**
	 * 最大长度
	 */
	private BigDecimal maxLength;
	/**
	 * 是否禁用
	 */
	private String isUse;
	
	public PickStandard() {}

	public PickStandard(String deliverId, String deliverName, BigDecimal minWeight, BigDecimal maxWeight,
			BigDecimal minLength, BigDecimal maxLength, String isUse) {
		super();
		this.deliverId = deliverId;
		this.deliverName = deliverName;
		this.minWeight = minWeight;
		this.maxWeight = maxWeight;
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.isUse = isUse;
	}

	public String getDeliverId() {
		return deliverId;
	}

	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}

	public String getDeliverName() {
		return deliverName;
	}

	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}

	public BigDecimal getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(BigDecimal minWeight) {
		this.minWeight = minWeight;
	}

	public BigDecimal getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}

	public BigDecimal getMinLength() {
		return minLength;
	}

	public void setMinLength(BigDecimal minLength) {
		this.minLength = minLength;
	}

	public BigDecimal getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(BigDecimal maxLength) {
		this.maxLength = maxLength;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliverId == null) ? 0 : deliverId.hashCode());
		result = prime * result + ((deliverName == null) ? 0 : deliverName.hashCode());
		result = prime * result + ((isUse == null) ? 0 : isUse.hashCode());
		result = prime * result + ((maxLength == null) ? 0 : maxLength.hashCode());
		result = prime * result + ((maxWeight == null) ? 0 : maxWeight.hashCode());
		result = prime * result + ((minLength == null) ? 0 : minLength.hashCode());
		result = prime * result + ((minWeight == null) ? 0 : minWeight.hashCode());
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
		PickStandard other = (PickStandard) obj;
		if (deliverId == null) {
			if (other.deliverId != null)
				return false;
		} else if (!deliverId.equals(other.deliverId))
			return false;
		if (deliverName == null) {
			if (other.deliverName != null)
				return false;
		} else if (!deliverName.equals(other.deliverName))
			return false;
		if (isUse == null) {
			if (other.isUse != null)
				return false;
		} else if (!isUse.equals(other.isUse))
			return false;
		if (maxLength == null) {
			if (other.maxLength != null)
				return false;
		} else if (!maxLength.equals(other.maxLength))
			return false;
		if (maxWeight == null) {
			if (other.maxWeight != null)
				return false;
		} else if (!maxWeight.equals(other.maxWeight))
			return false;
		if (minLength == null) {
			if (other.minLength != null)
				return false;
		} else if (!minLength.equals(other.minLength))
			return false;
		if (minWeight == null) {
			if (other.minWeight != null)
				return false;
		} else if (!minWeight.equals(other.minWeight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "deliverCriterion [deliverId=" + deliverId + ", deliverName=" + deliverName + ", minWeight=" + minWeight
				+ ", maxWeight=" + maxWeight + ", minLength=" + minLength + ", maxLength=" + maxLength + ", isUse="
				+ isUse + "]";
	}
	
	

}
