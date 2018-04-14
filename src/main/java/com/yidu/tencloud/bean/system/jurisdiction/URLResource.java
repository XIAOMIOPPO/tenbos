package com.yidu.tencloud.bean.system.jurisdiction;

import java.io.Serializable;
import java.util.List;

/**
 * 资源类
 * @author youngboy
 * @since 2017/11/5
 */
public class URLResource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5960699142979675947L;

	/**
	 * 资源id
	 */
	private String resourceId;
	
	/**
	 * 资源名
	 */
	private String resourceName;
	
	/**
	 * 资源码
	 */
	private String resourceCode;
	
	/**
	 * 资源地址
	 */
	private String resourceUrl;
	
	/**
	 * 资源类型
	 */
	private String resourceType;
	
	/**
	 * 父类资源id
	 */
	private String parentResId;
	
	/**
	 * 序号排序用
	 */
	private Integer rindex;
	
	
	/**
	 * 资源集合
	 */
	private List<URLResource> resList;
	
	
	/**
	 * 类型名
	 */
	private String fileName;
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getParentResId() {
		return parentResId;
	}

	public void setParentResId(String parentResId) {
		this.parentResId = parentResId;
	}

	public Integer getRindex() {
		return rindex;
	}

	public void setRindex(Integer rindex) {
		this.rindex = rindex;
	}

	public List<URLResource> getResList() {
		return resList;
	}

	public void setResList(List<URLResource> resList) {
		this.resList = resList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((parentResId == null) ? 0 : parentResId.hashCode());
		result = prime * result + ((resList == null) ? 0 : resList.hashCode());
		result = prime * result + ((resourceCode == null) ? 0 : resourceCode.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + ((resourceName == null) ? 0 : resourceName.hashCode());
		result = prime * result + ((resourceType == null) ? 0 : resourceType.hashCode());
		result = prime * result + ((resourceUrl == null) ? 0 : resourceUrl.hashCode());
		result = prime * result + ((rindex == null) ? 0 : rindex.hashCode());
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
		URLResource other = (URLResource) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (parentResId == null) {
			if (other.parentResId != null)
				return false;
		} else if (!parentResId.equals(other.parentResId))
			return false;
		if (resList == null) {
			if (other.resList != null)
				return false;
		} else if (!resList.equals(other.resList))
			return false;
		if (resourceCode == null) {
			if (other.resourceCode != null)
				return false;
		} else if (!resourceCode.equals(other.resourceCode))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (resourceName == null) {
			if (other.resourceName != null)
				return false;
		} else if (!resourceName.equals(other.resourceName))
			return false;
		if (resourceType == null) {
			if (other.resourceType != null)
				return false;
		} else if (!resourceType.equals(other.resourceType))
			return false;
		if (resourceUrl == null) {
			if (other.resourceUrl != null)
				return false;
		} else if (!resourceUrl.equals(other.resourceUrl))
			return false;
		if (rindex == null) {
			if (other.rindex != null)
				return false;
		} else if (!rindex.equals(other.rindex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "URLResource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceCode="
				+ resourceCode + ", resourceUrl=" + resourceUrl + ", resourceType=" + resourceType + ", parentResId="
				+ parentResId + ", rindex=" + rindex + ", resList=" + resList + ", fileName=" + fileName + "]";
	}

	

	
}
