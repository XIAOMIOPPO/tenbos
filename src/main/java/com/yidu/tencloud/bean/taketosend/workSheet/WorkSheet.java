package com.yidu.tencloud.bean.taketosend.workSheet;

import java.io.Serializable;
/**
 * 工作单实体类
 * @author 陈涛
 *
 */
public class WorkSheet implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 规则
	 */
	private Rule rule;
	/**
	 * 寄件人
	 */
	private Sender sender;
	/**
	 * 收件人
	 */
	private Addresses addresses;
	/**
	 * 开单人
	 */
	private Drawer drawer;
	/**
	 * 工作单Id
	 */
	private String workSheetId;
	/**
	 * 工作单编号
	 */
	private String workSheetNo;
	/**
	 * 客户单编号
	 */
	private String customerListNo;
    /**
     * 产品
     */
	private String product;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 业务通知单编号
	 */
	private String businessNoticeNo;
    /**
     * 取件人	
     */
	private String empName;
	/**
	 * 取件单位
	 */
	private String pickup;
	/**
	 * 配载要求
	 */
	private String stowageRequirement;
	/**
	 * 作废状态
	 */
	private String cancelStatus;
	/**
	 * 签收状态
	 */
	private int signStatus;
	/**
	 * 工作单类型
	 */
	private String workSheetType;
	/**
	 * 工作单来源
	 */
	private String workSheetSource;
	/**
	 * 完整性状态
	 */
	private String integraliyStatus;
	/**
	 * 返签单标志
	 */
	private String signBack;
	/**
	 * 返货标志
	 */
	private String cargoReturnSign;

	/**
	 * 分拣编码
	 */
	private String fixedAreaNo;

	public WorkSheet() {}

	public WorkSheet(Rule rule, Sender sender, Addresses addresses, Drawer drawer, String workSheetId,
			String workSheetNo, String customerListNo, String product, String destination, String businessNoticeNo,
			String empName, String pickup, String stowageRequirement, String cancelStatus, int signStatus,
			String workSheetType, String workSheetSource, String integraliyStatus, String signBack,
			String cargoReturnSign, String fixedAreaNo) {
		super();
		this.rule = rule;
		this.sender = sender;
		this.addresses = addresses;
		this.drawer = drawer;
		this.workSheetId = workSheetId;
		this.workSheetNo = workSheetNo;
		this.customerListNo = customerListNo;
		this.product = product;
		this.destination = destination;
		this.businessNoticeNo = businessNoticeNo;
		this.empName = empName;
		this.pickup = pickup;
		this.stowageRequirement = stowageRequirement;
		this.cancelStatus = cancelStatus;
		this.signStatus = signStatus;
		this.workSheetType = workSheetType;
		this.workSheetSource = workSheetSource;
		this.integraliyStatus = integraliyStatus;
		this.signBack = signBack;
		this.cargoReturnSign = cargoReturnSign;
		this.fixedAreaNo = fixedAreaNo;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

	public Drawer getDrawer() {
		return drawer;
	}

	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}

	public String getWorkSheetId() {
		return workSheetId;
	}

	public void setWorkSheetId(String workSheetId) {
		this.workSheetId = workSheetId;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
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

	public String getBusinessNoticeNo() {
		return businessNoticeNo;
	}

	public void setBusinessNoticeNo(String businessNoticeNo) {
		this.businessNoticeNo = businessNoticeNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getStowageRequirement() {
		return stowageRequirement;
	}

	public void setStowageRequirement(String stowageRequirement) {
		this.stowageRequirement = stowageRequirement;
	}

	public String getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public int getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(int signStatus) {
		this.signStatus = signStatus;
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

	public String getSignBack() {
		return signBack;
	}

	public void setSignBack(String signBack) {
		this.signBack = signBack;
	}

	public String getCargoReturnSign() {
		return cargoReturnSign;
	}

	public void setCargoReturnSign(String cargoReturnSign) {
		this.cargoReturnSign = cargoReturnSign;
	}

	public String getFixedAreaNo() {
		return fixedAreaNo;
	}

	public void setFixedAreaNo(String fixedAreaNo) {
		this.fixedAreaNo = fixedAreaNo;
	}

	@Override
	public String toString() {
		return "WorkSheet [rule=" + rule + ", sender=" + sender + ", addresses=" + addresses + ", drawer=" + drawer
				+ ", workSheetId=" + workSheetId + ", workSheetNo=" + workSheetNo + ", customerListNo=" + customerListNo
				+ ", product=" + product + ", destination=" + destination + ", businessNoticeNo=" + businessNoticeNo
				+ ", empName=" + empName + ", pickup=" + pickup + ", stowageRequirement=" + stowageRequirement
				+ ", cancelStatus=" + cancelStatus + ", signStatus=" + signStatus + ", workSheetType=" + workSheetType
				+ ", workSheetSource=" + workSheetSource + ", integraliyStatus=" + integraliyStatus + ", signBack="
				+ signBack + ", cargoReturnSign=" + cargoReturnSign + ", fixedAreaNo=" + fixedAreaNo + "]";
	}

	
}
