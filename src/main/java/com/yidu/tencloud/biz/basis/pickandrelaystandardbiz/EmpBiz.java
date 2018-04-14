package com.yidu.tencloud.biz.basis.pickandrelaystandardbiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.organizationchart.Organization;

public interface EmpBiz {
	
	public List<Emp> findAllEmp();
	
	public List<Emp> findAllEmp1();
	
	public boolean addEmp(Emp emp);
	
	public List<Emp> findEmpByPage(Map<String, Object> paremMap);
	
	public List<Emp> findEmpByPage1(Map<String, Integer> paremMap);
	
	/**
	 * 根据部门名字查询部门ID
	 * @param orgName 部门名
	 * @return  部门ID
	 */
	public String findOrgIdByOrgName(String orgName); 
	
	/**
	 * 根据收派标准找名字ID
	 * @param deliverName 收派标准名
	 * @return 收派标准ID
	 */
	public String findDeliverIdByDeliverName(String deliverName);
	
	/**
	 * 根据收派时间名字查询收派时间ID
	 * @param timeName 收派时间名字
	 * @return 收派时间ID
	 */
	public String findDrawTimeIdByTimeName(String timeName);
	
	/**
	 * 根据辅助档案名查询辅助档案ID
	 * @param fileName辅助档案名字
	 * @return 辅助档案ID
	 */
	public String findFileIdByFileName(String fileName);
	
	/**
	 * 根据部门ID查询部门名字
	 * @return 部门名
	 */
	public List<String> findOrgName();
	
	/**
	 * 根据收派标准名查询收派标准ID
	 * @return deliverName
	 */
	public List<String> findDeliverName();
	
	/**
	 * 根据收派时间名查询收派时间Id
	 * @return 收派时间Id
	 */
	public List<String> findDrawTimeName();
	
	/**
	 * 根据辅助档案名查询辅助档案Id
	 * @param fileId 辅助档案Id
	 * @return 辅助档案名
	 */
	public List<String> findFileName();
	
	/**
	 * 条件模糊查询
	 * @param paremMap 条件查询参数集合
	 * @return 查询到的职员集合
	 */
	public List<Emp> findEmpByConditionVague(Integer start, Integer end, String empName,String 
			phoneNum,String orgName ,String deliverName,String timeName,String fileName);
	
	/**
	 * 根据职员Id删除职员
	 * @param empId 职员Id
	 * @return 是否成功
	 */
	public boolean deleteEmp(String empId);
	
	/**
	 * 根据职员Id查询职员
	 * @param empId  职员Id
	 * @return 查询到的职员
	 */
	public Emp findEmpByEmpId(String empId);
	
	/**
	 * 根据职员Id修改职员信息
	 * @param param 要修改的职员信息集合
	 * @return 成功返回true 失败返回false
	 */
	public boolean updateEmp(String empNum, String empPassword,String phoneNum,String isPDA,
			String orgName ,String deliverName,String timeName,String fileName,
			String orgId,String deliverId,String drawTimeId,String fileId,
			String empId);
	
	/**
	 * 根据父类Id查询部门
	 * @param orgId 父类Id
	 * @return 
	 */
	public List<Organization> findOrgByParentId(String orgId);
	
	public List<String> orgListToString();
}
