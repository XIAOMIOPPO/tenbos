package com.yidu.tencloud.bean.route.aviation;

import java.io.Serializable;
import java.util.Date;

public class Buslisten implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1751259118580921201L;
	private String lineId;
	private String lineNo;
	private String scity;
	private String departureCenter;
	private String departureBatch;
	private String flightNumber;
	private Date takeoffTime;
	private Date landingTime;
	private String entryBath;
	private String entryOpreationCenter;
	private String arriveCity;
	private String transferBatch;
	private String transferOperationCenter;
	private String ferryTransferBath;
	private String ferryTransferOpreationCenter;
	private String ferryHongKong;
	private String ferryCentre;
	private String carriers;
	private String whetherCharter;
	private int actualWeight;
	private int volume;
	private String unitPrice;
	private String aminimumCharge;
	private String otherWeight;
	private String otherPrice;
	private String otherWeight1;
	private String othPrice1;
	private String fuelSurcharge;
	private String takeDeliveryFee;
	private int opreactionPrice;
	private String isContract;
	private Date contractStart;
	private Date contractEnd;
	private String advanceTimePoint;
	private int advanceDeliveryTime;
	private int deliveryDelayTime;
	private String deliveryTimePoint;
	private String remark;
	private String schedule;
	private String drawerName;
	private String drawerCompany;
	private Date drawerTime;
	private String supplementName;
	private Date supplementTime;
	public String getLineId() {
		return lineId;
	}
	public String getLineNo() {
		return lineNo;
	}
	public String getScity() {
		return scity;
	}
	public String getDepartureCenter() {
		return departureCenter;
	}
	public String getDepartureBatch() {
		return departureBatch;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public Date getTakeoffTime() {
		return takeoffTime;
	}
	public Date getLandingTime() {
		return landingTime;
	}
	public String getEntryBath() {
		return entryBath;
	}
	public String getEntryOpreationCenter() {
		return entryOpreationCenter;
	}
	public String getArriveCity() {
		return arriveCity;
	}
	public String getTransferBatch() {
		return transferBatch;
	}
	public String getTransferOperationCenter() {
		return transferOperationCenter;
	}
	public String getFerryTransferBath() {
		return ferryTransferBath;
	}
	public String getFerryTransferOpreationCenter() {
		return ferryTransferOpreationCenter;
	}
	public String getFerryHongKong() {
		return ferryHongKong;
	}
	public String getFerryCentre() {
		return ferryCentre;
	}
	public String getCarriers() {
		return carriers;
	}
	public String getWhetherCharter() {
		return whetherCharter;
	}
	public int getActualWeight() {
		return actualWeight;
	}
	public int getVolume() {
		return volume;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public String getAminimumCharge() {
		return aminimumCharge;
	}
	public String getOtherWeight() {
		return otherWeight;
	}
	public String getOtherPrice() {
		return otherPrice;
	}
	public String getOtherWeight1() {
		return otherWeight1;
	}
	public String getOthPrice1() {
		return othPrice1;
	}
	public String getFuelSurcharge() {
		return fuelSurcharge;
	}
	public String getTakeDeliveryFee() {
		return takeDeliveryFee;
	}
	public int getOpreactionPrice() {
		return opreactionPrice;
	}
	public String getIsContract() {
		return isContract;
	}
	public Date getContractStart() {
		return contractStart;
	}
	public Date getContractEnd() {
		return contractEnd;
	}
	public String getAdvanceTimePoint() {
		return advanceTimePoint;
	}
	public int getAdvanceDeliveryTime() {
		return advanceDeliveryTime;
	}
	public int getDeliveryDelayTime() {
		return deliveryDelayTime;
	}
	public String getDeliveryTimePoint() {
		return deliveryTimePoint;
	}
	public String getRemark() {
		return remark;
	}
	public String getSchedule() {
		return schedule;
	}
	public String getDrawerName() {
		return drawerName;
	}
	public String getDrawerCompany() {
		return drawerCompany;
	}
	public Date getDrawerTime() {
		return drawerTime;
	}
	public String getSupplementName() {
		return supplementName;
	}
	public Date getSupplementTime() {
		return supplementTime;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public void setDepartureCenter(String departureCenter) {
		this.departureCenter = departureCenter;
	}
	public void setDepartureBatch(String departureBatch) {
		this.departureBatch = departureBatch;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setTakeoffTime(Date takeoffTime) {
		this.takeoffTime = takeoffTime;
	}
	public void setLandingTime(Date landingTime) {
		this.landingTime = landingTime;
	}
	public void setEntryBath(String entryBath) {
		this.entryBath = entryBath;
	}
	public void setEntryOpreationCenter(String entryOpreationCenter) {
		this.entryOpreationCenter = entryOpreationCenter;
	}
	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}
	public void setTransferBatch(String transferBatch) {
		this.transferBatch = transferBatch;
	}
	public void setTransferOperationCenter(String transferOperationCenter) {
		this.transferOperationCenter = transferOperationCenter;
	}
	public void setFerryTransferBath(String ferryTransferBath) {
		this.ferryTransferBath = ferryTransferBath;
	}
	public void setFerryTransferOpreationCenter(String ferryTransferOpreationCenter) {
		this.ferryTransferOpreationCenter = ferryTransferOpreationCenter;
	}
	public void setFerryHongKong(String ferryHongKong) {
		this.ferryHongKong = ferryHongKong;
	}
	public void setFerryCentre(String ferryCentre) {
		this.ferryCentre = ferryCentre;
	}
	public void setCarriers(String carriers) {
		this.carriers = carriers;
	}
	public void setWhetherCharter(String whetherCharter) {
		this.whetherCharter = whetherCharter;
	}
	public void setActualWeight(int actualWeight) {
		this.actualWeight = actualWeight;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setAminimumCharge(String aminimumCharge) {
		this.aminimumCharge = aminimumCharge;
	}
	public void setOtherWeight(String otherWeight) {
		this.otherWeight = otherWeight;
	}
	public void setOtherPrice(String otherPrice) {
		this.otherPrice = otherPrice;
	}
	public void setOtherWeight1(String otherWeight1) {
		this.otherWeight1 = otherWeight1;
	}
	public void setOthPrice1(String othPrice1) {
		this.othPrice1 = othPrice1;
	}
	public void setFuelSurcharge(String fuelSurcharge) {
		this.fuelSurcharge = fuelSurcharge;
	}
	public void setTakeDeliveryFee(String takeDeliveryFee) {
		this.takeDeliveryFee = takeDeliveryFee;
	}
	public void setOpreactionPrice(int opreactionPrice) {
		this.opreactionPrice = opreactionPrice;
	}
	public void setIsContract(String isContract) {
		this.isContract = isContract;
	}
	public void setContractStart(Date contractStart) {
		this.contractStart = contractStart;
	}
	public void setContractEnd(Date contractEnd) {
		this.contractEnd = contractEnd;
	}
	public void setAdvanceTimePoint(String advanceTimePoint) {
		this.advanceTimePoint = advanceTimePoint;
	}
	public void setAdvanceDeliveryTime(int advanceDeliveryTime) {
		this.advanceDeliveryTime = advanceDeliveryTime;
	}
	public void setDeliveryDelayTime(int deliveryDelayTime) {
		this.deliveryDelayTime = deliveryDelayTime;
	}
	public void setDeliveryTimePoint(String deliveryTimePoint) {
		this.deliveryTimePoint = deliveryTimePoint;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}
	public void setDrawerCompany(String drawerCompany) {
		this.drawerCompany = drawerCompany;
	}
	public void setDrawerTime(Date drawerTime) {
		this.drawerTime = drawerTime;
	}
	public void setSupplementName(String supplementName) {
		this.supplementName = supplementName;
	}
	public void setSupplementTime(Date supplementTime) {
		this.supplementTime = supplementTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actualWeight;
		result = prime * result + advanceDeliveryTime;
		result = prime * result + ((advanceTimePoint == null) ? 0 : advanceTimePoint.hashCode());
		result = prime * result + ((aminimumCharge == null) ? 0 : aminimumCharge.hashCode());
		result = prime * result + ((arriveCity == null) ? 0 : arriveCity.hashCode());
		result = prime * result + ((carriers == null) ? 0 : carriers.hashCode());
		result = prime * result + ((contractEnd == null) ? 0 : contractEnd.hashCode());
		result = prime * result + ((contractStart == null) ? 0 : contractStart.hashCode());
		result = prime * result + deliveryDelayTime;
		result = prime * result + ((deliveryTimePoint == null) ? 0 : deliveryTimePoint.hashCode());
		result = prime * result + ((departureBatch == null) ? 0 : departureBatch.hashCode());
		result = prime * result + ((departureCenter == null) ? 0 : departureCenter.hashCode());
		result = prime * result + ((drawerCompany == null) ? 0 : drawerCompany.hashCode());
		result = prime * result + ((drawerName == null) ? 0 : drawerName.hashCode());
		result = prime * result + ((drawerTime == null) ? 0 : drawerTime.hashCode());
		result = prime * result + ((entryBath == null) ? 0 : entryBath.hashCode());
		result = prime * result + ((entryOpreationCenter == null) ? 0 : entryOpreationCenter.hashCode());
		result = prime * result + ((ferryCentre == null) ? 0 : ferryCentre.hashCode());
		result = prime * result + ((ferryHongKong == null) ? 0 : ferryHongKong.hashCode());
		result = prime * result + ((ferryTransferBath == null) ? 0 : ferryTransferBath.hashCode());
		result = prime * result
				+ ((ferryTransferOpreationCenter == null) ? 0 : ferryTransferOpreationCenter.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((fuelSurcharge == null) ? 0 : fuelSurcharge.hashCode());
		result = prime * result + ((isContract == null) ? 0 : isContract.hashCode());
		result = prime * result + ((landingTime == null) ? 0 : landingTime.hashCode());
		result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
		result = prime * result + ((lineNo == null) ? 0 : lineNo.hashCode());
		result = prime * result + opreactionPrice;
		result = prime * result + ((othPrice1 == null) ? 0 : othPrice1.hashCode());
		result = prime * result + ((otherPrice == null) ? 0 : otherPrice.hashCode());
		result = prime * result + ((otherWeight == null) ? 0 : otherWeight.hashCode());
		result = prime * result + ((otherWeight1 == null) ? 0 : otherWeight1.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((scity == null) ? 0 : scity.hashCode());
		result = prime * result + ((supplementName == null) ? 0 : supplementName.hashCode());
		result = prime * result + ((supplementTime == null) ? 0 : supplementTime.hashCode());
		result = prime * result + ((takeDeliveryFee == null) ? 0 : takeDeliveryFee.hashCode());
		result = prime * result + ((takeoffTime == null) ? 0 : takeoffTime.hashCode());
		result = prime * result + ((transferBatch == null) ? 0 : transferBatch.hashCode());
		result = prime * result + ((transferOperationCenter == null) ? 0 : transferOperationCenter.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + volume;
		result = prime * result + ((whetherCharter == null) ? 0 : whetherCharter.hashCode());
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
		if (!(obj instanceof Buslisten)) {
			return false;
		}
		Buslisten other = (Buslisten) obj;
		if (actualWeight != other.actualWeight) {
			return false;
		}
		if (advanceDeliveryTime != other.advanceDeliveryTime) {
			return false;
		}
		if (advanceTimePoint == null) {
			if (other.advanceTimePoint != null) {
				return false;
			}
		} else if (!advanceTimePoint.equals(other.advanceTimePoint)) {
			return false;
		}
		if (aminimumCharge == null) {
			if (other.aminimumCharge != null) {
				return false;
			}
		} else if (!aminimumCharge.equals(other.aminimumCharge)) {
			return false;
		}
		if (arriveCity == null) {
			if (other.arriveCity != null) {
				return false;
			}
		} else if (!arriveCity.equals(other.arriveCity)) {
			return false;
		}
		if (carriers == null) {
			if (other.carriers != null) {
				return false;
			}
		} else if (!carriers.equals(other.carriers)) {
			return false;
		}
		if (contractEnd == null) {
			if (other.contractEnd != null) {
				return false;
			}
		} else if (!contractEnd.equals(other.contractEnd)) {
			return false;
		}
		if (contractStart == null) {
			if (other.contractStart != null) {
				return false;
			}
		} else if (!contractStart.equals(other.contractStart)) {
			return false;
		}
		if (deliveryDelayTime != other.deliveryDelayTime) {
			return false;
		}
		if (deliveryTimePoint == null) {
			if (other.deliveryTimePoint != null) {
				return false;
			}
		} else if (!deliveryTimePoint.equals(other.deliveryTimePoint)) {
			return false;
		}
		if (departureBatch == null) {
			if (other.departureBatch != null) {
				return false;
			}
		} else if (!departureBatch.equals(other.departureBatch)) {
			return false;
		}
		if (departureCenter == null) {
			if (other.departureCenter != null) {
				return false;
			}
		} else if (!departureCenter.equals(other.departureCenter)) {
			return false;
		}
		if (drawerCompany == null) {
			if (other.drawerCompany != null) {
				return false;
			}
		} else if (!drawerCompany.equals(other.drawerCompany)) {
			return false;
		}
		if (drawerName == null) {
			if (other.drawerName != null) {
				return false;
			}
		} else if (!drawerName.equals(other.drawerName)) {
			return false;
		}
		if (drawerTime == null) {
			if (other.drawerTime != null) {
				return false;
			}
		} else if (!drawerTime.equals(other.drawerTime)) {
			return false;
		}
		if (entryBath == null) {
			if (other.entryBath != null) {
				return false;
			}
		} else if (!entryBath.equals(other.entryBath)) {
			return false;
		}
		if (entryOpreationCenter == null) {
			if (other.entryOpreationCenter != null) {
				return false;
			}
		} else if (!entryOpreationCenter.equals(other.entryOpreationCenter)) {
			return false;
		}
		if (ferryCentre == null) {
			if (other.ferryCentre != null) {
				return false;
			}
		} else if (!ferryCentre.equals(other.ferryCentre)) {
			return false;
		}
		if (ferryHongKong == null) {
			if (other.ferryHongKong != null) {
				return false;
			}
		} else if (!ferryHongKong.equals(other.ferryHongKong)) {
			return false;
		}
		if (ferryTransferBath == null) {
			if (other.ferryTransferBath != null) {
				return false;
			}
		} else if (!ferryTransferBath.equals(other.ferryTransferBath)) {
			return false;
		}
		if (ferryTransferOpreationCenter == null) {
			if (other.ferryTransferOpreationCenter != null) {
				return false;
			}
		} else if (!ferryTransferOpreationCenter.equals(other.ferryTransferOpreationCenter)) {
			return false;
		}
		if (flightNumber == null) {
			if (other.flightNumber != null) {
				return false;
			}
		} else if (!flightNumber.equals(other.flightNumber)) {
			return false;
		}
		if (fuelSurcharge == null) {
			if (other.fuelSurcharge != null) {
				return false;
			}
		} else if (!fuelSurcharge.equals(other.fuelSurcharge)) {
			return false;
		}
		if (isContract == null) {
			if (other.isContract != null) {
				return false;
			}
		} else if (!isContract.equals(other.isContract)) {
			return false;
		}
		if (landingTime == null) {
			if (other.landingTime != null) {
				return false;
			}
		} else if (!landingTime.equals(other.landingTime)) {
			return false;
		}
		if (lineId == null) {
			if (other.lineId != null) {
				return false;
			}
		} else if (!lineId.equals(other.lineId)) {
			return false;
		}
		if (lineNo == null) {
			if (other.lineNo != null) {
				return false;
			}
		} else if (!lineNo.equals(other.lineNo)) {
			return false;
		}
		if (opreactionPrice != other.opreactionPrice) {
			return false;
		}
		if (othPrice1 == null) {
			if (other.othPrice1 != null) {
				return false;
			}
		} else if (!othPrice1.equals(other.othPrice1)) {
			return false;
		}
		if (otherPrice == null) {
			if (other.otherPrice != null) {
				return false;
			}
		} else if (!otherPrice.equals(other.otherPrice)) {
			return false;
		}
		if (otherWeight == null) {
			if (other.otherWeight != null) {
				return false;
			}
		} else if (!otherWeight.equals(other.otherWeight)) {
			return false;
		}
		if (otherWeight1 == null) {
			if (other.otherWeight1 != null) {
				return false;
			}
		} else if (!otherWeight1.equals(other.otherWeight1)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (schedule == null) {
			if (other.schedule != null) {
				return false;
			}
		} else if (!schedule.equals(other.schedule)) {
			return false;
		}
		if (scity == null) {
			if (other.scity != null) {
				return false;
			}
		} else if (!scity.equals(other.scity)) {
			return false;
		}
		if (supplementName == null) {
			if (other.supplementName != null) {
				return false;
			}
		} else if (!supplementName.equals(other.supplementName)) {
			return false;
		}
		if (supplementTime == null) {
			if (other.supplementTime != null) {
				return false;
			}
		} else if (!supplementTime.equals(other.supplementTime)) {
			return false;
		}
		if (takeDeliveryFee == null) {
			if (other.takeDeliveryFee != null) {
				return false;
			}
		} else if (!takeDeliveryFee.equals(other.takeDeliveryFee)) {
			return false;
		}
		if (takeoffTime == null) {
			if (other.takeoffTime != null) {
				return false;
			}
		} else if (!takeoffTime.equals(other.takeoffTime)) {
			return false;
		}
		if (transferBatch == null) {
			if (other.transferBatch != null) {
				return false;
			}
		} else if (!transferBatch.equals(other.transferBatch)) {
			return false;
		}
		if (transferOperationCenter == null) {
			if (other.transferOperationCenter != null) {
				return false;
			}
		} else if (!transferOperationCenter.equals(other.transferOperationCenter)) {
			return false;
		}
		if (unitPrice == null) {
			if (other.unitPrice != null) {
				return false;
			}
		} else if (!unitPrice.equals(other.unitPrice)) {
			return false;
		}
		if (volume != other.volume) {
			return false;
		}
		if (whetherCharter == null) {
			if (other.whetherCharter != null) {
				return false;
			}
		} else if (!whetherCharter.equals(other.whetherCharter)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Buslisten [lineId=" + lineId + ", lineNo=" + lineNo + ", scity=" + scity + ", departureCenter="
				+ departureCenter + ", departureBatch=" + departureBatch + ", flightNumber=" + flightNumber
				+ ", takeoffTime=" + takeoffTime + ", landingTime=" + landingTime + ", entryBath=" + entryBath
				+ ", entryOpreationCenter=" + entryOpreationCenter + ", arriveCity=" + arriveCity + ", transferBatch="
				+ transferBatch + ", transferOperationCenter=" + transferOperationCenter + ", ferryTransferBath="
				+ ferryTransferBath + ", ferryTransferOpreationCenter=" + ferryTransferOpreationCenter
				+ ", ferryHongKong=" + ferryHongKong + ", ferryCentre=" + ferryCentre + ", carriers=" + carriers
				+ ", whetherCharter=" + whetherCharter + ", actualWeight=" + actualWeight + ", volume=" + volume
				+ ", unitPrice=" + unitPrice + ", aminimumCharge=" + aminimumCharge + ", otherWeight=" + otherWeight
				+ ", otherPrice=" + otherPrice + ", otherWeight1=" + otherWeight1 + ", othPrice1=" + othPrice1
				+ ", fuelSurcharge=" + fuelSurcharge + ", takeDeliveryFee=" + takeDeliveryFee + ", opreactionPrice="
				+ opreactionPrice + ", isContract=" + isContract + ", contractStart=" + contractStart + ", contractEnd="
				+ contractEnd + ", advanceTimePoint=" + advanceTimePoint + ", advanceDeliveryTime="
				+ advanceDeliveryTime + ", deliveryDelayTime=" + deliveryDelayTime + ", deliveryTimePoint="
				+ deliveryTimePoint + ", remark=" + remark + ", schedule=" + schedule + ", drawerName=" + drawerName
				+ ", drawerCompany=" + drawerCompany + ", drawerTime=" + drawerTime + ", supplementName="
				+ supplementName + ", supplementTime=" + supplementTime + "]";
	}
	public Buslisten(String lineId, String lineNo, String scity, String departureCenter, String departureBatch,
			String flightNumber, Date takeoffTime, Date landingTime, String entryBath, String entryOpreationCenter,
			String arriveCity, String transferBatch, String transferOperationCenter, String ferryTransferBath,
			String ferryTransferOpreationCenter, String ferryHongKong, String ferryCentre, String carriers,
			String whetherCharter, int actualWeight, int volume, String unitPrice, String aminimumCharge,
			String otherWeight, String otherPrice, String otherWeight1, String othPrice1, String fuelSurcharge,
			String takeDeliveryFee, int opreactionPrice, String isContract, Date contractStart, Date contractEnd,
			String advanceTimePoint, int advanceDeliveryTime, int deliveryDelayTime, String deliveryTimePoint,
			String remark, String schedule, String drawerName, String drawerCompany, Date drawerTime,
			String supplementName, Date supplementTime) {
		super();
		this.lineId = lineId;
		this.lineNo = lineNo;
		this.scity = scity;
		this.departureCenter = departureCenter;
		this.departureBatch = departureBatch;
		this.flightNumber = flightNumber;
		this.takeoffTime = takeoffTime;
		this.landingTime = landingTime;
		this.entryBath = entryBath;
		this.entryOpreationCenter = entryOpreationCenter;
		this.arriveCity = arriveCity;
		this.transferBatch = transferBatch;
		this.transferOperationCenter = transferOperationCenter;
		this.ferryTransferBath = ferryTransferBath;
		this.ferryTransferOpreationCenter = ferryTransferOpreationCenter;
		this.ferryHongKong = ferryHongKong;
		this.ferryCentre = ferryCentre;
		this.carriers = carriers;
		this.whetherCharter = whetherCharter;
		this.actualWeight = actualWeight;
		this.volume = volume;
		this.unitPrice = unitPrice;
		this.aminimumCharge = aminimumCharge;
		this.otherWeight = otherWeight;
		this.otherPrice = otherPrice;
		this.otherWeight1 = otherWeight1;
		this.othPrice1 = othPrice1;
		this.fuelSurcharge = fuelSurcharge;
		this.takeDeliveryFee = takeDeliveryFee;
		this.opreactionPrice = opreactionPrice;
		this.isContract = isContract;
		this.contractStart = contractStart;
		this.contractEnd = contractEnd;
		this.advanceTimePoint = advanceTimePoint;
		this.advanceDeliveryTime = advanceDeliveryTime;
		this.deliveryDelayTime = deliveryDelayTime;
		this.deliveryTimePoint = deliveryTimePoint;
		this.remark = remark;
		this.schedule = schedule;
		this.drawerName = drawerName;
		this.drawerCompany = drawerCompany;
		this.drawerTime = drawerTime;
		this.supplementName = supplementName;
		this.supplementTime = supplementTime;
	}
	public Buslisten() {
		super(); 
	}
	
	
	
}
