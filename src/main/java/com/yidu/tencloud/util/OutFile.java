package com.yidu.tencloud.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yidu.tencloud.bean.basis.managesubarea.Partition;

public class OutFile {
	@SuppressWarnings("deprecation")
	public static String outExcel(List<Partition> list, String path){
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		
		HSSFSheet hssfSheet =  hssfWorkbook.createSheet("区域表");
		
		hssfSheet.setDefaultColumnWidth((short)16);
		
		HSSFRow hssfRow = hssfSheet.createRow(0);
		
		HSSFCell hssfCell = hssfRow.createCell((short)0);
		hssfCell.setCellValue("分区ID");
		hssfCell = hssfRow.createCell((short)1);
		hssfCell.setCellValue("定区ID");
		hssfCell = hssfRow.createCell((short)2);
		hssfCell.setCellValue("省");
		hssfCell = hssfRow.createCell((short)3);
		hssfCell.setCellValue("市");
		hssfCell = hssfRow.createCell((short)4);
		hssfCell.setCellValue("区(县)");
		hssfCell = hssfRow.createCell((short)5);
		hssfCell.setCellValue("属性");
		hssfCell = hssfRow.createCell((short)6);
		hssfCell.setCellValue("关键字");
		hssfCell = hssfRow.createCell((short)7);
		hssfCell.setCellValue("起始号");
		hssfCell = hssfRow.createCell((short)8);
		hssfCell.setCellValue("终止号");
		hssfCell = hssfRow.createCell((short)9);
		hssfCell.setCellValue("单双号");
		hssfCell = hssfRow.createCell((short)10);
		hssfCell.setCellValue("辅助关键字");
		
		for(int i = 0;i<list.size();i++){
			hssfRow = hssfSheet.createRow(i+1);
			hssfRow.createCell(0).setCellValue(list.get(i).getPartitionId());
			hssfRow.createCell(1).setCellValue(list.get(i).getFixedAreaId());
			hssfRow.createCell(2).setCellValue(list.get(i).getProvince());
			hssfRow.createCell(3).setCellValue(list.get(i).getCity());
			hssfRow.createCell(4).setCellValue(list.get(i).getCounty());
			hssfRow.createCell(5).setCellValue(list.get(i).getProperty());
			hssfRow.createCell(6).setCellValue(list.get(i).getAddressKey());
			hssfRow.createCell(7).setCellValue(list.get(i).getStartNum());
			hssfRow.createCell(8).setCellValue(list.get(i).getEndNum());
			hssfRow.createCell(9).setCellValue(list.get(i).getSingle());
			hssfRow.createCell(10).setCellValue(list.get(i).getSecondaryKey());
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
