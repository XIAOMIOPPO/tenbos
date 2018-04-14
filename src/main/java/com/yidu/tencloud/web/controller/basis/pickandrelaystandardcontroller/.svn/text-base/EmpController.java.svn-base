package com.yidu.tencloud.web.controller.basis.pickandrelaystandardcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.Num;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpBiz empBiz;

	public EmpBiz getEmpBiz() {
		return empBiz;
	}

	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}
	
	@RequestMapping(value="/findAllEmp.action",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findAllEmp(@RequestBody Map<?, ?> map) throws Exception{	
		Map<String, Object> empMap = new HashMap<String, Object>();
		Map<String, Object> paremMap = new HashMap<String, Object>();
        Integer limit=(Integer)map.get("limit");
        Integer offset=(Integer)map.get("offset");
		
		paremMap.put("offset", offset);
		paremMap.put("limit", limit);
		paremMap.put("orgList", empBiz.orgListToString());
		
		empMap.put("total", empBiz.findAllEmp().size());
		empMap.put("rows", empBiz.findEmpByPage(paremMap));
		return empMap;
	}
	
	@RequestMapping(value="/addEmp.action",method={RequestMethod.POST})
	public String addEmp(Emp emp) throws Exception{	
		emp.setEmpId(IDGenderatorUtil.generateId());
		emp.setDeliverId(empBiz.findDeliverIdByDeliverName(emp.getDeliverName()));
		emp.setOrgId(empBiz.findOrgIdByOrgName(emp.getOrgName()));
		emp.setFileId(empBiz.findFileIdByFileName(emp.getFileName()));
		emp.setDrawTimeId(empBiz.findDrawTimeIdByTimeName(emp.getTimeName()));
		emp.setIsUse("1");
		emp.setEmpNum(Num.creatNum(emp.getFileName()));
		boolean result = empBiz.addEmp(emp);
		if(result==true){
			return "redirect:/jsps/basis/emp/emp.jsp";
		}else{
			return "redirect:/jsps/basis/emp/emp.jsp";
		}

	}
	
	@RequestMapping(value="/findDeliverName.action")
	@ResponseBody
	public List<String> findDeliverName(){
		List<String> deliverNames = empBiz.findDeliverName();		
		return deliverNames;
	}
	
	@RequestMapping(value="/findDrawTimeName.action")
	@ResponseBody
	public List<String> findDrawTimeName(){
		List<String> drawTimeName = empBiz.findDrawTimeName();		
		return drawTimeName;
	}
	
	@RequestMapping(value="/findOrgName.action")
	@ResponseBody
	public List<String> findOrgName(){
		List<String> orgName = empBiz.findOrgName();		
		return orgName;
	}
	
	@RequestMapping(value="/findFileName.action")
	@ResponseBody
	public List<String> findFileName(){
		List<String> fileName = empBiz.findFileName();		
		return fileName;
	}
	
	@RequestMapping(value="/findEmpByConditionVague.action",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findEmpByConditionVague(@RequestBody Map<?, ?> map) throws Exception{
        Integer end=(Integer)map.get("limit") ;
        Integer start=(Integer)map.get("offset");
        String empName = (String) map.get("empName");
        String phoneNum = (String) map.get("phoneNum");
        String orgName = (String) map.get("orgName");
        String deliverName = (String) map.get("deliverName");
        String timeName = (String) map.get("timeName");
        String fileName = (String) map.get("fileName");
        List<Emp> emps = empBiz.findEmpByConditionVague(start, end, empName, phoneNum, orgName, deliverName, timeName, fileName);
        Map<String, Object> empMap = new HashMap<String, Object>();
        empMap.put("total", empBiz.findAllEmp().size());
        empMap.put("rows", emps);
		return empMap;	
	}
	
	
	@RequestMapping("/deleteEmp.action")
	@ResponseBody
	public String deleteEmp(String[] empId) throws Exception{
		Boolean result = false;
		for(String empID : empId){
			System.out.println(empID);
			result = empBiz.deleteEmp(empID);
		}
		if(result) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("/findEmpByEmpId.action")
	@ResponseBody
	public Emp findEmpByEmpId(String empId)throws Exception{
		Emp emp = empBiz.findEmpByEmpId(empId);
		return emp;
	}
	
	
	@RequestMapping(value="/updateEmp.action",method={RequestMethod.POST})
	@ResponseBody
	public String updateEmp(Emp emp) throws Exception{
		boolean result = empBiz.updateEmp(
				emp.getEmpNum(),
				emp.getEmpPassword(), 
				emp.getPhoneNum(), 
				emp.getIsPDA(), 
				emp.getOrgName(), 
				emp.getDeliverName(), 
				emp.getTimeName(), 
				emp.getFileName(), 
				empBiz.findOrgIdByOrgName(emp.getOrgName()), 
				empBiz.findDeliverIdByDeliverName(emp.getDeliverName()), 
				empBiz.findDrawTimeIdByTimeName(emp.getTimeName()), 
				empBiz.findFileIdByFileName(emp.getFileName()), 
				emp.getEmpId());
		if(result) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	
	
	@RequestMapping(value="/findAllEmp1.action",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findAllEmp1(@RequestBody Map<?, ?> map) throws Exception{	
		Map<String, Object> empMap = new HashMap<String, Object>();
		Map<String, Integer> paremMap = new HashMap<String, Integer>();
        Integer limit=(Integer)map.get("limit");
        Integer offset=(Integer)map.get("offset");
		
		paremMap.put("offset", offset);
		paremMap.put("limit", limit);
		
		empMap.put("total", empBiz.findAllEmp1().size());
		empMap.put("rows", empBiz.findEmpByPage1(paremMap));
		return empMap;
	}
	
}
