package com.yidu.tencloud.bean.transitshipment.sort;

import java.util.Date;

public class Outstorage {

	
	/**
	 * 出库交接id号
	 */
	private String outstorageId;
	
	/**
	 * 出库单号
	 */
	private String outstorageno;
	
	/**
	 * 出库交接单类型   市内物流交接单，长途物流交接单，派送清单，发货交接单
	 */
	private String outstorageType;
	
	/**
	 * 线路类型
	 */
	private String lineType;
	
	/**
	 * 物流方向
	 */
	private String logdir;
	
	/**
	 * 运输方式
	 */
	private String transWay;
	
	/**
	 * 承运商 
	 */
	private String forwarder;
	
	/**
	 * 接货人id
	 */
	private String recPersonId;

	/**
	 * 接货人名
	 */
	private String recPersonName;
	
	/**
	 * 交接人id
	 */
	private String delivererId;
	
	/**
	 * 交接人名
	 */
	private String delivererName;
	
	/**
	 * 交接时间
	 */
	private Date delivererTime;
	
	/**
	 * 交货单位id
	 */
	private String delivererOrg;
	
	/**
	 * 交货单位名
	 */
	private String delivererOrgName;
	
	
	
	public String getOutstorageId() {
		return outstorageId;
	}
	public void setOutstorageId(String outstorageId) {
		this.outstorageId = outstorageId;
	}
	public String getOutstorageno() {
		return outstorageno;
	}
	public void setOutstorageno(String outstorageno) {
		this.outstorageno = outstorageno;
	}
	public String getOutstorageType() {
		return outstorageType;
	}
	public void setOutstorageType(String outstorageType) {
		this.outstorageType = outstorageType;
	}
	public String getLineType() {
		return lineType;
	}
	public void setLineType(String lineType) {
		this.lineType = lineType;
	}
	public String getLogdir() {
		return logdir;
	}
	public void setLogdir(String logdir) {
		this.logdir = logdir;
	}
	public String getTransWay() {
		return transWay;
	}
	public void setTransWay(String transWay) {
		this.transWay = transWay;
	}
	public String getForwarder() {
		return forwarder;
	}
	public void setForwarder(String forwarder) {
		this.forwarder = forwarder;
	}
	public String getRecPersonId() {
		return recPersonId;
	}
	public void setRecPersonId(String recPersonId) {
		this.recPersonId = recPersonId;
	}
	public String getRecPersonName() {
		return recPersonName;
	}
	public void setRecPersonName(String recPersonName) {
		this.recPersonName = recPersonName;
	}
	public String getDelivererId() {
		return delivererId;
	}
	public void setDelivererId(String delivererId) {
		this.delivererId = delivererId;
	}
	public String getDelivererName() {
		return delivererName;
	}
	public void setDelivererName(String delivererName) {
		this.delivererName = delivererName;
	}
	public Date getDelivererTime() {
		return delivererTime;
	}
	public void setDelivererTime(Date delivererTime) {
		this.delivererTime = delivererTime;
	}
	public String getDelivererOrg() {
		return delivererOrg;
	}
	public void setDelivererOrg(String delivererOrg) {
		this.delivererOrg = delivererOrg;
	}
	public String getDelivererOrgName() {
		return delivererOrgName;
	}
	public void setDelivererOrgName(String delivererOrgName) {
		this.delivererOrgName = delivererOrgName;
	}
	
	
	
	

	
	
	
}
