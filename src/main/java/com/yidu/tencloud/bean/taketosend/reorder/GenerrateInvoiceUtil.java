package com.yidu.tencloud.bean.taketosend.reorder;

import java.math.BigDecimal;
import java.util.Date;

public class GenerrateInvoiceUtil {

	private String workSheetNo;

	private Date drawerTime;
	
	private Date inputTime;
	
	private String status;
	
	private String customerNo;
	
	private String senderName;
	
	private String senderCompany;

	private int productAmount;
	
	private BigDecimal volume;
	
	private Date serviceTimeLimit;
	
	private String destination;
	
	private String customerListNo;
	
	private String productName;
	
	private String product;
	
	private int PaymentArrival;
	
	private BigDecimal replaceReceivables;
	
	private String empName;
	
	private Date takeTime;

	private String importantTips;
	
	private String pickup;
	
	private BigDecimal actualWeight;
	
	public GenerrateInvoiceUtil() {}

	public GenerrateInvoiceUtil(String workSheetNo, Date drawerTime, Date inputTime, String status, String customerNo,
			String senderName, String senderCompany, int productAmount, BigDecimal volume, Date serviceTimeLimit,
			String destination, String customerListNo, String productName, String product, int paymentArrival,
			BigDecimal replaceReceivables, String empName, Date takeTime, String importantTips, String pickup,
			BigDecimal actualWeight) {
		super();
		this.workSheetNo = workSheetNo;
		this.drawerTime = drawerTime;
		this.inputTime = inputTime;
		this.status = status;
		this.customerNo = customerNo;
		this.senderName = senderName;
		this.senderCompany = senderCompany;
		this.productAmount = productAmount;
		this.volume = volume;
		this.serviceTimeLimit = serviceTimeLimit;
		this.destination = destination;
		this.customerListNo = customerListNo;
		this.productName = productName;
		this.product = product;
		this.PaymentArrival = paymentArrival;
		this.replaceReceivables = replaceReceivables;
		this.empName = empName;
		this.takeTime = takeTime;
		this.importantTips = importantTips;
		this.pickup = pickup;
		this.actualWeight = actualWeight;
	}

	public String getWorkSheetNo() {
		return workSheetNo;
	}

	public void setWorkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	public Date getDrawerTime() {
		return drawerTime;
	}

	public void setDrawerTime(Date drawerTime) {
		this.drawerTime = drawerTime;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCustomerListNo() {
		return customerListNo;
	}

	public void setCustomerListNo(String customerListNo) {
		this.customerListNo = customerListNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPaymentArrival() {
		return PaymentArrival;
	}

	public void setPaymentArrival(int paymentArrival) {
		PaymentArrival = paymentArrival;
	}

	public BigDecimal getReplaceReceivables() {
		return replaceReceivables;
	}

	public void setReplaceReceivables(BigDecimal replaceReceivables) {
		this.replaceReceivables = replaceReceivables;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}

	public String getImportantTips() {
		return importantTips;
	}

	public void setImportantTips(String importantTips) {
		this.importantTips = importantTips;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public BigDecimal getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(BigDecimal actualWeight) {
		this.actualWeight = actualWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PaymentArrival;
		result = prime * result + ((actualWeight == null) ? 0 : actualWeight.hashCode());
		result = prime * result + ((customerListNo == null) ? 0 : customerListNo.hashCode());
		result = prime * result + ((customerNo == null) ? 0 : customerNo.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((drawerTime == null) ? 0 : drawerTime.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((importantTips == null) ? 0 : importantTips.hashCode());
		result = prime * result + ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result + ((pickup == null) ? 0 : pickup.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + productAmount;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((replaceReceivables == null) ? 0 : replaceReceivables.hashCode());
		result = prime * result + ((senderCompany == null) ? 0 : senderCompany.hashCode());
		result = prime * result + ((senderName == null) ? 0 : senderName.hashCode());
		result = prime * result + ((serviceTimeLimit == null) ? 0 : serviceTimeLimit.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((takeTime == null) ? 0 : takeTime.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		GenerrateInvoiceUtil other = (GenerrateInvoiceUtil) obj;
		if (PaymentArrival != other.PaymentArrival)
			return false;
		if (actualWeight == null) {
			if (other.actualWeight != null)
				return false;
		} else if (!actualWeight.equals(other.actualWeight))
			return false;
		if (customerListNo == null) {
			if (other.customerListNo != null)
				return false;
		} else if (!customerListNo.equals(other.customerListNo))
			return false;
		if (customerNo == null) {
			if (other.customerNo != null)
				return false;
		} else if (!customerNo.equals(other.customerNo))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (drawerTime == null) {
			if (other.drawerTime != null)
				return false;
		} else if (!drawerTime.equals(other.drawerTime))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (importantTips == null) {
			if (other.importantTips != null)
				return false;
		} else if (!importantTips.equals(other.importantTips))
			return false;
		if (inputTime == null) {
			if (other.inputTime != null)
				return false;
		} else if (!inputTime.equals(other.inputTime))
			return false;
		if (pickup == null) {
			if (other.pickup != null)
				return false;
		} else if (!pickup.equals(other.pickup))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productAmount != other.productAmount)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (replaceReceivables == null) {
			if (other.replaceReceivables != null)
				return false;
		} else if (!replaceReceivables.equals(other.replaceReceivables))
			return false;
		if (senderCompany == null) {
			if (other.senderCompany != null)
				return false;
		} else if (!senderCompany.equals(other.senderCompany))
			return false;
		if (senderName == null) {
			if (other.senderName != null)
				return false;
		} else if (!senderName.equals(other.senderName))
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
		if (takeTime == null) {
			if (other.takeTime != null)
				return false;
		} else if (!takeTime.equals(other.takeTime))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
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
		return "GenerrateInvoiceUtil [workSheetNo=" + workSheetNo + ", drawerTime=" + drawerTime + ", inputTime="
				+ inputTime + ", status=" + status + ", customerNo=" + customerNo + ", senderName=" + senderName
				+ ", senderCompany=" + senderCompany + ", productAmount=" + productAmount + ", volume=" + volume
				+ ", serviceTimeLimit=" + serviceTimeLimit + ", destination=" + destination + ", customerListNo="
				+ customerListNo + ", productName=" + productName + ", product=" + product + ", PaymentArrival="
				+ PaymentArrival + ", replaceReceivables=" + replaceReceivables + ", empName=" + empName + ", takeTime="
				+ takeTime + ", importantTips=" + importantTips + ", pickup=" + pickup + ", actualWeight="
				+ actualWeight + "]";
	}

	
	
	
	
}
