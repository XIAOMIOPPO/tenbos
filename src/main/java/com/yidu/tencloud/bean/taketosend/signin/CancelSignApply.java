package com.yidu.tencloud.bean.taketosend.signin;

import java.util.Date;

/**
 * 取消签收申请实体类
 * @author Administrator
 *
 */
public class CancelSignApply {
	/**
	 *  取消签收ID
	 */
	private String cancelSignId;
	
	/**
	 * 工作单号
	 */
	private String workSheetNo;
	
	/**
	 * 申请单号
	 */
	private String applicationNumber;
	
	/**
	 * 申请原因
	 */
	private String applicationReasons;
	
	/**
	 * 签收时间
	 */
	private Date signTime;
	
	/**
	 * 签收状态
	 */
	private String signStatus;
	
	/**
	 * 签收单位
	 */
	private String signUnit;

	/**
	 * 申请人
	 */
	private String applicant;

	/**
	 * 申请时间
	 */
	private Date applicationTime;
	
	/**
	 * 申请单位
	 */
	private String applicationUnit;
	
	/**
	 * 确认人
	 */
	private String confirmationPerson;
	
	/**
	 * 确认时间
	 */
	private String confirmationTime;
	
	/**
	 * 确认状态
	 */
	private String confirmationStatus;
	
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 异常备注
	 */
	private String abnormalRemarks;

	public CancelSignApply(){ }

	public String getCancelSignId() {
		return cancelSignId;
	}

	public void setCancelSignId(String cancelSignId) {
		this.cancelSignId = cancelSignId;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationReasons() {
		return applicationReasons;
	}

	public void setApplicationReasons(String applicationReasons) {
		this.applicationReasons = applicationReasons;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}

	public String getSignUnit() {
		return signUnit;
	}

	public void setSignUnit(String signUnit) {
		this.signUnit = signUnit;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getApplicationUnit() {
		return applicationUnit;
	}

	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}

	public String getConfirmationPerson() {
		return confirmationPerson;
	}

	public void setConfirmationPerson(String confirmationPerson) {
		this.confirmationPerson = confirmationPerson;
	}

	public String getConfirmationTime() {
		return confirmationTime;
	}

	public void setConfirmationTime(String confirmationTime) {
		this.confirmationTime = confirmationTime;
	}

	public String getConfirmationStatus() {
		return confirmationStatus;
	}

	public void setConfirmationStatus(String confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAbnormalRemarks() {
		return abnormalRemarks;
	}

	public void setAbnormalRemarks(String abnormalRemarks) {
		this.abnormalRemarks = abnormalRemarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abnormalRemarks == null) ? 0 : abnormalRemarks.hashCode());
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((applicationNumber == null) ? 0 : applicationNumber.hashCode());
		result = prime * result + ((applicationReasons == null) ? 0 : applicationReasons.hashCode());
		result = prime * result + ((applicationTime == null) ? 0 : applicationTime.hashCode());
		result = prime * result + ((applicationUnit == null) ? 0 : applicationUnit.hashCode());
		result = prime * result + ((cancelSignId == null) ? 0 : cancelSignId.hashCode());
		result = prime * result + ((confirmationPerson == null) ? 0 : confirmationPerson.hashCode());
		result = prime * result + ((confirmationStatus == null) ? 0 : confirmationStatus.hashCode());
		result = prime * result + ((confirmationTime == null) ? 0 : confirmationTime.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((signStatus == null) ? 0 : signStatus.hashCode());
		result = prime * result + ((signTime == null) ? 0 : signTime.hashCode());
		result = prime * result + ((signUnit == null) ? 0 : signUnit.hashCode());
		result = prime * result + ((workSheetNo == null) ? 0 : workSheetNo.hashCode());
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
		CancelSignApply other = (CancelSignApply) obj;
		if (abnormalRemarks == null) {
			if (other.abnormalRemarks != null)
				return false;
		} else if (!abnormalRemarks.equals(other.abnormalRemarks))
			return false;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (applicationNumber == null) {
			if (other.applicationNumber != null)
				return false;
		} else if (!applicationNumber.equals(other.applicationNumber))
			return false;
		if (applicationReasons == null) {
			if (other.applicationReasons != null)
				return false;
		} else if (!applicationReasons.equals(other.applicationReasons))
			return false;
		if (applicationTime == null) {
			if (other.applicationTime != null)
				return false;
		} else if (!applicationTime.equals(other.applicationTime))
			return false;
		if (applicationUnit == null) {
			if (other.applicationUnit != null)
				return false;
		} else if (!applicationUnit.equals(other.applicationUnit))
			return false;
		if (cancelSignId == null) {
			if (other.cancelSignId != null)
				return false;
		} else if (!cancelSignId.equals(other.cancelSignId))
			return false;
		if (confirmationPerson == null) {
			if (other.confirmationPerson != null)
				return false;
		} else if (!confirmationPerson.equals(other.confirmationPerson))
			return false;
		if (confirmationStatus == null) {
			if (other.confirmationStatus != null)
				return false;
		} else if (!confirmationStatus.equals(other.confirmationStatus))
			return false;
		if (confirmationTime == null) {
			if (other.confirmationTime != null)
				return false;
		} else if (!confirmationTime.equals(other.confirmationTime))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (signStatus == null) {
			if (other.signStatus != null)
				return false;
		} else if (!signStatus.equals(other.signStatus))
			return false;
		if (signTime == null) {
			if (other.signTime != null)
				return false;
		} else if (!signTime.equals(other.signTime))
			return false;
		if (signUnit == null) {
			if (other.signUnit != null)
				return false;
		} else if (!signUnit.equals(other.signUnit))
			return false;
		if (workSheetNo == null) {
			if (other.workSheetNo != null)
				return false;
		} else if (!workSheetNo.equals(other.workSheetNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CancelSignApply [cancelSignId=" + cancelSignId + ", workSheetNo=" + workSheetNo + ", applicationNumber="
				+ applicationNumber + ", applicationReasons=" + applicationReasons + ", signTime=" + signTime
				+ ", signStatus=" + signStatus + ", signUnit=" + signUnit + ", applicant=" + applicant
				+ ", applicationTime=" + applicationTime + ", applicationUnit=" + applicationUnit
				+ ", confirmationPerson=" + confirmationPerson + ", confirmationTime=" + confirmationTime
				+ ", confirmationStatus=" + confirmationStatus + ", reason=" + reason + ", abnormalRemarks="
				+ abnormalRemarks + "]";
	}

	public CancelSignApply(String cancelSignId, String workSheetNo, String applicationNumber, String applicationReasons,
			Date signTime, String signStatus, String signUnit, String applicant, Date applicationTime,
			String applicationUnit, String confirmationPerson, String confirmationTime, String confirmationStatus,
			String reason, String abnormalRemarks) {
		super();
		this.cancelSignId = cancelSignId;
		this.workSheetNo = workSheetNo;
		this.applicationNumber = applicationNumber;
		this.applicationReasons = applicationReasons;
		this.signTime = signTime;
		this.signStatus = signStatus;
		this.signUnit = signUnit;
		this.applicant = applicant;
		this.applicationTime = applicationTime;
		this.applicationUnit = applicationUnit;
		this.confirmationPerson = confirmationPerson;
		this.confirmationTime = confirmationTime;
		this.confirmationStatus = confirmationStatus;
		this.reason = reason;
		this.abnormalRemarks = abnormalRemarks;
	}

	
}

