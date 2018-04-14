package com.yidu.tencloud.biz.taketosend.signinBiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.taketosend.signin.SignIn;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.biz.taketosend.signinBiz.SignInBiz;
import com.yidu.tencloud.dao.taketosend.signin.SignInMapper;

/**
 * 
 * @author ZhangZhenhao
 * @since 2018/1/4
 */
@Service
public class SignInBizImpl implements SignInBiz{
	
	@Autowired
	private SignInMapper signMapper;
	
	public void setSignMapper(SignInMapper signMapper) {
		this.signMapper = signMapper;
	}

	@Override
	public List<SignIn> findSignPagenation(Map<String, Object> paramMap) {
		return signMapper.findSignPagenation(paramMap);
	}

	@Override
	public int countSignIn(Map<String, Object> paramMap) {
		return signMapper.countSignIn(paramMap);
	}

	@Override
	public boolean addSignIn(SignIn signIn) {
		return signMapper.addSignIn(signIn);
	}

	@Override
	public boolean deleteSignIn(String signId) {
		return signMapper.deleteSignIn(signId);
	}

	@Override
	public boolean updateAddresseeName(String signId) {
		return signMapper.updateAddresseeName(signId);
	}

	@Override
	public List<Emp> findEmp() {
		return signMapper.findEmp();
	}

	@Override
	public List<WorkSheet> findWorkSheet() {
		return signMapper.findWorkSheet();
	}

	@Override
	public Emp findEmpNoAndEmpNameByEmpId(String empId) {
		return signMapper.findEmpNoAndEmpNameByEmpId(empId);
	}

	@Override
	public Addresses findAddressesNameByWorkSheetNo(String workSheetNo) {
		return signMapper.findAddressNameByWorkSheetNo(workSheetNo);
	}

	@Override
	public WorkSheet findWorkSheetTypeByWorkSheetNo(String workSheetNo) {
		return signMapper.findWorkSheetTypeByWorkSheetNo(workSheetNo);
	}

	
	
}
