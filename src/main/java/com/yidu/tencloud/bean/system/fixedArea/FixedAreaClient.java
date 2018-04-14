package com.yidu.tencloud.bean.system.fixedArea;

import java.io.Serializable;
/**
 * 定区客户实体类
 * @author 陈涛
 *
 */
public class FixedAreaClient implements Serializable{

	/**
	 * 定区Id
	 */
	private String fixedAreaId;
	/**
	 * 定区名
	 */
	private String fixedAreaName;
	/**
	 * 客户Id
	 */
	private String clientId;
	/**
	 * 客户名
	 */
	private String clientName;
	/**
	 * 无参数的构造方法
	 */
	public FixedAreaClient() {}

	/**
	 * 构造方法
	 * @param fixedAreaId   定区Id
 	 * @param fixedAreaName 定区名称
	 * @param clientId  客户Id
	 * @param clientName 客户名
	 */
	public FixedAreaClient(String fixedAreaId, String fixedAreaName, String clientId, String clientName) {
		super();
		this.fixedAreaId = fixedAreaId;
		this.fixedAreaName = fixedAreaName;
		this.clientId = clientId;
		this.clientName = clientName;
	}

	public String getFixedAreaId() {
		return fixedAreaId;
	}

	public void setFixedAreaId(String fixedAreaId) {
		this.fixedAreaId = fixedAreaId;
	}

	public String getFixedAreaName() {
		return fixedAreaName;
	}

	public void setFixedAreaName(String fixedAreaName) {
		this.fixedAreaName = fixedAreaName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "FixedAreaClient [fixedAreaId=" + fixedAreaId + ", fixedAreaName=" + fixedAreaName + ", clientId="
				+ clientId + ", clientName=" + clientName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((fixedAreaId == null) ? 0 : fixedAreaId.hashCode());
		result = prime * result + ((fixedAreaName == null) ? 0 : fixedAreaName.hashCode());
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
		FixedAreaClient other = (FixedAreaClient) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (fixedAreaId == null) {
			if (other.fixedAreaId != null)
				return false;
		} else if (!fixedAreaId.equals(other.fixedAreaId))
			return false;
		if (fixedAreaName == null) {
			if (other.fixedAreaName != null)
				return false;
		} else if (!fixedAreaName.equals(other.fixedAreaName))
			return false;
		return true;
	};
	
	
}
