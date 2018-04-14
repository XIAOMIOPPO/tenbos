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
import com.yidu.tencloud.bean.transitshipment.sort.Outwarehouse;


public class OutWareExcel {
	 @SuppressWarnings("deprecation")
		public static String outExcel(List<Outwarehouse> outwarehouseList, String path){
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			
			HSSFSheet hssfSheet =  hssfWorkbook.createSheet("出入库查询表");
			
			hssfSheet.setDefaultColumnWidth((short)16);
			
			HSSFRow hssfRow = hssfSheet.createRow(0);
			
			HSSFCell hssfCell = hssfRow.createCell((short)0);
			hssfCell.setCellValue("出入库ID");
			
			hssfCell = hssfRow.createCell((short)1);
			hssfCell.setCellValue("操作单位");
			hssfCell = hssfRow.createCell((short)2);
			hssfCell.setCellValue("交接单号");
			hssfCell = hssfRow.createCell((short)3);
			hssfCell.setCellValue("工作单号");
			hssfCell = hssfRow.createCell((short)4);
			hssfCell.setCellValue("入库人");
			hssfCell = hssfRow.createCell((short)5);
			hssfCell.setCellValue("出库人");
			hssfCell = hssfRow.createCell((short)6);
			hssfCell.setCellValue("入库时间");
			hssfCell = hssfRow.createCell((short)7);
			hssfCell.setCellValue("出库时间");
			hssfCell = hssfRow.createCell((short)8);
			hssfCell.setCellValue("操作人");
			hssfCell = hssfRow.createCell((short)9);
			hssfCell.setCellValue("查询类型");
			hssfCell = hssfRow.createCell((short)10);
			hssfCell.setCellValue("操作时间");
			hssfCell = hssfRow.createCell((short)11);
			hssfCell.setCellValue("出入类型");
			hssfCell = hssfRow.createCell((short)12);
			hssfCell.setCellValue("交货人");
			hssfCell = hssfRow.createCell((short)13);
			hssfCell.setCellValue("件数");
			
			for(int i = 0;i<outwarehouseList.size();i++){
				hssfRow = hssfSheet.createRow(i+1);
				hssfRow.createCell(0).setCellValue(outwarehouseList.get(i).getOutwarehouseId());
				hssfRow.createCell(1).setCellValue(outwarehouseList.get(i).getOperationUnit());
				hssfRow.createCell(2).setCellValue(outwarehouseList.get(i).getReceiptNo());
				hssfRow.createCell(3).setCellValue(outwarehouseList.get(i).getJobNo());
				hssfRow.createCell(4).setCellValue(outwarehouseList.get(i).getWarehousePeople());
				hssfRow.createCell(5).setCellValue(outwarehouseList.get(i).getDeliveryMan());
				hssfRow.createCell(6).setCellValue(outwarehouseList.get(i).getWarehouseTime());
				hssfRow.createCell(7).setCellValue(outwarehouseList.get(i).getDeliveryTime());
				hssfRow.createCell(8).setCellValue(outwarehouseList.get(i).getOperator());
				hssfRow.createCell(9).setCellValue(outwarehouseList.get(i).getQueryType());
				hssfRow.createCell(10).setCellValue(outwarehouseList.get(i).getOperationTime());
				hssfRow.createCell(11).setCellValue(outwarehouseList.get(i).getAccessType());
				hssfRow.createCell(12).setCellValue(outwarehouseList.get(i).getDelivery());
				hssfRow.createCell(13).setCellValue(outwarehouseList.get(i).getNumberOf());
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
