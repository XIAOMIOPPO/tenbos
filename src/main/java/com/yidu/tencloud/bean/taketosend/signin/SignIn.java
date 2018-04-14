package com.yidu.tencloud.bean.taketosend.signin;

import java.util.Date;

/**
 * 签收录入实体类
 * @author Administrator
 * @since 2018/1/15 
 */
public class SignIn {
	/**
	 * 签收录入Id
	 */
	private String signId;
	
	/**
	 * 工作单Id(关联工作单表)
	 */
	private String workSheetId;
	
	/**
	 * 工作单号
	 */
	private String workSheetNo;
	
	/**
	 * 返单标记
	 */
	private String cargoReturnSign;

	/**
	 * 工作单类型(关联工作单表)
	 */
	private String workSheetType;

	/**
	 * 签收类型
	 */
	private int signType;
	
	/**
	 * 原单核销标志
	 */
	private String verificationMark;
	
	/**
	 * 签收人(关联收件表)
	 */
	private String addressesName;
	
	/**
	 * 员工Id(关联员工表)
	 */
	private String empId;
	
	/**
	 * 派送员员工号(关联员工表)
	 */
	private String empNo;
	
	/**
	 * 派送员员工姓名(关联员工表)
	 */
	private String empName;
	
	/**
	 * 派件单位
	 */
	private String sendUnit;
	
	/**
	 * 签收时间
	 */
	private Date signTime;
	
	/**
	 * 录入人
	 */
	private String drawerName;
	
	/**
	 * 录入单位
	 */
	private String drawerCompany;
	
	/**
	 * 录入时间
	 */
	private Date drawerTime;
	
	/**
	 * 异常备注
	 */
	private String abnormalRemarks;
	
	
	public SignIn(){}


	public String getSignId() {
		return signId;
	}


	public void setSignId(String signId) {
		this.signId = signId;
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


	public String getCargoReturnSign() {
		return cargoReturnSign;
	}


	public void setCargoReturnSign(String cargoReturnSign) {
		this.cargoReturnSign = cargoReturnSign;
	}


	public String getWorkSheetType() {
		return workSheetType;
	}


	public void setWorkSheetType(String workSheetType) {
		this.workSheetType = workSheetType;
	}


	public int getSignType() {
		return signType;
	}


	public void setSignType(int signType) {
		this.signType = signType;
	}


	public String getVerificationMark() {
		return verificationMark;
	}


	public void setVerificationMark(String verificationMark) {
		this.verificationMark = verificationMark;
	}


	public String getAddresseeName() {
		return addressesName;
	}


	public void setAddresseeName(String addresseeName) {
		this.addressesName = addresseeName;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getSendUnit() {
		return sendUnit;
	}


	public void setSendUnit(String sendUnit) {
		this.sendUnit = sendUnit;
	}


	public Date getSignTime() {
		return signTime;
	}


	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}


	public String getDrawerName() {
		return drawerName;
	}


	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}


	public String getDrawerCompany() {
		return drawerCompany;
	}


	public void setDrawerCompany(String drawerCompany) {
		this.drawerCompany = drawerCompany;
	}


	public Date getDrawerTime() {
		return drawerTime;
	}


	public void setDrawerTime(Date drawerTime) {
		this.drawerTime = drawerTime;
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
		result = prime * result + ((addressesName == null) ? 0 : addressesName.hashCode());
		result = prime * result + ((cargoReturnSign == null) ? 0 : cargoReturnSign.hashCode());
		result = prime * result + ((drawerCompany == null) ? 0 : drawerCompany.hashCode());
		result = prime * result + ((drawerName == null) ? 0 : drawerName.hashCode());
		result = prime * result + ((drawerTime == null) ? 0 : drawerTime.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
		result = prime * result + ((sendUnit == null) ? 0 : sendUnit.hashCode());
		result = prime * result + ((signId == null) ? 0 : signId.hashCode());
		result = prime * result + ((signTime == null) ? 0 : signTime.hashCode());
		result = prime * result + signType;
		result = prime * result + ((verificationMark == null) ? 0 : verificationMark.hashCode());
		result = prime * result + ((workSheetId == null) ? 0 : workSheetId.hashCode());
		result = prime * result + ((workSheetNo == null) ? 0 : workSheetNo.hashCode());
		result = prime * result + ((workSheetType == null) ? 0 : workSheetType.hashCode());
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
		SignIn other = (SignIn) obj;
		if (abnormalRemarks == null) {
			if (other.abnormalRemarks != null)
				return false;
		} else if (!abnormalRemarks.equals(other.abnormalRemarks))
			return false;
		if (addressesName == null) {
			if (other.addressesName != null)
				return false;
		} else if (!addressesName.equals(other.addressesName))
			return false;
		if (cargoReturnSign == null) {
			if (other.cargoReturnSign != null)
				return false;
		} else if (!cargoReturnSign.equals(other.cargoReturnSign))
			return false;
		if (drawerCompany == null) {
			if (other.drawerCompany != null)
				return false;
		} else if (!drawerCompany.equals(other.drawerCompany))
			return false;
		if (drawerName == null) {
			if (other.drawerName != null)
				return false;
		} else if (!drawerName.equals(other.drawerName))
			return false;
		if (drawerTime == null) {
			if (other.drawerTime != null)
				return false;
		} else if (!drawerTime.equals(other.drawerTime))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		if (sendUnit == null) {
			if (other.sendUnit != null)
				return false;
		} else if (!sendUnit.equals(other.sendUnit))
			return false;
		if (signId == null) {
			if (other.signId != null)
				return false;
		} else if (!signId.equals(other.signId))
			return false;
		if (signTime == null) {
			if (other.signTime != null)
				return false;
		} else if (!signTime.equals(other.signTime))
			return false;
		if (signType != other.signType)
			return false;
		if (verificationMark == null) {
			if (other.verificationMark != null)
				return false;
		} else if (!verificationMark.equals(other.verificationMark))
			return false;
		if (workSheetId == null) {
			if (other.workSheetId != null)
				return false;
		} else if (!workSheetId.equals(other.workSheetId))
			return false;
		if (workSheetNo == null) {
			if (other.workSheetNo != null)
				return false;
		} else if (!workSheetNo.equals(other.workSheetNo))
			return false;
		if (workSheetType == null) {
			if (other.workSheetType != null)
				return false;
		} else if (!workSheetType.equals(other.workSheetType))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SignIn [signId=" + signId + ", workSheetId=" + workSheetId + ", workSheetNo=" + workSheetNo
				+ ", cargoReturnSign=" + cargoReturnSign + ", workSheetType=" + workSheetType + ", signType=" + signType
				+ ", verificationMark=" + verificationMark + ", addresseeName=" + addressesName + ", empId=" + empId
				+ ", empNo=" + empNo + ", empName=" + empName + ", sendUnit=" + sendUnit + ", signTime=" + signTime
				+ ", drawerName=" + drawerName + ", drawerCompany=" + drawerCompany + ", drawerTime=" + drawerTime
				+ ", abnormalRemarks=" + abnormalRemarks + "]";
	}


	public SignIn(String signId, String workSheetId, String workSheetNo, String cargoReturnSign, String workSheetType,
			int signType, String verificationMark, String addresseeName, String empId, String empNo, String empName,
			String sendUnit, Date signTime, String drawerName, String drawerCompany, Date drawerTime,
			String abnormalRemarks) {
		super();
		this.signId = signId;
		this.workSheetId = workSheetId;
		this.workSheetNo = workSheetNo;
		this.cargoReturnSign = cargoReturnSign;
		this.workSheetType = workSheetType;
		this.signType = signType;
		this.verificationMark = verificationMark;
		this.addressesName = addresseeName;
		this.empId = empId;
		this.empNo = empNo;
		this.empName = empName;
		this.sendUnit = sendUnit;
		this.signTime = signTime;
		this.drawerName = drawerName;
		this.drawerCompany = drawerCompany;
		this.drawerTime = drawerTime;
		this.abnormalRemarks = abnormalRemarks;
	}

	
}