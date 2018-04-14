package com.yidu.tencloud.biz.transitshipment.sort;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.transitshipment.sort.Repertory;

/**
 * 业务逻辑层接口
 * @author 刘艺钿
 *
 */
public interface RepertoryBiz {
	
	/**
	 * 查询分页存库
	 * @param paremMap
	 * @return
	 */
	public abstract List<Repertory> findRepertoryPagenation(Map<String, Object> paremMap);
    /**
     * 查询库存查询总条数
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
