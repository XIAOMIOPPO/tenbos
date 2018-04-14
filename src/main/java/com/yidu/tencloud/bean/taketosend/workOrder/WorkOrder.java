package com.yidu.tencloud.bean.taketosend.workOrder;

import java.io.Serializable;
import java.util.Date;

/**
 * 工单实体类
 * 
 * @author 张建勇
 * @date 2017年11月23日 10:46:46
 */
public class WorkOrder implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4121644408789112987L;

	/**
	 * 工单Id
	 */
	private String workOrderId;

	/**
	 * 业务通知单Id
	 */
	private String businessRecsiptId;

	/**
	 * 工单编号
	 */
	private String workOrderNo;

	/**
	 * 业务通知单单号
	 */
	private String businessRecsiptNo;

	/**
	 * 工单类型
	 */
	private String workOrderType;

	/**
	 * 取件状态
	 */
	private String Wstatus;

	/**
	 * 短信序号
	 */
	private Integer noteNum;

	/**
	 * 工单生成时间
	 */
	private Date workOrderTime;

	/**
	 * 追单次数
	 */
	private Integer traceNum;
	
	/**
	 * 职员Id
	 */
	private String empId;

	/**
	 * 职员编号
	 */
	private String empNum;

	/**
	 * 职员名字
	 */
	private String empName;

	/**
	 * 取件单位
	 */
	private String takeOrgName;

	/**
	 * 取件时间
	 */
	private Date takeTime;

	/**
	 * 分拣编码
	 */
	private String sortingCode;

	/**
	 * 无参数构造方法
	 */
	public WorkOrder() {

	}

	public String getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getBusinessRecsiptId() {
		return businessRecsiptId;
	}

	public void setBusinessRecsiptId(String businessRecsiptId) {
		this.businessRecsiptId = businessRecsiptId;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getBusinessRecsiptNo() {
		return businessRecsiptNo;
	}

	public void setBusinessRecsiptNo(String businessRecsiptNo) {
		this.businessRecsiptNo = businessRecsiptNo;
	}

	public String getWorkOrderType() {
		return workOrderType;
	}

	public void setWorkOrderType(String workOrderType) {
		this.workOrderType = workOrderType;
	}

	public String getWstatus() {
		return Wstatus;
	}

	public void setWstatus(String wstatus) {
		Wstatus = wstatus;
	}

	public Integer getNoteNum() {
		return noteNum;
	}

	public void setNoteNum(Integer noteNum) {
		this.noteNum = noteNum;
	}

	public Date getWorkOrderTime() {
		return workOrderTime;
	}

	public void setWorkOrderTime(Date workOrderTime) {
		this.workOrderTime = workOrderTime;
	}

	public Integer getTraceNum() {
		return traceNum;
	}

	public void setTraceNum(Integer traceNum) {
		this.traceNum = traceNum;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpNum() {
		return empNum;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTakeOrgName() {
		return takeOrgName;
	}

	public void setTakeOrgName(String takeOrgName) {
		this.takeOrgName = takeOrgName;
	}

	public Date getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}

	public String getSortingCode() {
		return sortingCode;
	}

	public void setSortingCode(String sortingCode) {
		this.sortingCode = sortingCode;
	}

	@Override
	public String toString() {
		return "WorkOrder [workOrderId=" + workOrderId + ", businessRecsiptId=" + businessRecsiptId + ", workOrderNo="
				+ workOrderNo + ", businessRecsiptNo=" + businessRecsiptNo + ", workOrderType=" + workOrderType
				+ ", Wstatus=" + Wstatus + ", noteNum=" + noteNum + ", workOrderTime=" + workOrderTime + ", traceNum="
				+ traceNum + ", empId=" + empId + ", empNum=" + empNum + ", empName=" + empName + ", takeOrgName="
				+ takeOrgName + ", takeTime=" + takeTime + ", sortingCode=" + sortingCode + "]";
	}

	public WorkOrder(String workOrderId, String businessRecsiptId, String workOrderNo, String businessRecsiptNo,
			String workOrderType, String wstatus, Integer noteNum, Date workOrderTime, Integer traceNum, String empId,
			String empNum, String empName, String takeOrgName, Date takeTime, String sortingCode) {
		super();
		this.workOrderId = workOrderId;
		this.businessRecsiptId = businessRecsiptId;
		this.workOrderNo = workOrderNo;
		this.businessRecsiptNo = businessRecsiptNo;
		this.workOrderType = workOrderType;
		Wstatus = wstatus;
		this.noteNum = noteNum;
		this.workOrderTime = workOrderTime;
		this.traceNum = traceNum;
		this.empId = empId;
		this.empNum = empNum;
		this.empName = empName;
		this.takeOrgName = takeOrgName;
		this.takeTime = takeTime;
		this.sortingCode = sortingCode;
	}

	
}
