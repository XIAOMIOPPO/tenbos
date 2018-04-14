package com.yidu.tencloud.web.filter.dispatch;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yidu.tencloud.bean.taketosend.dispatch.Dispatch;

/**
 * 调度导出类
 * @author 邓哲敏
 * @since 2017/11/23
 */
public class OutExcelDispatch {
	/**
	 * 将数据导出到Excel表格
	 * @param regionList 区域集合
	 * @param path 接收的路径
	 * @return 字符串 String
	 */
	 @SuppressWarnings("deprecation")
		public static String outExcelDispatch(List<Dispatch> dispatchList, String path){
			//创建工作簿
		 	HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			//创建一个表单对象并赋值
			HSSFSheet hssfSheet =  hssfWorkbook.createSheet("调度查询表");
			//设置单元格的长度
			hssfSheet.setDefaultColumnWidth((short)18);
			//创建行
			HSSFRow hssfRow = hssfSheet.createRow(0);
			//创建列
			HSSFCell hssfCell = hssfRow.createCell((short)0);
			//为单元格取值为序号
			hssfCell.setCellValue("序号");
			//为第一行的单元格赋值
			hssfCell = hssfRow.createCell((short)1);
			//为单元格取值为异常
			hssfCell.setCellValue("异常");
			//为第二行的单元格赋值
			hssfCell = hssfRow.createCell((short)2);
			//为单元格取值为业务通知单号
			hssfCell.setCellValue("业务通知单号");
			//为第三行的单元格赋值
			hssfCell = hssfRow.createCell((short)3);
			//为单元格取值为工单号
			hssfCell.setCellValue("工单号");
			//为第四行的单元格赋值
			hssfCell = hssfRow.createCell((short)4);
			//为单元格取值为取件人
			hssfCell.setCellValue("取件人");
			//为第五行的单元格赋值
			hssfCell = hssfRow.createCell((short)5);
			//为单元格取值为取件地址
			hssfCell.setCellValue("取件地址");
			//为第七行的单元格赋值
			hssfCell = hssfRow.createCell((short)6);
			//为单元格取值为受理单位
			hssfCell.setCellValue("受理单位");
			//为第八行的单元格赋值
			hssfCell = hssfRow.createCell((short)7);
			//为单元格取值为受理时间
			hssfCell.setCellValue("受理时间");
			//为第九行的单元格赋值
			hssfCell = hssfRow.createCell((short)8);
			//为单元格取值为下单成功时间
			hssfCell.setCellValue("下单成功时间");
			//为第十行的单元格赋值
			hssfCell = hssfRow.createCell((short)9);
			//为单元格取值为确认时间
			hssfCell.setCellValue("确认时间");
			//为第十一行的单元格赋值
			hssfCell = hssfRow.createCell((short)10);
			//为单元格取值为取件时间
			hssfCell.setCellValue("取件时间");
			//为第十二行的单元格赋值
			hssfCell = hssfRow.createCell((short)11);
			//为单元格取值为入库时间
			hssfCell.setCellValue("入库时间");
			//为第十三行的单元格赋值
			hssfCell = hssfRow.createCell((short)12);
			//为单元格取值为录单时间
			hssfCell.setCellValue("录单时间");
			//为第十四行的单元格赋值
			hssfCell = hssfRow.createCell((short)13);
			//为单元格取值为核销时间
			hssfCell.setCellValue("核销时间");
			//为第十五行的单元格赋值
			hssfCell = hssfRow.createCell((short)14);
			//为单元格取值为运费
			hssfCell.setCellValue("运费");
			//为第十六行的单元格赋值
			hssfCell = hssfRow.createCell((short)15);
			//为单元格取值为保险费
			hssfCell.setCellValue("保险费");
			//为第十七行的单元格赋值
			hssfCell = hssfRow.createCell((short)16);
			//为单元格取值为包装费
			hssfCell.setCellValue("包装费");
			//为第十八行的单元格赋值
			hssfCell = hssfRow.createCell((short)17);
			//为单元格取值为实收款
			hssfCell.setCellValue("实收款");
			//使用普通for循环进行遍历
			for(int i = 0;i<dispatchList.size();i++){
				//自动创建单元格
				hssfRow = hssfSheet.createRow(i+1);
				//创建序号的单元格
				hssfRow.createCell(0).setCellValue(dispatchList.get(i).getNumId());
				//创建异常的单元格
				hssfRow.createCell(1).setCellValue(dispatchList.get(i).getIsAbnormal());
				//创建业务通知单号的单元格
				hssfRow.createCell(2).setCellValue(dispatchList.get(i).getBusinessRecsiptNo());
				//创建工单号的单元格
				hssfRow.createCell(3).setCellValue(dispatchList.get(i).getWorkOrderNo());
				//创建取件人的单元格
				hssfRow.createCell(4).setCellValue(dispatchList.get(i).getEmpName());
				//创建取件地址的单元格
				hssfRow.createCell(6).setCellValue(dispatchList.get(i).getFetchAddress());
				//创建受理单位的单元格
				hssfRow.createCell(7).setCellValue(dispatchList.get(i).getAcceptingUnit());
				//创建受理时间的单元格
				hssfRow.createCell(8).setCellValue(dispatchList.get(i).getRecsiptTime());
				//创建下单成功时间的单元格
				hssfRow.createCell(9).setCellValue(dispatchList.get(i).getPlaceTime());
				//创建确认时间的单元格
				hssfRow.createCell(10).setCellValue(dispatchList.get(i).getConfirmationTime());
				//创建取件时间的单元格
				hssfRow.createCell(11).setCellValue(dispatchList.get(i).getTakeTime());
				//创建入库时间的单元格
				hssfRow.createCell(12).setCellValue(dispatchList.get(i).getTaskTime());
				//创建录单时间的单元格
				hssfRow.createCell(13).setCellValue(dispatchList.get(i).getRecordTime());
				//创建核销时间的单元格
				hssfRow.createCell(14).setCellValue(dispatchList.get(i).getCancelTime());
				//创建运费的单元格
				hssfRow.createCell(15).setCellValue(dispatchList.get(i).getFare());
				//创建保险费的单元格
				hssfRow.createCell(16).setCellValue(dispatchList.get(i).getInsurance());
				//创建包装费的单元格
				hssfRow.createCell(17).setCellType(dispatchList.get(i).getBagging());
				//创建实收款的单元格
				hssfRow.createCell(18).setCellValue(dispatchList.get(i).getTrueMoney());
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
