package com.yidu.tencloud.dao.transitshipment.sort;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yidu.tencloud.bean.transitshipment.sort.Packageinfo;
import com.yidu.tencloud.bean.transitshipment.sort.Packagelist;

/**
 * 合包Mapper层
 * @author 刘勇杰
 *
 */
public interface PackageMapper {

	/**
	 * 分页查询合包
	 * @param paramMap
	 * @return
	 */
	public List<Packageinfo> findPackageinfoPagenation(Map<String, Integer> paramMap);
	
	/**
	 * 查询合包总记录数
	 * @return
	 */
	public int countPackageinfo();
	
	/**
	 * 添加合包主表
	 * @param packageinfo
	 * @return
	 */
	public int addPackageinfo(Packageinfo packageinfo);
	
	/**
	 * 添加合包明细表
	 * @param packagelist
	 * @return
	 */
	public int addPackagelist(Packagelist packagelist);
	
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
	public int deletePackageStatus(List<String> packageNo);
	
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
	 * @param packageId
	 * @return
	 */
	public int updatePackageinfo(Packageinfo packageinfo);
	
	/**
	 * 查询合包数
	 * @return
	 */
	public int countPackageNumber();
}
