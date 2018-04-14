package com.yidu.tencloud.bean.taketosend.pack;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mysql.fabric.xmlrpc.base.Data;

public class UserUncl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nucId;
	private String workSheetNo;
	private String bility;
	private Data nucLear;
	private BigDecimal weigHing;
	private int geweRenz;
	private String opeRation;
	private String unit;
	private String userId;
	private int productAmount;
	private String addresseeAddress;
	private BigDecimal actualWeight;
	private BigDecimal billingWeight;
	public String getNucId() {
		return nucId;
	}
	public void setNucId(String nucId) {
		this.nucId = nucId;
	}
	public String getworkSheetNo() {
		return workSheetNo;
	}
	public void setworkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}
	public String getBility() {
		return bility;
	}
	public void setBility(String bility) {
		this.bility = bility;
	}
	public Data getNucLear() {
		return nucLear;
	}
	public void setNucLear(Data nucLear) {
		this.nucLear = nucLear;
	}
	public BigDecimal getWeigHing() {
		return weigHing;
	}
	public void setWeigHing(BigDecimal weigHing) {
		this.weigHing = weigHing;
	}
	public int getGeweRenz() {
		return geweRenz;
	}
	public void setGeweRenz(int geweRenz) {
		this.geweRenz = geweRenz;
	}
	public String getOpeRation() {
		return opeRation;
	}
	public void setOpeRation(String opeRation) {
		this.opeRation = opeRation;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public String getAddresseeAddress() {
		return addresseeAddress;
	}
	public void setAddresseeAddress(String addresseeAddress) {
		this.addresseeAddress = addresseeAddress;
	}
	public BigDecimal getActualWeight() {
		return actualWeight;
	}
	public void setActualWeight(BigDecimal actualWeight) {
		this.actualWeight = actualWeight;
	}
	public BigDecimal getBillingWeight() {
		return billingWeight;
	}
	public void setBillingWeight(BigDecimal billingWeight) {
		this.billingWeight = billingWeight;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualWeight == null) ? 0 : actualWeight.hashCode());
		result = prime * result + ((addresseeAddress == null) ? 0 : addresseeAddress.hashCode());
		result = prime * result + ((bility == null) ? 0 : bility.hashCode());
		result = prime * result + ((billingWeight == null) ? 0 : billingWeight.hashCode());
		result = prime * result + geweRenz;
		result = prime * result + ((nucId == null) ? 0 : nucId.hashCode());
		result = prime * result + ((nucLear == null) ? 0 : nucLear.hashCode());
		result = prime * result + ((opeRation == null) ? 0 : opeRation.hashCode());
		result = prime * result + ((workSheetNo == null) ? 0 : workSheetNo.hashCode());
		result = prime * result + productAmount;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((weigHing == null) ? 0 : weigHing.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserUncl other = (UserUncl) obj;
		if (actualWeight == null) {
			if (other.actualWeight != null) {
				return false;
			}
		} else if (!actualWeight.equals(other.actualWeight)) {
			return false;
		}
		if (addresseeAddress == null) {
			if (other.addresseeAddress != null) {
				return false;
			}
		} else if (!addresseeAddress.equals(other.addresseeAddress)) {
			return false;
		}
		if (bility == null) {
			if (other.bility != null) {
				return false;
			}
		} else if (!bility.equals(other.bility)) {
			return false;
		}
		if (billingWeight == null) {
			if (other.billingWeight != null) {
				return false;
			}
		} else if (!billingWeight.equals(other.billingWeight)) {
			return false;
		}
		if (geweRenz != other.geweRenz) {
			return false;
		}
		if (nucId == null) {
			if (other.nucId != null) {
				return false;
			}
		} else if (!nucId.equals(other.nucId)) {
			return false;
		}
		if (nucLear == null) {
			if (other.nucLear != null) {
				return false;
			}
		} else if (!nucLear.equals(other.nucLear)) {
			return false;
		}
		if (opeRation == null) {
			if (other.opeRation != null) {
				return false;
			}
		} else if (!opeRation.equals(other.opeRation)) {
			return false;
		}
		if (workSheetNo == null) {
			if (other.workSheetNo != null) {
				return false;
			}
		} else if (!workSheetNo.equals(other.workSheetNo)) {
			return false;
		}
		if (productAmount != other.productAmount) {
			return false;
		}
		if (unit == null) {
			if (other.unit != null) {
				return false;
			}
		} else if (!unit.equals(other.unit)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		if (weigHing == null) {
			if (other.weigHing != null) {
				return false;
			}
		} else if (!weigHing.equals(other.weigHing)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "UserUncl [nucId=" + nucId + ", workSheetNo=" + workSheetNo + ", bility=" + bility + ", nucLear=" + nucLear
				+ ", weigHing=" + weigHing + ", geweRenz=" + geweRenz + ", opeRation=" + opeRation + ", unit=" + unit
				+ ", userId=" + userId + ", productAmount=" + productAmount + ", addresseeAddress=" + addresseeAddress
				+ ", actualWeight=" + actualWeight + ", billingWeight=" + billingWeight + "]";
	}
	public UserUncl(String nucId, String workSheetNo, String bility, Data nucLear, BigDecimal weigHing, int geweRenz,
			String opeRation, String unit, String userId, int productAmount, String addresseeAddress,
			BigDecimal actualWeight, BigDecimal billingWeight) {
		super();
		this.nucId = nucId;
		this.workSheetNo = workSheetNo;
		this.bility = bility;
		this.nucLear = nucLear;
		this.weigHing = weigHing;
		this.geweRenz = geweRenz;
		this.opeRation = opeRation;
		this.unit = unit;
		this.userId = userId;
		this.productAmount = productAmount;
		this.addresseeAddress = addresseeAddress;
		this.actualWeight = actualWeight;
		this.billingWeight = billingWeight;
	}
	public UserUncl() {
		super();
	}
	
	
}
