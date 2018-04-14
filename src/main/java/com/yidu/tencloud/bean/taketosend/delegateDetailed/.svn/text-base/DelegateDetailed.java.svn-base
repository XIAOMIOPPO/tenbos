package com.yidu.tencloud.bean.taketosend.delegateDetailed;

import java.util.Date;
/**
 * 委派明细的实体类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public class DelegateDetailed {
	    /**
	     * 工作单号
	     */
	    private String workSheetNo;
	    /**
	     * 签收
	     */
	    private String signStatus;
	    /**
	     * 签收人
	     */
	    private String addressesName;
	    /**
	     * 派送单位
	     */
	    private String empName;
	    /**
	     * 受理单位
	     */
	    private String pickup;
	    /**
	     * 结算方式
	     */
	    private String settlementMode;
	    /**
	     * 产品名
	     */
	    private String productName;
	    /**
	     * 件数
	     */
	    private int productAmount;
	    /**
	     * 体积
	     */
	    private String size;
	    /**
	     * 到达地
	     */
	    private String addressesAddress;
	    /**
	     * 希望送达时间
	     */
	    private Date serviceTimeLimit;
	    /**
	     * 配载要求
	     */
	    private String stowageRequirement;
	    /**
	     * 总票数
	     */
	    private int votes;
	    /**
	     * 已派送
	     */
	    private int delivered;
	    /**
	     * 未派送
	     */
	    private int notDelivered;
	    /**
	     * 晚点率
	     */
	    private double delayRate;
	    
	    public DelegateDetailed() {
	    	
	    }

		public String getWorkSheetNo() {
			return workSheetNo;
		}

		public void setWorkSheetNo(String workSheetNo) {
			this.workSheetNo = workSheetNo;
		}

		public String getSignStatus() {
			return signStatus;
		}

		public void setSignStatus(String signStatus) {
			this.signStatus = signStatus;
		}

		public String getAddressesName() {
			return addressesName;
		}

		public void setAddressesName(String addressesName) {
			this.addressesName = addressesName;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getPickup() {
			return pickup;
		}

		public void setPickup(String pickup) {
			this.pickup = pickup;
		}

		public String getSettlementMode() {
			return settlementMode;
		}

		public void setSettlementMode(String settlementMode) {
			this.settlementMode = settlementMode;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public int getProductAmount() {
			return productAmount;
		}

		public void setProductAmount(int productAmount) {
			this.productAmount = productAmount;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getAddressesAddress() {
			return addressesAddress;
		}

		public void setAddressesAddress(String addressesAddress) {
			this.addressesAddress = addressesAddress;
		}

		public Date getServiceTimeLimit() {
			return serviceTimeLimit;
		}

		public void setServiceTimeLimit(Date serviceTimeLimit) {
			this.serviceTimeLimit = serviceTimeLimit;
		}

		public String getStowageRequirement() {
			return stowageRequirement;
		}

		public void setStowageRequirement(String stowageRequirement) {
			this.stowageRequirement = stowageRequirement;
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

		public double getDelayRate() {
			return delayRate;
		}

		public void setDelayRate(double delayRate) {
			this.delayRate = delayRate;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((addressesAddress == null) ? 0 : addressesAddress.hashCode());
			result = prime * result + ((addressesName == null) ? 0 : addressesName.hashCode());
			long temp;
			temp = Double.doubleToLongBits(delayRate);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + delivered;
			result = prime * result + ((empName == null) ? 0 : empName.hashCode());
			result = prime * result + notDelivered;
			result = prime * result + ((pickup == null) ? 0 : pickup.hashCode());
			result = prime * result + productAmount;
			result = prime * result + ((productName == null) ? 0 : productName.hashCode());
			result = prime * result + ((serviceTimeLimit == null) ? 0 : serviceTimeLimit.hashCode());
			result = prime * result + ((settlementMode == null) ? 0 : settlementMode.hashCode());
			result = prime * result + ((signStatus == null) ? 0 : signStatus.hashCode());
			result = prime * result + ((size == null) ? 0 : size.hashCode());
			result = prime * result + ((stowageRequirement == null) ? 0 : stowageRequirement.hashCode());
			result = prime * result + votes;
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
			DelegateDetailed other = (DelegateDetailed) obj;
			if (addressesAddress == null) {
				if (other.addressesAddress != null)
					return false;
			} else if (!addressesAddress.equals(other.addressesAddress))
				return false;
			if (addressesName == null) {
				if (other.addressesName != null)
					return false;
			} else if (!addressesName.equals(other.addressesName))
				return false;
			if (Double.doubleToLongBits(delayRate) != Double.doubleToLongBits(other.delayRate))
				return false;
			if (delivered != other.delivered)
				return false;
			if (empName == null) {
				if (other.empName != null)
					return false;
			} else if (!empName.equals(other.empName))
				return false;
			if (notDelivered != other.notDelivered)
				return false;
			if (pickup == null) {
				if (other.pickup != null)
					return false;
			} else if (!pickup.equals(other.pickup))
				return false;
			if (productAmount != other.productAmount)
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
			if (settlementMode == null) {
				if (other.settlementMode != null)
					return false;
			} else if (!settlementMode.equals(other.settlementMode))
				return false;
			if (signStatus == null) {
				if (other.signStatus != null)
					return false;
			} else if (!signStatus.equals(other.signStatus))
				return false;
			if (size == null) {
				if (other.size != null)
					return false;
			} else if (!size.equals(other.size))
				return false;
			if (stowageRequirement == null) {
				if (other.stowageRequirement != null)
					return false;
			} else if (!stowageRequirement.equals(other.stowageRequirement))
				return false;
			if (votes != other.votes)
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
			return "DelegateDetailed [workSheetNo=" + workSheetNo + ", signStatus=" + signStatus + ", addressesName="
					+ addressesName + ", empName=" + empName + ", pickup=" + pickup + ", settlementMode="
					+ settlementMode + ", productName=" + productName + ", productAmount=" + productAmount + ", size="
					+ size + ", addressesAddress=" + addressesAddress + ", serviceTimeLimit=" + serviceTimeLimit
					+ ", stowageRequirement=" + stowageRequirement + ", votes=" + votes + ", delivered=" + delivered
					+ ", notDelivered=" + notDelivered + ", delayRate=" + delayRate + "]";
		}

		public DelegateDetailed(String workSheetNo, String signStatus, String addressesName, String empName,
				String pickup, String settlementMode, String productName, int productAmount, String size,
				String addressesAddress, Date serviceTimeLimit, String stowageRequirement, int votes, int delivered,
				int notDelivered, double delayRate) {
			super();
			this.workSheetNo = workSheetNo;
			this.signStatus = signStatus;
			this.addressesName = addressesName;
			this.empName = empName;
			this.pickup = pickup;
			this.settlementMode = settlementMode;
			this.productName = productName;
			this.productAmount = productAmount;
			this.size = size;
			this.addressesAddress = addressesAddress;
			this.serviceTimeLimit = serviceTimeLimit;
			this.stowageRequirement = stowageRequirement;
			this.votes = votes;
			this.delivered = delivered;
			this.notDelivered = notDelivered;
			this.delayRate = delayRate;
		}


		
}
