package com.yidu.tencloud.util;

import java.util.Arrays;

/**
 * 编号生成工具类
 * @author 张建勇
 * @date 2017年11月27日 11:23:58
 */
public class Num {
	
	public static void main(String[] args) {
		/*for(int i=0;i<1000;i++) {
			System.out.println(creatNum("茶陵"));
			
		}*/
		System.out.println(creatPY("我要"));
	}
	

	
	
	/**
	 * 编号生成工具方法
	 * @param Name 编码前缀名字，生成拼音首字母大写
	 * @return  编号
	 */
	public static String creatNum(String Name){
		// 调用拼音方法 获得单名首字母大写的数组
		String[] headArray = PinYin4jUtils.getHeadByString(Name);
		/*
		 * 先将单名数组转换为字符串 再去掉字符串中的不需要的字符串
		 */
		String name = Arrays.toString(headArray).replace("[", "").replace(",", "").replace("]", "").replaceAll(" ", "");
		// 获取 多线程高并发的流水号
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 5);
		long id = idWorker.nextId();
		// 将这个流水号转换为字符串，然后切割
		String workId = (id + "").substring(14, 18);		
		String creatNum =  name + "-" + workId;
		return creatNum;
	}
	
	public static String creatPY(String Name){
		String[] headArray = PinYin4jUtils.getHeadByString(Name);
		String name = Arrays.toString(headArray).replace("[", "").replace(",", "").replace("]", "").replaceAll(" ", "");
		return name;
	}
}
