package com.yidu.tencloud.util;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {

	/**
	 * 返回结果
	 * @param result 布尔类型
	 * @return Map格式数据
	 */
	public static Map<String, String> writeResult(boolean result) {
		Map<String,String> resultJSON = new HashMap<String,String>();
		if (result) {
			resultJSON.put("status", "success");
		} else {
			resultJSON.put("status", "failed");
		}
		return resultJSON;
	}
	
}
