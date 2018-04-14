package com.yidu.tencloud.dao.taketosend.applygoodsdao;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.returnGoods.ApplyGoods;

/**
 *  Mapper接口
 * @author 刘艺钿
 * 
 */
public interface ApplyGoodsMapper {

	/**
     * 分页查询
     * @param param
     * @return
     */
	public abstract List<ApplyGoods> findApplyGoodsPagenation(Map<String, Object> paremMap);
	
	/**
	 * 查询返货总记录数
	 * @return 查询总记录数
	 */
	public abstract int applyGoodscount();
	/**
     * 查询满足条件查询的返货记录数
     * @param paremMap 查询条件
     * @return 满足条件查询的返货记录数
     */
    public abstract int countapplyGoodsWithCriteria(Map<String, Object> paremMap);

    /**
     * 带条件的分页查询
     * @param paremMap
     * @return
     */
    public abstract List<ApplyGoods> findApplyGoodsPagenationWithCriteria(Map<String, Object> paremMap);
    
    /**
     * 添加返货信息
     * @param applyGoods
     * @return
     */
    public abstract int addApplyGoods(ApplyGoods applyGoods);
    /**
     * 修改作废返货信息
     * @param applyGoods
     * @return
     */
    public abstract int updateApplyGoods(ApplyGoods applyGoods);
    /**
     * 修改返货信息
     * @param applyGoods
     * @return
     */
    public abstract int updateIApplyGoods(ApplyGoods applyGoods);
    /**
     * 返货单位业务接口
     * @param id
     * @return
     */
    public abstract String findOrgNameById(String  id);
    
    /**
     * 录入单位接口 
     * @param senderPhone
     * @return
     */
    public abstract List<String> findworkSheetByNo(String senderPhone);
    
}
