package com.yidu.tencloud.bean.system.user;

import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */


public class User implements Serializable{
	
	private static final long serialVersionUID = 4500009104324744791L;

	private String userId;
	private String userName;
	private String pwd;
	private String age;
	private String sex;
	private String phoneNum;
	private String orgId;
	private String isUse;
	private String orgName;
	private String fileName;
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPwd() {
		return pwd;
	}
	public String getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getOrgId() {
		return orgId;
	}
	public String getIsUse() {
		return isUse;
	}
	public String getOrgName() {
		return orgName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", pwd=" + pwd + ", age=" + age + ", sex=" + sex
				+ ", phoneNum=" + phoneNum + ", orgId=" + orgId + ", isUse=" + isUse + ", orgName=" + orgName
				+ ", fileName=" + fileName + "]";
	}
	
	

}
