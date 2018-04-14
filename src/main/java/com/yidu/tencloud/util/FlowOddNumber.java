package com.yidu.tencloud.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 流水单号生成工具类
 * 
 * @author 张建勇
 * @date 2017年11月23日 12:35:48
 */
public class FlowOddNumber {
	
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println(AtomicRangeInteger("出库"));;
	}

	public static String AtomicRangeInteger(String orderName) {
		// 调用拼音方法 获得单名首字母大写的数组
		String[] headArray = PinYin4jUtils.getHeadByString(orderName);
		/*
		 * 先将单名数组转换为字符串 再去掉字符串中的不需要的字符串
		 */
		String name = Arrays.toString(headArray).replace("[", "").replace(",", "").replace("]", "").replaceAll(" ", "");
		// 获得时间部分 时间字符串产生方式
		SimpleDateFormat formatTime = new SimpleDateFormat("yyyyMMdd");
		//获取当前时间并且格式化
		String time = formatTime.format(new Date());
		// 获取 多线程高并发的流水号
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
		long id = idWorker.nextId();
		// 将这个流水号转换为字符串，然后切割
		String workId = (id + "").substring(12, 16);
		// 将 单名 时间 职员编号 拼接起来
		String oddNumber = name + "-" + time + "-" + workId;
		// 返回出去
		return oddNumber;
	}
}
