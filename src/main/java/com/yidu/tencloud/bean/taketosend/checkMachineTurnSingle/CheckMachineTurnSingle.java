package com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle;

import java.io.Serializable;


/**
 * 查台转单实体类
 * 
 * @author 64429
 *
 */
public class CheckMachineTurnSingle implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 6959476089775981554L;

	/**
	 * 工单号
	 */
	private String workOrderNo;

	/**
	 * 短信序号
	 */
	private String noteNum;

	/**
	 * 通知单号
	 */
	private String businessRecsiptNo;

	/**
	 * 工单生成时间
	 */
	private String workOrderTime;

	/**
	 * 追单次数
	 */
	private String traceNum;

	/**
	 * 收件地址
	 */
	private String serveAddress;

	/**
	 * 收件人
	 */
	private String contacts;

	/**
	 * 电话
	 */
	private String telephone;

	/**
	 * 操作人单位
	 */
	private String operatorOrg;

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getNoteNum() {
		return noteNum;
	}

	public void setNoteNum(String noteNum) {
		this.noteNum = noteNum;
	}

	public String getBusinessRecsiptNo() {
		return businessRecsiptNo;
	}

	public void setBusinessRecsiptNo(String businessRecsiptNo) {
		this.businessRecsiptNo = businessRecsiptNo;
	}

	public String getWorkOrderTime() {
		return workOrderTime;
	}

	public void setWorkOrderTime(String workOrderTime) {
		this.workOrderTime = workOrderTime;
	}

	public String getTraceNum() {
		return traceNum;
	}

	public void setTraceNum(String traceNum) {
		this.traceNum = traceNum;
	}

	public String getServeAddress() {
		return serveAddress;
	}

	public void setServeAddress(String serveAddress) {
		this.serveAddress = serveAddress;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOperatorOrg() {
		return operatorOrg;
	}

	public void setOperatorOrg(String operatorOrg) {
		this.operatorOrg = operatorOrg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessRecsiptNo == null) ? 0 : businessRecsiptNo.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((noteNum == null) ? 0 : noteNum.hashCode());
		result = prime * result + ((operatorOrg == null) ? 0 : operatorOrg.hashCode());
		result = prime * result + ((serveAddress == null) ? 0 : serveAddress.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((traceNum == null) ? 0 : traceNum.hashCode());
		result = prime * result + ((workOrderNo == null) ? 0 : workOrderNo.hashCode());
		result = prime * result + ((workOrderTime == null) ? 0 : workOrderTime.hashCode());
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
		CheckMachineTurnSingle other = (CheckMachineTurnSingle) obj;
		if (businessRecsiptNo == null) {
			if (other.businessRecsiptNo != null)
				return false;
		} else if (!businessRecsiptNo.equals(other.businessRecsiptNo))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (noteNum == null) {
			if (other.noteNum != null)
				return false;
		} else if (!noteNum.equals(other.noteNum))
			return false;
		if (operatorOrg == null) {
			if (other.operatorOrg != null)
				return false;
		} else if (!operatorOrg.equals(other.operatorOrg))
			return false;
		if (serveAddress == null) {
			if (other.serveAddress != null)
				return false;
		} else if (!serveAddress.equals(other.serveAddress))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (traceNum == null) {
			if (other.traceNum != null)
				return false;
		} else if (!traceNum.equals(other.traceNum))
			return false;
		if (workOrderNo == null) {
			if (other.workOrderNo != null)
				return false;
		} else if (!workOrderNo.equals(other.workOrderNo))
			return false;
		if (workOrderTime == null) {
			if (other.workOrderTime != null)
				return false;
		} else if (!workOrderTime.equals(other.workOrderTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckMachineTurnSingle [workOrderNo=" + workOrderNo + ", noteNum=" + noteNum + ", businessRecsiptNo="
				+ businessRecsiptNo + ", workOrderTime=" + workOrderTime + ", traceNum=" + traceNum + ", serveAddress="
				+ serveAddress + ", contacts=" + contacts + ", telephone=" + telephone + ", operatorOrg=" + operatorOrg
				+ "]";
	}

	public CheckMachineTurnSingle(String workOrderNo, String noteNum, String businessRecsiptNo, String workOrderTime,
			String traceNum, String serveAddress, String contacts, String telephone, String operatorOrg) {
		super();
		this.workOrderNo = workOrderNo;
		this.noteNum = noteNum;
		this.businessRecsiptNo = businessRecsiptNo;
		this.workOrderTime = workOrderTime;
		this.traceNum = traceNum;
		this.serveAddress = serveAddress;
		this.contacts = contacts;
		this.telephone = telephone;
		this.operatorOrg = operatorOrg;
	}

	public CheckMachineTurnSingle() {

	}
}
