package com.yidu.tencloud.bean.taketosend.fastEntering;

import java.io.Serializable;

/**
 * 快速录入实体类
 * @author 廖晓翠
 * @since 2017/12/12
 */
public class FastEntering implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 工作单Id
	 */
	private String workSheetId;
	/**
	 * 工作单编号
	 */
	private String workSheetNo;
	/**
	 * 到达地
	 */
	private String destination;
	/**
	 * 产品
	 */
	private String product;
	/**
	 * 总件数
	 */
	private Integer productAmount;
	/**
	 * 重量
	 */
	private Integer actualWeight;
	/**
	 * 配载要求
	 */
	private String stowageRequirement;
	/**
	 * 规则Id
	 */
	private String ruleId;
	/**
	 * 工作单来源
	 */
	private String workSheetSource;
	/**
	 * 工作单状态
	 */
    private String workSheetType;
    /**
     * 完整性状态
     */
    private String integraliyStatus;
	
	public FastEntering() {}

	public FastEntering(String workSheetId, String workSheetNo, String destination, String product,
			Integer productAmount, Integer actualWeight, String stowageRequirement, String ruleId,
			String workSheetSource, String workSheetType, String integraliyStatus) {
		super();
		this.workSheetId = workSheetId;
		this.workSheetNo = workSheetNo;
		this.destination = destination;
		this.product = product;
		this.productAmount = productAmount;
		this.actualWeight = actualWeight;
		this.stowageRequirement = stowageRequirement;
		this.ruleId = ruleId;
		this.workSheetSource = workSheetSource;
		this.workSheetType = workSheetType;
		this.integraliyStatus = integraliyStatus;
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public Integer getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(Integer actualWeight) {
		this.actualWeight = actualWeight;
	}

	public String getStowageRequirement() {
		return stowageRequirement;
	}

	public void setStowageRequirement(String stowageRequirement) {
		this.stowageRequirement = stowageRequirement;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getWorkSheetSource() {
		return workSheetSource;
	}

	public void setWorkSheetSource(String workSheetSource) {
		this.workSheetSource = workSheetSource;
	}

	public String getWorkSheetType() {
		return workSheetType;
	}

	public void setWorkSheetType(String workSheetType) {
		this.workSheetType = workSheetType;
	}

	public String getIntegraliyStatus() {
		return integraliyStatus;
	}

	public void setIntegraliyStatus(String integraliyStatus) {
		this.integraliyStatus = integraliyStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FastEntering [workSheetId=" + workSheetId + ", workSheetNo=" + workSheetNo + ", destination="
				+ destination + ", product=" + product + ", productAmount=" + productAmount + ", actualWeight="
				+ actualWeight + ", stowageRequirement=" + stowageRequirement + ", ruleId=" + ruleId
				+ ", workSheetSource=" + workSheetSource + ", workSheetType=" + workSheetType + ", integraliyStatus="
				+ integraliyStatus + "]";
	}

	
}
