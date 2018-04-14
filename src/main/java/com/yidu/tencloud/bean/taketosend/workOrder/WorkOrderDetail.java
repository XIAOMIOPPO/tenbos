package com.yidu.tencloud.bean.taketosend.workOrder;

import java.io.Serializable;

/**
 * 工单详情信息实体类
 * @author 张建勇
 * @date 2017年11月23日 10:55:18
 */
public class WorkOrderDetail implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 2588009733314023647L;
	
	/**
	 * 工单详情Id
	 */
	private String workOrderDetailId;
	
	/**
	 * 工单详情编号
	 */
	private String workOrderDetailNo; 
	
	/**
	 * 原工单Id
	 */
	private String formerId;
	
	/**
	 * 原工单号
	 */
	private String formerNo;
	
	/**
	 * 原因
	 */
	private String cause;
	
	/**
	 * 备注
	 */
	private String remark;
	
	
	
	/**
	 * 无参数构造方法
	 */
	public WorkOrderDetail(){}



	public String getWorkOrderDetailId() {
		return workOrderDetailId;
	}



	public void setWorkOrderDetailId(String workOrderDetailId) {
		this.workOrderDetailId = workOrderDetailId;
	}



	public String getWorkOrderDetailNo() {
		return workOrderDetailNo;
	}



	public void setWorkOrderDetailNo(String workOrderDetailNo) {
		this.workOrderDetailNo = workOrderDetailNo;
	}



	public String getFormerId() {
		return formerId;
	}



	public void setFormerId(String formerId) {
		this.formerId = formerId;
	}



	public String getFormerNo() {
		return formerNo;
	}



	public void setFormerNo(String formerNo) {
		this.formerNo = formerNo;
	}



	public String getCause() {
		return cause;
	}



	public void setCause(String cause) {
		this.cause = cause;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public WorkOrderDetail(String workOrderDetailId, String workOrderDetailNo, String formerId, String formerNo,
			String cause, String remark) {
		super();
		this.workOrderDetailId = workOrderDetailId;
		this.workOrderDetailNo = workOrderDetailNo;
		this.formerId = formerId;
		this.formerNo = formerNo;
		this.cause = cause;
		this.remark = remark;
	}



	@Override
	public String toString() {
		return "WorkOrderDetail [workOrderDetailId=" + workOrderDetailId + ", workOrderDetailNo=" + workOrderDetailNo
				+ ", formerId=" + formerId + ", formerNo=" + formerNo + ", cause=" + cause + ", remark=" + remark + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
