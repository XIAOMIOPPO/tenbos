package com.yidu.tencloud.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;

public class FixedAreaNum {
	
	public static Map<String,Object> createFN(List<Partition> partitionList,String fixedAreaId) {
		String strn = "";
		for(Partition partitionList1 : partitionList) {
			String str =partitionList1.getProvince()+partitionList1.getCity()+partitionList1.getCounty();
			str=str.replace("省", "");
			str=str.replace("市", "");
			str=str.replace("县", "");
			str=str.replace("区", "");
			str=str.replace("街道", "");
			str=str.substring(0, 2)+str.substring(str.length()-2,str.length());
			String strName = Num.creatPY(str);
			strn+=strName;
		}
		String strNO = UUID.randomUUID().toString().
				replace("-", "").toUpperCase().substring(0, 16-strn.length());
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("fixedAreaId", fixedAreaId);
		param.put("fixedAreaNum", strn+strNO);
		
		return param;
	}
	
}
