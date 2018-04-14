package com.yidu.tencloud.bean.taketosend.workSheet;

import java.io.Serializable;
import java.util.Date;
/**
 * 国际表实体类
 * @author 陈涛
 *
 */
public class International implements Serializable{
    /**
     * 国际单Id
     */
	private String internationalId;
	/**
	 * 出口口岸
	 */
	private String portOfExport;
	/**
	 * 运输方式
	 */
	private String typeOfExport;
	/**
	 * 快递物品类别
	 */
	private String expressGoodsType;
	/**
	 * 海关申报价值
	 */
	private int customsDeclarationValue;
	/**
	 * 币种
	 */
	private String currency;
	/**
	 * 预计离港时间
	 */
	private Date estimatedTimeDeparture;
	/**
	 * 预计到港时间
	 */
	private Date estimatedTimeArrival;
	
	public International() {}

	public International(String internationalId, String portOfExport, String typeOfExport, String expressGoodsType,
			int customsDeclarationValue, String currency, Date estimatedTimeDeparture, Date estimatedTimeArrival) {
		super();
		this.internationalId = internationalId;
		this.portOfExport = portOfExport;
		this.typeOfExport = typeOfExport;
		this.expressGoodsType = expressGoodsType;
		this.customsDeclarationValue = customsDeclarationValue;
		this.currency = currency;
		this.estimatedTimeDeparture = estimatedTimeDeparture;
		this.estimatedTimeArrival = estimatedTimeArrival;
	}

	public String getInternationalId() {
		return internationalId;
	}

	public void setInternationalId(String internationalId) {
		this.internationalId = internationalId;
	}

	public String getPortOfExport() {
		return portOfExport;
	}

	public void setPortOfExport(String portOfExport) {
		this.portOfExport = portOfExport;
	}

	public String getTypeOfExport() {
		return typeOfExport;
	}

	public void setTypeOfExport(String typeOfExport) {
		this.typeOfExport = typeOfExport;
	}

	public String getExpressGoodsType() {
		return expressGoodsType;
	}

	public void setExpressGoodsType(String expressGoodsType) {
		this.expressGoodsType = expressGoodsType;
	}

	public int getCustomsDeclarationValue() {
		return customsDeclarationValue;
	}

	public void setCustomsDeclarationValue(int customsDeclarationValue) {
		this.customsDeclarationValue = customsDeclarationValue;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getEstimatedTimeDeparture() {
		return estimatedTimeDeparture;
	}

	public void setEstimatedTimeDeparture(Date estimatedTimeDeparture) {
		this.estimatedTimeDeparture = estimatedTimeDeparture;
	}

	public Date getEstimatedTimeArrival() {
		return estimatedTimeArrival;
	}

	public void setEstimatedTimeArrival(Date estimatedTimeArrival) {
		this.estimatedTimeArrival = estimatedTimeArrival;
	}

	@Override
	public String toString() {
		return "International [internationalId=" + internationalId + ", portOfExport=" + portOfExport
				+ ", typeOfExport=" + typeOfExport + ", expressGoodsType=" + expressGoodsType
				+ ", customsDeclarationValue=" + customsDeclarationValue + ", currency=" + currency
				+ ", estimatedTimeDeparture=" + estimatedTimeDeparture + ", estimatedTimeArrival="
				+ estimatedTimeArrival + "]";
	}
	
	
}
