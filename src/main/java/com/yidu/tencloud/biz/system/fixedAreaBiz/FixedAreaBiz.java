package com.yidu.tencloud.biz.system.fixedAreaBiz;
/**
 * 业务访问层接口
 * @author 陈涛
 */
import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.fixedArea.FixedAreaEmp;
import com.yidu.tencloud.bean.system.user.User;

public interface FixedAreaBiz {

	/**
	 * 添加定区
	 * @param fixedArea 定区对象
	 * @return 字符
	 */
	public String addFixedArea(FixedArea fixedArea);
	
	/**
	 * 添加定区职员
	 * @param fixedAreaId 定区Id
	 * @param empId 职员Id
	 * @return 字符
	 */
	public String addFixedAreaEmp(String fixedAreaId,String[] empId);
	
	/**
	 * 添加定区客户
	 * @param fixedAreaId 定区Id
	 * @param clientId 客户Id
	 * @return 字符
	 */
	public String addFixedAreaClient(String fixedAreaId,String[] clientId);
	
	/**
	 * 删除定区
	 * @param fixedAreaId 定区Id集合
	 * @return 字符
	 */
	public String deleteFixedArea(String[] fixedAreaId);
	
	/**
	 * 删除定区职员
	 * @param empId 职员Id集合
	 * @return 字符
	 */
	public String deleteFixedAreaEmp(String[] empId);
	
	/**
	 * 删除定区客户
	 * @param clientId 客户Id集合
	 * @return 字符
	 */
	public String deleteFixedAreaClient(String[] clientId);
	
	/**
	 * 修改定区
	 * @param fixedArea 定区对象
	 * @return 字符
	 */
	public String updateFixedArea(FixedArea fixedArea);
	
	/**
	 * 修改定区编码
	 * @param param 参数map
	 * @return 布尔
	 */
	public boolean updateFixedAreaNum(Map<String,Object> param);
	
	/**
	 * 修改分区
	 * @param partition 分区对象
	 * @return 字符
	 */
	public String updatePartition(Partition partition);
	
	/**
	 * 统计定区数量
	 * @param paramMap map集合
	 * @return 数量
	 */
	public int count(Map<String,Object> paramMap);
	
	/**
	 * 模糊查询定区
	 * @param paramMap map集合
	 * @return 定区集合
	 */
	public List<FixedArea> findFixedAreaByPageWithTerm(Map<String,Object> paramMap);
	
	
	public List<FixedArea> findFixedAreaByPage(Map<String,Object> paramMap);
	/**
	 * 找到此定区下的客户
	 * @param fixedAreaId 定区Id
	 * @return map集合
	 */
	public Map<String,Object> findClientByFixedArea(String fixedAreaId);
	
	/**
	 * 找到不在此定区的客户
	 * @param fixedAreaId 定区Id
	 * @param clientName 客户名
	 * @return map集合
	 */
	public Map<String,Object> findClientNotInFixedArea(String fixedAreaId,String clientName);
	
	/**
	 * 找到此定区下的分区
	 * @param fixedAreaId 定区Id
	 * @return map集合
	 */
	public Map<String,Object> findPartitionByFixedArea(String fixedAreaId);
	
	/**
	 * 找到不在此定区下的分区
	 * @param fixedAreaId 定区Id
	 * @param county 分区名
	 * @return map集合
	 */
	public Map<String,Object> findPartitionNotInFixedArea(String fixedAreaId,String county);
	
	/**
	 * 找到此定区下的职员
	 * @param fixedAreaId 定区Id
	 * @return map集合
	 */
	public Map<String,Object> findEmpByFixedArea(String fixedAreaId);
	
	/**
	 * 找到不在此定区的职员
	 * @param fixedAreaId 定区Id
	 * @param empName 职员名
	 * @return map集合
	 */
	public Map<String,Object> findEmpNotInFixedArea(String empName);
	
	/**
	 * 找到用户Id
	 * @param userName 用户名
	 * @return 字符集合
	 */
	public List<String> findUserId(String userName);
	
	/**
	 * 找到用户名集合
	 * @return 用户名集合
	 */
	public List<String> findUserName();
	
	/**
	 * 管理分区
	 * @param partitionId 分区Id集合
	 * @param fixedAreaId 定区Id
	 * @return 字符
	 */
	public String managePar(String[] partitionId,String fixedAreaId);
	
	/**
	 * 管理分区
	 * @param partitionId 分区Id集合
	 * @param fixedAreaId 定区Id
	 * @return 字符
	 */
	public String managePartition(String[] partitionId,String fixedAreaId);
	
	
}
