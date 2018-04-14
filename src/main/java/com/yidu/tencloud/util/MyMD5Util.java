package com.yidu.tencloud.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.scheduling.SchedulingException;

public class MyMD5Util {
	public static String getMD5(String str) {
	try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(str.getBytes());
		 return new BigInteger(1, md.digest()).toString(16);
		 } catch (Exception e) {
		 throw new SchedulingException("MD5加密出现错误");
		 }
	}
}