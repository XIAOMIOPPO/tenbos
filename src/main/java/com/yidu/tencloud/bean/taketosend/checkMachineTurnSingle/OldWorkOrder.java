package com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle;

import java.io.Serializable;

/**
 * 销工单实体类
 * @author 64429
 *
 */
public class OldWorkOrder implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -7750242461952847194L;
	
	/**
	 * 工单编号
	 */
	private String oldWorkOrderNo;
	
	/**
	 * 工单类型
	 */
	private String oldWorkOrderType;

	/**
	 * 工单状态
	 */
	private String oldWstatus;
	
	/**
	 * 短信序号
	 */
	private String oldNoteNum;
	
	/**
	 * 工单生成时间
	 */
	private String oldWorkOrderTime;
	
	/**
	 * 追单次数
	 */
	private String oldTraceNum;
	
	/**
	 * 员工号
	 */
	private String oldEmpNum;
	
	/**
	 * 取件单位
	 */
	private String oldTakeOrgName;
	
	/**
	 * 取件时间
	 */
	private String oldTakeTime;
	
	/**
	 * 分拣编码
	 */
	private String oldSortingCode;

	public String getOldWorkOrderNo() {
		return oldWorkOrderNo;
	}

	public void setOldWorkOrderNo(String oldWorkOrderNo) {
		this.oldWorkOrderNo = oldWorkOrderNo;
	}

	public String getOldWorkOrderType() {
		return oldWorkOrderType;
	}

	public void setOldWorkOrderType(String oldWorkOrderType) {
		this.oldWorkOrderType = oldWorkOrderType;
	}

	public String getOldWstatus() {
		return oldWstatus;
	}

	public void setOldWstatus(String oldWstatus) {
		this.oldWstatus = oldWstatus;
	}

	public String getOldNoteNum() {
		return oldNoteNum;
	}

	public void setOldNoteNum(String oldNoteNum) {
		this.oldNoteNum = oldNoteNum;
	}

	public String getOldWorkOrderTime() {
		return oldWorkOrderTime;
	}

	public void setOldWorkOrderTime(String oldWorkOrderTime) {
		this.oldWorkOrderTime = oldWorkOrderTime;
	}

	public String getOldTraceNum() {
		return oldTraceNum;
	}

	public void setOldTraceNum(String oldTraceNum) {
		this.oldTraceNum = oldTraceNum;
	}

	public String getOldEmpNum() {
		return oldEmpNum;
	}

	public void setOldEmpNum(String oldEmpNum) {
		this.oldEmpNum = oldEmpNum;
	}

	public String getOldTakeOrgName() {
		return oldTakeOrgName;
	}

	public void setOldTakeOrgName(String oldTakeOrgName) {
		this.oldTakeOrgName = oldTakeOrgName;
	}

	public String getOldTakeTime() {
		return oldTakeTime;
	}

	public void setOldTakeTime(String oldTakeTime) {
		this.oldTakeTime = oldTakeTime;
	}

	public String getOldSortingCode() {
		return oldSortingCode;
	}

	public void setOldSortingCode(String oldSortingCode) {
		this.oldSortingCode = oldSortingCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oldEmpNum == null) ? 0 : oldEmpNum.hashCode());
		result = prime * result + ((oldNoteNum == null) ? 0 : oldNoteNum.hashCode());
		result = prime * result + ((oldSortingCode == null) ? 0 : oldSortingCode.hashCode());
		result = prime * result + ((oldTakeOrgName == null) ? 0 : oldTakeOrgName.hashCode());
		result = prime * result + ((oldTakeTime == null) ? 0 : oldTakeTime.hashCode());
		result = prime * result + ((oldTraceNum == null) ? 0 : oldTraceNum.hashCode());
		result = prime * result + ((oldWorkOrderNo == null) ? 0 : oldWorkOrderNo.hashCode());
		result = prime * result + ((oldWorkOrderTime == null) ? 0 : oldWorkOrderTime.hashCode());
		result = prime * result + ((oldWorkOrderType == null) ? 0 : oldWorkOrderType.hashCode());
		result = prime * result + ((oldWstatus == null) ? 0 : oldWstatus.hashCode());
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
		OldWorkOrder other = (OldWorkOrder) obj;
		if (oldEmpNum == null) {
			if (other.oldEmpNum != null)
				return false;
		} else if (!oldEmpNum.equals(other.oldEmpNum))
			return false;
		if (oldNoteNum == null) {
			if (other.oldNoteNum != null)
				return false;
		} else if (!oldNoteNum.equals(other.oldNoteNum))
			return false;
		if (oldSortingCode == null) {
			if (other.oldSortingCode != null)
				return false;
		} else if (!oldSortingCode.equals(other.oldSortingCode))
			return false;
		if (oldTakeOrgName == null) {
			if (other.oldTakeOrgName != null)
				return false;
		} else if (!oldTakeOrgName.equals(other.oldTakeOrgName))
			return false;
		if (oldTakeTime == null) {
			if (other.oldTakeTime != null)
				return false;
		} else if (!oldTakeTime.equals(other.oldTakeTime))
			return false;
		if (oldTraceNum == null) {
			if (other.oldTraceNum != null)
				return false;
		} else if (!oldTraceNum.equals(other.oldTraceNum))
			return false;
		if (oldWorkOrderNo == null) {
			if (other.oldWorkOrderNo != null)
				return false;
		} else if (!oldWorkOrderNo.equals(other.oldWorkOrderNo))
			return false;
		if (oldWorkOrderTime == null) {
			if (other.oldWorkOrderTime != null)
				return false;
		} else if (!oldWorkOrderTime.equals(other.oldWorkOrderTime))
			return false;
		if (oldWorkOrderType == null) {
			if (other.oldWorkOrderType != null)
				return false;
		} else if (!oldWorkOrderType.equals(other.oldWorkOrderType))
			return false;
		if (oldWstatus == null) {
			if (other.oldWstatus != null)
				return false;
		} else if (!oldWstatus.equals(other.oldWstatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OldWorkOrder [oldWorkOrderNo=" + oldWorkOrderNo + ", oldWorkOrderType=" + oldWorkOrderType
				+ ", oldWstatus=" + oldWstatus + ", oldNoteNum=" + oldNoteNum + ", oldWorkOrderTime=" + oldWorkOrderTime
				+ ", oldTraceNum=" + oldTraceNum + ", oldEmpNum=" + oldEmpNum + ", oldTakeOrgName=" + oldTakeOrgName
				+ ", oldTakeTime=" + oldTakeTime + ", oldSortingCode=" + oldSortingCode + "]";
	}

	public OldWorkOrder(String oldWorkOrderNo, String oldWorkOrderType, String oldWstatus, String oldNoteNum,
			String oldWorkOrderTime, String oldTraceNum, String oldEmpNum, String oldTakeOrgName, String oldTakeTime,
			String oldSortingCode) {
		super();
		this.oldWorkOrderNo = oldWorkOrderNo;
		this.oldWorkOrderType = oldWorkOrderType;
		this.oldWstatus = oldWstatus;
		this.oldNoteNum = oldNoteNum;
		this.oldWorkOrderTime = oldWorkOrderTime;
		this.oldTraceNum = oldTraceNum;
		this.oldEmpNum = oldEmpNum;
		this.oldTakeOrgName = oldTakeOrgName;
		this.oldTakeTime = oldTakeTime;
		this.oldSortingCode = oldSortingCode;
	}
	
	public OldWorkOrder() {
		
	}
	
	
}
