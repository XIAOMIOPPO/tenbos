package com.yidu.tencloud.bean.basis.basisrecord;

import java.io.Serializable;
import java.util.List;
/**
 * 基础档案实体类
 * @author 陈玉娟
 * @since 2017年11月2日18:42:34
 */
public class BasisFiles implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 基础档案ID
	 */
	private String recordId;
	/**
	 * 基础档案名
	 */
	private String recordName;
	/**
	 * 档案是否分级
	 */
	private String classification;
	/**
	 * 备注
	 */
	private String remarlk;
	/**
	 * 辅助档案
	 */
	private List<HelpFiles> helpFilesList;
	
	public BasisFiles() {}

	public BasisFiles(String recordId, String recordName, String classification, String remarlk,
			List<HelpFiles> helpFilesList) {
		super();
		this.recordId = recordId;
		this.recordName = recordName;
		this.classification = classification;
		this.remarlk = remarlk;
		this.helpFilesList = helpFilesList;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getRemarlk() {
		return remarlk;
	}

	public void setRemarlk(String remarlk) {
		this.remarlk = remarlk;
	}

	public List<HelpFiles> getHelpFilesList() {
		return helpFilesList;
	}

	public void setHelpFilesList(List<HelpFiles> helpFilesList) {
		this.helpFilesList = helpFilesList;
	}

	@Override
	public String toString() {
		return "BasisFiles [recordId=" + recordId + ", recordName=" + recordName + ", classification=" + classification
				+ ", remarlk=" + remarlk + ", helpFilesList=" + helpFilesList + "]";
	}
	
	
	

}
