package com.yidu.tencloud.dao.taketosend.checkMachineTurnSingledao;
/**
 * 查台转单Mapper
 * @author 64429
 *
 */

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle.CheckMachineTurnSingle;
import com.yidu.tencloud.bean.taketosend.checkMachineTurnSingle.OldWorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
/**
 * 查台转单数据访问层接口
 * @author 64429
 *
 */
public interface CheckMachineTurnSingleMapper {

	/**
	 * 查台
	 * 
	 * @param paramMap
	 *            参数map
	 * @return 查台集合
	 */
	public List<CheckMachineTurnSingle> find(Map<String, Object> paramMap);

	/**
	 * 通过员工号和密码查询员工
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 查到的员工
	 */
	public Emp findEmpByEmpNumAndPwd(Map<String, String> paramMap);

	/**
	 * 通过员工号查询员工
	 * 
	 * @param empNum
	 *            员工号
	 * @return 查到的员工
	 */
	public Emp findEmpByEmpNum(String empNum);

	/**
	 * 查询所有定区编码
	 * 
	 * @return 定区编码集合
	 */
	public List<FixedArea> findAllFixedAreaNum();

	/**
	 * 查询所有员工号
	 * 
	 * @return 员工集合
	 */
	public List<Emp> findAllEmpNum();

	/**
	 * 查询所有组织名
	 * 
	 * @return 组织结构集合
	 */
	public List<Organization> findAllOrgName();

	/**
	 * 查询新工单
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 工单集合
	 */
	public List<WorkOrder> findNewWorkOrder(Map<String, Object> paramMap);

	/**
	 * 查询销工单
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 销工单集合
	 */
	public List<OldWorkOrder> findOldWorkOrder(Map<String, Object> paramMap);

	/**
	 * 添加销工单
	 * 
	 * @param oldWorkOrder
	 *            销工单
	 * @return 0或1
	 */
	public int addOldWorkOrder(OldWorkOrder oldWorkOrder);

	/**
	 * 修改工单
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 0或1
	 */
	public int updateWorkOrder(Map<String, Object> paramMap);

}
