package com.yidu.tencloud.biz.system.fixedAreaBiz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.system.fixedAreaBiz.FixedAreaBiz;
import com.yidu.tencloud.dao.system.fixedAreaDao.FixedAreaMapper;
import com.yidu.tencloud.util.FixedAreaNum;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.Num;
import com.yidu.tencloud.util.ShiroUtil;
/**
 * 定区实现类
 * @author 陈涛
 *
 */
@Service
public class FixedAreaBizImpl implements FixedAreaBiz{

	/**
	 * 引用dao层
	 */
	@Autowired
	private FixedAreaMapper fixedAreaMapper;
	/**
	 * 给dao赋值
	 * @param fixedAreaMapper
	 */
	public void setFixedAreaMapper(FixedAreaMapper fixedAreaMapper) {
		this.fixedAreaMapper = fixedAreaMapper;
	}
	@Autowired
	private EmpBiz empBiz;
	

    public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	/**
     * 添加定区
     */
	@Override
	public String addFixedArea(FixedArea fixedArea) {
		Map<String,Object> param= new HashMap<String,Object>();
		param.put("fixedAreaName", fixedArea.getFixedAreaName());
		String fixedAreaName = fixedArea.getFixedAreaName();
		String fANNum = Num.creatPY(fixedAreaName);
		String fAN = UUID.randomUUID().toString().
				replace("-", "").toUpperCase().substring(0, 16-fANNum.length());
		param.put("fixedAreaNum", fANNum+fAN);
		param.put("fixedAreaId", IDGenderatorUtil.generateId());
		param.put("userId", fixedArea.getUserId());
		param.put("userName", fixedArea.getUserName());
		param.put("status", "0");
		if(fixedAreaMapper.addFixedArea(param)==1){
			return "success";
		}else {
			return "fail";
		}
	}
	
	/**
     * 添加定区职员
     */
	@Override
	public String addFixedAreaEmp(String fixedAreaId,String[] empId) {
		Map<String,Object> param= new HashMap<String,Object>();
		int result = 0;
		for(String eId : empId) {
		  param.put("fixedAreaId", fixedAreaId);
		  param.put("empId", eId);
		  result=fixedAreaMapper.addFixedAreaEmp(param);
		}
		if(result==1){
			return "success";
		}else {
			return "fail";
		}
	}
	
	/**
     * 添加定区客户
     */
	@Override
	public String addFixedAreaClient(String fixedAreaId,String[] clientId) {
		Map<String,Object> param= new HashMap<String,Object>();
		int result = 0;
		for(String cId : clientId) {
		  param.put("fixedAreaId", fixedAreaId);
		  param.put("clientId", cId);
		  result=fixedAreaMapper.addFixedAreaClient(param);
		}
		if(result==1){
			return "success";
		}else {
			return "fail";
		}
	}

	/**
	 * 删除定区
	 */
	@Override
	public String deleteFixedArea(String[] fixedAreaId) {
		FixedArea fixedArea = new FixedArea();
		int result = 0;
		for(String areaId : fixedAreaId) {
			fixedArea.setFixedAreaId(areaId);
			fixedArea.setStatus("1");
			result = fixedAreaMapper.deleteFixedArea(fixedArea);
		}
		if(result==1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	/**
	 * 删除定区职员
	 */
	@Override
	public String deleteFixedAreaEmp(String[] empId) {
		int result = 0;
		for(String eId : empId) {
			 result = fixedAreaMapper.deleteFixedAreaEmp(eId);
		}
		if(result==1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	/**
	 * 删除定区客户
	 */
	@Override
	public String deleteFixedAreaClient(String[] clientId) {
		int result = 0;
		for(String cId : clientId) {
			 result = fixedAreaMapper.deleteFixedAreaClient(cId);
		}
		if(result==1) {
			return "success";
		}else {
			return "fail";
		}
	}


	/**
	 * 模糊查询并分页
	 */
	@Override
	public List<FixedArea> findFixedAreaByPageWithTerm(Map<String, Object> paramMap) {
		return fixedAreaMapper.findFixedAreaByPageWithTerm(paramMap);
	}
	
	@Override
	public List<FixedArea> findFixedAreaByPage(Map<String, Object> paramMap) {
		return fixedAreaMapper.findFixedAreaByPage(paramMap);
	}

	/**
	 * 统计记录数
	 */
	@Override
	public int count(Map<String,Object> paramMap) {
		return fixedAreaMapper.count(paramMap);
	}

    /**
     * 修改定区
     */
	@Override
	public String updateFixedArea(FixedArea fixedArea) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("fixedAreaName", fixedArea.getFixedAreaName());
		param.put("fixedAreaNum", fixedArea.getFixedAreaNum());
		param.put("fixedAreaId", fixedArea.getFixedAreaId());
		if(fixedAreaMapper.updateFixedArea(param)==1){
			return "success";
		}else {
			return "fail";
		}
	}
	
	/**
     * 修改定区编号
     */
	@Override
	public boolean updateFixedAreaNum(Map<String, Object> param) {
		if(fixedAreaMapper.updateFixedAreaNum(param)==1){
			return true;
		}
		return false;
	}


	/**
	 * 根据定区Id查询客户
	 */
	@Override
	public Map<String,Object> findClientByFixedArea(String fixedAreaId) {
		List<Client> clientList = fixedAreaMapper.findClientByFixedArea(fixedAreaId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",fixedAreaMapper.findClientByFixedArea(fixedAreaId).size());
		map.put("rows", clientList);
		return map;
	}
	
	/**
	 * 找到不在此定区的客户
	 */
	@Override
	public Map<String,Object> findClientNotInFixedArea(String fixedAreaId,String clientName) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("fixedAreaId", fixedAreaId);
		param.put("clientName", clientName);
		List<Client> clientList = fixedAreaMapper.findClientNotInFixedArea(param);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",fixedAreaMapper.findClientNotInFixedArea(param).size());
		map.put("rows", clientList);
		return map;
	}


	/**
	 * 根据定区Id查询分区
	 */
	@Override
	public Map<String,Object> findPartitionByFixedArea(String fixedAreaId) {
		List<Partition> partitionList = fixedAreaMapper.findPartitionByFixedArea(fixedAreaId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",fixedAreaMapper.findPartitionByFixedArea(fixedAreaId).size());
		map.put("rows", partitionList);
		return map;
	}
	
	/**
	 * 找到不在此定区的分区
	 */
	@Override
	public Map<String,Object> findPartitionNotInFixedArea(String fixedAreaId,String addressKey) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("fixedAreaId", fixedAreaId);
		param.put("addressKey", addressKey);
		List<Partition> partitionList = fixedAreaMapper.findPartitionNotInFixedArea(param);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",fixedAreaMapper.findPartitionNotInFixedArea(param).size());
		map.put("rows", partitionList);
		return map;
	}


	/**
	 * 根据定区Id查询职员
	 */
	@Override
	public Map<String,Object> findEmpByFixedArea(String fixedAreaId) {
		List<Emp> empList = fixedAreaMapper.findEmpByFixedArea(fixedAreaId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",fixedAreaMapper.findEmpByFixedArea(fixedAreaId).size());
		map.put("rows", empList);
		return map;
	}
	
	/**
	 * 找到不在此定区的职员
	 */
	@Override
	public Map<String,Object> findEmpNotInFixedArea(String empName) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("empName", empName);
		param.put("orgList", empBiz.orgListToString());
		List<Emp> empList = fixedAreaMapper.findEmpNotInFixedArea(param);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total",fixedAreaMapper.findEmpNotInFixedArea(param).size());
		map.put("rows", empList);
		return map;
	}

	/**
	 * 查询用户Id集合
	 */
	@Override
	public List<String> findUserId(String userName) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userName", userName);
		List<String> userList = fixedAreaMapper.findUserId(param);
		return userList;
	}
	/**
	 * 查询用户名集合
	 */
	@Override
	public List<String> findUserName() {
		String orgId = ShiroUtil.getUser().getOrgId();
		List<Organization> orgs = empBiz.findOrgByParentId(orgId);
		List<String> list = new ArrayList<>();
		for (Organization organization : orgs) {
			list.add(organization.getOrgId());
		}
		List<String> userNameList = fixedAreaMapper.findUserName(list);
		return userNameList;
	}


	/**
	 * 修改分区
	 */
	@Override
	public String updatePartition(Partition partition) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("partitionId", partition.getPartitionId());
		param.put("fixedAreaId", partition.getFixedAreaId());
		if(fixedAreaMapper.updatePartition(param)==1){
			return "success";
		}else {
			return "fail";
		}
		
	}

	/**
	 * 管理分区  传出
	 */
	@Override
	public String managePar(String[] partitionId, String fixedAreaId) {
		Map<String,Object> param = new HashMap<String,Object>();
		int result1 = 0;
		int result = 0;
		for(String pId : partitionId) {
			param.put("partitionId", pId);
			param.put("fixedAreaId", null);
			result = fixedAreaMapper.updatePartition(param);
		}
		List<Partition> partitionList = fixedAreaMapper.findPartitionByFixedArea(fixedAreaId);
		result1 = fixedAreaMapper.updateFixedAreaNum(FixedAreaNum.createFN(partitionList, fixedAreaId));
		if(result==1 && result1==1) {
			return "success";
		}else {
			return "fail";
		}
	}

	/**
	 * 管理分区 传入
	 */
	@Override
	public String managePartition(String[] partitionId, String fixedAreaId) {
        Map<String,Object> param = new HashMap<String,Object>();
		int result = 0;
		int result1 = 0;
		for(String pId : partitionId) {
			param.put("fixedAreaId", fixedAreaId);
			param.put("partitionId", pId);
			result = fixedAreaMapper.updatePartition(param);
		}
		List<Partition> partitionList = fixedAreaMapper.findPartitionByFixedArea(fixedAreaId);
		result1 = fixedAreaMapper.updateFixedAreaNum(FixedAreaNum.createFN(partitionList, fixedAreaId));
		if(result==1 && result1==1) {
			return "success";
		}else {
			return "fail";
		}
	}


	

}
