package com.yidu.tencloud.bean.taketosend.workSheetSerach;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 工作单查询实体类
 * @author ZhangZhenhao
 * @since 2017/11/28
 */
public class WorkSheetSearch {
	/**
	 * 工作单号
	 */
	private String workSheetNo;

	/**
	 * 返单标记
	 */
	private String cargoReturnSign;
	
	/**
	 * 品名
	 */
	private String productName;
	
	/**
	 * 件数
	 */
	private Integer billingQuantity;

	/**
	 * 产品
	 */
	private String product;

	/**
	 * 寄件人
	 */
	private String senderName;

	/**
	 * 寄件人电话
	 */
	private String senderPhone;

	/**
	 * 寄件人单位
	 */
	private String senderCompany;
	
	/**
	 * 到达地
	 */
	private String addressesAddress;

	/**
	 * 希望到达时间
	 */
	@Column(name="serviceTimeLimit")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date serviceTimeLimit;

	/**
	 * 收件人
	 */
	private String addressesName;

	/**
	 * 开单时间
	 */
	private Date drawerTime;

	/**
	 * 修改人
	 */
	private String supplementName;
	
	/**
	 * 修改单位
	 */
	private String supplementCompany;

	/**
	 * 修改时间
	 */
	private Date supplementTime;
	
	/**
	 * 完整性状态
	 */
	private String integraliyStatus;
	
	/**
	 * 受理单位
	 */
	private String pickup;
	
	private String cancelStatus;

	public WorkSheetSearch(){}

	public WorkSheetSearch(String workSheetNo, String cargoReturnSign, String productName, Integer billingQuantity,
			String product, String senderName, String senderPhone, String senderCompany, String addressesAddress,
			Date serviceTimeLimit, String addressesName, Date drawerTime, String supplementName,
			String supplementCompany, Date supplementTime, String integraliyStatus, String pickup,
			String cancelStatus) {
		super();
		this.workSheetNo = workSheetNo;
		this.cargoReturnSign = cargoReturnSign;
		this.productName = productName;
		this.billingQuantity = billingQuantity;
		this.product = product;
		this.senderName = senderName;
		this.senderPhone = senderPhone;
		this.senderCompany = senderCompany;
		this.addressesAddress = addressesAddress;
		this.serviceTimeLimit = serviceTimeLimit;
		this.addressesName = addressesName;
		this.drawerTime = drawerTime;
		this.supplementName = supplementName;
		this.supplementCompany = supplementCompany;
		this.supplementTime = supplementTime;
		this.integraliyStatus = integraliyStatus;
		this.pickup = pickup;
		this.cancelStatus = cancelStatus;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	public String getCargoReturnSign() {
		return cargoReturnSign;
	}

	public void setCargoReturnSign(String cargoReturnSign) {
		this.cargoReturnSign = cargoReturnSign;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getBillingQuantity() {
		return billingQuantity;
	}

	public void setBillingQuantity(Integer billingQuantity) {
		this.billingQuantity = billingQuantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public String getAddressesAddress() {
		return addressesAddress;
	}

	public void setAddressesAddress(String addressesAddress) {
		this.addressesAddress = addressesAddress;
	}

	public Date getServiceTimeLimit() {
		return serviceTimeLimit;
	}

	public void setServiceTimeLimit(Date serviceTimeLimit) {
		this.serviceTimeLimit = serviceTimeLimit;
	}

	public String getAddressesName() {
		return addressesName;
	}

	public void setAddressesName(String addressesName) {
		this.addressesName = addressesName;
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

	public String getSupplementCompany() {
		return supplementCompany;
	}

	public void setSupplementCompany(String supplementCompany) {
		this.supplementCompany = supplementCompany;
	}

	public Date getSupplementTime() {
		return supplementTime;
	}

	public void setSupplementTime(Date supplementTime) {
		this.supplementTime = supplementTime;
	}

	public String getIntegraliyStatus() {
		return integraliyStatus;
	}

	public void setIntegraliyStatus(String integraliyStatus) {
		this.integraliyStatus = integraliyStatus;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	@Override
	public String toString() {
		return "WorkSheetSearch [workSheetNo=" + workSheetNo + ", cargoReturnSign=" + cargoReturnSign + ", productName="
				+ productName + ", billingQuantity=" + billingQuantity + ", product=" + product + ", senderName="
				+ senderName + ", senderPhone=" + senderPhone + ", senderCompany=" + senderCompany
				+ ", addressesAddress=" + addressesAddress + ", serviceTimeLimit=" + serviceTimeLimit
				+ ", addressesName=" + addressesName + ", drawerTime=" + drawerTime + ", supplementName="
				+ supplementName + ", supplementCompany=" + supplementCompany + ", supplementTime=" + supplementTime
				+ ", integraliyStatus=" + integraliyStatus + ", pickup=" + pickup + ", cancelStatus=" + cancelStatus
				+ "]";
	}

	
}