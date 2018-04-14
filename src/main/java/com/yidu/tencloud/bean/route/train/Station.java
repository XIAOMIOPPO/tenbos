package com.yidu.tencloud.bean.route.train;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

public class Station {

private String stationId;
	
	private String city;
	
	private String code;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String remark;
	
	private String drawerName;
	
	private String drawerCompany;
	
	@Column(name="drawerTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date drawerTime;
	
	private String supplementName;
	
	@Column(name="supplementTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date supplementTime;
	
	private String status;
	
	private String longitude;
	
	private String latitude;
	
	
	public Station() {}


	public String getStationId() {
		return stationId;
	}


	public void setStationId(String stationId) {
		this.stationId = stationId;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", city=" + city + ", code=" + code + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", remark=" + remark + ", drawerName=" + drawerName
				+ ", drawerCompany=" + drawerCompany + ", drawerTime=" + drawerTime + ", supplementName="
				+ supplementName + ", supplementTime=" + supplementTime + ", status=" + status + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}


	public Station(String stationId, String city, String code, String name, String address, String phone, String remark,
			String drawerName, String drawerCompany, Date drawerTime, String supplementName, Date supplementTime,
			String status, String longitude, String latitude) {
		super();
		this.stationId = stationId;
		this.city = city;
		this.code = code;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.remark = remark;
		this.drawerName = drawerName;
		this.drawerCompany = drawerCompany;
		this.drawerTime = drawerTime;
		this.supplementName = supplementName;
		this.supplementTime = supplementTime;
		this.status = status;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	
	
}
