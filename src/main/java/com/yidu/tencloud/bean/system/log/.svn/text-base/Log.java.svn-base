package com.yidu.tencloud.bean.system.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志实体类
 * @author 邓哲敏
 * @since 2017/11/2
 */
public class Log implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -9031892196499362519L;

	private String logId; // 日志Id
	private String userName; // 操作用户名
	private Date visitDate; // 访问时间
	private String visitResource; // 访问资源
	private String visitResult; // 访问结果

	/**
	 * 提供无参的构造方法
	 */
	public Log() {

	}

	/**
	 * 提供有参的构造方法
	 * @param logId 日志Id
	 * @param userName  操作用户名
	 * @param visitDate 访问时间
	 * @param visitResource 访问资源
	 * @param visitResult 访问结果
	 */
	public Log(String logId, String userName, Date visitDate, String visitResource, String visitResult) {
		super();
		this.logId = logId;
		this.userName = userName;
		this.visitDate = visitDate;
		this.visitResource = visitResource;
		this.visitResult = visitResult;
	}

	/**
	 * 获得日志Id
	 * @return 日志Id
	 */
	public String getLogId() {
		return logId;
	}

	/**
	 * 设置日志Id
	 * @param logId 日志Id
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}

	/**
	 * 获得操作用户名
	 * @return 操作用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置操作用户名
	 * @param userName 操作用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获得访问时间
	 * @return 访问时间
	 */
	public Date getVisitDate() {
		return visitDate;
	}

	/**
	 * 设置访问时间
	 * @param visitDate 访问时间
	 */
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	/**
	 * 获得访问资源
	 * @return 访问时间
	 */
	public String getVisitResource() {
		return visitResource;
	}

	/**
	 * 设置访问资源
	 * @param visitResource 访问资源
	 */
	public void setVisitResource(String visitResource) {
		this.visitResource = visitResource;
	}

	/**
	 * 获得访问结果
	 * @return 访问结果
	 */
	public String getVisitResult() {
		return visitResult;
	}

	/**
	 * 设置访问结果
	 * @param visitResult 访问结果
	 */
	public void setVisitResult(String visitResult) {
		this.visitResult = visitResult;
	}

	/**
	 * 遍历
	 */
	@Override
	public String toString() {
		return "Log [logId=" + logId + ", userName=" + userName + ", visitDate=" + visitDate + ", visitResource="
				+ visitResource + ", visitResult=" + visitResult + "]";
	}
	
}