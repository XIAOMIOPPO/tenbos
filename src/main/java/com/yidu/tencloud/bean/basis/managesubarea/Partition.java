package com.yidu.tencloud.bean.basis.managesubarea;

import java.io.Serializable;
/**
 * 定区实体类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public class Partition implements Serializable{
    /**
     * 分区Id
     */
	private String partitionId;
	/**
	 * 定区Id
	 */
	private String fixedAreaId;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 区/县
	 */
	private String county;
	/**
	 * 属性
	 */
	private String property;
	/**
	 * 关键字
	 */
	private String addressKey;
	/**
	 * 起始号
	 */
	private int startNum;
	/**
	 * 终止号
	 */
	private int endNum;
	/**
	 * 单双号
	 */
	private String single;
	/**
	 * 辅助关键字
	 */
	private String secondaryKey;
    
	public Partition() {
		
	}

	public String getPartitionId() {
		return partitionId;
	}

	public void setPartitionId(String partitionId) {
		this.partitionId = partitionId;
	}

	public String getFixedAreaId() {
		return fixedAreaId;
	}

	public void setFixedAreaId(String fixedAreaId) {
		this.fixedAreaId = fixedAreaId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getAddressKey() {
		return addressKey;
	}

	public void setAddressKey(String addressKey) {
		this.addressKey = addressKey;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getSecondaryKey() {
		return secondaryKey;
	}

	public void setSecondaryKey(String secondaryKey) {
		this.secondaryKey = secondaryKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressKey == null) ? 0 : addressKey.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + endNum;
		result = prime * result + ((fixedAreaId == null) ? 0 : fixedAreaId.hashCode());
		result = prime * result + ((partitionId == null) ? 0 : partitionId.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((secondaryKey == null) ? 0 : secondaryKey.hashCode());
		result = prime * result + ((single == null) ? 0 : single.hashCode());
		result = prime * result + startNum;
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
		Partition other = (Partition) obj;
		if (addressKey == null) {
			if (other.addressKey != null)
				return false;
		} else if (!addressKey.equals(other.addressKey))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (endNum != other.endNum)
			return false;
		if (fixedAreaId == null) {
			if (other.fixedAreaId != null)
				return false;
		} else if (!fixedAreaId.equals(other.fixedAreaId))
			return false;
		if (partitionId == null) {
			if (other.partitionId != null)
				return false;
		} else if (!partitionId.equals(other.partitionId))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (secondaryKey == null) {
			if (other.secondaryKey != null)
				return false;
		} else if (!secondaryKey.equals(other.secondaryKey))
			return false;
		if (single == null) {
			if (other.single != null)
				return false;
		} else if (!single.equals(other.single))
			return false;
		if (startNum != other.startNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partition [partitionId=" + partitionId + ", fixedAreaId=" + fixedAreaId + ", province=" + province
				+ ", city=" + city + ", county=" + county + ", property=" + property + ", addressKey=" + addressKey
				+ ", startNum=" + startNum + ", endNum=" + endNum + ", single=" + single + ", secondaryKey="
				+ secondaryKey + "]";
	}

	public Partition(String partitionId, String fixedAreaId, String province, String city, String county,
			String property, String addressKey, int startNum, int endNum, String single, String secondaryKey) {
		super();
		this.partitionId = partitionId;
		this.fixedAreaId = fixedAreaId;
		this.province = province;
		this.city = city;
		this.county = county;
		this.property = property;
		this.addressKey = addressKey;
		this.startNum = startNum;
		this.endNum = endNum;
		this.single = single;
		this.secondaryKey = secondaryKey;
	}

	

}
