package com.yidu.tencloud.util;

import com.yidu.tencloud.bean.taketosend.fastEntering.FastEntering;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLead;

public class UpdateSta {

	/**
	 * 工作单快速录入修改完整性状态
	 * @return 工作单对象
	 */
	public static String changeStatusFas(FastEntering fastEntering) {
		  //如果工作单六项基本信息不完整
		  if(fastEntering.getWorkSheetNo()==null || fastEntering.getProduct()==null
		  || fastEntering.getDestination()==null || fastEntering.getStowageRequirement()==null
		  || fastEntering.getProductAmount()==0 || fastEntering.getActualWeight()==0) {
			 //则设置完整性状态为配置信息不全
			  return "配载信息不全";
		  //如果其他信息不全
		  }else {
			  //则设置状态为其他信息不全
			  return "其他信息不全";
		  }
	}
	 
	/** 
	 * 工作单导入
	 * @return
	 */
	public static String changeStatus(WorkSheetLead workSheetLead) {
		  //如果工作单六项基本信息不完整
		  if(workSheetLead.getWorkSheetNo()==null || workSheetLead.getProduct()==null
		  || workSheetLead.getDestination()==null || workSheetLead.getStowageRequirement()==null
		  || workSheetLead.getProductAmount()==0 || workSheetLead.getActualWeight()==0) {
			 //则设置完整性状态为配置信息不全
			  return "配载信息不全";
		  //如果其他信息不全
		  }else if(workSheetLead.getSenderName()==null || workSheetLead.getSenderNo()==null
		  || workSheetLead.getSenderAddress()==null || workSheetLead.getSenderPhone()==null
		  || workSheetLead.getAddressesName()==null || workSheetLead.getAddressesAddress()==null
		  || workSheetLead.getAddressesPhone()==null) {
			  //则设置状态为其他信息不全
			  return "其他信息不全";
			  //调用修改状态的方法
		  }else {
			//如果都不是则状态为信息完整
			  return "信息完整";
		  }
	}
	
	public static String getFree(String str) {
		int i = 0;
		int j = 0;
		if(str.indexOf("市")>=0) {
			i=str.indexOf("市");
		}
		if(str.indexOf("省")>=0) {
			j=str.indexOf("省")+1;
		}
		System.out.println(str.substring(j, i));
		return str.substring(j, i);
		
	}

}
