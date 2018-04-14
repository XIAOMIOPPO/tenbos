package com.yidu.tencloud.web.filter.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yidu.tencloud.bean.system.log.Log;

/**
 * 日志导出类
 * @author 邓哲敏
 * @since 2017/11/23
 */
public class OutExcelLog {
	/**
	 * 将数据导出到Excel表格
	 * @param regionList 区域集合
	 * @param path 接收的路径
	 * @return 字符串 String
	 */
	 @SuppressWarnings("deprecation")
		public static String outExcelLog(List<Log> logList, String path){
			//创建工作簿
		 	HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			//创建一个表单对象并赋值
			HSSFSheet hssfSheet =  hssfWorkbook.createSheet("日志表");
			//设置单元格的长度
			hssfSheet.setDefaultColumnWidth((short)18);
			//创建行
			HSSFRow hssfRow = hssfSheet.createRow(0);
			//创建列
			HSSFCell hssfCell = hssfRow.createCell((short)0);
			//为单元格取值为日志
			hssfCell.setCellValue("日志号");
			//为第一行的单元格赋值
			hssfCell = hssfRow.createCell((short)1);
			//为单元格取值为操作用户号
			hssfCell.setCellValue("操作用户号");
			//为第二行的单元格赋值
			hssfCell = hssfRow.createCell((short)2);
			//为单元格取值为访问时间
			hssfCell.setCellValue("访问时间");
			//为第三行的单元格赋值
			hssfCell = hssfRow.createCell((short)3);
			//为单元格取值为访问资源
			hssfCell.setCellValue("访问资源");
			//为第四行的单元格赋值
			hssfCell = hssfRow.createCell((short)4);
			//为单元格取值为访问结果
			hssfCell.setCellValue("访问结果");
			//使用普通for循环进行遍历
			for(int i = 0;i<logList.size();i++){
				//自动创建单元格
				hssfRow = hssfSheet.createRow(i+1);
				//创建日志号的单元格
				hssfRow.createCell(0).setCellValue(logList.get(i).getLogId());
				//创建操作用户号的单元格
				hssfRow.createCell(1).setCellValue(logList.get(i).getUserName());
				//创建访问时间的单元格
				hssfRow.createCell(2).setCellValue(logList.get(i).getVisitDate());
				//创建访问资源的单元格
				hssfRow.createCell(3).setCellValue(logList.get(i).getVisitResource());
				//创建访问结果的单元格
				hssfRow.createCell(4).setCellValue(logList.get(i).getVisitResult());
				
			}
			//定义输入流
			FileOutputStream fileOutputStream; 
			//定义一个空的字符串
			String result = "";
			try {
				//创建输入流将地址放入
				fileOutputStream = new FileOutputStream(path);
				//将输入流添加到工作簿中
				hssfWorkbook.write(fileOutputStream);
				//刷新
				fileOutputStream.flush();
				//关闭
				fileOutputStream.close();
				//返回成功
				result="success";
			} catch (FileNotFoundException e) {
				//返回失败
				result="file";
				e.printStackTrace();
			} catch (IOException e) {
				//返回失败
				result="file";
				e.printStackTrace();
			}
			//返回结果集
			return result;
		}
}
