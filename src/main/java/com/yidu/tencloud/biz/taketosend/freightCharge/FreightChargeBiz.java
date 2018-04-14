package com.yidu.tencloud.biz.taketosend.freightCharge;


import java.util.Map;

import com.yidu.tencloud.bean.taketosend.freightCharge.FreightCharge;

/**
 * 运费计算逻辑接口层
 * @author 廖晓翠
 * @since 2017/11/23
 */
public interface FreightChargeBiz {
	/**
	 * 根据寄件地和目的地查找运费计算
	 * @param paramMap 参数集合
	 * @return 查找成功返回运费对象 否则返回null
	 */
	public FreightCharge findFreightChargeByPlaceOfDispatchPYAndReceivingLandPY(Map<String,Object>paramMap);
}
