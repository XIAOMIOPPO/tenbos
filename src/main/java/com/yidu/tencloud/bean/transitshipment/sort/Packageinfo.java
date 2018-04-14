package com.yidu.tencloud.bean.transitshipment.sort;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Packageinfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 合包主信息Id
	 */
	private String packageId;
	/**
	 * 合包号
	 */
	private String packageNo;
	/**
	 * 合包单位
	 */
	private String packageUnit;
	/**
	 * 合包人
	 */
	private String packageName;
	/**
	 * 封签号
	 */
	private String sealNumber;
	/**
	 * 到达地
	 */
	private String destination;
	
	private String computationalArrival;
	
	private Date serviceTimeLimit;
	
	private Date packageTime;
	
	private BigDecimal votes;
	
	private BigDecimal totalPackages;
	
	private BigDecimal totalWeight;
	
	private BigDecimal totalVolume;
	
	private String pstatus;
	/**
	 * 合包作废状态
	 */
	private String status;
	
	private String stowageRequirement;

	
	public List<Packagelist> pkgDetailList;
	
	public Packageinfo() {}

	public Packageinfo(String packageId, String packageNo, String packageUnit, String packageName, String sealNumber,
			String destination, String computationalArrival, Date serviceTimeLimit, Date packageTime, BigDecimal votes,
			BigDecimal totalPackages, BigDecimal totalWeight, BigDecimal totalVolume, String pstatus, String status,
			String stowageRequirement, List<Packagelist> pkgDetailList) {
		super();
		this.packageId = packageId;
		this.packageNo = packageNo;
		this.packageUnit = packageUnit;
		this.packageName = packageName;
		this.sealNumber = sealNumber;
		this.destination = destination;
		this.computationalArrival = computationalArrival;
		this.serviceTimeLimit = serviceTimeLimit;
		this.packageTime = packageTime;
		this.votes = votes;
		this.totalPackages = totalPackages;
		this.totalWeight = totalWeight;
		this.totalVolume = totalVolume;
		this.pstatus = pstatus;
		this.status = status;
		this.stowageRequirement = stowageRequirement;
		this.pkgDetailList = pkgDetailList;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}

	public String getPackageUnit() {
		return packageUnit;
	}

	public void setPackageUnit(String packageUnit) {
		this.packageUnit = packageUnit;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getSealNumber() {
		return sealNumber;
	}

	public void setSealNumber(String sealNumber) {
		this.sealNumber = sealNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getComputationalArrival() {
		return computationalArrival;
	}

	public void setComputationalArrival(String computationalArrival) {
		this.computationalArrival = computationalArrival;
	}

	public Date getServiceTimeLimit() {
		return serviceTimeLimit;
	}

	public void setServiceTimeLimit(Date serviceTimeLimit) {
		this.serviceTimeLimit = serviceTimeLimit;
	}

	public Date getPackageTime() {
		return packageTime;
	}

	public void setPackageTime(Date packageTime) {
		this.packageTime = packageTime;
	}

	public BigDecimal getVotes() {
		return votes;
	}

	public void setVotes(BigDecimal votes) {
		this.votes = votes;
	}

	public BigDecimal getTotalPackages() {
		return totalPackages;
	}

	public void setTotalPackages(BigDecimal totalPackages) {
		this.totalPackages = totalPackages;
	}

	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public BigDecimal getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(BigDecimal totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStowageRequirement() {
		return stowageRequirement;
	}

	public void setStowageRequirement(String stowageRequirement) {
		this.stowageRequirement = stowageRequirement;
	}

	public List<Packagelist> getPkgDetailList() {
		return pkgDetailList;
	}

	public void setPkgDetailList(List<Packagelist> pkgDetailList) {
		this.pkgDetailList = pkgDetailList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((computationalArrival == null) ? 0 : computationalArrival.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
		result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result + ((packageNo == null) ? 0 : packageNo.hashCode());
		result = prime * result + ((packageTime == null) ? 0 : packageTime.hashCode());
		result = prime * result + ((packageUnit == null) ? 0 : packageUnit.hashCode());
		result = prime * result + ((pkgDetailList == null) ? 0 : pkgDetailList.hashCode());
		result = prime * result + ((pstatus == null) ? 0 : pstatus.hashCode());
		result = prime * result + ((sealNumber == null) ? 0 : sealNumber.hashCode());
		result = prime * result + ((serviceTimeLimit == null) ? 0 : serviceTimeLimit.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stowageRequirement == null) ? 0 : stowageRequirement.hashCode());
		result = prime * result + ((totalPackages == null) ? 0 : totalPackages.hashCode());
		result = prime * result + ((totalVolume == null) ? 0 : totalVolume.hashCode());
		result = prime * result + ((totalWeight == null) ? 0 : totalWeight.hashCode());
		result = prime * result + ((votes == null) ? 0 : votes.hashCode());
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
		Packageinfo other = (Packageinfo) obj;
		if (computationalArrival == null) {
			if (other.computationalArrival != null)
				return false;
		} else if (!computationalArrival.equals(other.computationalArrival))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (packageNo == null) {
			if (other.packageNo != null)
				return false;
		} else if (!packageNo.equals(other.packageNo))
			return false;
		if (packageTime == null) {
			if (other.packageTime != null)
				return false;
		} else if (!packageTime.equals(other.packageTime))
			return false;
		if (packageUnit == null) {
			if (other.packageUnit != null)
				return false;
		} else if (!packageUnit.equals(other.packageUnit))
			return false;
		if (pkgDetailList == null) {
			if (other.pkgDetailList != null)
				return false;
		} else if (!pkgDetailList.equals(other.pkgDetailList))
			return false;
		if (pstatus == null) {
			if (other.pstatus != null)
				return false;
		} else if (!pstatus.equals(other.pstatus))
			return false;
		if (sealNumber == null) {
			if (other.sealNumber != null)
				return false;
		} else if (!sealNumber.equals(other.sealNumber))
			return false;
		if (serviceTimeLimit == null) {
			if (other.serviceTimeLimit != null)
				return false;
		} else if (!serviceTimeLimit.equals(other.serviceTimeLimit))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stowageRequirement == null) {
			if (other.stowageRequirement != null)
				return false;
		} else if (!stowageRequirement.equals(other.stowageRequirement))
			return false;
		if (totalPackages == null) {
			if (other.totalPackages != null)
				return false;
		} else if (!totalPackages.equals(other.totalPackages))
			return false;
		if (totalVolume == null) {
			if (other.totalVolume != null)
				return false;
		} else if (!totalVolume.equals(other.totalVolume))
			return false;
		if (totalWeight == null) {
			if (other.totalWeight != null)
				return false;
		} else if (!totalWeight.equals(other.totalWeight))
			return false;
		if (votes == null) {
			if (other.votes != null)
				return false;
		} else if (!votes.equals(other.votes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Packageinfo [packageId=" + packageId + ", packageNo=" + packageNo + ", packageUnit=" + packageUnit
				+ ", packageName=" + packageName + ", sealNumber=" + sealNumber + ", destination=" + destination
				+ ", computationalArrival=" + computationalArrival + ", serviceTimeLimit=" + serviceTimeLimit
				+ ", packageTime=" + packageTime + ", votes=" + votes + ", totalPackages=" + totalPackages
				+ ", totalWeight=" + totalWeight + ", totalVolume=" + totalVolume + ", pstatus=" + pstatus + ", status="
				+ status + ", stowageRequirement=" + stowageRequirement + ", pkgDetailList=" + pkgDetailList + "]";
	}
}
