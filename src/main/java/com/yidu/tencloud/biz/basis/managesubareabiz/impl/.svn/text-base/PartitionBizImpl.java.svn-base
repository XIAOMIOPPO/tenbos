package com.yidu.tencloud.biz.basis.managesubareabiz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;
import com.yidu.tencloud.biz.basis.managesubareabiz.PartitionBiz;
import com.yidu.tencloud.dao.basis.managesubarea.PartitionMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
/**
 * 业务逻辑层实现类
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Service
public class PartitionBizImpl implements PartitionBiz{
	//对分区mapper接口进行注入
	@Autowired
	private PartitionMapper partitionMapper;
    /**
     * partitionMapper的set方法
     * @param partitionMapper
     */
	public void setPartitionMapper(PartitionMapper partitionMapper) {
		this.partitionMapper = partitionMapper;
	}
    /**
     * 查找分区带分页的方法
     */
	@Override
	public List<Partition> findPartitionQuery(Map<String,Object> paramMap) {
        return partitionMapper.partitionPageQuery(paramMap);
	}

	
   /**
    * 添加分区方法
    */
	@Override
	public boolean addPartition(Partition partition) {
		//判断是否添加成功
		if(partitionMapper.addPartition(partition)==1) {
			return true;
		}
		return false;
	}
    
	/**
	 * 删除分区的方法
	 */
	@Override
	public boolean deletePartition(String partitionId) {
		//判断是否删除成功
		if(partitionMapper.deletePartition(partitionId)==1) {
			return true;
		}
		return false;
	}
    /**
     * 修改分区的方法
     */
	@Override
	public boolean updateproperty(String partitionId,String property) {
		//创建一个Map接口对象
		Map<String,String> paramMap = new HashMap<String,String>();
		//使用Map接口为分区Id赋值
		paramMap.put("partitionId", partitionId);
		//使用Map接口为属性赋值
		paramMap.put("property", property);
		//判断是否修改成功
		if(partitionMapper.updatePartitionpeoperty(paramMap)==1) {
			return true;
		}
		return false;
	}
    /**
     * 计算分区的总记录数
     */
	@Override
	public int countPartition() {
        return partitionMapper.countPartition();
	}
    /**
     * 计算符合标准的分区的总记录数
     */
	@Override
	public int countPartitionWithCriteria(Map<String, Object> paramMap) {
		return partitionMapper.countPatitionWithCriteria(paramMap);
	}
    /**
     * 查找符合标准的分区的带分页的方法
     */
	@Override
	public List<Partition> findpartitionPageQueryWithCriteria(Map<String, Object> paramMap) {
		return partitionMapper.partitionPageQueryWithCriteria(paramMap);
	}
    /**
     * 导入方法
     */
	@Override
	public void saveBath(List<String[]> list) {
		//遍历集合
		for (String[] strings : list) {
			//创建一个分区对象
			Partition partition = new Partition();
			//设置分区Id
			partition.setPartitionId(IDGenderatorUtil.generateId());
			//设置省
			partition.setProvince(strings[0]);
			//设置市
            partition.setCity(strings[1]);
            //设置县
            partition.setCounty(strings[2]);
            //设置属性
            partition.setProperty(strings[3]);
            //设置关键字
            partition.setAddressKey(strings[4]);
            //设置初始号
            partition.setStartNum(Integer.parseInt(strings[5]));
            //设置终止号
            partition.setEndNum(Integer.parseInt(strings[6]));
            //设置单双号
            partition.setSingle(strings[7]);
            //设置辅助关键字
            partition.setSecondaryKey(strings[8]);
            //调用添加分区方法
            this.addPartition(partition);
        }
	}

}
