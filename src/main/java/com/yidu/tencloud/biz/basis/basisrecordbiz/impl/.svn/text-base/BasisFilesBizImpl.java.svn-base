package com.yidu.tencloud.biz.basis.basisrecordbiz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.basisrecord.BasisFiles;
import com.yidu.tencloud.bean.basis.basisrecord.HelpFiles;
import com.yidu.tencloud.biz.basis.basisrecordbiz.BasisFilesBiz;
import com.yidu.tencloud.dao.basis.basisrecord.BasisFilesMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
/**
 * 基础档案实现类
 * @author 陈玉娟
 * @since 2017年11月16日10:03:42
 */
@Service
public class BasisFilesBizImpl implements BasisFilesBiz {
	/**
	 * 依赖注入basisFilesMapper
	 */
	@Autowired
	private BasisFilesMapper basisFilesMapper;
	public void setBasisFilesMapper(BasisFilesMapper basisFilesMapper) {
		this.basisFilesMapper = basisFilesMapper;
	}
	/**
	 * 查找所有基础档案总数
	 * @param paramMap 参数
	 * @return 返回查找到的总数
	 */
	@Override
	public int countBasisFiles(Map<String, Object> paramMap) {
		//调用mapper中查询所有总数的方法
		return basisFilesMapper.countBasisFiles(paramMap);
	}
	/**
	 * 查找所有基础档案
	 * @param paramMap 参数
	 * @return  返回查找到的结果
	 */
	@Override
	public List<BasisFiles> findAllBasisFiles(Map<String, Object> paramMap) {
		//调用mapper中查询所有基础档案的方法
		return basisFilesMapper.findAllBasisFiles(paramMap);
	}
	/**
	 * 添加基础档案
	 * @param basisFiles 基础档案对象
	 * @return 返回添加后的结果
	 */
	@Override
	public int addBasisFiles(BasisFiles basisFiles) {
		//基础档案ID自动生成
		basisFiles.setRecordId(IDGenderatorUtil.generateId());
		//基础档案名
		basisFiles.setRecordName(basisFiles.getRecordName());
		//基础档案是否分级
		basisFiles.setClassification(basisFiles.getClassification());
		//基础档案备注
		basisFiles.setRemarlk(basisFiles.getRemarlk());
		//调用mapper中添加方法添加基础档案
		return basisFilesMapper.addBasisFiles(basisFiles);
	}
	/**
	 * 根据名字查找基础档案
	 * @param recordName基础档案名字
	 * @return 返回查找到的结果
	 */
	@Override
	public boolean findBasisFilesByRecordName(String recordName) {
		//判断基础档案名称不为空,为空返回false,否则返回true
		if(basisFilesMapper.findBasisFilesByRecordName(recordName) != null) {
			//失败
			return false;
		}
		//成功
		return true;
	}
	/**
	 * 根据ID删除基础档案
	 * @param recordId 基础档案ID
	 * @return 返回删除后的结果
	 */
	@Override
	public boolean deleteBasisFiles(String recordId) {
		//定义一个Map集合
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//辅助档案ID
		paramMap.put("fileId", "");
		//基础档案ID
		paramMap.put("recordId", recordId);
		//删除辅助档案
		int result = basisFilesMapper.deleteHelpFiles(paramMap);
		//如果等于1删除成功，否则失败
		if(basisFilesMapper.deleteBasisFiles(recordId)==1) {
			//成功
			return true;
		}else {
			//失败
		return false;
		}
	}
	/**
	 * 修改基础档案
	 * @param basisFiles 基础档案对象
	 * @return 返回修改后的结果
	 */
	@Override
	public boolean updateBasisFiles(BasisFiles basisFiles) {
		//修改成功返回true,否则返回false
		if(basisFilesMapper.updateBasisFiles(basisFiles)==1) {
			//成功
			return true;
		}else {
			//失败
		return false;
		}
	}
	/**
	 * 查找所有基础档案的名字
	 * @return 返回查到的结果
	 */
	@Override
	public List<BasisFiles> findAllRecordName() {
		//调用mapper中的方法查找基础档案名称
		return basisFilesMapper.findAllRecordName();
	}
	/**
	 * 查找辅助档案
	 * 查询所有并分页
	 * @param paramMap 参数
	 * @return 返回结果
	 */
	@Override
	public List<HelpFiles> findAllHelpFiles(Map<String, Object> paramMap) {
		//查找所有辅助档案
		return basisFilesMapper.findAllHelpFiles(paramMap);
	}
	/**
	 * 查找所有辅助档案的总数
	 * @param paramMap参数
	 * @return 返回查找到的总数
	 */
	@Override
	public int countHelpFiles(Map<String, Object> paramMap) {
		//查找辅助档案总数
		return basisFilesMapper.countHelpFiles(paramMap);
	}
	/**
	 * 添加辅助档案
	 * @param helpFiles辅助档案对象
	 * @return 返回添加后的结果
	 */
	@Override
	public int addHelpFiles(HelpFiles helpFiles) {
		//辅助档案ID 自动生成
		helpFiles.setFileId(IDGenderatorUtil.generateId());
		//添加辅助档案
		return basisFilesMapper.addHelpFiles(helpFiles);
	}
	/**
	 * 根据名字查找辅助档案
	 * @param fileName 辅助档案名
	 * @return 返回查找到的结果
	 */
	@Override
	public boolean findHelpFilesByFileName(String fileName) {
		//判断名称是否为空,为空返回false,否则返回true
		if(basisFilesMapper.findHelpFilesByFileName(fileName)!= null) {
			//失败
			return false;
		}
		//成功
		return true;
	}
	/**
	 * 修改辅助档案
	 * @param helpFiles辅助档案对象
	 * @return 返回结果
	 */
	@Override
	public boolean updateHelpFiles(HelpFiles helpFiles) {
		//判断修改行数等于1返回true,否则返回false
		if(basisFilesMapper.updateHelpFiles(helpFiles)==1) {
			//成功
			return true;
		}else {
			//失败
		return false;
		}
	}
	/**
	 * 根据ID删除辅助档案
	 * @param fileId 辅助档案ID
	 * @return 返回结果
	 */
	@Override
	public boolean deleteHelpFiles(String fileId) {
		//定义一个Map集合
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//辅助档案ID
		paramMap.put("fileId", fileId);
		//基础档案ID
		paramMap.put("recordId", "");
		//判断删除行数等于1返回true,否则返回false
		if(basisFilesMapper.deleteHelpFiles(paramMap)==1) {
			//成功
			return true;
		}else {
			//失败
			return false;
		}
	}
	/**
	 * 通过备注查找辅助档案表
	 * @param remarlk备注
	 * @return 返回查到的结果
	 */
	@Override
	public List<HelpFiles> findFileByParentName(String remarlk) {
		//调用Mapper中通过父类名查找辅助档案
		return basisFilesMapper.selectFileByParentName(remarlk);
	}



}
