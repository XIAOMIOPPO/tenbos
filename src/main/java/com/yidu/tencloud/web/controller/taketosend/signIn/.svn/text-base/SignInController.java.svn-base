package com.yidu.tencloud.web.controller.taketosend.signIn;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.taketosend.signin.SignIn;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.biz.taketosend.signinBiz.SignInBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 控制器层
 * @author ZhangZhenhao
 * @since  2018/1/19
 */ 
@Controller
@RequestMapping("/sign")
public class SignInController {
	
	@Autowired
	private SignInBiz signBiz;
	
	public void setSignBiz(SignInBiz signBiz) {
		this.signBiz = signBiz;
	}

	/**
	 * 查询所有员工
	 * @return 员工集合
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/findEmp")
	@ResponseBody
	public List<Emp> findEmp()throws Exception{
		//调用Biz层查询所有员工的方法
		return signBiz.findEmp();
	}

	/**
	 * 查询所有工作单
	 * @return 工作单集合
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/findWorkSheet")
	@ResponseBody
	public List<WorkSheet> findWorkSheet()throws Exception{
		//调用Biz层查询所有工作单的方法
		return signBiz.findWorkSheet();
	}
	
	/**
	 * 查询所有签收录入
	 * @param paramMap 签收录入集合
	 * @return 签收录入对象 
	 * @throws Exception
	 */
	@RequestMapping(value="/findSignPagenation")
	@ResponseBody
	public List<SignIn> findSignPagenation(Map<String,Object> paramMap)throws Exception{
		//调用业务层查询所有的方法
		return signBiz.findSignPagenation(paramMap);
	}
	/**
	 * 通过员工Id查询员工号和员工姓名
	 * @param empId	员工Id
	 * @return 员工对象
	 * @throws Exception 异常
	 */
	@RequestMapping(value="findEmpNoAndEmpNameByEmpId")
	@ResponseBody
	public Emp findEmpNoAndEmpNameByEmpId(String empId)throws Exception{
		//调用业务层查询员工号和员工姓名的方法
		return signBiz.findEmpNoAndEmpNameByEmpId(empId);
	}
	
	/**
	 * 通过工作单号查询签收人
	 * @param workSheetNo 工作单号
	 * @return	签收人对象
	 * @throws Exception 异常
	 */
	@RequestMapping(value="findAddressesNameByWorkSheetNo")
	@ResponseBody
	public Addresses findAddressesNameByWorkSheetNo(String workSheetNo)throws Exception{
		//调用业务层查询签收人的方法
		return signBiz.findAddressesNameByWorkSheetNo(workSheetNo);
	}
	
	/**
	 * 通过工作单号查询工作单类型
	 * @param workSheetNo	工作单号
	 * @return 工作单类型对象
	 * @throws Exception	异常
	 */
	@RequestMapping(value="findWorkSheetTypeByWorkSheetNo")
	@ResponseBody
	public WorkSheet findWorkSheetTypeByWorkSheetNo(String workSheetNo)throws Exception{
		//调用业务层查询工作单类型的方法
		return signBiz.findWorkSheetTypeByWorkSheetNo(workSheetNo);
	}
	
	/**
	 * 添加签收录入
	 * @param signIn 签收录入对象
	 * @param request 请求
	 * @return	字符串成功或失败
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/addSignIn")
	@ResponseBody
	public String addSignIn(SignIn signIn,HttpServletRequest request)throws Exception{
		//从session中获取当前登录用户
		User user = (User) request.getSession().getAttribute("user");
		//设置signId
		signIn.setSignId(IDGenderatorUtil.generateId());
		//设置录入人
		signIn.setDrawerName(user.getUserName());
		//设置录入单位
		signIn.setDrawerCompany(user.getOrgName());
		//调用Biz层的添加签收录入方法
		boolean result = signBiz.addSignIn(signIn);
		//判断结果
		if(result){
			//返回字符串成功
			return "success";
		}
		//返回字符串失败
		return "defeat";
	}
	
	/**
	 * 删除未保存的签收录入
	 * @param signId 签收录入Id
	 * @return	字符串成功或失败
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/deleteSignIn")
	@ResponseBody
	public String deleteSignIn(String[] signId)throws Exception{
		//定义一个布尔型变量并赋值fasle
		boolean result = false;
		//遍历数组
		for(int i=0;i<signId.length;i++){
			//给变量赋值,调用Biz层删除方法
			result = this.signBiz.deleteSignIn(signId[i]);
		}
		//判断结果
		if(result){
			//返回字符串成功
			return "success";
		}else{
			//返回字符串失败
			return "defeat";
		}
	}
}