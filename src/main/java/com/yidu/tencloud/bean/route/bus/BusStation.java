package com.yidu.tencloud.bean.route.bus;

import java.io.Serializable;
import java.util.Date;

/**
 * 汽车站实体类
 * @author 廖晓翠
 * @since 2018/01/05
 */
public class BusStation implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 汽车站Id
	 */
	private String busStationId;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String busStationName;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 联系人电话
	 */
	private String contactNumber;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 录入人
	 */
	private String drawerName;
	/**
	 * 录入单位
	 */
	private String drawerCompany;
	/**
	 * 录入时间
	 */
	private Date drawerTime;
	/**
	 * 最后修改人
	 */
	private String supplementName;
	/**
	 * 最后修改时间
	 */
	private Date supplementTime;
	/**
	 * 是否禁用
	 */
	private String isUse;

	public BusStation() {}

	public BusStation(String busStationId, String city, String code, String busStationName, String address,
			String contactNumber, String remark, String drawerName, String drawerCompany, Date drawerTime,
			String supplementName, Date supplementTime, String isUse) {
		super();
		this.busStationId = busStationId;
		this.city = city;
		this.code = code;
		this.busStationName = busStationName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.remark = remark;
		this.drawerName = drawerName;
		this.drawerCompany = drawerCompany;
		this.drawerTime = drawerTime;
		this.supplementName = supplementName;
		this.supplementTime = supplementTime;
		this.isUse = isUse;
	}

	public String getBusStationId() {
		return busStationId;
	}

	public void setBusStationId(String busStationId) {
		this.busStationId = busStationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBusStationName() {
		return busStationName;
	}

	public void setBusStationName(String busStationName) {
		this.busStationName = busStationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDrawerName() {
		return drawerName;
	}

	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}

	public String getDrawerCompany() {
		return drawerCompany;
	}

	public void setDrawerCompany(String drawerCompany) {
		this.drawerCompany = drawerCompany;
	}

	public Date getDrawerTime() {
		return drawerTime;
	}

	public void setDrawerTime(Date drawerTime) {
		this.drawerTime = drawerTime;
	}

	public String getSupplementName() {
		return supplementName;
	}

	public void setSupplementName(String supplementName) {
		this.supplementName = supplementName;
	}

	public Date getSupplementTime() {
		return supplementTime;
	}

	public void setSupplementTime(Date supplementTime) {
		this.supplementTime = supplementTime;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((busStationId == null) ? 0 : busStationId.hashCode());
		result = prime * result + ((busStationName == null) ? 0 : busStationName.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((drawerCompany == null) ? 0 : drawerCompany.hashCode());
		result = prime * result + ((drawerName == null) ? 0 : drawerName.hashCode());
		result = prime * result + ((drawerTime == null) ? 0 : drawerTime.hashCode());
		result = prime * result + ((isUse == null) ? 0 : isUse.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((supplementName == null) ? 0 : supplementName.hashCode());
		result = prime * result + ((supplementTime == null) ? 0 : supplementTime.hashCode());
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
		BusStation other = (BusStation) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (busStationId == null) {
			if (other.busStationId != null)
				return false;
		} else if (!busStationId.equals(other.busStationId))
			return false;
		if (busStationName == null) {
			if (other.busStationName != null)
				return false;
		} else if (!busStationName.equals(other.busStationName))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (drawerCompany == null) {
			if (other.drawerCompany != null)
				return false;
		} else if (!drawerCompany.equals(other.drawerCompany))
			return false;
		if (drawerName == null) {
			if (other.drawerName != null)
				return false;
		} else if (!drawerName.equals(other.drawerName))
			return false;
		if (drawerTime == null) {
			if (other.drawerTime != null)
				return false;
		} else if (!drawerTime.equals(other.drawerTime))
			return false;
		if (isUse == null) {
			if (other.isUse != null)
				return false;
		} else if (!isUse.equals(other.isUse))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (supplementName == null) {
			if (other.supplementName != null)
				return false;
		} else if (!supplementName.equals(other.supplementName))
			return false;
		if (supplementTime == null) {
			if (other.supplementTime != null)
				return false;
		} else if (!supplementTime.equals(other.supplementTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusStation [busStationId=" + busStationId + ", city=" + city + ", code=" + code + ", busStationName="
				+ busStationName + ", address=" + address + ", contactNumber=" + contactNumber + ", remark=" + remark
				+ ", drawerName=" + drawerName + ", drawerCompany=" + drawerCompany + ", drawerTime=" + drawerTime
				+ ", supplementName=" + supplementName + ", supplementTime=" + supplementTime + ", isUse=" + isUse
				+ "]";
	}

}
