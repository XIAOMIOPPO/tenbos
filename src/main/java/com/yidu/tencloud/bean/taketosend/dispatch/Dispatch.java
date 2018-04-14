package com.yidu.tencloud.bean.taketosend.dispatch;

import java.io.Serializable;

/**
 * 调度实体类
 * @author 邓哲敏
 * @since 2017/11/23
 */
public class Dispatch implements Serializable {

	/**
	 * 序号
	 */
	private static final long serialVersionUID = -8347021479818827198L;

	private String numId;//序号
	private String isAbnormal;//异常
	private String businessRecsiptId;//业务受理单Id
	private String businessRecsiptNo;//业务受理单编号
	private String workOrderId;//工单Id
	private String workOrderNo;//工单单号
	private String empName;//取件员
	private String fetchAddress;//取件地址
	private String acceptingUnit;//受理单位
	private String recsiptTime;//受理时间
	private String placeTime;//下单成功时间
	private String applicationId;//申请返货Id(申请返货表)
	private String confirmationTime;//确认时间
	private String takeTime;//取件时间
	private String taskTime;//入库时间
	private String recordTime;//录单时间
	private String cancelTime;//核销时间
	private Double fare;//运费
	private Double insurance;//保险费
	private Integer bagging;//包装费
	private Double trueMoney;//实收款
	
	/**
	 * 提供无参的构造方法
	 */
	public Dispatch() {
		
	}

	/**
	 * 提供有参的构造方法
	 * @param numId 序号
	 * @param isAbnormal 异常
	 * @param businessRecsiptId 业务受理单Id
	 * @param businessRecsiptNo 业务受理单编号
	 * @param workOrderId 工单Id
	 * @param workOrderNo 工单单号
	 * @param empName 取件员
	 * @param fetchAddress 取件地址
	 * @param acceptingUnit 受理单位
	 * @param recsiptTime 受理时间
	 * @param placeTime 下单成功时间
	 * @param applicationId 申请返货Id
	 * @param confirmationTime 确认时间
	 * @param takeTime 取件时间
	 * @param taskTime 入库时间
	 * @param recordTime 录单时间
	 * @param cancelTime 核销时间
	 * @param fare 运费
	 * @param insurance 保险费
	 * @param bagging 包装费
	 * @param trueMoney 实收款
	 */
	public Dispatch(String numId, String isAbnormal, String businessRecsiptId, String businessRecsiptNo,
			String workOrderId, String workOrderNo, String empName, String fetchAddress, String acceptingUnit,
			String recsiptTime, String placeTime, String applicationId, String confirmationTime, String takeTime,
			String taskTime, String recordTime, String cancelTime, Double fare, Double insurance, Integer bagging,
			Double trueMoney) {
		super();
		this.numId = numId;
		this.isAbnormal = isAbnormal;
		this.businessRecsiptId = businessRecsiptId;
		this.businessRecsiptNo = businessRecsiptNo;
		this.workOrderId = workOrderId;
		this.workOrderNo = workOrderNo;
		this.empName = empName;
		this.fetchAddress = fetchAddress;
		this.acceptingUnit = acceptingUnit;
		this.recsiptTime = recsiptTime;
		this.placeTime = placeTime;
		this.applicationId = applicationId;
		this.confirmationTime = confirmationTime;
		this.takeTime = takeTime;
		this.taskTime = taskTime;
		this.recordTime = recordTime;
		this.cancelTime = cancelTime;
		this.fare = fare;
		this.insurance = insurance;
		this.bagging = bagging;
		this.trueMoney = trueMoney;
	}

	/**
	 * 获得序号
	 * @return 序号
	 */
	public String getNumId() {
		return numId;
	}
    
	/**
	 * 设置序号
	 * @param numId 序号
	 */
	public void setNumId(String numId) {
		this.numId = numId;
	}

	/**
	 * 获得异常
	 * @return 异常
	 */
	public String getIsAbnormal() {
		return isAbnormal;
	}

	/**
	 * 设置异常
	 * @param isAbnormal 异常
	 */
	public void setIsAbnormal(String isAbnormal) {
		this.isAbnormal = isAbnormal;
	}
    
	/**
	 * 获得业务受理单Id
	 * @return 业务受理单Id
	 */
	public String getBusinessRecsiptId() {
		return businessRecsiptId;
	}

	/**
	 * 设置业务受理单Id
	 * @param businessRecsiptId 业务受理单Id
	 */
	public void setBusinessRecsiptId(String businessRecsiptId) {
		this.businessRecsiptId = businessRecsiptId;
	}

	/**
	 * 获得业务受理单编号
	 * @return 业务受理单编号
	 */
	public String getBusinessRecsiptNo() {
		return businessRecsiptNo;
	}
	
    /**
     * 设置业务受理单编号
     * @param businessRecsiptNo 业务受理单编号
     */
	public void setBusinessRecsiptNo(String businessRecsiptNo) {
		this.businessRecsiptNo = businessRecsiptNo;
	}

	/**
	 * 获得工单Id
	 * @return 工单Id
	 */
	public String getWorkOrderId() {
		return workOrderId;
	}

	/**
	 * 设置工单Id
	 * @param workOrderId 工单Id
	 */
	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}

	/**
	 * 获得工单单号
	 * @return 工单单号
	 */
	public String getWorkOrderNo() {
		return workOrderNo;
	}

	/**
	 * 设置工单单号
	 * @param workOrderNo 工单单号
	 */
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	/**
	 * 获得取件员
	 * @return 取件员
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * 设置取件员
	 * @param empName 取件员
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * 获得取件地址
	 * @return 取件地址
	 */
	public String getFetchAddress() {
		return fetchAddress;
	}

	/**
	 * 设置取件地址
	 * @param fetchAddress
	 */
	public void setFetchAddress(String fetchAddress) {
		this.fetchAddress = fetchAddress;
	}

	/**
	 * 获得受理单位
	 * @return 受理单位
	 */
	public String getAcceptingUnit() {
		return acceptingUnit;
	}

	/**
	 * 设置受理单位
	 * @param acceptingUnit 受理单位
	 */
	public void setAcceptingUnit(String acceptingUnit) {
		this.acceptingUnit = acceptingUnit;
	}

	/**
	 * 获得受理时间
	 * @return 受理时间
	 */
	public String getRecsiptTime() {
		return recsiptTime;
	}

	/**
	 * 设置受理时间
	 * @param recsiptTime 受理时间
	 */
	public void setRecsiptTime(String recsiptTime) {
		this.recsiptTime = recsiptTime;
	}

	/**
	 * 获得下单成功时间
	 * @return 下单成功时间
	 */
	public String getPlaceTime() {
		return placeTime;
	}

	/**
	 * 设置下单成功时间
	 * @param placeTime 下单成功时间
	 */
	public void setPlaceTime(String placeTime) {
		this.placeTime = placeTime;
	}

	/**
	 * 获得申请返货Id
	 * @return 申请返货Id
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * 设置申请返货Id
	 * @param applicationId 申请返货Id
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * 获得确认时间
	 * @return 确认时间
	 */
	public String getConfirmationTime() {
		return confirmationTime;
	}

	/**
	 * 设置确认时间
	 * @param confirmationTime 确认时间
	 */
	public void setConfirmationTime(String confirmationTime) {
		this.confirmationTime = confirmationTime;
	}

	/**
	 * 获得取件时间
	 * @return 取件时间
	 */
	public String getTakeTime() {
		return takeTime;
	}

	/**
	 * 设置取件时间
	 * @param takeTime 取件时间
	 */
	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}

	/**
	 * 获得入库时间
	 * @return 入库时间
	 */
	public String getTaskTime() {
		return taskTime;
	}

	/**
	 * 设置入库时间
	 * @param taskTime 入库时间
	 */
	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}

	/**
	 * 获得录单时间
	 * @return 录单时间
	 */
	public String getRecordTime() {
		return recordTime;
	}

	/**
	 * 设置录单时间
	 * @param recordTime 录单时间
	 */
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	/**
	 * 获得核销时间
	 * @return 核销时间
	 */
	public String getCancelTime() {
		return cancelTime;
	}

	/**
	 * 设置核销时间
	 * @param cancelTime 核销时间
	 */
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}

	/**
	 * 获得运费
	 * @return 运费
	 */
	public Double getFare() {
		return fare;
	}

	/**
	 * 设置运费
	 * @param fare 运费
	 */
	public void setFare(Double fare) {
		this.fare = fare;
	}

	/**
	 * 获得保险费
	 * @return 保险费
	 */
	public Double getInsurance() {
		return insurance;
	}

	/**
	 * 设置保险费
	 * @param insurance 保险费
	 */
	public void setInsurance(Double insurance) {
		this.insurance = insurance;
	}

	/**
	 * 获得包装费
	 * @return 包装费
	 */
	public Integer getBagging() {
		return bagging;
	}

	/**
	 * 设置包装费
	 * @param bagging 包装费
	 */
	public void setBagging(Integer bagging) {
		this.bagging = bagging;
	}

	/**
	 * 获得实收款
	 * @return 实收款
	 */
	public Double getTrueMoney() {
		return trueMoney;
	}

	/**
	 * 设置实收款
	 * @param trueMoney 实收款
	 */
	public void setTrueMoney(Double trueMoney) {
		this.trueMoney = trueMoney;
	}

	/**
	 * 遍历
	 */
	@Override
	public String toString() {
		return "Dispatch [numId=" + numId + ", isAbnormal=" + isAbnormal + ", businessRecsiptId=" + businessRecsiptId
				+ ", businessRecsiptNo=" + businessRecsiptNo + ", workOrderId=" + workOrderId + ", workOrderNo="
				+ workOrderNo + ", empName=" + empName + ", fetchAddress=" + fetchAddress + ", acceptingUnit="
				+ acceptingUnit + ", recsiptTime=" + recsiptTime + ", placeTime=" + placeTime + ", applicationId="
				+ applicationId + ", confirmationTime=" + confirmationTime + ", takeTime=" + takeTime + ", taskTime="
				+ taskTime + ", recordTime=" + recordTime + ", cancelTime=" + cancelTime + ", fare=" + fare
				+ ", insurance=" + insurance + ", bagging=" + bagging + ", trueMoney=" + trueMoney + "]";
	}
	
}
