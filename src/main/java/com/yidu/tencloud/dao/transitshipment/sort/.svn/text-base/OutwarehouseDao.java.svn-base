package com.yidu.tencloud.dao.transitshipment.sort;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.transitshipment.sort.Outwarehouse;


/** mapper接口
 * @since 2018-01-03
 * @author 刘艺钿
 *
 */
public interface OutwarehouseDao {
 
	/**
	 * 查询分页出入库
	 * @param paremMap
	 * @return
	 */
	public abstract List<Outwarehouse> findOutWareHousePagenation(Map<String, Object> paremMap);

	/**
	 * 查询出入库总条数
	 * @return
	 */
    public abstract int outwarehousecount();
    
    /**
	 * 带条件的分页查询出入库信息
	 * @param paremMap
	 * @return
	 */
	public abstract List<Outwarehouse> findOutWareHousePagenationWithCriteria(Map<String,Object> paremMap);
    
	/**
	 * 查询出满足条件的总条数
	 * @param paremMap
	 * @return
	 */
	public abstract int outwareousecountWithCriteria(Map<String ,Object> paremMap);
	
	public abstract String findOrgNameById(String  id);
	
	public abstract Outwarehouse findoutPrint(String outwarehouseId);

}
