package role;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.transitshipment.sort.Storagein;
import com.yidu.tencloud.biz.system.jurisdictionbiz.RoleService;
import com.yidu.tencloud.dao.system.jurisdiction.RoleMapper;
import com.yidu.tencloud.dao.transitshipment.sort.SignDao;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring/spring.xml"})
public class RoleTest {
	
	@Resource RoleService res;
	
	@Resource RoleMapper mapper;
	
	
	@Resource SignDao sdao;
	
	@Test
	public void testAddIn() {
		Storagein sin = new Storagein();
		//设置入库id
		sin.setStorageinId(IDGenderatorUtil.generateId());
		//设置入库单号
		sin.setStorageinNo(FlowOddNumber.AtomicRangeInteger("入库"));
		//获取当前用户
		//设置收货人id
		sin.setRecPersonId("xxx");
		//设置接受人名
		sin.setRecPersonName("xxx");
		//设置接受时间
		sin.setRecDate(new Date());
		//设置接收人单位
		sin.setRecOrgId("xxx");
		//设置接收人单位名
		sin.setRecOrgName("xx");
		//设置发送人名
		sin.setSendPersonName("xx");
		
		sin.setSendOrgId("xxx");
		sin.setSendOrgName("xxx");
		sin.setSendPersonId("xxx");
		
		System.out.println(sdao.addStorage(sin));
	}
	
	
	//@Test
	public void testAddRes(){
		Role role = new Role();
		role.setRoleId(IDGenderatorUtil.generateId());
		role.setRoleCode("123456");
		role.setRoleName("testrole");
		role.setRoleTypeId("testRoleTypeId");
		role.setRoleTypeName("testRole");
		assertEquals(true,res.addRole(role));
	}
	
	
	//@Test
	public void testUpdateRes(){
		Role role = new Role();
		role.setRoleId("12AC581D439F4DD2");
		role.setRoleCode("654321");
		assertEquals(true,res.updateRole(role));
	}
	
	//@Test
	public void testFinaAll(){
		List<Role> roles = res.findAllRole();
		for (Role role : roles) {
			System.out.println(role);
		}
		assertNotNull(roles);
	}
	
	

	//@Test
	public void testFindByTypeId() {
		System.out.println(mapper.findRoleByTypeId("1"));
	}
	
	
	//@Test
	public void testFindRoleByCriteria() {
		Map<String,String> param = new HashMap<>();
		param.put("roleName", "经理");
		System.out.println(mapper.findRoleByCriteria(param));
	}
	
	
	
}
