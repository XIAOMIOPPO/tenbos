package com.yidu.tencloud.biz.taketosend.checkMachineTurnSinglebiz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.jurisdiction.ResDto;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle.CheckMachineTurnSingle;
import com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle.OldWorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.biz.taketosend.checkMachineTurnSinglebiz.CheckMachineTurnSingleBiz;
import com.yidu.tencloud.dao.taketosend.checkMachineTurnSingledao.CheckMachineTurnSingleMapper;

/**
 * 查台转单业务逻辑层实现类
 * @author 64429
 *
 */
@Service
public class CheckMachineTurnSingleService implements CheckMachineTurnSingleBiz {

	@Autowired
	private CheckMachineTurnSingleMapper checkMachineTurnSingleMapper;

	public CheckMachineTurnSingleMapper getCheckMachineTurnSingleMapper() {
		return checkMachineTurnSingleMapper;
	}

	public void setCheckMachineTurnSingleMapper(CheckMachineTurnSingleMapper checkMachineTurnSingleMapper) {
		this.checkMachineTurnSingleMapper = checkMachineTurnSingleMapper;
	}

	@Override
	public List<CheckMachineTurnSingle> find(Map<String, Object> paramMap) {
		return checkMachineTurnSingleMapper.find(paramMap);
	}

	@Override
	public Emp findEmpByEmpNumAndPwd(Map<String, String> paramMap) {
		return checkMachineTurnSingleMapper.findEmpByEmpNumAndPwd(paramMap);
	}

	@Override
	public Emp findEmpByEmpNum(String empNum) {
		return checkMachineTurnSingleMapper.findEmpByEmpNum(empNum);
	}

	@Override
	public List<WorkOrder> findNewWorkOrder(Map<String, Object> paramMap) {
		return checkMachineTurnSingleMapper.findNewWorkOrder(paramMap);
	}

	@Override
	public List<FixedArea> findAllFixedAreaNum() {
		return checkMachineTurnSingleMapper.findAllFixedAreaNum();
	}

	@Override
	public List<Emp> findAllEmpNum() {
		return checkMachineTurnSingleMapper.findAllEmpNum();
	}

	@Override
	public List<Organization> findAllOrgName() {
		return listToTree(checkMachineTurnSingleMapper.findAllOrgName());
	}

	@Override
	public List<OldWorkOrder> findOldWorkOrder(Map<String, Object> paramMap) {
		return checkMachineTurnSingleMapper.findOldWorkOrder(paramMap);
	}

	@Override
	public int addOldWorkOrder(OldWorkOrder oldWorkOrder) {
		return checkMachineTurnSingleMapper.addOldWorkOrder(oldWorkOrder);
	}

	@Override
	public int updateWorkOrder(Map<String, Object> paramMap) {
		return checkMachineTurnSingleMapper.updateWorkOrder(paramMap);
	}

	/**
	 * 把集合变成树
	 * 
	 * @param listData
	 *            需要变成树的集合
	 * @return 需要变成树的集合
	 */
	public List<Organization> listToTree(List<Organization> listData) {
		// 挑出父节点和字节点
		List<Organization> parentNode = new ArrayList<Organization>();
		List<Organization> childrenNode = new ArrayList<Organization>();
		// 分离子节点和父节点
		for (Organization resource : listData) {
			String pname = resource.getParendOrgId();
			System.out.println(pname == null || pname.equals(""));
			if (pname == null || pname.equals("")) {
				parentNode.add(resource);
			} else {
				childrenNode.add(resource);
			}
		}

		// 递归生成树
		for (Organization resource : parentNode) {
			String primaryKey = resource.getOrgId();
			resource.setResList(getChildren(primaryKey, childrenNode));
		}

		return parentNode;
	}

	/**
	 * 获得子节点
	 * 
	 * @param primaryKey
	 *            主键
	 * @param childrenNode
	 *            子节点集合
	 * @return
	 */
	private List<Organization> getChildren(String primaryKey, List<Organization> childrenNode) {
		// 子集合
		List<Organization> cNode = new ArrayList<Organization>();
		// 遍历集合寻找符合主键的记录
		for (Organization resource : childrenNode) {
			String pname = resource.getParendOrgId();
			if (pname.equals(primaryKey)) {
				cNode.add(resource);
			}
		}

		// 递归子集合
		for (Organization resource : cNode) {
			resource.setResList(getChildren(resource.getOrgId(), childrenNode));
		}

		if (cNode.size() == 0) {
			return null;
		}

		return cNode;

	}

	@Override
	public List<ResDto> findDto() {
		List<ResDto> resDtoList = new ArrayList<ResDto>();
		List<Organization> orgList = findAllOrgName();
		return createDtoTree(orgList, resDtoList);
	}

	/**
	 * 生成dto树
	 * 
	 * @param orgList
	 *            组织结构集合
	 * @param resDtoList
	 *            树集合
	 * @return dto树集合
	 */
	private List<ResDto> createDtoTree(List<Organization> orgList, List<ResDto> resDtoList) {
		List<ResDto> dtoList = new ArrayList<ResDto>();

		for (Organization org : orgList) {
			String id = org.getOrgName();
			String text = org.getOrgName();
			ResDto dto = new ResDto();
			dto.setId(id);
			dto.setText(text);

			List<Organization> orgs = org.getResList();
			if (orgs != null && !orgs.isEmpty()) {
				dto.setNodes(createDtoTree(orgs, dtoList));
			}

			resDtoList.add(dto);
		}

		return resDtoList;
	}

}
