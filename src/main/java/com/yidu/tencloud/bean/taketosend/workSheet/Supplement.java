package com.yidu.tencloud.bean.taketosend.workSheet;

import java.io.Serializable;
import java.util.Date;
/**
 * 补单人实体类
 * @author 陈涛
 *
 */
public class Supplement implements Serializable{

	/**
	 * 补单人Id
	 */
	private String supplementId;
	/**
	 * 补单人姓名
	 */
	private String supplementName;
	/**
	 * 补单人编号
	 */
	private String supplementNo;
	/**
	 * 补单时间
	 */
	private Date supplementTime;
	/**
	 * 补单人单位
	 */
	private String supplementCompany;
	/**
	 * 工作单编号
	 */
	private String workSheetNo;
	
	public Supplement() {}

	public Supplement(String supplementId, String supplementName, String supplementNo, Date supplementTime,
			String supplementCompany, String workSheetNo) {
		super();
		this.supplementId = supplementId;
		this.supplementName = supplementName;
		this.supplementNo = supplementNo;
		this.supplementTime = supplementTime;
		this.supplementCompany = supplementCompany;
		this.workSheetNo = workSheetNo;
	}

	public String getSupplementId() {
		return supplementId;
	}

	public void setSupplementId(String supplementId) {
		this.supplementId = supplementId;
	}

	public String getSupplementName() {
		return supplementName;
	}

	public void setSupplementName(String supplementName) {
		this.supplementName = supplementName;
	}

	public String getSupplementNo() {
		return supplementNo;
	}

	public void setSupplementNo(String supplementNo) {
		this.supplementNo = supplementNo;
	}

	public Date getSupplementTime() {
		return supplementTime;
	}

	public void setSupplementTime(Date supplementTime) {
		this.supplementTime = supplementTime;
	}

	public String getSupplementCompany() {
		return supplementCompany;
	}

	public void setSupplementCompany(String supplementCompany) {
		this.supplementCompany = supplementCompany;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	@Override
	public String toString() {
		return "Supplement [supplementId=" + supplementId + ", supplementName=" + supplementName + ", supplementNo="
				+ supplementNo + ", supplementTime=" + supplementTime + ", supplementCompany=" + supplementCompany
				+ ", workSheetNo=" + workSheetNo + "]";
	}

	
}
