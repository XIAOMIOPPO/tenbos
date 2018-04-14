package com.yidu.tencloud.web.controller.taketosend.worksheetLead;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WorkSheetServlet", urlPatterns = "/WorkSheetServlet")
public class WorkSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WorkSheetServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] name = request.getParameterValues("filename");// 获取要下载的文件名
		if (name.length == 0) {
		} else if (name.length == 1) {
			String path = getServletContext().getRealPath("/Excel/" + name[0]);
			File file  =new File(path);
			downloadBorder(response, file);
		} else {
			File zipFile = new File("weer.zip"); 
			CheckedOutputStream cout = new CheckedOutputStream(new FileOutputStream(zipFile), new CRC32());
			ZipOutputStream zip = new ZipOutputStream(cout);
			File[] files = new File[name.length];
			int i=0;
			for(String string:name) {
				String path = getServletContext().getRealPath("/Excel/" + string);
				File file =new File(path);
				files[i++]=file;
			}
			dzipFile(files, zip);
			downloadBorder(response, zipFile);
		}
	}

	private void downloadBorder(HttpServletResponse response, File file)
			throws FileNotFoundException, UnsupportedEncodingException, IOException {
		// 第一步：设置响应类型
		response.setContentType("application/force-download");// 应用程序强制下载
		// 第二读取文件
		// String path = getServletContext().getRealPath("/Excel/"+name);
		InputStream inputStream = new FileInputStream(file);
		// 设置响应头，对文件进行url编码
		String name = URLEncoder.encode(file.getName(), "UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + name);
		response.setContentLength(inputStream.available());

		// 第三步：老套路，开始copy
		OutputStream outputStream = response.getOutputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(b)) != -1) {
			outputStream.write(b, 0, len);
		}
		outputStream.flush();
		outputStream.close();
		inputStream.close();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
