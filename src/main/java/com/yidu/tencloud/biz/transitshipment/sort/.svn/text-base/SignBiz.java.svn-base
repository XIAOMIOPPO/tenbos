package com.yidu.tencloud.biz.transitshipment.sort;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.transitshipment.sort.Outstorage;
import com.yidu.tencloud.bean.transitshipment.sort.OutstorageDetail;
import com.yidu.tencloud.bean.transitshipment.sort.Storagein;
import com.yidu.tencloud.bean.transitshipment.sort.StorageinDetail;

public interface SignBiz {

	/**
	 * 查询入库信息
	 * @param params 参数map
	 * @return 入库单集合
	 */
	List<Storagein> findStorages(Map<String,Object> params);
	
	
	/**
	 * 根据id查询入库情
	 * @param params 参数map
	 * @return 入库详情集合
	 */
	List<StorageinDetail> findStorageDetailById(Map<String,Object> params);


	/**
	 * 解析execel文件
	 * @param myFile 文件对象
	 */
	List<StorageinDetail> parseExecel(MultipartFile myFile);
	
	
	/**
	 * 统计入库数量
	 * @param params 参数map
	 * @return 数量
	 */
	int countStorages(Map<String,Object> params);
	
	
	/**
	 * 统计入库详细
	 * @param params 参数map
	 * @return 数量
	 */
	int countStorageDetail(Map<String,Object> params);
	
	
	/**
	 * 添加成入库信息
	 * @param storagein
	 * @return 影响的行数
	 */
	int addStoragein(List<StorageinDetail> storageinDetail);
	
	
	/**
	 * 添加出库信息
	 * @param outstorage 出库信息集合
	 * @return 影响的行数 
	 */
	int addOutStorage(List<OutstorageDetail> outstorage);
	
	
	/**
	 * 拆包方法
	 * @param packageNo 合包号
	 * @return 拆出来的工作单集合
	 */
	List<StorageinDetail> demoPack(String packageNo);


	/**
	 * 通过单号找工作单详情
	 * @param wno 单号
	 * @return 工作单详情
	 */
	List<StorageinDetail> findSheetDetailByNo(String wno);
	
	
	/**
	 * 通过出库交接单查找出库详情
	 * @param outNo 出库交接单号
	 * @return 出库交接单详情
	 */
	List<OutstorageDetail> findOutDetialByNo(String outNo);


	/**
	 * 通过单号集合查询出库交接单获得状态
	 * @param outno 
	 * @return 状态数据
	 */
	List<Map<String, String>> findOutStatus(List<String> outno);


	/**
	 * 查询出库单并分页
	 * @param params 参数
	 * @return 出库单对象的集合
	 */
	List<Outstorage> findPageOutstorage(Map<String, Object> params);
	
	
	/**
	 * 统计出库单总数
	 * @param params 参数map
	 * @return 影响的函数
	 */
	int countPageOutstorage(Map<String, Object> params);
	
	
}
