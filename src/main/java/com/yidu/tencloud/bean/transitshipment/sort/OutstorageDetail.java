package com.yidu.tencloud.bean.transitshipment.sort;

import java.math.BigDecimal;
import java.util.Date;

public class OutstorageDetail {

	
	/**
	 * 出库详情id
	 */
	private String outdetailId;
	
	/**
	 * 工作单号
	 */
	private String outdetailNo;
	
	/**
	 * 合包号
	 */
	private String copackno;
	
	/**
	 * 重量
	 */
	private BigDecimal weight;
	
	/**
	 * 体积
	 */
	private BigDecimal volume;
	
	/**
	 * 扫描日期
	 */
	private Date scanDate;
	
	/**
	 * 是否扫描
	 */
	private String isScan;
	
	/**
	 * 是否下环节入库
	 */
	private String isIn;
	
	/**
	 * 是否二次入库
	 */
	private String isReIn;

	public String getOutdetailId() {
		return outdetailId;
	}

	public void setOutdetailId(String outdetailId) {
		this.outdetailId = outdetailId;
	}

	public String getOutdetailNo() {
		return outdetailNo;
	}

	public void setOutdetailNo(String outdetailNo) {
		this.outdetailNo = outdetailNo;
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

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public Date getScanDate() {
		return scanDate;
	}

	public void setScanDate(Date scanDate) {
		this.scanDate = scanDate;
	}

	public String getIsScan() {
		return isScan;
	}

	public void setIsScan(String isScan) {
		this.isScan = isScan;
	}

	public String getIsIn() {
		return isIn;
	}

	public void setIsIn(String isIn) {
		this.isIn = isIn;
	}

	public String getIsReIn() {
		return isReIn;
	}

	public void setIsReIn(String isReIn) {
		this.isReIn = isReIn;
	}

	
	
}
