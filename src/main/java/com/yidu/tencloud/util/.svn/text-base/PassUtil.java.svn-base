package com.yidu.tencloud.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 
 * @author youngboy
 * @since 2017/11/28
 */
public class PassUtil {
	
	
	public static String MD5(String unencryptedPass) {
		String salt = "tenbos";
		return new SimpleHash("MD5", unencryptedPass, salt,1).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(MD5("123qwe"));
	}
	
	
}
