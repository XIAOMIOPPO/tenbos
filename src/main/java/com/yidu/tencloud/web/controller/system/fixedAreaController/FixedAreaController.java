package com.yidu.tencloud.web.controller.system.fixedAreaController;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.fixedArea.FixedAreaClient;
import com.yidu.tencloud.bean.system.fixedArea.FixedAreaEmp;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.system.fixedAreaBiz.FixedAreaBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.Num;
import com.yidu.tencloud.util.ShiroUtil;
@RequestMapping("fixedArea")
@Controller
public class FixedAreaController {

	@Autowired
	private FixedAreaBiz fixedAreaBiz;

	public void setFixedAreaBiz(FixedAreaBiz fixedAreaBiz) {
		this.fixedAreaBiz = fixedAreaBiz;
	}
	
	@Autowired
	private EmpBiz empBiz;
	

    public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	/**
	 * 删除定区
	 * @param fixedAreaId 定区Id
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/deleteFixedArea")
	@ResponseBody
	public String deleteFixedArea(String[] fixedAreaId) throws Exception{
		return fixedAreaBiz.deleteFixedArea(fixedAreaId);
	}
	
	/**
	 * 删除定区职员
	 * @param empId 职员Id
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/deleteFixedAreaEmp")
	@ResponseBody
	public String deleteFixedAreaEmp(String[] empId) throws Exception{
		return fixedAreaBiz.deleteFixedAreaEmp(empId);
	}
	
	/**
	 * 删除定区客户
	 * @param empId 职员Id
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/deleteFixedAreaClient")
	@ResponseBody
	public String deleteFixedAreaClient(String[] clientId) throws Exception{
		return fixedAreaBiz.deleteFixedAreaClient(clientId);
	}
	
	/**
	 * 管理分区
	 * @param partitionId 分区Id
	 * @param fixedAreaId 定区Id
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/managePartition")
	@ResponseBody
	public String managePartition(String[] partitionId,String fixedAreaId) throws Exception{
		return fixedAreaBiz.managePartition(partitionId, fixedAreaId);
	}
	/**
	 * 管理分区
	 * @param partitionId 分区Id
	 * @param fixedAreaId 定区Id
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/managePar")
	@ResponseBody
	public String managePar(String[] partitionId,String fixedAreaId) throws Exception{
		return fixedAreaBiz.managePar(partitionId, fixedAreaId);
	}
	/**
	 * 修改分区
	 * @param partition 分区
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/updatePartition")
	@ResponseBody
	public String updatePartition(Partition partition) throws Exception{
		return fixedAreaBiz.updatePartition(partition);
	}
	/**
	 * 修改定区
	 * @param fixedArea 定区对象
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/updateFixedArea")
	@ResponseBody
	public String updateFixedArea(FixedArea fixedArea) throws Exception{
		return fixedAreaBiz.updateFixedArea(fixedArea);
	}
	
	
	/**
	 * 添加定区
	 * @param fixedArea 定区对象
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/addFixedArea")
	@ResponseBody
	public String addFixedArea(FixedArea fixedArea) throws Exception{
		return fixedAreaBiz.addFixedArea(fixedArea);
	}
	
	/**
	 * 添加定区职员
	 * @param fixedArea 定区对象
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/addFixedAreaEmp")
	@ResponseBody
	public String addFixedAreaEmp(String fixedAreaId,String[] empId) throws Exception{
		return fixedAreaBiz.addFixedAreaEmp(fixedAreaId, empId);
	}
	
	/**
	 * 添加定区客户
	 * @param fixedArea 定区对象
	 * @return 字符
	 * @throws Exception
	 */
	@RequestMapping("/addFixedAreaClient")
	@ResponseBody
	public String addFixedAreaClient(String fixedAreaId,String[] clientId) throws Exception{
		return fixedAreaBiz.addFixedAreaClient(fixedAreaId, clientId);
	}
	/**
	 * 定区分页
	 * @param pageNumber 页码
	 * @param pageSize   页面大小
	 * @param fixedArea 定区对象
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findFixedAreaPage")
	public @ResponseBody Map<String,Object> findFixedAreaPage(int pageNumber,int pageSize,FixedArea fixedArea)throws Exception{
		Map<String,Object> paramMap = new HashMap<String, Object>();
		
		
		String orgId = ShiroUtil.getUser().getOrgId();
		List<Organization> orgs = empBiz.findOrgByParentId(orgId);
		List<String> list = new ArrayList<>();
		for (Organization organization : orgs) {
			list.add(organization.getOrgId());
		}
		paramMap.put("orgList", list);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", fixedAreaBiz.findFixedAreaByPage(paramMap).size());
		
		paramMap.put("start",(pageNumber-1)*pageSize);
		paramMap.put("pageSize",pageSize);
		List<FixedArea> fixedAreaList = fixedAreaBiz.findFixedAreaByPageWithTerm(paramMap);
		map.put("rows", fixedAreaList);
		return map;
	}
	/**
	 * 模糊查询并分页
	 * @param pageNumber 页码
	 * @param pageSize   页面大小
	 * @param fixedArea  定区对象
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findFixedAreaPageByTerm")
	public @ResponseBody Map<String,Object> findFixedAreaPageByTerm(int pageNumber,int pageSize,FixedArea fixedArea)throws Exception{
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("start",(pageNumber-1)*pageSize);
		paramMap.put("pageSize",pageSize);
		paramMap.put("fixedAreaName", fixedArea.getFixedAreaName());
		paramMap.put("userName", fixedArea.getUserName());
		
		String orgId = ShiroUtil.getUser().getOrgId();
		List<Organization> orgs = empBiz.findOrgByParentId(orgId);
		List<String> list = new ArrayList<>();
		for (Organization organization : orgs) {
			list.add(organization.getOrgId());
		}
		paramMap.put("orgList", list);
		List<FixedArea> fixedAreaList = fixedAreaBiz.findFixedAreaByPageWithTerm(paramMap);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", fixedAreaBiz.count(paramMap));
		map.put("rows", fixedAreaList);
		return map;
	}
	/**
	 * 查找定区下的客户
	 * @param fixedAreaId 定区Id
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findClientByFixedArea")
	public @ResponseBody Map<String,Object> findClientByFixedArea(@RequestParam(required=true,value="fixedAreaId")String fixedAreaId)throws Exception{
		return fixedAreaBiz.findClientByFixedArea(fixedAreaId);
	}
	/**
	 * 找到此定区下的客户
	 * @param fixedAreaId 定区Id
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findClientNotInFixedArea")
	public @ResponseBody Map<String,Object> findClientNotInFixedArea(String fixedAreaId,String clientName)throws Exception{
		return fixedAreaBiz.findClientNotInFixedArea(fixedAreaId,clientName);
	}
	/**
	 * 查找定区下的分区
	 * @param fixedAreaId 定区Id
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findPartitionByFixedArea")
	public @ResponseBody Map<String,Object> findPartitionByFixedArea(@RequestParam(required=true,value="fixedAreaId")String fixedAreaId)throws Exception{
		return fixedAreaBiz.findPartitionByFixedArea(fixedAreaId);
	}
	
	/**
	 * 找到不在次定区的分区
	 * @param fixedAreaId 定区Id
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findPartitionNotInFixedArea")
	public @ResponseBody Map<String,Object> findPartitionNotInFixedArea(String fixedAreaId,String county)throws Exception{
		return fixedAreaBiz.findPartitionNotInFixedArea(fixedAreaId,county);
	}
	/**
	 * 查找定区下的职员
	 * @param fixedAreaId 定区Id
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findEmpByFixedArea")
	public @ResponseBody Map<String,Object> findEmpByFixedArea(@RequestParam(required=true,value="fixedAreaId")String fixedAreaId)throws Exception{
		return fixedAreaBiz.findEmpByFixedArea(fixedAreaId);
	}
	
	/**
	 * 找到不在此定区的职员
	 * @param fixedAreaId 定区Id
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping("/findEmpNotInFixedArea")
	public @ResponseBody Map<String,Object> findEmpNotInFixedArea(String empName)throws Exception{
		return fixedAreaBiz.findEmpNotInFixedArea(empName);
	}
	
	/**
	 * 查找用户Id
	 * @param userName 用户名
	 * @return 用户Id集合
	 * @throws Exception
	 */
	@RequestMapping("/findUserId")
	public @ResponseBody List<String> findUserId(String userName)throws Exception{
		return fixedAreaBiz.findUserId(userName);
	}
	/**
	 * 查找用户名
	 * @return 用户名集合
	 * @throws Exception
	 */
	@RequestMapping("/findUserName")
	public @ResponseBody List<String> findUserName()throws Exception{
		return fixedAreaBiz.findUserName();
	}
	
}
