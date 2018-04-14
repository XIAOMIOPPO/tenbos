package com.yidu.tencloud.biz.basis.managesubareabiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
/**
 * 业务逻辑层
 * @author 袁棋凡
 * @since 2017/12/25
 */
public interface PartitionBiz {
    /**
     * 查找所有分区带分页
     * @param paramMap
     * @return
     */
 	public List<Partition> findPartitionQuery(Map<String,Object> paramMap);
 	
	/**
	 * 添加分区
	 * @param partition
	 * @return
	 */
	public boolean addPartition(Partition partition);
	/**
	 * 删除分区
	 * @param partitionId
	 * @return
	 */
	public boolean deletePartition(String partitionId);
	/**
	 * 修改分区属性
	 * @param partitionId
	 * @param property
	 * @return
	 */
	public boolean updateproperty(String partitionId,String property);
	/**
	 * 分区的总记录数
	 * @return
	 */
	public int countPartition();
	
	/**
	 * 符合标准的分区总记录数
	 * @param paramMap
	 * @return
	 */
	public int countPartitionWithCriteria(Map<String,Object> paramMap);
	/**
	 * 查找分页
	 * @param paramMap
	 * @return
	 */
	public List<Partition> findpartitionPageQueryWithCriteria(Map<String,Object> paramMap);
	/**
	 * 导入方法
	 * @param list
	 */
    public void saveBath(List<String[]> list);
    
}
