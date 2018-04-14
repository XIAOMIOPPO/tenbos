package com.yidu.tencloud.biz.taketosend.applygoodsbiz.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.taketosend.returnGoods.ApplyGoods;
import com.yidu.tencloud.biz.taketosend.applygoodsbiz.ApplyGoodsBiz;
import com.yidu.tencloud.dao.taketosend.applygoodsdao.ApplyGoodsMapper;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;
/**
 * 业务逻辑实现类
 * @author 刘艺钿 
 *
 */
@Service
public class ApplyGoodsImpl implements ApplyGoodsBiz{
    @Autowired
	private ApplyGoodsMapper applyGoodsmapper;
	
	
	public ApplyGoodsMapper getApplyGoodsmapper() {
		return applyGoodsmapper;
	}

	public void setApplyGoodsmapper(ApplyGoodsMapper applyGoodsmapper) {
		this.applyGoodsmapper = applyGoodsmapper;
	}
    /**
     * 
     * 分页查询
     */
	@Override
	public List<ApplyGoods> findApplyGoodsPagenation(Map<String, Object> paremMap) {
		
		return applyGoodsmapper.findApplyGoodsPagenation(paremMap);
	}
    /**
     * 查询总条数
     */
	@Override
	public int applyGoodscount() {
		
		return applyGoodsmapper.applyGoodscount();
	}
    /**
     * 分页查询总条数
     */
	@Override
	public int countapplyGoodsWithCriteria(Map<String, Object> paremMap) {
		
		return applyGoodsmapper.countapplyGoodsWithCriteria(paremMap);
	}
    /**
     * 分页查询模糊条件查询
     */
	@Override
	public List<ApplyGoods> findApplyGoodsPagenationWithCriteria(Map<String, Object> paremMap) {
		User user = ShiroUtil.getUser();
		 paremMap.put("inputUnit", applyGoodsmapper.findOrgNameById(user.getOrgId()));
		return applyGoodsmapper.findApplyGoodsPagenationWithCriteria(paremMap);
	}
    /**
     * 添加返货信息
     */
	@Override
	public int addApplyGoods(ApplyGoods applyGoods) {
		Date date = new Date();
		User user = ShiroUtil.getUser();
		//返货ID
		applyGoods.setApplicationId(IDGenderatorUtil.generateId());
		//作废标志
		applyGoods.setInvalidSign("1");
		//申请单号
	    applyGoods.setApplicationNo(FlowOddNumber.AtomicRangeInteger("返货单"));
		//返货单位
	    applyGoods.setReturningUnit(applyGoodsmapper.findOrgNameById(user.getOrgId()));
		//录入时间
	    applyGoods.setInputTime(date);   
	    //进港时间
	    applyGoods.setEnrat(date);
		//录入人
		applyGoods.setEntryPerson(user.getUserName());
		//确认人
		applyGoods.setVerifier(user.getUserName());
		//系统确认标志
		applyGoods.setSign("否");
		//录入单位
        applyGoods.setInputUnit(applyGoodsmapper.findOrgNameById(user.getOrgId()));
        //确认单位
		applyGoods.setAcknowledgindUnit(applyGoodsmapper.findOrgNameById(user.getOrgId()));
		
		return applyGoodsmapper.addApplyGoods(applyGoods);
	}
	
    /**
     * 修改作废返货信息
     */
	@Override
	public boolean updateApplyGoods(String[] applyGoods) {
		boolean result = false;
		//遍历循环
		for (String good : applyGoods) {
			ApplyGoods applyGood =  new ApplyGoods();
			//设置返货ID
			applyGood.setApplicationId(good);
			//设置作废标志默认为否
			applyGood.setInvalidSign("0");
			int i=applyGoodsmapper.updateApplyGoods(applyGood);
			if(i>0) {
				result=true;
			}
		}
		
		return result;
	}

	/**
	 * 修改返货信息
	 */
	@Override
	public int updateIApplyGoods(ApplyGoods applyGoods) {
		
		return applyGoodsmapper.updateIApplyGoods(applyGoods);
	}
    /**
     * 录入单位接口 
     */
	@Override
	public List<String> findworkSheetByNo(String senderPhone) {
		
		return applyGoodsmapper.findworkSheetByNo(senderPhone);
	}

}
