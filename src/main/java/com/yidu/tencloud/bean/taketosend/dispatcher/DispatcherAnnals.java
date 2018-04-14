package com.yidu.tencloud.bean.taketosend.dispatcher;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;

/**
 * 调度历史实体类
 * @author 鲁静芝
 * @since 2017/11/25
 */
public class DispatcherAnnals implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5149518096175868864L;
	/**
	 * 调度历史Id
	 */
	private String dispatcherAnnalsId;
	/**
	 * 调度序号
	 */
	private String dispatcherNum;
	/**
	 * 操作时间
	 */
	private Date operatorTime;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 业务通知单Id
	 */
	private String businessRecsiptId;
	/**
	 * 调入单位
	 */
	private String takeOrgName;
	/**
	 * 操作人
	 */
	private String operator;
	/**
	 * 操作单位
	 */
	private String operatorOrg;
	/**
	 * 备注
	 */
	private String commonRemarks;
	/**
	 * 获得调度历史Id
	 * @return 调度历史Id
	 */
	public String getDispatcherAnnalsId() {
		return dispatcherAnnalsId;
	}
	/**
	 * 设置调度历史Id
	 * @param dispatcherAnnalsId 调度历史Id
	 */
	public void setDispatcherAnnalsId(String dispatcherAnnalsId) {
		this.dispatcherAnnalsId = dispatcherAnnalsId;
	}
	/**
	 * 获得调度序号
	 * @return 调度序号
	 */
	public String getDispatcherNum() {
		return dispatcherNum;
	}
	/**
	 * 设置调度序号
	 * @param dispatcherNum 调度序号
	 */
	public void setDispatcherNum(String dispatcherNum) {
		this.dispatcherNum = dispatcherNum;
	}
	/**
	 * 获得操作时间
	 * @return 操作时间
	 */
	public Date getOperatorTime() {
		return operatorTime;
	}
	/**
	 *设置操作时间
	 * @param operatorTime 操作时间
	 */
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	/**
	 * 设置状态
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 * @param status 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获得业务通知单Id
	 * @return 业务通知单Id
	 */
	public String getBusinessRecsiptId() {
		return businessRecsiptId;
	}
	/**
	 * 设置业务通知单Id
	 * @param businessRecsiptId 业务通知单Id
	 */
	public void setBusinessRecsiptId(String businessRecsiptId) {
		this.businessRecsiptId = businessRecsiptId;
	}
	/**
	 * 获得调入单位
	 * @return 调入单位
	 */
	public String getTakeOrgName() {
		return takeOrgName;
	}
	/**
	 * 设置调入单位
	 * @param takeOrgName 调入单位
	 */
	public void setTakeOrgName(String takeOrgName) {
		this.takeOrgName = takeOrgName;
	}
	/**
	 * 获得操作人
	 * @return 操作人
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 设置操作人
	 * @param operator 操作人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 获得操作单位
	 * @return 操作单位
	 */
	public String getOperatorOrg() {
		return operatorOrg;
	}
	/**
	 * 设置操作单位
	 * @param operatorOrg 操作单位
	 */
	public void setOperatorOrg(String operatorOrg) {
		this.operatorOrg = operatorOrg;
	}
	/**
	 * 获得备注
	 * @return 备注
	 */
	public String getCommonRemarks() {
		return commonRemarks;
	}
	/**
	 * 设置备注
	 * @param commonRemarks 备注
	 */
	public void setCommonRemarks(String commonRemarks) {
		this.commonRemarks = commonRemarks;
	}
	/**
	 * 有参数的构造方法
	 * @param dispatcherAnnalsId 调度历史Id 
	 * @param dispatcherNum 调度序号
	 * @param operatorTime 调度时间
	 * @param status 状态
	 * @param businessRecsiptId 业务通知单Id
	 * @param takeOrgName 调入单位
	 * @param operator 操作人
	 * @param operatorOrg 操作单位  
	 * @param commonRemarks 备注
	 */
	public DispatcherAnnals(String dispatcherAnnalsId, String dispatcherNum, Date operatorTime, String status,
			String businessRecsiptId, String takeOrgName, String operator, String operatorOrg, String commonRemarks) {
		super();
		this.dispatcherAnnalsId = dispatcherAnnalsId;
		this.dispatcherNum = dispatcherNum;
		this.operatorTime = operatorTime;
		this.status = status;
		this.businessRecsiptId = businessRecsiptId;
		this.takeOrgName = takeOrgName;
		this.operator = operator;
		this.operatorOrg = operatorOrg;
		this.commonRemarks = commonRemarks;
	}
	
	/**
	 * 无参的构造方法
	 */
	public DispatcherAnnals() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessRecsiptId == null) ? 0 : businessRecsiptId.hashCode());
		result = prime * result + ((commonRemarks == null) ? 0 : commonRemarks.hashCode());
		result = prime * result + ((dispatcherAnnalsId == null) ? 0 : dispatcherAnnalsId.hashCode());
		result = prime * result + ((dispatcherNum == null) ? 0 : dispatcherNum.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((operatorOrg == null) ? 0 : operatorOrg.hashCode());
		result = prime * result + ((operatorTime == null) ? 0 : operatorTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((takeOrgName == null) ? 0 : takeOrgName.hashCode());
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
		DispatcherAnnals other = (DispatcherAnnals) obj;
		if (businessRecsiptId == null) {
			if (other.businessRecsiptId != null)
				return false;
		} else if (!businessRecsiptId.equals(other.businessRecsiptId))
			return false;
		if (commonRemarks == null) {
			if (other.commonRemarks != null)
				return false;
		} else if (!commonRemarks.equals(other.commonRemarks))
			return false;
		if (dispatcherAnnalsId == null) {
			if (other.dispatcherAnnalsId != null)
				return false;
		} else if (!dispatcherAnnalsId.equals(other.dispatcherAnnalsId))
			return false;
		if (dispatcherNum == null) {
			if (other.dispatcherNum != null)
				return false;
		} else if (!dispatcherNum.equals(other.dispatcherNum))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (operatorOrg == null) {
			if (other.operatorOrg != null)
				return false;
		} else if (!operatorOrg.equals(other.operatorOrg))
			return false;
		if (operatorTime == null) {
			if (other.operatorTime != null)
				return false;
		} else if (!operatorTime.equals(other.operatorTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (takeOrgName == null) {
			if (other.takeOrgName != null)
				return false;
		} else if (!takeOrgName.equals(other.takeOrgName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DispatcherAnnals [dispatcherAnnalsId=" + dispatcherAnnalsId + ", dispatcherNum=" + dispatcherNum
				+ ", operatorTime=" + operatorTime + ", status=" + status + ", businessRecsiptId=" + businessRecsiptId
				+ ", takeOrgName=" + takeOrgName + ", operator=" + operator + ", operatorOrg=" + operatorOrg
				+ ", commonRemarks=" + commonRemarks + "]";
	}
}
