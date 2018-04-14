package com.yidu.tencloud.util;

import java.io.File;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QRcodeUtil {

	public static File toEANCode(int width,int height,String text){
		 	String format = "png";  
	        HashMap<EncodeHintType, String> hints = new HashMap<>();  
	        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
	        // 条形码的格式是 BarcodeFormat.EAN_13
	        // 二维码的格式是BarcodeFormat.QR_CODE  
	        BitMatrix bm = null;
			try {
				bm = new MultiFormatWriter().encode(text,  
				        BarcodeFormat.EAN_13, width, height, hints);
			} catch (WriterException e) {
				e.printStackTrace();
			}  
	  
	        File out = new File("new.png"); 
	  
	        MatrixToImageWriter.writeBitMatricToFile(bm, format, out);  
	        
	        return out;
		
	}
	
	public static File toQRCode(int width,int height,String text){
		String format = "png";  
        HashMap<EncodeHintType, String> hints = new HashMap<>();  
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        // 条形码的格式是 BarcodeFormat.EAN_13  
        // 二维码的格式是BarcodeFormat.QR_CODE  
        BitMatrix bm = null;
		try {
			bm = new MultiFormatWriter().encode(text,  
			        BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}  
  
        File out = new File("new.png");  
  
        MatrixToImageWriter.writeBitMatricToFile(bm, format, out);  
        return out;
	 }
}	
	 
	
	
	
	
	

