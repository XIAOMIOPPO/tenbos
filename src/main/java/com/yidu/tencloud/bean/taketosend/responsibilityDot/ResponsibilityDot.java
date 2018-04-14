package com.yidu.tencloud.bean.taketosend.responsibilityDot;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 责任网点设置实体类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public class ResponsibilityDot {
	  /**
	   * 责任网点Id
	   */
      private String responsibilityDotId;
      /**
       * 加盟商代码
       */
      private String franchiseeCode;
      /**
       * 加盟商
       */
      private String franchisee;
      /**
       * 晚点标准
       */
      private int lateStandard;
      /**
       * 作废标志
       */
      private String cancelSign;
      /**
       * 操作人
       */
      private String operator;
     
      /**
       * 操作时间
       */
      @Column(name="operatingTime")
  	  @DateTimeFormat(pattern = "yyyy-MM-dd")
      private Date operatingTime;
      
      public ResponsibilityDot() {
    	  
      }

	public String getResponsibilityDotId() {
		return responsibilityDotId;
	}

	public void setResponsibilityDotId(String responsibilityDotId) {
		this.responsibilityDotId = responsibilityDotId;
	}

	public String getFranchiseeCode() {
		return franchiseeCode;
	}

	public void setFranchiseeCode(String franchiseeCode) {
		this.franchiseeCode = franchiseeCode;
	}

	public String getFranchisee() {
		return franchisee;
	}

	public void setFranchisee(String franchisee) {
		this.franchisee = franchisee;
	}

	public int getLateStandard() {
		return lateStandard;
	}

	public void setLateStandard(int lateStandard) {
		this.lateStandard = lateStandard;
	}

	public String getCancelSign() {
		return cancelSign;
	}

	public void setCancelSign(String cancelSign) {
		this.cancelSign = cancelSign;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(Date operatingTime) {
		this.operatingTime = operatingTime;
	}

	@Override
	public String toString() {
		return "ResponsibilityDot [responsibilityDotId=" + responsibilityDotId + ", franchiseeCode=" + franchiseeCode
				+ ", franchisee=" + franchisee + ", lateStandard=" + lateStandard + ", cancelSign=" + cancelSign
				+ ", operator=" + operator + ", operatingTime=" + operatingTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancelSign == null) ? 0 : cancelSign.hashCode());
		result = prime * result + ((franchisee == null) ? 0 : franchisee.hashCode());
		result = prime * result + ((franchiseeCode == null) ? 0 : franchiseeCode.hashCode());
		result = prime * result + lateStandard;
		result = prime * result + ((operatingTime == null) ? 0 : operatingTime.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((responsibilityDotId == null) ? 0 : responsibilityDotId.hashCode());
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
		ResponsibilityDot other = (ResponsibilityDot) obj;
		if (cancelSign == null) {
			if (other.cancelSign != null)
				return false;
		} else if (!cancelSign.equals(other.cancelSign))
			return false;
		if (franchisee == null) {
			if (other.franchisee != null)
				return false;
		} else if (!franchisee.equals(other.franchisee))
			return false;
		if (franchiseeCode == null) {
			if (other.franchiseeCode != null)
				return false;
		} else if (!franchiseeCode.equals(other.franchiseeCode))
			return false;
		if (lateStandard != other.lateStandard)
			return false;
		if (operatingTime == null) {
			if (other.operatingTime != null)
				return false;
		} else if (!operatingTime.equals(other.operatingTime))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (responsibilityDotId == null) {
			if (other.responsibilityDotId != null)
				return false;
		} else if (!responsibilityDotId.equals(other.responsibilityDotId))
			return false;
		return true;
	}

	public ResponsibilityDot(String responsibilityDotId, String franchiseeCode, String franchisee, int lateStandard,
			String cancelSign, String operator, Date operatingTime) {
		super();
		this.responsibilityDotId = responsibilityDotId;
		this.franchiseeCode = franchiseeCode;
		this.franchisee = franchisee;
		this.lateStandard = lateStandard;
		this.cancelSign = cancelSign;
		this.operator = operator;
		this.operatingTime = operatingTime;
	}

	
}

