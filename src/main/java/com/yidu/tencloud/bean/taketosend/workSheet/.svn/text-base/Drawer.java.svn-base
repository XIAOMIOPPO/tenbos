package com.yidu.tencloud.bean.taketosend.workSheet;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 开单人实体类
 * @author 陈涛
 *
 */
public class Drawer implements Serializable{

	/**
	 * 开单Id
	 */
	private String drawerId;
	/**
	 * 开单人单位
	 */
	private String drawerOperationCompany;
	/**
	 * 开单人编号
	 */
	private String drawerNo;
    /**
     * 开单人姓名	
     */
	private String drawerName;
	/**
	 * 开单时间
	 */
	@Column(name="drawerTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date drawerTime;
	/**
	 * 工作单编号
	 */
	private String workSheetNo;
	
	public Drawer() {}

	public Drawer(String drawerId, String drawerOperationCompany, String drawerNo, String drawerName, Date drawerTime,
			String workSheetNo) {
		super();
		this.drawerId = drawerId;
		this.drawerOperationCompany = drawerOperationCompany;
		this.drawerNo = drawerNo;
		this.drawerName = drawerName;
		this.drawerTime = drawerTime;
		this.workSheetNo = workSheetNo;
	}

	public String getDrawerId() {
		return drawerId;
	}

	public void setDrawerId(String drawerId) {
		this.drawerId = drawerId;
	}

	public String getDrawerOperationCompany() {
		return drawerOperationCompany;
	}

	public void setDrawerOperationCompany(String drawerOperationCompany) {
		this.drawerOperationCompany = drawerOperationCompany;
	}

	public String getDrawerNo() {
		return drawerNo;
	}

	public void setDrawerNo(String drawerNo) {
		this.drawerNo = drawerNo;
	}

	public String getDrawerName() {
		return drawerName;
	}

	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}

	public Date getDrawerTime() {
		return drawerTime;
	}

	public void setDrawerTime(Date drawerTime) {
		this.drawerTime = drawerTime;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	@Override
	public String toString() {
		return "Drawer [drawerId=" + drawerId + ", drawerOperationCompany=" + drawerOperationCompany + ", drawerNo="
				+ drawerNo + ", drawerName=" + drawerName + ", drawerTime=" + drawerTime + ", workSheetNo="
				+ workSheetNo + "]";
	}

	
}
