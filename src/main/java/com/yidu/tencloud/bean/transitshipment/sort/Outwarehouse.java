package com.yidu.tencloud.bean.transitshipment.sort;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据实体类
 * @author 刘艺钿
 *
 */
public class Outwarehouse  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int outwarehouseId;
	
	private String operationUnit;
	
	private String receiptNo;
	
	private String jobNo;
	
	private String warehousePeople;
	
	private String deliveryMan;
	
	private Date warehouseTime;
	
	private Date deliveryTime;
	
	private String operator;
	
	private String queryType;
	
	private Date operationTime;
	
	private String AccessType;
	
	private String delivery ;
	
	private String numberOf;

	public int getOutwarehouseId() {
		return outwarehouseId;
	}

	public void setOutwarehouseId(int outwarehouseId) {
		this.outwarehouseId = outwarehouseId;
	}

	public String getOperationUnit() {
		return operationUnit;
	}

	public void setOperationUnit(String operationUnit) {
		this.operationUnit = operationUnit;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getWarehousePeople() {
		return warehousePeople;
	}

	public void setWarehousePeople(String warehousePeople) {
		this.warehousePeople = warehousePeople;
	}

	public String getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public Date getWarehouseTime() {
		return warehouseTime;
	}

	public void setWarehouseTime(Date warehouseTime) {
		this.warehouseTime = warehouseTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public String getAccessType() {
		return AccessType;
	}

	public void setAccessType(String accessType) {
		AccessType = accessType;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getNumberOf() {
		return numberOf;
	}

	public void setNumberOf(String numberOf) {
		this.numberOf = numberOf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Outwarehouse(int outwarehouseId, String operationUnit, String receiptNo, String jobNo,
			String warehousePeople, String deliveryMan, Date warehouseTime, Date deliveryTime, String operator,
			String queryType, Date operationTime, String accessType, String delivery, String numberOf) {
		super();
		this.outwarehouseId = outwarehouseId;
		this.operationUnit = operationUnit;
		this.receiptNo = receiptNo;
		this.jobNo = jobNo;
		this.warehousePeople = warehousePeople;
		this.deliveryMan = deliveryMan;
		this.warehouseTime = warehouseTime;
		this.deliveryTime = deliveryTime;
		this.operator = operator;
		this.queryType = queryType;
		this.operationTime = operationTime;
		AccessType = accessType;
		this.delivery = delivery;
		this.numberOf = numberOf;
	}

	@Override
	public String toString() {
		return "outwarehouse [outwarehouseId=" + outwarehouseId + ", operationUnit=" + operationUnit + ", receiptNo="
				+ receiptNo + ", jobNo=" + jobNo + ", warehousePeople=" + warehousePeople + ", deliveryMan="
				+ deliveryMan + ", warehouseTime=" + warehouseTime + ", deliveryTime=" + deliveryTime + ", operator="
				+ operator + ", queryType=" + queryType + ", operationTime=" + operationTime + ", AccessType="
				+ AccessType + ", delivery=" + delivery + ", numberOf=" + numberOf + "]";
	}

	public Outwarehouse() {
		super();
	}
	
	
	
	

}
