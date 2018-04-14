package basic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLead;
import com.yidu.tencloud.util.BeanUtil;
import com.yidu.tencloud.util.CommPOIUtil;

public class BasicTest {
	//@Test
	public void test() throws FileNotFoundException {
		File[] files = new File[2];
		files[0] = new File("E:\\lllll.xls");
		files[1] = new File("E:\\lead.xls");
		File zipFile = new File("E:\\weer3.zip"); 
		CheckedOutputStream cout = new CheckedOutputStream(new FileOutputStream(zipFile), new CRC32());
		ZipOutputStream zip = new ZipOutputStream(cout);
		dzipFile(files,zip);
		
	}
	

	public void dzipFile(File[] inputFile, ZipOutputStream zipoutputStream) {
		try {
			if (inputFile.length!=0) { // 判断文件是否存在
				for (File file : inputFile) {
					// 创建输入流读取文件
					FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis);
					
					// 将文件写入zip内，即将文件进行打包
					ZipEntry ze = new ZipEntry(file.getName()); // 获取文件名
					zipoutputStream.putNextEntry(ze);
					
					// 写入文件的方法，同上
					byte[] b = new byte[1024];
					long l = 0;
					while (l < file.length()) {
						int j = bis.read(b, 0, 1024);
						l += j;
						zipoutputStream.write(b, 0, j);
					}
					// 关闭输入输出流
					bis.close();
					fis.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void parseExecel() throws IOException {
		List<WorkSheetLead> sheets = new ArrayList<>();
		List<List<Object>> list = CommPOIUtil.commReadExecel(CommPOIUtil.getWorkBook("E:\\导入.xls"));
		int i=0;
		for (List<Object> listItem : list) {
			System.out.println(i);
			if(i==0) {
				i++;
				continue;
			}
			WorkSheetLead worksheet = BeanUtil.convertListToBean(listItem, WorkSheetLead.class);
			System.out.println("data"+worksheet);
			sheets.add(worksheet);
		}
		
		for (WorkSheetLead list2 : sheets) {
			System.out.println(list2);
		}
		
	}
	
	
}
