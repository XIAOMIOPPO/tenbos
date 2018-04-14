package com.yidu.tencloud.bean.transitshipment.sort;

import java.math.BigDecimal;
import java.util.Date;

public class Packagelist {
	/**
	 * 合包明细Id
	 */
	private String packListId;
	/**
	 * 单号
	 */
	private String oddNo;
	/**
	 * 品名
	 */
	private String productName;
	/**
	 * 到达地
	 */
	private String destination;
	/**
	 * 票数
	 */
	private int vote;
	/**
	 * 实际件数
	 */
	private BigDecimal productAmount;
	/**
	 * 件数
	 */
	private BigDecimal number;
	/**
	 * 重量
	 */
	private BigDecimal actualWeight;
	/**
	 * 体积
	 */
	private BigDecimal volume;
	/**
	 * 到达时限
	 */
	private Date serviceTimeLimit;
	/**
	 * 重要提示
	 */
	private String importantTips;
	/**
	 * 配载要求
	 */
	private String stowageRequirement;
	/**
	 * 输入类型
	 */
	private String inputType;
	/**
	 * 工作单号
	 */
	private String workSheetNo;
	/**
	 * 合包主表Id
	 */
	private String packageId;
	
	public Packagelist() {}

	public Packagelist(String packListId, String oddNo, String productName, String destination, int vote,
			BigDecimal productAmount, BigDecimal number, BigDecimal actualWeight, BigDecimal volume,
			Date serviceTimeLimit, String importantTips, String stowageRequirement, String inputType, String workSheetNo,
			String packageId) {
		super();
		this.packListId = packListId;
		this.oddNo = oddNo;
		this.productName = productName;
		this.destination = destination;
		this.vote = vote;
		this.productAmount = productAmount;
		this.number = number;
		this.actualWeight = actualWeight;
		this.volume = volume;
		this.serviceTimeLimit = serviceTimeLimit;
		this.importantTips = importantTips;
		this.stowageRequirement = stowageRequirement;
		this.inputType = inputType;
		this.workSheetNo = workSheetNo;
		this.packageId = packageId;
	}

	public String getPackListId() {
		return packListId;
	}

	public void setPackListId(String packListId) {
		this.packListId = packListId;
	}

	public String getOddNo() {
		return oddNo;
	}

	public void setOddNo(String oddNo) {
		this.oddNo = oddNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public BigDecimal getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(BigDecimal productAmount) {
		this.productAmount = productAmount;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public BigDecimal getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(BigDecimal actualWeight) {
		this.actualWeight = actualWeight;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public Date getServiceTimeLimit() {
		return serviceTimeLimit;
	}

	public void setServiceTimeLimit(Date serviceTimeLimit) {
		this.serviceTimeLimit = serviceTimeLimit;
	}

	public String getImportantTips() {
		return importantTips;
	}

	public void setImportantTips(String importantTips) {
		this.importantTips = importantTips;
	}

	public String getStowageRequirement() {
		return stowageRequirement;
	}

	public void setStowageRequirement(String stowageRequirement) {
		this.stowageRequirement = stowageRequirement;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualWeight == null) ? 0 : actualWeight.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((importantTips == null) ? 0 : importantTips.hashCode());
		result = prime * result + ((inputType == null) ? 0 : inputType.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((oddNo == null) ? 0 : oddNo.hashCode());
		result = prime * result + ((packListId == null) ? 0 : packListId.hashCode());
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
		result = prime * result + ((productAmount == null) ? 0 : productAmount.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((serviceTimeLimit == null) ? 0 : serviceTimeLimit.hashCode());
		result = prime * result + ((stowageRequirement == null) ? 0 : stowageRequirement.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result + vote;
		result = prime * result + ((workSheetNo == null) ? 0 : workSheetNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Packagelist other = (Packagelist) obj;
		if (actualWeight == null) {
			if (other.actualWeight != null)
				return false;
		} else if (!actualWeight.equals(other.actualWeight))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (importantTips == null) {
			if (other.importantTips != null)
				return false;
		} else if (!importantTips.equals(other.importantTips))
			return false;
		if (inputType == null) {
			if (other.inputType != null)
				return false;
		} else if (!inputType.equals(other.inputType))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (oddNo == null) {
			if (other.oddNo != null)
				return false;
		} else if (!oddNo.equals(other.oddNo))
			return false;
		if (packListId == null) {
			if (other.packListId != null)
				return false;
		} else if (!packListId.equals(other.packListId))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		if (productAmount == null) {
			if (other.productAmount != null)
				return false;
		} else if (!productAmount.equals(other.productAmount))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (serviceTimeLimit == null) {
			if (other.serviceTimeLimit != null)
				return false;
		} else if (!serviceTimeLimit.equals(other.serviceTimeLimit))
			return false;
		if (stowageRequirement == null) {
			if (other.stowageRequirement != null)
				return false;
		} else if (!stowageRequirement.equals(other.stowageRequirement))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		if (vote != other.vote)
			return false;
		if (workSheetNo == null) {
			if (other.workSheetNo != null)
				return false;
		} else if (!workSheetNo.equals(other.workSheetNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Packagelist [packListId=" + packListId + ", oddNo=" + oddNo + ", productName=" + productName
				+ ", destination=" + destination + ", vote=" + vote + ", productAmount=" + productAmount + ", number="
				+ number + ", actualWeight=" + actualWeight + ", volume=" + volume + ", serviceTimeLimit="
				+ serviceTimeLimit + ", importantTips=" + importantTips + ", stowageRequirement=" + stowageRequirement
				+ ", inputType=" + inputType + ", workSheetNo=" + workSheetNo + ", packageId=" + packageId + "]";
	}

}
