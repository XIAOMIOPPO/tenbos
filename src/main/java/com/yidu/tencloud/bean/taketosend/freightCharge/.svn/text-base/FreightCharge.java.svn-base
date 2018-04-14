package com.yidu.tencloud.bean.taketosend.freightCharge;

import java.io.Serializable;

/**
 * 运费计算实体类
 * @author 廖晓翠
 * @since 2017/11/23
 */
public class FreightCharge implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 运费计算Id
	 */
	private String freightId;
	/**
	 * 发货地
	 */
	private String placeOfDispatch;

	/**
	 * 发货地的拼音简称
	 */
	private String placeOfDispatchPY;
	/**
	 * 收货地
	 */
	private String receivingLand;
	/**
	 * 收货地的拼音简称
	 */
	private String receivingLandPY;
	/**
	 * 首重价格
	 */
	private Integer firstHeavy;
	/**
	 * 次重价格
	 */
	private Integer secondHeavy;
	
	
	public FreightCharge() {}

	
	public FreightCharge(String freightId, String placeOfDispatch, String placeOfDispatchPY, String receivingLand,
			String receivingLandPY, Integer firstHeavy, Integer secondHeavy) {
		super();
		this.freightId = freightId;
		this.placeOfDispatch = placeOfDispatch;
		this.placeOfDispatchPY = placeOfDispatchPY;
		this.receivingLand = receivingLand;
		this.receivingLandPY = receivingLandPY;
		this.firstHeavy = firstHeavy;
		this.secondHeavy = secondHeavy;
	}


	public String getFreightId() {
		return freightId;
	}

	public void setFreightId(String freightId) {
		this.freightId = freightId;
	}

	public String getPlaceOfDispatch() {
		return placeOfDispatch;
	}

	public void setPlaceOfDispatch(String placeOfDispatch) {
		this.placeOfDispatch = placeOfDispatch;
	}

	public String getReceivingLand() {
		return receivingLand;
	}

	public void setReceivingLand(String receivingLand) {
		this.receivingLand = receivingLand;
	}

	public Integer getFirstHeavy() {
		return firstHeavy;
	}

	public void setFirstHeavy(Integer firstHeavy) {
		this.firstHeavy = firstHeavy;
	}

	public Integer getSecondHeavy() {
		return secondHeavy;
	}

	public void setSecondHeavy(Integer secondHeavy) {
		this.secondHeavy = secondHeavy;
	}

	public String getPlaceOfDispatchPY() {
		return placeOfDispatchPY;
	}

	public void setPlaceOfDispatchPY(String placeOfDispatchPY) {
		this.placeOfDispatchPY = placeOfDispatchPY;
	}

	public String getReceivingLandPY() {
		return receivingLandPY;
	}

	public void setReceivingLandPY(String receivingLandPY) {
		this.receivingLandPY = receivingLandPY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstHeavy == null) ? 0 : firstHeavy.hashCode());
		result = prime * result + ((freightId == null) ? 0 : freightId.hashCode());
		result = prime * result + ((placeOfDispatch == null) ? 0 : placeOfDispatch.hashCode());
		result = prime * result + ((placeOfDispatchPY == null) ? 0 : placeOfDispatchPY.hashCode());
		result = prime * result + ((receivingLand == null) ? 0 : receivingLand.hashCode());
		result = prime * result + ((receivingLandPY == null) ? 0 : receivingLandPY.hashCode());
		result = prime * result + ((secondHeavy == null) ? 0 : secondHeavy.hashCode());
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
		FreightCharge other = (FreightCharge) obj;
		if (firstHeavy == null) {
			if (other.firstHeavy != null)
				return false;
		} else if (!firstHeavy.equals(other.firstHeavy))
			return false;
		if (freightId == null) {
			if (other.freightId != null)
				return false;
		} else if (!freightId.equals(other.freightId))
			return false;
		if (placeOfDispatch == null) {
			if (other.placeOfDispatch != null)
				return false;
		} else if (!placeOfDispatch.equals(other.placeOfDispatch))
			return false;
		if (placeOfDispatchPY == null) {
			if (other.placeOfDispatchPY != null)
				return false;
		} else if (!placeOfDispatchPY.equals(other.placeOfDispatchPY))
			return false;
		if (receivingLand == null) {
			if (other.receivingLand != null)
				return false;
		} else if (!receivingLand.equals(other.receivingLand))
			return false;
		if (receivingLandPY == null) {
			if (other.receivingLandPY != null)
				return false;
		} else if (!receivingLandPY.equals(other.receivingLandPY))
			return false;
		if (secondHeavy == null) {
			if (other.secondHeavy != null)
				return false;
		} else if (!secondHeavy.equals(other.secondHeavy))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FreightCharge [freightId=" + freightId + ", placeOfDispatch=" + placeOfDispatch + ", receivingLand="
				+ receivingLand + ", firstHeavy=" + firstHeavy + ", secondHeavy=" + secondHeavy + ", placeOfDispatchPY="
				+ placeOfDispatchPY + ", receivingLandPY=" + receivingLandPY + "]";
	}

	
}
