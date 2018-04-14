package com.yidu.tencloud.bean.taketosend.returnGoods;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 刘艺钿
 *
 */
@Component
public class ApplyGoods implements Serializable{

	private static final long serialVersionUID = 1L;

	private String applicationId;  					
	private String applicationNo;					
	private String jobNo;					        
	private String cargoType;					    
	private String piecesNumber;					
	@Column(name="enrat")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date   enrat;					        
	private String receiver;					   
	private String invalidSign;					    
	private String returningUnit;					
	@Column(name="inputTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date   inputTime;					   
	private String inputUnit;					   
	private String entryPerson;					    
	private String acknowledgindUnit;			  
	private String verifier;					  
	private String status;					       
	private String statusGoogs;					    
	private String sign;					       
	private String handlingSuggestion;			    
	private String typeofRejection;					
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	public String getCargoType() {
		return cargoType;
	}
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	public String getPiecesNumber() {
		return piecesNumber;
	}
	public void setPiecesNumber(String piecesNumber) {
		this.piecesNumber = piecesNumber;
	}
	public Date getEnrat() {
		return enrat;
	}
	public void setEnrat(Date enrat) {
		this.enrat = enrat;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getInvalidSign() {
		return invalidSign;
	}
	public void setInvalidSign(String invalidSign) {
		this.invalidSign = invalidSign;
	}
	public String getReturningUnit() {
		return returningUnit;
	}
	public void setReturningUnit(String returningUnit) {
		this.returningUnit = returningUnit;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public String getInputUnit() {
		return inputUnit;
	}
	public void setInputUnit(String inputUnit) {
		this.inputUnit = inputUnit;
	}
	public String getEntryPerson() {
		return entryPerson;
	}
	public void setEntryPerson(String entryPerson) {
		this.entryPerson = entryPerson;
	}
	public String getAcknowledgindUnit() {
		return acknowledgindUnit;
	}
	public void setAcknowledgindUnit(String acknowledgindUnit) {
		this.acknowledgindUnit = acknowledgindUnit;
	}
	public String getVerifier() {
		return verifier;
	}
	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusGoogs() {
		return statusGoogs;
	}
	public void setStatusGoogs(String statusGoogs) {
		this.statusGoogs = statusGoogs;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getHandlingSuggestion() {
		return handlingSuggestion;
	}
	public void setHandlingSuggestion(String handlingSuggestion) {
		this.handlingSuggestion = handlingSuggestion;
	}
	public String getTypeofRejection() {
		return typeofRejection;
	}
	public void setTypeofRejection(String typeofRejection) {
		this.typeofRejection = typeofRejection;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ApplyGoods(String applicationId, String applicationNo, String jobNo, String cargoType, String piecesNumber,
			Date enrat, String receiver, String invalidSign, String returningUnit, Date inputTime, String inputUnit,
			String entryPerson, String acknowledgindUnit, String verifier, String status, String statusGoogs,
			String sign, String handlingSuggestion, String typeofRejection) {
		super();
		this.applicationId = applicationId;
		this.applicationNo = applicationNo;
		this.jobNo = jobNo;
		this.cargoType = cargoType;
		this.piecesNumber = piecesNumber;
		this.enrat = enrat;
		this.receiver = receiver;
		this.invalidSign = invalidSign;
		this.returningUnit = returningUnit;
		this.inputTime = inputTime;
		this.inputUnit = inputUnit;
		this.entryPerson = entryPerson;
		this.acknowledgindUnit = acknowledgindUnit;
		this.verifier = verifier;
		this.status = status;
		this.statusGoogs = statusGoogs;
		this.sign = sign;
		this.handlingSuggestion = handlingSuggestion;
		this.typeofRejection = typeofRejection;
	}
	@Override
	public String toString() {
		return "ApplyGoods [applicationId=" + applicationId + ", applicationNo=" + applicationNo + ", jobNo=" + jobNo
				+ ", cargoType=" + cargoType + ", piecesNumber=" + piecesNumber + ", enrat=" + enrat + ", receiver="
				+ receiver + ", invalidSign=" + invalidSign + ", returningUnit=" + returningUnit + ", inputTime="
				+ inputTime + ", inputUnit=" + inputUnit + ", entryPerson=" + entryPerson + ", acknowledgindUnit="
				+ acknowledgindUnit + ", verifier=" + verifier + ", status=" + status + ", statusGoogs=" + statusGoogs
				+ ", sign=" + sign + ", handlingSuggestion=" + handlingSuggestion + ", typeofRejection="
				+ typeofRejection + "]";
	}
	public ApplyGoods() {
		super();
	}

	
	
} 
