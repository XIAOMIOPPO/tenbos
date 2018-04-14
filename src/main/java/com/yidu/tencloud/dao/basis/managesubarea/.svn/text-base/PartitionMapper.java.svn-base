package com.yidu.tencloud.dao.basis.managesubarea;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
/**
 * 定区的数据访问层的接口类
 * @author 袁棋凡
 * @sinne 2017/12/25
 */
public interface PartitionMapper {
   /**
    * 查找分区带分页的方法
    * @param paramMap
    * @return
    */
	public List<Partition> partitionPageQuery(Map<String,Object> paramMap);
	/**
	 * 添加分区的方法
	 * @param partition
	 * @return
	 */
	
	public int addPartition(Partition partition);
	/**
	 * 修改分区的方法
	 * @param paramMap
	 * @return
	 */
	public int updatePartitionpeoperty(Map<String,String> paramMap);
	/**
	 * 删除分区的方法
	 * @param partitionId
	 * @return
	 */
	public int deletePartition(String partitionId);
	/**
	 * 计算分区的总记录数的方法
	 * @return
	 */
	public int countPartition();
	/**
	 * 计算符合标准的分区的总记录数的方法
	 * @param paramMap
	 * @return
	 */
	
	public int countPatitionWithCriteria(Map<String,Object> paramMap);
	/**
	 * 查找符合标准的分区带分页的方法
	 * @param paramMap
	 * @return
	 */
	public List<Partition> partitionPageQueryWithCriteria(Map<String,Object> paramMap);
}
