package com.yidu.tencloud.biz.basis.pickstandardbiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.pickstandard.PickStandard;
import com.yidu.tencloud.biz.basis.pickstandardbiz.PickStandardBiz;
import com.yidu.tencloud.dao.basis.pickstandard.PickStandardMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 业务逻辑层的实现类
 * @author 廖晓翠
 * @since 2017/11/16
 */
@Service
public class PickStandardBizImpl implements PickStandardBiz {
	/**
	 * 保留对数据访问层的引用
	 */
	@Autowired
	private PickStandardMapper deliverCriterionMapper;

	public void setDeliverCriterionMapper(PickStandardMapper deliverCriterionMapper) {
		this.deliverCriterionMapper = deliverCriterionMapper;
	}

	@Override
	public int countFindAllDeliverCriterion(Map<String,Object>paramMap) {
		//返回数据访问层的方法
		return deliverCriterionMapper.countFindAllDeliverCriterion(paramMap);
	}
	
	@Override
	public List<PickStandard> findAllDeliverPageQuery(Map<String,Object>paramMap) {
		//返回数据访问层的方法
		return deliverCriterionMapper.findAllDeliverPageQuery(paramMap);
	}


	@Override
	public boolean addDeliverCriterion(PickStandard deliverCriterion) {
		//自动生成Id
		deliverCriterion.setDeliverId(IDGenderatorUtil.generateId());
		//如果添加的结果为1
		if(deliverCriterionMapper.addDeliverCriterion(deliverCriterion)==1) {
			//成功
			return true;
		}
		//失败
		return false;
	}

	@Override
	public boolean updateIsUseById(Map<String,Object>paramMap) {
		//如果修改的结果为1
		if(deliverCriterionMapper.updateIsUseById(paramMap) == 1) {
			//成功
			return true;
		}
		//失败
		return false;
	}

	@Override
	public List<PickStandard> criterDeliverCriterion(Map<String,Object>paramMap) {
		//返回数据访问层的方法
		return deliverCriterionMapper.criterDeliverCriterion(paramMap);
	}

	@Override
	public int countAllDeliverCriterion() {
		//返回数据访问层的方法
		return deliverCriterionMapper.countAllDeliverCriterion();
	}

	@Override
	public int deleteDeliverCriterion(String deliverId) {
		//返回数据访问层的方法
		return deliverCriterionMapper.deleteDeliverCriterion(deliverId);
	}

	@Override
	public boolean findDeliverCriterioByName(String deliverName) {
		//定义一个变量接收数据访问层的方法
		String result = deliverCriterionMapper.findDeliverCriterioByName(deliverName);
		//如果结果为空
		if(result == null) {
			//成功
			return true;
		}else{
			//失败
			return false;
		}
	}

}
