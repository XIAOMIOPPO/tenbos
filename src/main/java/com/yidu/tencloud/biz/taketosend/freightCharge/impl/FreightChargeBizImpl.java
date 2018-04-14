package com.yidu.tencloud.biz.taketosend.freightCharge.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.freightCharge.FreightCharge;
import com.yidu.tencloud.biz.taketosend.freightCharge.FreightChargeBiz;
import com.yidu.tencloud.dao.taketosend.freightCharge.FreightChargeMapper;

/**
 * 运费计算逻辑实现层
 * @author 廖晓翠
 * @since 2017/11/23
 */
@Service
public class FreightChargeBizImpl implements FreightChargeBiz{
	/**
	 * 保留对数据访问层的引用
	 */
	@Autowired
	private FreightChargeMapper freightChargeMapper;
	
	public void setFreightChargeMapper(FreightChargeMapper freightChargeMapper) {
		this.freightChargeMapper = freightChargeMapper;
	}

	/**
	 * 根据寄件地和目的地查找运费计算
	 * @param paramMap 参数集合
	 * @return 查找成功返回运费对象 否则返回null
	 */
	public FreightCharge findFreightChargeByPlaceOfDispatchPYAndReceivingLandPY(Map<String,Object>paramMap) {
		//调用数据访问层的方法
		return freightChargeMapper.findFreightChargeByPlaceOfDispatchPYAndReceivingLandPY(paramMap);
	}
}
