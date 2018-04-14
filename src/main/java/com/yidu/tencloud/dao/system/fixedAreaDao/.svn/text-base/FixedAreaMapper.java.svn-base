package com.yidu.tencloud.dao.system.fixedAreaDao;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.user.User;
/**
 * 定区dao层
 * @author 陈涛
 *
 */
public interface FixedAreaMapper {

	/**
	 * 找到记录数
	 * @param paramMap 
	 * @return 记录数
	 */
	public int count(Map<String,Object> paramMap);
	/**
	 * 模糊查询并分页
	 * @param paramMap
	 * @return 定区集合
	 */
	public List<FixedArea> findFixedAreaByPageWithTerm(Map<String,Object> paramMap);
	
	public List<FixedArea> findFixedAreaByPage(Map<String,Object> paramMap);
	/**
	 * 添加定区
	 * @param param
	 * @return 受影响行数
	 */
    public int addFixedArea(Map<String,Object> param);
    /**
	 * 添加定区职员
	 * @param param
	 * @return 受影响行数
	 */
    public int addFixedAreaEmp(Map<String,Object> param);
    /**
	 * 添加定区客户
	 * @param param
	 * @return 受影响行数
	 */
    public int addFixedAreaClient(Map<String,Object> param);
    /**
     * 删除定区
     * @param fixedAreaId 定区Id
     * @return 受影响的行数
     */
    public int deleteFixedArea(FixedArea fixedArea);
    /**
     * 删除定区职员
     * @param empId 职员Id
     * @return 受影响的行数
     */
    public int deleteFixedAreaEmp(String empId);
    /**
     * 删除定区客户
     * @param clientId 客户Id
     * @return 受影响的行数
     */
    public int deleteFixedAreaClient(String clientId);
    /**
     * 修改定区
     * @param param
     * @return 受影响的行数
     */
    public int updateFixedArea(Map<String,Object> param);
    /**
     * 修改分区
     * @param param
     * @return 受影响的行数
     */
    public int updatePartition(Map<String,Object> param);
    /**
     * 修改定区编码
     * @param param
     * @return 受影响的行数
     */
    public int updateFixedAreaNum(Map<String,Object> param);
    /**
     * 根据定区Id找到客户
     * @param fixedAreaId 定区Id
     * @return 客户集合
     */
    public List<Client> findClientByFixedArea(String fixedAreaId);
    /**
     * 找到不在此定区的客户
     * @param fixedAreaId 定区Id
     * @return 客户集合
     */
    public List<Client> findClientNotInFixedArea(Map<String,Object> param);
 
    /**
     * 根据定区Id找到分区
     * @param fixedAreaId 定区Id
     * @return 分区集合
     */
    public List<Partition> findPartitionByFixedArea(String fixedAreaId);
    
    /**
     * 找到不在此定区的分区
     * @param fixedAreaId 定区Id
     * @return 分区集合
     */
    public List<Partition> findPartitionNotInFixedArea(Map<String,Object> param);
    
    /**
     * 根据定区Id找到职员
     * @param fixedAreaId 定区Id
     * @return 职员集合
     */
    public List<Emp> findEmpByFixedArea(String fixedAreaId);
    /**
     * 找到不在此定区的职员
     * @param fixedAreaId 定区Id
     * @return 职员集合
     */
    public List<Emp> findEmpNotInFixedArea(Map<String,Object> param);

    /**
     * 根据用户名查找用户Id
     * @param param
     * @return 用户Id集合
     */
    public List<String> findUserId(Map<String,Object> param);
    /**
     * 查找用户名
     * @return 用户名集合
     */
    public List<String> findUserName(List<String> orgId);
    
    
}
