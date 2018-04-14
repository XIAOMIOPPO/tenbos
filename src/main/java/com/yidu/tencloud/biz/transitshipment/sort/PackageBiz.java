package com.yidu.tencloud.biz.transitshipment.sort;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.transitshipment.sort.Packageinfo;
import com.yidu.tencloud.bean.transitshipment.sort.Packagelist;
/**
 * 业务接口
 * @author 刘勇杰
 *
 */

public interface PackageBiz {
	
	public List<Packageinfo> findPackageinfoPagenation(Map<String, Integer> paramMap);
	
	public int countPackageinfo();

	/**
	 * @param myFile 文件名
	 * @return 返回所获得的文件
	 * @throws IOException 异常
	 */
	List<Packagelist> parseExecel(MultipartFile myFile) throws IOException;
	
	/**
	 * 添加合包主表
	 * @param packageinfo
	 * @return
	 */
	public boolean addPackageinfo(Packageinfo packageinfo);
	
	/**
	 * 添加合包明细表
	 * @param packagelist
	 * @return
	 */
	public boolean addPackagelist(List<Packagelist> packagelist,String packageId);
	
	/**
	 * 根据单号查找相关信息
	 * @param worksheetNo
	 * @return
	 */
	public Packagelist findPackagelistByOddNo(Map<String, String> paramMap);
	
	/**
	 * 获得封签号的方法
	 * @return 合包号字符串
	 */
	public int datePackageSizeQuery(String date);
	
	/**
	 * 根据合包号修改合包状态
	 * @param packageNo
	 * @return
	 */
	public boolean deletePackageStatus(String[] packageNo);
	
	/**
	 * 根据合包Id查询合包信息
	 * @param packageId
	 * @return
	 */
	public Packageinfo findPackageinfoById(String packageId);
	
	/**
	 * 根据合包主Id查询子表对应的信息
	 * @param packageId
	 * @return
	 */
	public List<Packagelist> findPackagelistByPackageId(String packageId);
	
	/**
	 * 根据合包Id修改相关字段
	 * @param packageinfo
	 * @return
	 */
	public boolean updatePackageinfo(Packageinfo packageinfo);

	/**
	 * 查询合包数
	 * @return
	 */
	public int countPackageNumber();
}