package com.yidu.tencloud.dao.basis.pickandrelaystandard;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.organizationchart.Organization;

/**
 * 职员数据访问层接口
 * @author 张建勇
 * @date 2017年11月2日 19:21:25
 */
public interface EmpMapper {
	
	/**
	 * 添加一个职员
	 * @param emp  职员对象
	 * @return 受影响的行数
	 */
	public int addEmp(Emp emp);
	
	
	/**
	 * 删除
	 * @param emp  职员对象
	 * @return 受影响的行数
	 */
	public int delEmp(String empId);
	
	/**
	 * 根据职员Id修改职员信息
	 * @param param 要修改的职员信息集合
	 * @return 成功返回1 失败返回0
	 */
	public int updateEmp(Map<String,Object> param);
	
	/**
	 * 查询所有的职员
	 * @return
	 */
	public List<Emp> findAllEmp(List<String> orgList);
	
	/**
	 * 分页查询
	 * @param paremMap
	 * @return
	 */
	public List<Emp> findEmpByPage(Map<String, Object> paremMap);
	
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
	 * @param orgId 部门ID
	 * @return 部门名
	 */
	public List<String> findAllOrgName();
	
	/**
	 * 根据收派标准名查询收派标准ID
	 * @param deliverId 收派标准Id
	 * @return deliverId
	 */
	public List<String> findAllDeliverName();
	
	/**
	 * 根据收派时间名查询收派时间Id
	 * @param drawTimeId 收派时间名
	 * @return 收派时间Id
	 */
	public List<String> findAllDrawTimeName();
	
	/**
	 * 根据辅助档案名查询辅助档案Id
	 * @param fileId 辅助档案Id
	 * @return 辅助档案名
	 */
	public List<String> findAllFileName();
	
	/**
	 * 条件模糊查询
	 * @param paremMap 条件查询参数集合
	 * @return 查询到的职员集合
	 */
	public List<Emp> findEmpByConditionVague(Map<String, Object> paremMap);
	
	/**
	 * 查询大小
	 * @return 总记录数
	 */
	public int countEmp();
	
	/**
	 * 根据职员Id查询职员
	 * @param empId  职员Id
	 * @return 查询到的职员
	 */
	public Emp findEmpByEmpId(String empId);
	
	/**
	 * 根据Id查询部门
	 * @param orgId
	 * @return
	 */
	public Organization findOrgByOrgId(String orgId);
	
	/**
	 * 根据父类Id查询部门
	 * @param orgId 父类Id
	 * @return 
	 */
	public List<Organization> findOrgByParentId(String orgId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 查询所有的职员1
	 * @return
	 */
	public List<Emp> findAllEmp1();
	
	/**
	 * 分页查询1
	 * @param paremMap
	 * @return
	 */
	public List<Emp> findEmpByPage1(Map<String, Integer> paremMap);
	
}
