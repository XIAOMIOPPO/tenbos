package com.yidu.tencloud.dao.transitshipment.sort;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.transitshipment.sort.Repertory;
/**
 * 存库mapper接口
 * @author 刘艺钿
 *
 */
public interface RepertoryDao {
	
	/**
	 * 查询分页库存
	 * @param paremMap
	 * @return
	 */
	public abstract List<Repertory> findRepertoryPagenation(Map<String, Object> paremMap);
    /**
     * 查询库存总条数
     * @return
     */
	public abstract int outRepertorycount();
	
	/**
	 * 分页模糊查询库存
	 * @param paremMap
	 * @return
	 */
	public abstract List<Repertory> findRepertoryPagenationWithCriteria(Map<String,Object> paremMap);

    /**
    * 查询满足条件的库存的总条数
    * @param paremMap
    * @return
    */
    public abstract int reperTorycountWithCriteria(Map<String,Object> paremMap);



}
