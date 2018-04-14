package com.yidu.tencloud.bean.taketosend.delegationStatistics;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 委派明细统计的实体类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public class DelegationStatistics {
	/**
	 * 网点代码
	 */
	private String orgId;
	/**
	 * 网点名称
	 */
	private String pickup;
	/**
	 * 应派送票数
	 */
	private int votes;
	/**
	 * 已派送票数
	 */
	private int delivered;
	/**
	 * 未派送票数
	 */
	private int notDelivered;
	/**
	 * 已返货数量
	 */
	private int returnNum;
	/**
	 * 晚点率
	 */
	private double delayRate;
	/**
	 * 返货率
	 */
	private double returnRate;
	
	public DelegationStatistics() {
		
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getDelivered() {
		return delivered;
	}

	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}

	public int getNotDelivered() {
		return notDelivered;
	}

	public void setNotDelivered(int notDelivered) {
		this.notDelivered = notDelivered;
	}

	public int getReturnNum() {
		return returnNum;
	}

	public void setReturnNum(int returnNum) {
		this.returnNum = returnNum;
	}

	public double getDelayRate() {
		return delayRate;
	}

	public void setDelayRate(double delayRate) {
		this.delayRate = delayRate;
	}

	public double getReturnRate() {
		return returnRate;
	}

	public void setReturnRate(double returnRate) {
		this.returnRate = returnRate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(delayRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + delivered;
		result = prime * result + notDelivered;
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((pickup == null) ? 0 : pickup.hashCode());
		result = prime * result + returnNum;
		temp = Double.doubleToLongBits(returnRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + votes;
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
		DelegationStatistics other = (DelegationStatistics) obj;
		if (Double.doubleToLongBits(delayRate) != Double.doubleToLongBits(other.delayRate))
			return false;
		if (delivered != other.delivered)
			return false;
		if (notDelivered != other.notDelivered)
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (pickup == null) {
			if (other.pickup != null)
				return false;
		} else if (!pickup.equals(other.pickup))
			return false;
		if (returnNum != other.returnNum)
			return false;
		if (Double.doubleToLongBits(returnRate) != Double.doubleToLongBits(other.returnRate))
			return false;
		if (votes != other.votes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DelegationStatistics [orgId=" + orgId + ", pickup=" + pickup + ", votes=" + votes + ", delivered="
				+ delivered + ", notDelivered=" + notDelivered + ", returnNum=" + returnNum + ", delayRate=" + delayRate
				+ ", returnRate=" + returnRate + "]";
	}

	public DelegationStatistics(String orgId, String pickup, int votes, int delivered, int notDelivered, int returnNum,
			double delayRate, double returnRate) {
		super();
		this.orgId = orgId;
		this.pickup = pickup;
		this.votes = votes;
		this.delivered = delivered;
		this.notDelivered = notDelivered;
		this.returnNum = returnNum;
		this.delayRate = delayRate;
		this.returnRate = returnRate;
	}

	
	
}
