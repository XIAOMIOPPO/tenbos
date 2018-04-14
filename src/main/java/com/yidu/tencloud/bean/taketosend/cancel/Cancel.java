package com.yidu.tencloud.bean.taketosend.cancel;

import java.io.Serializable;
import java.util.Date;

/**
 * 原单登记核销的实体类
 * @author Administrator
 *
 */
public class Cancel implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 3856691821962911632L;
	
	private String workId;//工作单号
	private String returnType;//返单类型
	private String acceptingUnit;//受理单位
	private Date acceptingTime;//受理时间
	private String clieUnit;//委托单位
	private Date enrat;//进港时间
	private String deliveryUnit;//派送单位
	private Date deliveryTime;//派送时间
	private String deliveryMan;//派送员
	private String isCancel;//已核销
	private Date cancelTime;//核销时间
	private String isDeposit; //已寄单
	private Date depositTime;//寄单时间
	
	public String getWorkId() {
		return workId;
	}
	
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	
	public String getReturnType() {
		return returnType;
	}
	
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	public String getAcceptingUnit() {
		return acceptingUnit;
	}
	
	public void setAcceptingUnit(String acceptingUnit) {
		this.acceptingUnit = acceptingUnit;
	}
	
	public Date getAcceptingTime() {
		return acceptingTime;
	}
	
	public void setAcceptingTime(Date acceptingTime) {
		this.acceptingTime = acceptingTime;
	}
	
	public String getClieUnit() {
		return clieUnit;
	}
	
	public void setClieUnit(String clieUnit) {
		this.clieUnit = clieUnit;
	}
	
	public Date getEnrat() {
		return enrat;
	}
	
	public void setEnrat(Date enrat) {
		this.enrat = enrat;
	}
	
	public String getDeliveryUnit() {
		return deliveryUnit;
	}
	
	public void setDeliveryUnit(String deliveryUnit) {
		this.deliveryUnit = deliveryUnit;
	}
	
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public String getDeliveryMan() {
		return deliveryMan;
	}
	
	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	
	public String getIsCancel() {
		return isCancel;
	}
	
	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}
	
	public Date getCancelTime() {
		return cancelTime;
	}
	
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	
	public String getIsDeposit() {
		return isDeposit;
	}
	
	public void setIsDeposit(String isDeposit) {
		this.isDeposit = isDeposit;
	}
	
	public Date getDepositTime() {
		return depositTime;
	}
	
	public void setDepositTime(Date depositTime) {
		this.depositTime = depositTime;
	}

	public Cancel() {
		
	}
	
	public Cancel(String workId, String returnType, String acceptingUnit, Date acceptingTime, String clieUnit,
			Date enrat, String deliveryUnit, Date deliveryTime, String deliveryMan, String isCancel, Date cancelTime,
			String isDeposit, Date depositTime) {
		super();
		this.workId = workId;
		this.returnType = returnType;
		this.acceptingUnit = acceptingUnit;
		this.acceptingTime = acceptingTime;
		this.clieUnit = clieUnit;
		this.enrat = enrat;
		this.deliveryUnit = deliveryUnit;
		this.deliveryTime = deliveryTime;
		this.deliveryMan = deliveryMan;
		this.isCancel = isCancel;
		this.cancelTime = cancelTime;
		this.isDeposit = isDeposit;
		this.depositTime = depositTime;
	}

	@Override
	public String toString() {
		return "Cancel [workId=" + workId + ", returnType=" + returnType + ", acceptingUnit=" + acceptingUnit
				+ ", acceptingTime=" + acceptingTime + ", clieUnit=" + clieUnit + ", enrat=" + enrat + ", deliveryUnit="
				+ deliveryUnit + ", deliveryTime=" + deliveryTime + ", deliveryMan=" + deliveryMan + ", isCancel="
				+ isCancel + ", cancelTime=" + cancelTime + ", isDeposit=" + isDeposit + ", depositTime=" + depositTime
				+ "]";
	}
		
}
