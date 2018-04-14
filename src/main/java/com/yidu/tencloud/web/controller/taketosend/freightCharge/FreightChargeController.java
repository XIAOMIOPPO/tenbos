package com.yidu.tencloud.web.controller.taketosend.freightCharge;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.freightCharge.FreightCharge;
import com.yidu.tencloud.biz.taketosend.freightCharge.FreightChargeBiz;

/**
 * 运费计算控制器(基于注解)
 * @author 廖晓翠
 * @since 2017-11-24 09:47:35
 */
@Controller
@RequestMapping("/freightCharge")
public class FreightChargeController {
	//保留对业务逻辑层的引用
	@Autowired
	private FreightChargeBiz freightChargeBiz;
	
	public void setFreightChargeBiz(FreightChargeBiz freightChargeBiz) {
		this.freightChargeBiz = freightChargeBiz;
	}

	/**
	 * 根据发货地和收货地查找运费
	 * @param freightCharge 运费计算对象
	 * @return 如果找到返回success 否则返回failed
	 * @throws Exception 异常
	 */
	@RequestMapping("/findFreightChargeByPlaceOfDispatchAndReceivingLand.action")
	@ResponseBody
	public FreightCharge findFreightChargeByPlaceOfDispatchAndReceivingLand(FreightCharge freightCharge)throws Exception{
		//创一个集合
		Map<String,Object>paramMap = new HashMap<String,Object>();
		//将切割好的发货地放入集合中
		paramMap.put("placeOfDispatch",freightCharge.getPlaceOfDispatch()
				.substring(0,2));
		//将切割好的收货地放入集合中
		paramMap.put("receivingLand", freightCharge.getReceivingLand()
				.substring(0,2));
		//返回逻辑层的方法
		return freightChargeBiz.findFreightChargeByPlaceOfDispatchPYAndReceivingLandPY(paramMap);
		
	}
}
