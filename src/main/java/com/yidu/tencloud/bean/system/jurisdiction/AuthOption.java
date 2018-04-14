package com.yidu.tencloud.bean.system.jurisdiction;

/**
 * 权限通用bean
 * @author youngboy
 * @since 2017/12/19
 */
public class AuthOption {

	/**
	 * 记录id
	 */
	private String fileId;
	
	/**
	 * 记录名
	 */
	private String recordName;

	
	/**
	 * 获取记录id
	 * @return 记录id
	 */
	public String getFileId() {
		return fileId;
	}

	/**
	 * 设置记录id
	 * @param fileId 记录id
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * 获取记录名
	 * @return 记录名
	 */
	public String getRecordName() {
		return recordName;
	}

	/**
	 * 设置记录名
	 * @param recordName 记录名
	 */
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	
	
	
}
