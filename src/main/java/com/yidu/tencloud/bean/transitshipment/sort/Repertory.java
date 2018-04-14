package com.yidu.tencloud.bean.transitshipment.sort;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据实体类
 *@author 刘艺钿
 * 
 */
public class Repertory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int repertoryId;  
	private String jobNo;
	private String operationUnit;
	private Date warehouseTime;
	private Date warningTime;
	private String arrival;
	private Date DeliveryTime;
	private String warehousePeople;
	private Date stockTime;
	private String acceptUnits;
	private String shippingAddress;
	private String stockNumber;
	private String actualNumber;
	private String weight;
	public int getRepertoryId() {
		return repertoryId;
	}
	public void setRepertoryId(int repertoryId) {
		this.repertoryId = repertoryId;
	}
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	public String getOperationUnit() {
		return operationUnit;
	}
	public void setOperationUnit(String operationUnit) {
		this.operationUnit = operationUnit;
	}
	public Date getWarehouseTime() {
		return warehouseTime;
	}
	public void setWarehouseTime(Date warehouseTime) {
		this.warehouseTime = warehouseTime;
	}
	public Date getWarningTime() {
		return warningTime;
	}
	public void setWarningTime(Date warningTime) {
		this.warningTime = warningTime;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public Date getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public String getWarehousePeople() {
		return warehousePeople;
	}
	public void setWarehousePeople(String warehousePeople) {
		this.warehousePeople = warehousePeople;
	}
	public Date getStockTime() {
		return stockTime;
	}
	public void setStockTime(Date stockTime) {
		this.stockTime = stockTime;
	}
	public String getAcceptUnits() {
		return acceptUnits;
	}
	public void setAcceptUnits(String acceptUnits) {
		this.acceptUnits = acceptUnits;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getActualNumber() {
		return actualNumber;
	}
	public void setActualNumber(String actualNumber) {
		this.actualNumber = actualNumber;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Repertory(int repertoryId, String jobNo, String operationUnit, Date warehouseTime, Date warningTime,
			String arrival, Date deliveryTime, String warehousePeople, Date stockTime, String acceptUnits,
			String shippingAddress, String stockNumber, String actualNumber, String weight) {
		super();
		this.repertoryId = repertoryId;
		this.jobNo = jobNo;
		this.operationUnit = operationUnit;
		this.warehouseTime = warehouseTime;
		this.warningTime = warningTime;
		this.arrival = arrival;
		DeliveryTime = deliveryTime;
		this.warehousePeople = warehousePeople;
		this.stockTime = stockTime;
		this.acceptUnits = acceptUnits;
		this.shippingAddress = shippingAddress;
		this.stockNumber = stockNumber;
		this.actualNumber = actualNumber;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "repertory [repertoryId=" + repertoryId + ", jobNo=" + jobNo + ", operationUnit=" + operationUnit
				+ ", warehouseTime=" + warehouseTime + ", warningTime=" + warningTime + ", arrival=" + arrival
				+ ", DeliveryTime=" + DeliveryTime + ", warehousePeople=" + warehousePeople + ", stockTime=" + stockTime
				+ ", acceptUnits=" + acceptUnits + ", shippingAddress=" + shippingAddress + ", stockNumber="
				+ stockNumber + ", actualNumber=" + actualNumber + ", weight=" + weight + "]";
	}
	public Repertory() {
		super();
	}
	
	
	


}
