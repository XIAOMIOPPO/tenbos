package com.yidu.tencloud.biz.basis.basisrecordbiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.basisrecord.BasisFiles;
import com.yidu.tencloud.bean.basis.basisrecord.HelpFiles;
/**
 * 基础档案接口
 * @author 陈玉娟
 * @since 2017年11月16日09:56:36
 */
public interface BasisFilesBiz {
	/**
	 * 查找所有基础档案
	 * @param paramMap 参数
	 * @return  返回查找到的结果
	 */
	public List<BasisFiles> findAllBasisFiles(Map<String, Object> paramMap);
	/**
	 * 查找所有基础档案总数
	 * @param paramMap 参数
	 * @return 返回查找到的总数
	 */
	public int countBasisFiles(Map<String, Object> paramMap);
	/**
	 * 添加基础档案
	 * @param basisFiles 基础档案对象
	 * @return 返回添加后的结果
	 */
	public int addBasisFiles(BasisFiles basisFiles);
	/**
	 * 根据名字查找基础档案
	 * @param recordName基础档案名字
	 * @return 返回查找到的结果
	 */
	public boolean findBasisFilesByRecordName(String recordName);
	/**
	 * 根据ID删除基础档案
	 * @param recordId 基础档案ID
	 * @return 返回删除后的结果
	 */
	public boolean deleteBasisFiles(String recordId);
	/**
	 * 修改基础档案
	 * @param basisFiles 基础档案对象
	 * @return 返回修改后的结果
	 */
	public boolean updateBasisFiles(BasisFiles basisFiles);
	/**
	 * 查找所有基础档案的名字
	 * @return 返回查到的结果
	 */
	public List<BasisFiles> findAllRecordName();
	/**
	 * 辅助档案
	 * 查询所有并分页
	 * @param paramMap 参数
	 * @return 返回结果
	 */
	public List<HelpFiles> findAllHelpFiles(Map<String,Object> paramMap);
	/**
	 * 查找所有辅助档案的总数
	 * @param paramMap参数
	 * @return 返回查找到的总数
	 */
	public int countHelpFiles(Map<String,Object> paramMap);
	/**
	 * 添加辅助档案
	 * @param helpFiles辅助档案对象
	 * @return 返回添加后的结果
	 */
	public int addHelpFiles(HelpFiles helpFiles);
	/**
	 * 根据名字查找辅助档案
	 * @param fileName 辅助档案名
	 * @return 返回查找到的结果
	 */
	public boolean findHelpFilesByFileName(String fileName);
	/**
	 * 修改辅助档案
	 * @param helpFiles辅助档案对象
	 * @return 返回结果
	 */
	public boolean updateHelpFiles(HelpFiles helpFiles);
	/**
	 * 根据ID删除辅助档案
	 * @param fileId 辅助档案ID
	 * @return 返回结果
	 */
	public boolean deleteHelpFiles(String fileId);
	
	/**
	 * 通过备注查找辅助档案表
	 * @param remarlk备注
	 * @return 返回查到的结果
	 */
	List<HelpFiles> findFileByParentName(String remarlk);

}
