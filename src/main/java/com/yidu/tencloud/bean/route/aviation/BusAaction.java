package com.yidu.tencloud.bean.route.aviation;

import java.io.Serializable;
import java.sql.Date;

public class BusAaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String planeStationId;
	private String city;
	private String code;
	private String busStationName;
	private String address;
	private String contactNumber;
	private String remark;
	private String drawerName;
	private String drawerCompany;
	private Date drawerTime;
	private	String supplementName;
	private Date supplementTime;
	public String getPlaneStationId() {
		return planeStationId;
	}
	public String getCity() {
		return city;
	}
	public String getCode() {
		return code;
	}
	public String getBusStationName() {
		return busStationName;
	}
	public String getAddress() {
		return address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getRemark() {
		return remark;
	}
	public String getDrawerName() {
		return drawerName;
	}
	public String getDrawerCompany() {
		return drawerCompany;
	}
	public Date getDrawerTime() {
		return drawerTime;
	}
	public String getSupplementName() {
		return supplementName;
	}
	public Date getSupplementTime() {
		return supplementTime;
	}
	public void setPlaneStationId(String planeStationId) {
		this.planeStationId = planeStationId;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setBusStationName(String busStationName) {
		this.busStationName = busStationName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}
	public void setDrawerCompany(String drawerCompany) {
		this.drawerCompany = drawerCompany;
	}
	public void setDrawerTime(Date drawerTime) {
		this.drawerTime = drawerTime;
	}
	public void setSupplementName(String supplementName) {
		this.supplementName = supplementName;
	}
	public void setSupplementTime(Date supplementTime) {
		this.supplementTime = supplementTime;
	}
	
	public BusAaction() {
		super();
	}
	@Override
	public String toString() {
		return "BusAaction [planeStationId=" + planeStationId + ", city=" + city + ", code=" + code
				+ ", busStationName=" + busStationName + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", remark=" + remark + ", drawerName=" + drawerName + ", drawerCompany=" + drawerCompany
				+ ", drawerTime=" + drawerTime + ", supplementName=" + supplementName + ", supplementTime="
				+ supplementTime + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((busStationName == null) ? 0 : busStationName.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((drawerCompany == null) ? 0 : drawerCompany.hashCode());
		result = prime * result + ((drawerName == null) ? 0 : drawerName.hashCode());
		result = prime * result + ((drawerTime == null) ? 0 : drawerTime.hashCode());
		result = prime * result + ((planeStationId == null) ? 0 : planeStationId.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((supplementName == null) ? 0 : supplementName.hashCode());
		result = prime * result + ((supplementTime == null) ? 0 : supplementTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BusAaction)) {
			return false;
		}
		BusAaction other = (BusAaction) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (busStationName == null) {
			if (other.busStationName != null) {
				return false;
			}
		} else if (!busStationName.equals(other.busStationName)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (contactNumber == null) {
			if (other.contactNumber != null) {
				return false;
			}
		} else if (!contactNumber.equals(other.contactNumber)) {
			return false;
		}
		if (drawerCompany == null) {
			if (other.drawerCompany != null) {
				return false;
			}
		} else if (!drawerCompany.equals(other.drawerCompany)) {
			return false;
		}
		if (drawerName == null) {
			if (other.drawerName != null) {
				return false;
			}
		} else if (!drawerName.equals(other.drawerName)) {
			return false;
		}
		if (drawerTime == null) {
			if (other.drawerTime != null) {
				return false;
			}
		} else if (!drawerTime.equals(other.drawerTime)) {
			return false;
		}
		if (planeStationId == null) {
			if (other.planeStationId != null) {
				return false;
			}
		} else if (!planeStationId.equals(other.planeStationId)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (supplementName == null) {
			if (other.supplementName != null) {
				return false;
			}
		} else if (!supplementName.equals(other.supplementName)) {
			return false;
		}
		if (supplementTime == null) {
			if (other.supplementTime != null) {
				return false;
			}
		} else if (!supplementTime.equals(other.supplementTime)) {
			return false;
		}
		return true;
	}
	public BusAaction(String planeStationId, String city, String code, String busStationName, String address,
			String contactNumber, String remark, String drawerName, String drawerCompany, Date drawerTime,
			String supplementName, Date supplementTime) {
		super();
		this.planeStationId = planeStationId;
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
	}
	
	
}
