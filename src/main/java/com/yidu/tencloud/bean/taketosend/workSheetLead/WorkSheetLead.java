package com.yidu.tencloud.bean.taketosend.workSheetLead;

import java.util.Date;

/**
 * 工作单导入实体类
 * @author 陈玉娟
 * @since 2017年12月20日10:23:47
 */
public class WorkSheetLead {
	/**
	 * 工作单编号
	 */
	private String workSheetNo;
	/**
	 * 业务通知单号
	 */
	private String businessNoticeNo;
	/**
	 * 客户单号
	 */
	private String customerListNo;
	/**
	 * 产品
	 */
	private String product;
	/**
	 * 到达地
	 */
	private String destination;
	/**
	 * 取货联系人
	 */
	private String empName;
	/**
	 * 配载要求
	 */
	private String stowageRequirement;
	/**
	 * 工作单类型
	 */
	private String workSheetType;
	/**
	 * 工作单来源
	 */
	private String workSheetSource;
	/**
	 * 工作单完整性状态
	 */
	private String integraliyStatus;
	/**
	 * 寄件人
	 */
	private String senderName;
	/**
	 * 寄件人传真
	 */
	private String senderFax;
	/**
	 * 寄件人地址
	 */
	private String senderAddress;
	/**
	 * 寄件人单位
	 */
	private String senderCompany;
	/**
	 * 寄件人电话
	 */
	private String senderPhone;
	/**
	 * 寄件人编号
	 */
	private String senderNo;
	/**
	 * 收件人
	 */
	private String addressesName;
	/**
	 * 收件人传真
	 */
	private String addressesFax;
	/**
	 * 收件人地址
	 */
	private String addressesAddress;
	/**
	 * 收件人单位
	 */
	private String addressesCompany;
	/**
	 * 收件人电话
	 */
	private String addressesPhone;
	/**
	 * 实际重量
	 */
	private double actualWeight;
	/**
	 * 品名
	 */
	private String productName;
	/**
	 * 体积
	 */
	private String size;
	/**
	 * 保险类型
	 */
	private String insuranceType;
	/**
	 * 保险费
	 */
	private int insurancePremium;
	/**
	 * 声明价值
	 */
	private String declaredValue;
	/**
	 * 原包装
	 */
	private String originalPacking;
	/**
	 * 实际包装
	 */
	private String actualPacking;
	// 包装费
	private int packingCharges;
	/**
	 * 包装要求
	 */
	private String packagingRequirements;
	/**
	 * 实际件数
	 */
	private int productAmount;
	/**
	 * 计费重量
	 */
	private double billingWeight;
	/**
	 * 预计运费
	 */
	private int preCharge;
	/**
	 * 结算方式
	 */
	private String settlementMode;
	/**
	 * 代收款
	 */
	private int replaceReceivables;
	/**
	 * 到付款
	 */
	private int paymentArrival;
	/**
	 * 反馈签收
	 */
	private String feedbackSign;
	/**
	 * 节假日可以收获
	 */
	private String holidayIsCollect;
	/**
	 * 送达时限
	 */
	private Date serviceTimeLimit;
	// 处理方式
	// private String processingMethod;
	// 签单返回
	// private String signBack;
	// 重要提示
	// private String importantTips;
	/**
	 * 是否COD
	 */
	private String cod;

	public WorkSheetLead() {
	}

	public WorkSheetLead(String workSheetNo, String businessNoticeNo, String customerListNo, String product,
			String destination, String empName, String stowageRequirement, String workSheetType, String workSheetSource,
			String integraliyStatus, String senderName, String senderFax, String senderAddress, String senderCompany,
			String senderPhone, String senderNo, String addressesName, String addressesFax, String addressesAddress,
			String addressesCompany, String addressesPhone, double actualWeight, String productName, String size,
			String insuranceType, int insurancePremium, String declaredValue, String originalPacking,
			String actualPacking, int packingCharges, String packagingRequirements, int productAmount,
			double billingWeight, int preCharge, String settlementMode, int replaceReceivables, int paymentArrival,
			String feedbackSign, String holidayIsCollect, Date serviceTimeLimit, String cod) {
		super();
		this.workSheetNo = workSheetNo;
		this.businessNoticeNo = businessNoticeNo;
		this.customerListNo = customerListNo;
		this.product = product;
		this.destination = destination;
		this.empName = empName;
		this.stowageRequirement = stowageRequirement;
		this.workSheetType = workSheetType;
		this.workSheetSource = workSheetSource;
		this.integraliyStatus = integraliyStatus;
		this.senderName = senderName;
		this.senderFax = senderFax;
		this.senderAddress = senderAddress;
		this.senderCompany = senderCompany;
		this.senderPhone = senderPhone;
		this.senderNo = senderNo;
		this.addressesName = addressesName;
		this.addressesFax = addressesFax;
		this.addressesAddress = addressesAddress;
		this.addressesCompany = addressesCompany;
		this.addressesPhone = addressesPhone;
		this.actualWeight = actualWeight;
		this.productName = productName;
		this.size = size;
		this.insuranceType = insuranceType;
		this.insurancePremium = insurancePremium;
		this.declaredValue = declaredValue;
		this.originalPacking = originalPacking;
		this.actualPacking = actualPacking;
		this.packingCharges = packingCharges;
		this.packagingRequirements = packagingRequirements;
		this.productAmount = productAmount;
		this.billingWeight = billingWeight;
		this.preCharge = preCharge;
		this.settlementMode = settlementMode;
		this.replaceReceivables = replaceReceivables;
		this.paymentArrival = paymentArrival;
		this.feedbackSign = feedbackSign;
		this.holidayIsCollect = holidayIsCollect;
		this.serviceTimeLimit = serviceTimeLimit;
		this.cod = cod;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	public String getBusinessNoticeNo() {
		return businessNoticeNo;
	}

	public void setBusinessNoticeNo(String businessNoticeNo) {
		this.businessNoticeNo = businessNoticeNo;
	}

	public String getCustomerListNo() {
		return customerListNo;
	}

	public void setCustomerListNo(String customerListNo) {
		this.customerListNo = customerListNo;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getStowageRequirement() {
		return stowageRequirement;
	}

	public void setStowageRequirement(String stowageRequirement) {
		this.stowageRequirement = stowageRequirement;
	}

	public String getWorkSheetType() {
		return workSheetType;
	}

	public void setWorkSheetType(String workSheetType) {
		this.workSheetType = workSheetType;
	}

	public String getWorkSheetSource() {
		return workSheetSource;
	}

	public void setWorkSheetSource(String workSheetSource) {
		this.workSheetSource = workSheetSource;
	}

	public String getIntegraliyStatus() {
		return integraliyStatus;
	}

	public void setIntegraliyStatus(String integraliyStatus) {
		this.integraliyStatus = integraliyStatus;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderFax() {
		return senderFax;
	}

	public void setSenderFax(String senderFax) {
		this.senderFax = senderFax;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderNo() {
		return senderNo;
	}

	public void setSenderNo(String senderNo) {
		this.senderNo = senderNo;
	}

	public String getAddressesName() {
		return addressesName;
	}

	public void setAddressesName(String addressesName) {
		this.addressesName = addressesName;
	}

	public String getAddressesFax() {
		return addressesFax;
	}

	public void setAddressesFax(String addressesFax) {
		this.addressesFax = addressesFax;
	}

	public String getAddressesAddress() {
		return addressesAddress;
	}

	public void setAddressesAddress(String addressesAddress) {
		this.addressesAddress = addressesAddress;
	}

	public String getAddressesCompany() {
		return addressesCompany;
	}

	public void setAddressesCompany(String addressesCompany) {
		this.addressesCompany = addressesCompany;
	}

	public String getAddressesPhone() {
		return addressesPhone;
	}

	public void setAddressesPhone(String addressesPhone) {
		this.addressesPhone = addressesPhone;
	}

	public double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public int getInsurancePremium() {
		return insurancePremium;
	}

	public void setInsurancePremium(int insurancePremium) {
		this.insurancePremium = insurancePremium;
	}

	public String getDeclaredValue() {
		return declaredValue;
	}

	public void setDeclaredValue(String declaredValue) {
		this.declaredValue = declaredValue;
	}

	public String getOriginalPacking() {
		return originalPacking;
	}

	public void setOriginalPacking(String originalPacking) {
		this.originalPacking = originalPacking;
	}

	public String getActualPacking() {
		return actualPacking;
	}

	public void setActualPacking(String actualPacking) {
		this.actualPacking = actualPacking;
	}

	public int getPackingCharges() {
		return packingCharges;
	}

	public void setPackingCharges(int packingCharges) {
		this.packingCharges = packingCharges;
	}

	public String getPackagingRequirements() {
		return packagingRequirements;
	}

	public void setPackagingRequirements(String packagingRequirements) {
		this.packagingRequirements = packagingRequirements;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public double getBillingWeight() {
		return billingWeight;
	}

	public void setBillingWeight(double billingWeight) {
		this.billingWeight = billingWeight;
	}

	public int getPreCharge() {
		return preCharge;
	}

	public void setPreCharge(int preCharge) {
		this.preCharge = preCharge;
	}

	public String getSettlementMode() {
		return settlementMode;
	}

	public void setSettlementMode(String settlementMode) {
		this.settlementMode = settlementMode;
	}

	public int getReplaceReceivables() {
		return replaceReceivables;
	}

	public void setReplaceReceivables(int replaceReceivables) {
		this.replaceReceivables = replaceReceivables;
	}

	public int getPaymentArrival() {
		return paymentArrival;
	}

	public void setPaymentArrival(int paymentArrival) {
		this.paymentArrival = paymentArrival;
	}

	public String getFeedbackSign() {
		return feedbackSign;
	}

	public void setFeedbackSign(String feedbackSign) {
		this.feedbackSign = feedbackSign;
	}

	public String getHolidayIsCollect() {
		return holidayIsCollect;
	}

	public void setHolidayIsCollect(String holidayIsCollect) {
		this.holidayIsCollect = holidayIsCollect;
	}

	public Date getServiceTimeLimit() {
		return serviceTimeLimit;
	}

	public void setServiceTimeLimit(Date serviceTimeLimit) {
		this.serviceTimeLimit = serviceTimeLimit;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "WorkSheetLead [workSheetNo=" + workSheetNo + ", businessNoticeNo=" + businessNoticeNo
				+ ", customerListNo=" + customerListNo + ", product=" + product + ", destination=" + destination
				+ ", empName=" + empName + ", stowageRequirement=" + stowageRequirement + ", workSheetType="
				+ workSheetType + ", workSheetSource=" + workSheetSource + ", integraliyStatus=" + integraliyStatus
				+ ", senderName=" + senderName + ", senderFax=" + senderFax + ", senderAddress=" + senderAddress
				+ ", senderCompany=" + senderCompany + ", senderPhone=" + senderPhone + ", senderNo=" + senderNo
				+ ", addressesName=" + addressesName + ", addressesFax=" + addressesFax + ", addressesAddress="
				+ addressesAddress + ", addressesCompany=" + addressesCompany + ", addressesPhone=" + addressesPhone
				+ ", actualWeight=" + actualWeight + ", productName=" + productName + ", size=" + size
				+ ", insuranceType=" + insuranceType + ", insurancePremium=" + insurancePremium + ", declaredValue="
				+ declaredValue + ", originalPacking=" + originalPacking + ", actualPacking=" + actualPacking
				+ ", packingCharges=" + packingCharges + ", packagingRequirements=" + packagingRequirements
				+ ", productAmount=" + productAmount + ", billingWeight=" + billingWeight + ", preCharge=" + preCharge
				+ ", settlementMode=" + settlementMode + ", replaceReceivables=" + replaceReceivables
				+ ", paymentArrival=" + paymentArrival + ", feedbackSign=" + feedbackSign + ", holidayIsCollect="
				+ holidayIsCollect + ", serviceTimeLimit=" + serviceTimeLimit + ", cod=" + cod + "]";
	}

}
