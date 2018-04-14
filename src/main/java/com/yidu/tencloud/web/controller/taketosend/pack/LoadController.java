package com.yidu.tencloud.web.controller.taketosend.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.pack.Pack;
import com.yidu.tencloud.biz.taketosend.pack.LoadBiz;
import com.yidu.tencloud.util.QRcodeUtil;
import com.yidu.tencloud.util.ResultUtil;


/**
 * 荷重控制器
 * @author 刘子轩
 * @since 2017/12/26
 */
@Controller
@RequestMapping("load")
public class LoadController {

	/**
	 * 荷重业务对象
	 */
	@Autowired
	private LoadBiz loadBiz;
	
	public LoadBiz getLoadBiz() {
		return loadBiz;
	}

	public void setLoadBiz(LoadBiz loadBiz) {
		this.loadBiz = loadBiz;
	}



	/**
	 * 添加荷重数据
	 * @param pack
	 * @return
	 */
	@RequestMapping("/addload")
	@ResponseBody
	public Map<String,String> addLoad(Pack pack){
		//判断是否添加成功
		boolean result = loadBiz.addPack(pack);
		//写入结果
		return ResultUtil.writeResult(result);
	}
	
	
	
	/**
	 * 模糊查询荷重监控  
	 * @param param 参数
	 * @return 查询结果
	 */
	@RequestMapping("/findpack")
	@ResponseBody
	public Map<String,Object> findPackByCirtual(@RequestBody Map<String,Object> param){
		//创建结果map
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//通过条件查询数量
		resultMap.put("total",loadBiz.countPackPageQuery(param));
		//通过param查询符合的数据
		resultMap.put("rows", loadBiz.findPackPage(param));
		//返回结果map
		return resultMap;
	}
	
	
	
	/**
	 * 模糊查询荷重监控  
	 * @param param 参数
	 * @return 查询结果
	 */
	@RequestMapping("/findOrgById")
	@ResponseBody
	public String findOrgNameByOrgId(String id) {
		return loadBiz.findOrgNameByOrg(id);
	}
	
	
	
	/**
	 * 生成条形码的方法
	 * @param width 宽度
	 * @param height 高度
	 * @param msg 打印的信息
	 * @return 图片
	 */
	@RequestMapping("/code")
	public void commPrintCode(int width,int height,String msg,HttpServletResponse response) {
		File file = QRcodeUtil.toEANCode(width, height, msg);
		
		ServletOutputStream out = null;
		InputStream in = null;
		try {
			out = response.getOutputStream();
			in = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int pos=0;
			while ((pos=in.read(bytes))!=-1) {
				out.write(bytes, 0, pos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in!=null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(out!=null) {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		

		
		
		
	}
	
	
	
	
	
	
	
	
}
