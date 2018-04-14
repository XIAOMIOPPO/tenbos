package com.yidu.tencloud.dao.transitshipment.sort;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.transitshipment.sort.Outstorage;
import com.yidu.tencloud.bean.transitshipment.sort.OutstorageDetail;
import com.yidu.tencloud.bean.transitshipment.sort.Packagelist;
import com.yidu.tencloud.bean.transitshipment.sort.Storagein;
import com.yidu.tencloud.bean.transitshipment.sort.StorageinDetail;

public interface SignDao {
	
	/**
	 * 查询入库信息
	 * @param params 参数map
	 * @return 入库单集合
	 */
	List<Storagein> findStorages(Map<String,Object> params);
	
	
	/**
	 * 统计入库数量
	 * @param params 参数map
	 * @return 数量
	 */
	int countStorages(Map<String,Object> params);
	
	/**
	 * 根据id查询入库情
	 * @param params 参数map
	 * @return 入库详情集合
	 */
	List<StorageinDetail> findStorageDetailById(Map<String,Object> params);
	
	
	/**
	 * 统计入库详细
	 * @param params 参数map
	 * @return 数量
	 */
	int countStorageDetail(Map<String,Object> params);
	
	/**
	 * 通过 出库交接单号找出库交接单对象
	 * @param outStorageId 出库交接单号
	 * @return 出库交接单对象
	 */
	Outstorage findOutStorageDetailById(String outStorageId);
	
	
	/**
	 * 通过出库交接单号找出库交接单明细
	 * @param outStorageNo 出库交接单号
	 * @return 出库交接单详情
	 */
	List<OutstorageDetail> findOutStorageByNo(String outStorageNo);
	
	
	/**
	 * 添加入库信息
	 * @param storagein 入库对象
	 * @return 影响的行数
	 */
	int addStorageIn(Storagein storagein);

	
	/**
	 * 添加入库详情信息
	 * @param sdetail 入库详情对象
	 * @return 影响的行数
	 */
	int addStorageInDetail(StorageinDetail sdetail);
	
	/**
	 * 添加出库信息
	 * @param outstorage 出库对象
	 * @return 影响的行数
	 */
	int addOutStorage(Outstorage outstorage);
	
	
	/**
	 * 添加出库详情
	 * @param outdetail 出库详情对象
	 * @return 影响的行数
	 */
	
	int addOutStorageDetail(OutstorageDetail outdetail);


	/**
	 * 通过关联出库单号查找出库人名
	 * @param outno 关联出库单号
	 * @return 找到出库的人
	 */
	String findOutPerByOutNo(String outno);


	/**
	 * 拆包后
	 * @param packageNo 合包号
	 * @return 拆出来的工作单
	 */
	List<Packagelist> demoPack(String packageNo);


	
	/**
	 * 通过合包号查找关联的出库交接单号
	 * @param packageNo 合包号
	 * @return 出库交接单号
	 */
	String findOutStoragenoByCopackNo(String packageNo);
	
	
	/**
	 * 添加入库
	 * @param in 入库对象
	 * @return 影响的行数
	 */
	int addStorage(Storagein in);
	
	
	/**
	 * 通过出库单号查询出库单
	 * @return 出库单对象
	 */
	Outstorage findOutstorageByNo(String no);
	
	
	/**
	 * 通过出库no找到出库详情
	 * @param outstorageno 出库单号
	 * @return 出库详情集合
	 */
	List<OutstorageDetail> findOutstorageDetailByNo(String outstorageno);


	/**
	 * 查询出库单并分页
	 * @param params 参数map
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
