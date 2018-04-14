package com.yidu.tencloud.util;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class IDGenderatorUtil {

	public static String generateId(){
		String id = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
	    return id;
	}
	
	public static void main(String[] args) {
		System.out.println(generateId());
	}
	
	 /**
     * 封签号
     * @return
     */
	public static String getSealNo() {
		  // 时间格式
		SimpleDateFormat dateFormats = new SimpleDateFormat("yyMMddhhmmss");
		    // 获得当前时间
		String dates = dateFormats.format(System.currentTimeMillis());
		return "FQ"+"-"+dates;
	}
	

	
}
