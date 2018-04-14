package com.yidu.tencloud.bean.basis.busseting;
/**
 * Bus实体类
 * @author ZhangZhenhao
 * @since 2017/11/17
 */
public class Bus {
	
	private String busId;			//班车ID

	private String licenseNum;		//车牌号
	
	private String commonCarrier;	//承运商
	
	private String motorcycleType;	//车型
	
	private String empId;			//员工Id
	
	private Integer tControl;		//吨控
	
	private String circuitType;		//线路类型
	
	private String empName;	//关联员工表获取司机名
	
	private String fileName; //关联基础档案辅助表获取线路类型
	
	private String circuitName;	//线路名

	
	public Bus(String busId, String licenseNum, String commonCarrier, String motorcycleType, String empId,
			Integer tControl, String circuitType, String empName, String fileName, String circuitName) {
		super();
		this.busId = busId;
		this.licenseNum = licenseNum;
		this.commonCarrier = commonCarrier;
		this.motorcycleType = motorcycleType;
		this.empId = empId;
		this.tControl = tControl;
		this.circuitType = circuitType;
		this.empName = empName;
		this.fileName = fileName;
		this.circuitName = circuitName;
	}


	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", licenseNum=" + licenseNum + ", commonCarrier=" + commonCarrier
				+ ", motorcycleType=" + motorcycleType + ", empId=" + empId + ", tControl=" + tControl
				+ ", circuitType=" + circuitType + ", empName=" + empName + ", fileName=" + fileName + ", circuitName="
				+ circuitName + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busId == null) ? 0 : busId.hashCode());
		result = prime * result + ((circuitName == null) ? 0 : circuitName.hashCode());
		result = prime * result + ((circuitType == null) ? 0 : circuitType.hashCode());
		result = prime * result + ((commonCarrier == null) ? 0 : commonCarrier.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((licenseNum == null) ? 0 : licenseNum.hashCode());
		result = prime * result + ((motorcycleType == null) ? 0 : motorcycleType.hashCode());
		result = prime * result + ((tControl == null) ? 0 : tControl.hashCode());
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
		Bus other = (Bus) obj;
		if (busId == null) {
			if (other.busId != null)
				return false;
		} else if (!busId.equals(other.busId))
			return false;
		if (circuitName == null) {
			if (other.circuitName != null)
				return false;
		} else if (!circuitName.equals(other.circuitName))
			return false;
		if (circuitType == null) {
			if (other.circuitType != null)
				return false;
		} else if (!circuitType.equals(other.circuitType))
			return false;
		if (commonCarrier == null) {
			if (other.commonCarrier != null)
				return false;
		} else if (!commonCarrier.equals(other.commonCarrier))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (licenseNum == null) {
			if (other.licenseNum != null)
				return false;
		} else if (!licenseNum.equals(other.licenseNum))
			return false;
		if (motorcycleType == null) {
			if (other.motorcycleType != null)
				return false;
		} else if (!motorcycleType.equals(other.motorcycleType))
			return false;
		if (tControl == null) {
			if (other.tControl != null)
				return false;
		} else if (!tControl.equals(other.tControl))
			return false;
		return true;
	}


	public String getBusId() {
		return busId;
	}


	public void setBusId(String busId) {
		this.busId = busId;
	}


	public String getLicenseNum() {
		return licenseNum;
	}


	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}


	public String getCommonCarrier() {
		return commonCarrier;
	}


	public void setCommonCarrier(String commonCarrier) {
		this.commonCarrier = commonCarrier;
	}


	public String getMotorcycleType() {
		return motorcycleType;
	}


	public void setMotorcycleType(String motorcycleType) {
		this.motorcycleType = motorcycleType;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public Integer gettControl() {
		return tControl;
	}


	public void settControl(Integer tControl) {
		this.tControl = tControl;
	}


	public String getCircuitType() {
		return circuitType;
	}


	public void setCircuitType(String circuitType) {
		this.circuitType = circuitType;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getCircuitName() {
		return circuitName;
	}


	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}

	public Bus(){}
}
