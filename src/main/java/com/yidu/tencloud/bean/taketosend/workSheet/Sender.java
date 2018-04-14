package com.yidu.tencloud.bean.taketosend.workSheet;

import java.io.Serializable;
/**
 * 寄件人实体类
 * @author 陈涛
 *
 */
public class Sender implements Serializable{
    /**
     * 寄件人Id
     */
	private String senderId;
	/**
	 * 寄件人编号
	 */
	private String senderNo;
	/**
	 * 寄件人姓名
	 */
	private String senderName;
	/**
	 * 寄件人传真
	 */
	private String senderFax;
	/**
	 * 寄件人地址
	 */
	private String senderAddress;
	/**
	 * 寄件人单位
	 */
	private String senderCompany;
	/**
	 * 寄件人电话
	 */
	private String senderPhone;
	/**
	 * 工作单编号
	 */
	private String workSheetNo;
	
	public Sender() {}

	public Sender(String senderId, String senderNo, String senderName, String senderFax, String senderAddress,
			String senderCompany, String senderPhone, String workSheetNo) {
		super();
		this.senderId = senderId;
		this.senderNo = senderNo;
		this.senderName = senderName;
		this.senderFax = senderFax;
		this.senderAddress = senderAddress;
		this.senderCompany = senderCompany;
		this.senderPhone = senderPhone;
		this.workSheetNo = workSheetNo;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderNo() {
		return senderNo;
	}

	public void setSenderNo(String senderNo) {
		this.senderNo = senderNo;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderFax() {
		return senderFax;
	}

	public void setSenderFax(String senderFax) {
		this.senderFax = senderFax;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	@Override
	public String toString() {
		return "Sender [senderId=" + senderId + ", senderNo=" + senderNo + ", senderName=" + senderName + ", senderFax="
				+ senderFax + ", senderAddress=" + senderAddress + ", senderCompany=" + senderCompany + ", senderPhone="
				+ senderPhone + ", workSheetNo=" + workSheetNo + "]";
	}

	
	
	
	
}
