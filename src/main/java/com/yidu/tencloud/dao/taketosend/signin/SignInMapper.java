package com.yidu.tencloud.dao.taketosend.signin;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.taketosend.signin.SignIn;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;

/**
 * 签收录入Dao层
 * @author ZhangZhenhao
 * @since 2018/1/8
 */
public interface SignInMapper {
	
	/**
	 * 分页查询所有签收录入
	 * @param paramMap	参数集合
	 * @return	签收录入集合
	 */
	public List<SignIn> findSignPagenation(Map<String,Object> paramMap);

	/**
	 * 查询签收录入的总记录数
	 * @param paramMap	参数集合
	 * @return	返回总记录数
	 */
	public int countSignIn(Map<String,Object> paramMap);
	
	/**
	 * 添加签收录入
	 * @param signIn	签收录入对象
	 * @return	如果添加成功返回true,否则返回false
	 */
	public boolean addSignIn(SignIn signIn);
	
	/**
	 * 删除未保存的签收录入
	 * @param signId	签收录入Id
	 * @return	如果删除成功返回true,否则返回fasle
	 */
	public boolean deleteSignIn(String signId);

	/**
	 * 修改签收人
	 * @param paramMap 集合参数
	 * @return	如果修改成功返回true,否则返回fasle
	 */
	public boolean updateAddresseeName(String signId);

	/**
	 * 查询所有员工
	 * @return	员工集合List<Emp>
	 */
	public List<Emp> findEmp();
	
	/**
	 * 查询所有工作单
	 * @return	工作单集合List<WorkSheet>
	 */
	public List<WorkSheet> findWorkSheet();
		
	/**
	 * 通过员工Id查询员工号和员工姓名
	 * @param EmpId	员工Id
	 * @return	员工号和员工姓名
	 */
	public Emp findEmpNoAndEmpNameByEmpId(String EmpId);

	/**
	 * 通过工作单号查询签收人
	 * @param workSheetId	工作单号
	 * @return	收件人
	 */
	public Addresses findAddressNameByWorkSheetNo(String workSheetNo);
	
	/**
	 * 通过工作单号查询工作单类型
	 * @param workSheetNo	工作单号
	 * @return	工作单类型
	 */
	public WorkSheet findWorkSheetTypeByWorkSheetNo(String workSheetNo);
}
