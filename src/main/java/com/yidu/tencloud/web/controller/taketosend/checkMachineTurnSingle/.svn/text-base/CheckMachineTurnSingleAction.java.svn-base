package com.yidu.tencloud.web.controller.taketosend.checkMachineTurnSingle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.jurisdiction.ResDto;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle.CheckMachineTurnSingle;
import com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle.OldWorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.biz.taketosend.checkMachineTurnSinglebiz.impl.CheckMachineTurnSingleService;

/**
 * 查台转单控制器
 * @author 64429
 *
 */
@Controller
@RequestMapping("/cmts")
public class CheckMachineTurnSingleAction {

	@Autowired
	private CheckMachineTurnSingleService checkMachineTurnSingleService;

	public CheckMachineTurnSingleService getCheckMachineTurnSingleService() {
		return checkMachineTurnSingleService;
	}

	public void setCheckMachineTurnSingleService(CheckMachineTurnSingleService checkMachineTurnSingleService) {
		this.checkMachineTurnSingleService = checkMachineTurnSingleService;
	}
	
	/**
	 * 查台
	 * @param empNum 员工号
	 * @param empPassword 密码
	 * @param noteNum 短息序号
	 * @param businessRecsiptNo 通知单号
	 * @param workOrderTime 工单生成时间
	 * @return 绑定到前端的数据参数map
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String empNum, String empPassword, String noteNum, String businessRecsiptNo,
			String workOrderTime) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, String> empMap = new HashMap<String, String>();
		Map<String, Object> ckMap = new HashMap<String, Object>();
		empMap.put("empNum", empNum);
		empMap.put("empPassword", empPassword);
		ckMap.put("empNum", empNum);
		ckMap.put("noteNum", noteNum);
		ckMap.put("businessRecsiptNo", businessRecsiptNo);
		ckMap.put("workOrderTime", workOrderTime);
		if (empPassword == null || "".equals(empPassword)) {
			if (checkMachineTurnSingleService.find(ckMap).size() == 0) {
				paramMap.put("status", 3);
			} else {
				List<CheckMachineTurnSingle> cmtsList = checkMachineTurnSingleService.find(ckMap);
				paramMap.put("total", cmtsList.size());
				paramMap.put("rows", cmtsList);
				paramMap.put("status", 2);
			}
		} else if (empPassword != null || !("".equals(empPassword))) {
			if (checkMachineTurnSingleService.findEmpByEmpNumAndPwd(empMap) != null) {
				if (checkMachineTurnSingleService.find(ckMap).size() == 0) {
					paramMap.put("status", 3);
				} else {
					List<CheckMachineTurnSingle> cmtsList = checkMachineTurnSingleService.find(ckMap);
					paramMap.put("total", cmtsList.size());
					paramMap.put("rows", cmtsList);
					paramMap.put("status", 1);
				}
			} else {
				paramMap.put("status", 0);
			}
		}

		return paramMap;
	}

	/**
	 * 转单
	 * @param oldWorkOrderNo 工单号(销工单)
	 * @param oldWorkOrderType 工单类型(销工单)
	 * @param oldWstatus 工单状态(销工单)
	 * @param oldNoteNum 短信序号(销工单)
	 * @param oldWorkOrderTime 工单生成时间(销工单)
	 * @param oldTraceNum 追单次数(销工单)
	 * @param oldEmpNum 员工号(销工单)
	 * @param oldTakeOrgName 取件单位(销工单)
	 * @param oldTakeTime 取件时间(销工单)
	 * @param oldSortingCode 分拣编码(销工单)
	 * @param sortingCode 分拣编码
	 * @param empNum 员工号
	 * @param takeOrgName 取件单位
	 * @return 绑定到前端的数据参数map
	 */
	@RequestMapping("/turnTheSingle")
	@ResponseBody
	public Map<String, Object> turnTheSingle(String oldWorkOrderNo, String oldWorkOrderType, String oldWstatus,
			String oldNoteNum, String oldWorkOrderTime, String oldTraceNum, String oldEmpNum, String oldTakeOrgName,
			String oldTakeTime, String oldSortingCode, String sortingCode, String empNum,
			String takeOrgName) {
		Map<String, Object> upMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		OldWorkOrder oldWorkOrder = new OldWorkOrder(oldWorkOrderNo, oldWorkOrderType, oldWstatus, oldNoteNum,
				oldWorkOrderTime, oldTraceNum, oldEmpNum, oldTakeOrgName, oldTakeTime, oldSortingCode);
		
		
		if((empNum == null || "".equals(empNum)) && (sortingCode == null || "".equals(sortingCode))) {
			upMap.put("sortingCode", sortingCode);
			upMap.put("empNum", empNum);
			upMap.put("empId", "");
			upMap.put("empName", "");
			upMap.put("takeOrgName", takeOrgName);
			upMap.put("workOrderNo", oldWorkOrderNo);
			if (checkMachineTurnSingleService.addOldWorkOrder(oldWorkOrder) == 1
					&& checkMachineTurnSingleService.updateWorkOrder(upMap) == 1) {
				paramMap.put("status", "1");
			} else {
				paramMap.put("status", "0");
			}
		}else if((sortingCode == null || "".equals(sortingCode)) && (takeOrgName == null || "".equals(takeOrgName))) {
			Emp emp = checkMachineTurnSingleService.findEmpByEmpNum(empNum);
			System.out.println(1);
			System.out.println(emp);
			String empId = emp.getEmpId();
			String empName = emp.getEmpName();
			upMap.put("sortingCode", sortingCode);
			upMap.put("empNum", empNum);
			upMap.put("empId", empId);
			upMap.put("empName", empName);
			upMap.put("takeOrgName", emp.getOrgName());
			upMap.put("workOrderNo", oldWorkOrderNo);
			if (checkMachineTurnSingleService.updateWorkOrder(upMap) == 1) {
				paramMap.put("status", "1");
			} else {
				paramMap.put("status", "0");
			}
		}else if((empNum == null || "".equals(empNum)) && (takeOrgName == null || "".equals(takeOrgName))) {
			upMap.put("sortingCode", sortingCode);
			upMap.put("empNum", empNum);
			upMap.put("empId", "");
			upMap.put("empName", "");
			upMap.put("takeOrgName", takeOrgName);
			upMap.put("workOrderNo", oldWorkOrderNo);
			if (checkMachineTurnSingleService.updateWorkOrder(upMap) == 1) {
				paramMap.put("status", "1");
			} else {
				paramMap.put("status", "0");
			}
		}
		return paramMap;
	}

	/**
	 * 查询新工单
	 * @param empNum 员工号
	 * @param workOrderTime 工单生成时间
	 * @return 绑定到前端的数据参数map
	 */
	@RequestMapping("/queryNewWorkOrder")
	@ResponseBody
	public Map<String, Object> queryNewWorkOrder(String empNum, String workOrderTime) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> rtMap = new HashMap<String, Object>();
		paramMap.put("empNum", empNum);
		paramMap.put("workOrderTime", workOrderTime);
		List<WorkOrder> woList = checkMachineTurnSingleService.findNewWorkOrder(paramMap);
		rtMap.put("total", woList.size());
		rtMap.put("rows", woList);
		return rtMap;
	}

	/**
	 * 查询销工单
	 * @param oldEmpNum 员工号 (销工单)
	 * @param oldWorkOrderTime 工单生成时间(销工单)
	 * @return 绑定到前端的数据参数map
	 */
	@RequestMapping("/queryOldWorkOrder")
	@ResponseBody
	public Map<String, Object> queryOldWorkOrder(String oldEmpNum, String oldWorkOrderTime) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> rtMap = new HashMap<String, Object>();
		paramMap.put("oldEmpNum", oldEmpNum);
		paramMap.put("oldWorkOrderTime", oldWorkOrderTime);
		List<OldWorkOrder> woList = checkMachineTurnSingleService.findOldWorkOrder(paramMap);
		rtMap.put("total", woList.size());
		rtMap.put("rows", woList);
		return rtMap;
	}

	/**
	 * 查询所有定区编码
	 * @return 定区集合
	 */
	@RequestMapping("/allFixedAreaNum")
	@ResponseBody
	public List<FixedArea> findAllFixedAreaNum() {
		return checkMachineTurnSingleService.findAllFixedAreaNum();
	}
	
	/**
	 * 查询所有员工号
	 * @return 员工集合
	 */
	@RequestMapping("/allEmpNum")
	@ResponseBody
	public List<Emp> findAllEmpNum() {
		return checkMachineTurnSingleService.findAllEmpNum();
	};

	/**
	 * 查询所有组织结构名
	 * @return 组织结构集合
	 */
	@RequestMapping("/allOrgName")
	@ResponseBody
	public List<Organization> findAllOrgName() {
		return checkMachineTurnSingleService.findAllOrgName();
	}
	
	/**
	 * 组织结构树
	 * @return 树集合
	 */
	@RequestMapping("/orgDtoTree")
	@ResponseBody
	public List<ResDto> orgDtoTree() {
		return checkMachineTurnSingleService.findDto();
	}
	
	/**
	 * 通过empNum查找员工手机号
	 * @param empNum 员工号
	 * @return 查到的手机号
	 */
	@RequestMapping("/findPhoneNumByEmpNum")
	@ResponseBody
	public String findPhoneNumByEmpNum(String empNum) {
		return checkMachineTurnSingleService.findEmpByEmpNum(empNum).getPhoneNum();
	}
	
}


