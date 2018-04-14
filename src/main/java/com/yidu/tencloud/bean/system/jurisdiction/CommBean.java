package com.yidu.tencloud.bean.system.jurisdiction;

/**
 * 权限通用bean
 * @author youngboy
 * @since 2017/12/19
 */
public class CommBean {

	/**
	 * 主键
	 */
	private String primaryId;
	
	/**
	 * 第一个id
	 */
	private String beanId;

	/**
	 * 第二个id
	 */
	private String obeanId;

	
	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public String getObeanId() {
		return obeanId;
	}

	public void setObeanId(String obeanId) {
		this.obeanId = obeanId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanId == null) ? 0 : beanId.hashCode());
		result = prime * result + ((obeanId == null) ? 0 : obeanId.hashCode());
		result = prime * result + ((primaryId == null) ? 0 : primaryId.hashCode());
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
		CommBean other = (CommBean) obj;
		if (beanId == null) {
			if (other.beanId != null)
				return false;
		} else if (!beanId.equals(other.beanId))
			return false;
		if (obeanId == null) {
			if (other.obeanId != null)
				return false;
		} else if (!obeanId.equals(other.obeanId))
			return false;
		if (primaryId == null) {
			if (other.primaryId != null)
				return false;
		} else if (!primaryId.equals(other.primaryId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommBean [primaryId=" + primaryId + ", beanId=" + beanId + ", obeanId=" + obeanId + "]";
	}
	
	
	
	
}
