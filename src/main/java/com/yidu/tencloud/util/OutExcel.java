package com.yidu.tencloud.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yidu.tencloud.bean.basis.regionsetting.Area;


public class OutExcel {
	 @SuppressWarnings("deprecation")
		public static String outExcel(List<Area> regionList, String path){
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			
			HSSFSheet hssfSheet =  hssfWorkbook.createSheet("区域表");
			
			hssfSheet.setDefaultColumnWidth((short)16);
			
			HSSFRow hssfRow = hssfSheet.createRow(0);
			
			HSSFCell hssfCell = hssfRow.createCell((short)0);
			hssfCell.setCellValue("区域ID");
			
			hssfCell = hssfRow.createCell((short)1);
			hssfCell.setCellValue("省");
			hssfCell = hssfRow.createCell((short)2);
			hssfCell.setCellValue("市");
			hssfCell = hssfRow.createCell((short)3);
			hssfCell.setCellValue("区(县)");
			hssfCell = hssfRow.createCell((short)4);
			hssfCell.setCellValue("邮编");
			hssfCell = hssfRow.createCell((short)5);
			hssfCell.setCellValue("简码");
			hssfCell = hssfRow.createCell((short)6);
			hssfCell.setCellValue("城市编码");
			hssfCell = hssfRow.createCell((short)7);
			hssfCell.setCellValue("状态");
			
			for(int i = 0;i<regionList.size();i++){
				hssfRow = hssfSheet.createRow(i+1);
				hssfRow.createCell(0).setCellValue(regionList.get(i).getAreaId());
				hssfRow.createCell(1).setCellValue(regionList.get(i).getProvince());
				hssfRow.createCell(2).setCellValue(regionList.get(i).getCity());
				hssfRow.createCell(3).setCellValue(regionList.get(i).getCounty());
				hssfRow.createCell(4).setCellValue(regionList.get(i).getPostcode());
				hssfRow.createCell(5).setCellValue(regionList.get(i).getCitycode());
				hssfRow.createCell(6).setCellValue(regionList.get(i).getBrevitycode());
				hssfRow.createCell(7).setCellValue(regionList.get(i).getIsUse());
			}
			FileOutputStream fileOutputStream;
			String result = "";
			try {
				fileOutputStream = new FileOutputStream(path);
				hssfWorkbook.write(fileOutputStream);
				fileOutputStream.flush();
				fileOutputStream.close();
				result="success";
			} catch (FileNotFoundException e) {
				result="file";
				e.printStackTrace();
			} catch (IOException e) {
				result="file";
				e.printStackTrace();
			}
			return result;
		}
}
