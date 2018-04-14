package com.yidu.tencloud.bean.transitshipment.sort;

import java.math.BigDecimal;

public class StorageinDetail {

	/**
	 * 入库详情id
	 */
	private String sdetailId;
	
	/**
	 * 工作单号
	 */
	private String sdetailNo;
	
	/**
	 * 合包号
	 */
	private String copackno;
	
	
	/**
	 * 重量
	 */
	private BigDecimal weight;
	
	
	/**
	 * 入库id 外键
	 */
	private String storageinId;
	
	/**
	 * 关联出库交接单
	 */
	private String outstorageno;
	
	
	/**
	 * 入库状态
	 */
	private String rstatus;


	
	
	
	public String getStorageinId() {
		return storageinId;
	}

	public void setStorageinId(String storageinId) {
		this.storageinId = storageinId;
	}

	public String getSdetailId() {
		return sdetailId;
	}

	public void setSdetailId(String sdetailId) {
		this.sdetailId = sdetailId;
	}

	public String getSdetailNo() {
		return sdetailNo;
	}

	public void setSdetailNo(String sdetailNo) {
		this.sdetailNo = sdetailNo;
	}

	public String getCopackno() {
		return copackno;
	}

	public void setCopackno(String copackno) {
		this.copackno = copackno;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getOutstorageno() {
		return outstorageno;
	}

	public void setOutstorageno(String outstorageno) {
		this.outstorageno = outstorageno;
	}

	public String getRstatus() {
		return rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	@Override
	public String toString() {
		return "StorageinDetail [sdetailId=" + sdetailId + ", sdetailNo=" + sdetailNo + ", copackno=" + copackno
				+ ", weight=" + weight + ", storageinId=" + storageinId + ", outstorageno=" + outstorageno
				+ ", rstatus=" + rstatus + "]";
	}
	
	
	
	
	
}
