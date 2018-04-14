package com.yidu.tencloud.bean.transitshipment.sort;

import java.util.Date;

public class Storagein {

	
	/**
	 * 入库ID
	 */
	private String storageinId;
	
	/**
	 * 入库交接单号
	 */
	private String storageinNo;
	
	/**
	 * 接受时间
	 */
	private Date recDate;
	
	/**
	 * 接受人id
	 */
	private String recPersonId;
	
	/**
	 * 接受人名
	 */
	private String recPersonName;
	
	/**
	 * 接受人单位id
	 */
	private String recOrgId;
	
	/**
	 * 接受人单位名
	 */
	private String recOrgName;
	
	/**
	 * 返货人id
	 */
	private String sendPersonId;
	
	/**
	 * 发送人名
	 */
	private String sendPersonName;
	
	/**
	 * 发送人单位id
	 */
	private String sendOrgId;
	
	/**
	 * 发送人组织结构名
	 */
	private String sendOrgName;

	public String getStorageinId() {
		return storageinId;
	}

	public void setStorageinId(String storageinId) {
		this.storageinId = storageinId;
	}

	public String getStorageinNo() {
		return storageinNo;
	}

	public void setStorageinNo(String storageinNo) {
		this.storageinNo = storageinNo;
	}

	public Date getRecDate() {
		return recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
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

	public String getRecOrgId() {
		return recOrgId;
	}

	public void setRecOrgId(String recOrgId) {
		this.recOrgId = recOrgId;
	}

	public String getRecOrgName() {
		return recOrgName;
	}

	public void setRecOrgName(String recOrgName) {
		this.recOrgName = recOrgName;
	}

	public String getSendPersonId() {
		return sendPersonId;
	}

	public void setSendPersonId(String sendPersonId) {
		this.sendPersonId = sendPersonId;
	}

	public String getSendPersonName() {
		return sendPersonName;
	}

	public void setSendPersonName(String sendPersonName) {
		this.sendPersonName = sendPersonName;
	}

	public String getSendOrgId() {
		return sendOrgId;
	}

	public void setSendOrgId(String sendOrgId) {
		this.sendOrgId = sendOrgId;
	}

	public String getSendOrgName() {
		return sendOrgName;
	}

	public void setSendOrgName(String sendOrgName) {
		this.sendOrgName = sendOrgName;
	}

	@Override
	public String toString() {
		return "Storagein [storageinId=" + storageinId + ", storageinNo=" + storageinNo + ", recDate=" + recDate
				+ ", recPersonId=" + recPersonId + ", recPersonName=" + recPersonName + ", recOrgId=" + recOrgId
				+ ", recOrgName=" + recOrgName + ", sendPersonId=" + sendPersonId + ", sendPersonName=" + sendPersonName
				+ ", sendOrgId=" + sendOrgId + ", sendOrgName=" + sendOrgName + "]";
	}
	
	
	
}
