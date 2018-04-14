package com.yidu.tencloud.bean.system.fixedArea;

import java.io.Serializable;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
/**
 * 定区实体类
 * @author 陈涛
 *
 */
public class FixedArea implements Serializable{

	/**
	 * 定区Id
	 */
	private String fixedAreaId;
	/**
	 * 定区名
	 */
	private String fixedAreaName;
	/**
	 * 定区编码
	 */
	private String fixedAreaNum;
	/**
	 * 用户Id
	 */
	private String userId;
	/**
	 * 用户负责人
	 */
	private String userName;
	
	private String status;
	/**
	 * 无参数的构造方法
	 */
	public FixedArea() {}
	public FixedArea(String fixedAreaId, String fixedAreaName, String fixedAreaNum, String userId, String userName,
			String status) {
		super();
		this.fixedAreaId = fixedAreaId;
		this.fixedAreaName = fixedAreaName;
		this.fixedAreaNum = fixedAreaNum;
		this.userId = userId;
		this.userName = userName;
		this.status = status;
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
	public String getFixedAreaNum() {
		return fixedAreaNum;
	}
	public void setFixedAreaNum(String fixedAreaNum) {
		this.fixedAreaNum = fixedAreaNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FixedArea [fixedAreaId=" + fixedAreaId + ", fixedAreaName=" + fixedAreaName + ", fixedAreaNum="
				+ fixedAreaNum + ", userId=" + userId + ", userName=" + userName + ", status=" + status + "]";
	}
	
	
}
