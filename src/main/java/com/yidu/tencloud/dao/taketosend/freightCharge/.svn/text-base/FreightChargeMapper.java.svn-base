package com.yidu.tencloud.dao.taketosend.freightCharge;

import java.util.Map;

import com.yidu.tencloud.bean.taketosend.freightCharge.FreightCharge;

/**
 * 运费计算的Mapper接口
 * @author 廖晓翠
 * @since 2017/11/23
 */
public interface FreightChargeMapper {
	/**
	 * 根据发货地和收货地查找运费
	 * @param paramMap 参数
	 * @return 如果找到返回该用户 否则返回null
	 */
	public FreightCharge findFreightChargeByPlaceOfDispatchPYAndReceivingLandPY(Map<String,Object>paramMap);
	
	/**
	 * 添加运费数据
	 * @param freightCharge 运费对象
	 * @return 如果成功返回1 否则返回0
	 */
	public int add(FreightCharge freightCharge);
}
