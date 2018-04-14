package com.yidu.tencloud.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


/**
 * 通用poi
 * @author youngboy
 * @param <T>
 * @since 2017/9/28
 */
public class CommPOIUtil {

	private static List<List<Object>> rowobjs = new ArrayList<List<Object>>();
	
	
	public static List<List<Object>> readExecel(String fileName){
		
		boolean isE2007 = false;
		Workbook wb = null;
		InputStream input = null;
		if (fileName.endsWith("xlsx"))
			isE2007 = true;
		try {
			input = new FileInputStream(fileName);
			if (isE2007)
				wb = new XSSFWorkbook(input);
			else
				wb = new HSSFWorkbook(input);
			Sheet sheet = wb.getSheetAt(0); 
			Iterator<Row> rows = sheet.rowIterator(); 
			while (rows.hasNext()) {
				Row row = rows.next(); 
				Iterator<Cell> cells = row.cellIterator();
				List<Object> exells = new ArrayList<Object>();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					switch (cell.getCellType()) { 
					case HSSFCell.CELL_TYPE_NUMERIC:
						if(HSSFDateUtil.isCellDateFormatted(cell)){
							//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							exells.add(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
						}else{
							exells.add(cell.getNumericCellValue());
						}
						
						break;
					case HSSFCell.CELL_TYPE_STRING:
						exells.add(cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						exells.add(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						exells.add(cell.getCellFormula());
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						exells.add(" ");
						break;
					default:
						exells.add(" ");
						break;
						
					}
				}
				rowobjs.add(exells);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if(input!=null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return rowobjs;
		
		
	}
	
	
	public static List<List<Object>> commReadExecel(Workbook wb){
		List<List<Object>> rowobjs = new ArrayList<List<Object>>();
		Sheet sheet = wb.getSheetAt(0); 
		Iterator<Row> rows = sheet.rowIterator(); 
		while (rows.hasNext()) {
			Row row = rows.next(); 
			Iterator<Cell> cells = row.cellIterator();
			List<Object> exells = new ArrayList<Object>();
			while (cells.hasNext()) {
				Cell cell = cells.next();
				switch (cell.getCellType()) { 
				case HSSFCell.CELL_TYPE_NUMERIC:
					if(HSSFDateUtil.isCellDateFormatted(cell)){
						//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						exells.add(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					}else{
						exells.add(cell.getNumericCellValue());
					}
					
					break;
				case HSSFCell.CELL_TYPE_STRING:
					exells.add(cell.getStringCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					exells.add(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					exells.add(cell.getCellFormula());
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					exells.add(" ");
					break;
				default:
					System.out.println("unsuported");
					exells.add(" ");
					break;
				}
			}
			rowobjs.add(exells);
		}
		return rowobjs;
	}
	
	
	
	public static Object getCellValue(Cell cell)
    {
        Object cellValue = "";
        
        if (null != cell)
        {
            switch (cell.getCellType())
            {
            case HSSFCell.CELL_TYPE_NUMERIC:
				if(HSSFDateUtil.isCellDateFormatted(cell)){
					cellValue = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
				}else{
					cellValue=cell.getNumericCellValue();
				}
				
				break;
			case HSSFCell.CELL_TYPE_STRING:
				cellValue=cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				cellValue=cell.getBooleanCellValue();
				break;
			case HSSFCell.CELL_TYPE_FORMULA:
				cellValue=cell.getCellFormula();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				cellValue=" ";
				break;
			default:
				cellValue=" ";
				System.out.println("unsuported cell type");
				break;
            }
            
        }
        return cellValue;
    }
	
	

	public static Workbook getWorkBook(String fileName) {
		boolean isE2007 = false;
		Workbook wb = null;
		if (fileName.endsWith("xlsx"))
			isE2007 = true;
		
		InputStream input=null;
		
		try {
			input = new FileInputStream(fileName);
			if (isE2007){
				wb = new XSSFWorkbook(input);
			}else{
				wb = new HSSFWorkbook(input);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(input!=null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return wb;
	}
	
	
	public static Workbook getWorkBook(MultipartFile file) {
		boolean isE2007 = false;
		Workbook wb = null;
		if (file.getName().endsWith("xlsx"))
			isE2007 = true;
		
		InputStream input=null;
		
		try {
			input = file.getInputStream();
			if (isE2007){
				wb = new XSSFWorkbook(input);
			}else{
				wb = new HSSFWorkbook(input);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(input!=null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return wb;
	}
	
	
	
	
	
	
	
}
