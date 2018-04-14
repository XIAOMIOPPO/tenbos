package com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.dao.basis.pickandrelaystandard.EmpMapper;
import com.yidu.tencloud.util.ShiroUtil;

@Service
public class EmpBizImpl implements EmpBiz {
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<Emp> findAllEmp() {
		// 直接返回查询到的职员集合，无论是不是空
		return empMapper.findAllEmp(orgListToString());
	}
	
	@Override
	public List<Emp> findAllEmp1() {
		// 直接返回查询到的职员集合，无论是不是空
		return empMapper.findAllEmp1();
	}

	@Override
	public boolean addEmp(Emp emp) {
		int result = empMapper.addEmp(emp);
		if (result < 1) {
			return false;
		} else {
			return true;
		}
	}

	public EmpMapper getEmpMapper() {
		return empMapper;
	}

	public void setEmpMapper(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	@Override
	public List<Emp> findEmpByPage(Map<String, Object> paremMap) {
		return empMapper.findEmpByPage(paremMap);
	}
	
	@Override
	public List<Emp> findEmpByPage1(Map<String, Integer> paremMap) {
		return empMapper.findEmpByPage1(paremMap);
	}

	@Override
	public String findOrgIdByOrgName(String orgName) {
		return empMapper.findOrgIdByOrgName(orgName);
	}

	@Override
	public String findDeliverIdByDeliverName(String deliverName) {
		return empMapper.findDeliverIdByDeliverName(deliverName);
	}

	@Override
	public String findDrawTimeIdByTimeName(String timeName) {
		return empMapper.findDrawTimeIdByTimeName(timeName);
	}

	@Override
	public String findFileIdByFileName(String fileName) {
		return empMapper.findFileIdByFileName(fileName);
	}

	@Override
	public List<Emp> findEmpByConditionVague(Integer start, Integer end, String empName, String phoneNum,
			String orgName, String deliverName, String timeName, String fileName) {
		Map<String, Object> paramCriteriaMap = new HashMap<String, Object>();
		paramCriteriaMap.put("start", start);
		paramCriteriaMap.put("end", end);
		paramCriteriaMap.put("empName", empName);
		paramCriteriaMap.put("phoneNum", phoneNum);
		paramCriteriaMap.put("orgName", orgName);
		paramCriteriaMap.put("deliverName", deliverName);
		paramCriteriaMap.put("timeName", timeName);
		paramCriteriaMap.put("fileName", fileName);
		paramCriteriaMap.put("orgList", orgListToString());
		return empMapper.findEmpByConditionVague(paramCriteriaMap);
	}

	@Override
	public boolean deleteEmp(String empId) {
		if(empMapper.delEmp(empId) == 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<String> findOrgName() {
		return empMapper.findAllOrgName();
	}

	@Override
	public List<String> findDeliverName() {
		return empMapper.findAllDeliverName();
	}

	@Override
	public List<String> findDrawTimeName() {
		return empMapper.findAllDrawTimeName();
	}

	@Override
	public List<String> findFileName() {
		return empMapper.findAllFileName();
	}

	@Override
	public Emp findEmpByEmpId(String empId) {
		return empMapper.findEmpByEmpId(empId);
	}

	@Override
	public boolean updateEmp(String empNum, String empPassword, String phoneNum, String isPDA, String orgName, String deliverName,
			String timeName, String fileName, String orgId, String deliverId, String drawTimeId, String fileId,
			String empId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("empNum", empNum);
		paramMap.put("empPassword", empPassword);
		paramMap.put("phoneNum", phoneNum);
		paramMap.put("isPDA", isPDA);
		paramMap.put("orgName", orgName);
		paramMap.put("deliverName", deliverName);
		paramMap.put("timeName", timeName);
		paramMap.put("fileName", fileName);
		paramMap.put("orgId", orgId);
		paramMap.put("drawTimeId", drawTimeId);
		paramMap.put("deliverId", deliverId);
		paramMap.put("fileId", fileId);
		paramMap.put("empId", empId);
		
		if(empMapper.updateEmp(paramMap) == 1 ){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<Organization> findOrgByParentId(String orgId) {
		List<Organization> orgList = new ArrayList<>();
		createTreeByOrg(orgId,orgList);
		orgList.add(empMapper.findOrgByOrgId(orgId));
		return orgList;
	}

	private void createTreeByOrg(String orgId,List<Organization> orgList) {
		List<Organization> organizations = empMapper.findOrgByParentId(orgId);
		for (Organization organization : organizations) {
			createTreeByOrg(organization.getOrgId(),orgList);
			orgList.add(organization);
		}
	}


	public List<String> orgListToString(){
		String orgId = ShiroUtil.getUser().getOrgId();
		List<Organization> list = findOrgByParentId(orgId);
		List<String> orgList = new ArrayList<>();
		for (Organization organization : list) {
			orgList.add(organization.getOrgName());
		}
		return orgList;
	}




}
