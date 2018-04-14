package role;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.tencloud.bean.system.jurisdiction.CommBean;
import com.yidu.tencloud.dao.system.jurisdiction.RoleResMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring/spring.xml"})
public class RoleResTest {

	@Resource RoleResMapper mapper;
	
	@Test
	public void testAddResRole(){
		String[] roles = {
		 "12AC581D439F4DD2", 
		  "B57CBF83C8A64793", 
		  "B57CBF83C8A64893",
		  "B57CBF83C8A64983",
		  "B57CBF83C8A64993",
		  "B57CBF83C8A64994",
		  "B57CBF83C8A64995",
		  "B57CBF83C8A64996"
		};
		
		String[] resids = {
		  "33D34AE58BB542EA",
		  "BAA0E72F0DA64EB6",
		  "BAA0E71F0DA34EA7",
		  "BAA0E71F0DA34EB6",
		  "BAA0E71F0DA34EE0",
		  "BAA0E71F0DA34EE6",
		  "BAA0E71F0DA34EE7",
		  "BAA0E71F0DA34EE8"
		};
		
		List<CommBean> beans = new LinkedList<CommBean>();
		for (int i = 0; i < 5; i++) {
			CommBean bean = new CommBean();
			bean.setPrimaryId(IDGenderatorUtil.generateId());
			bean.setBeanId(roles[i]);
			bean.setObeanId(resids[i]);
			beans.add(bean);
		}
		
		int res = mapper.addRoleRes(beans);
		System.err.println(res);
		assertEquals(5,res);
		
	}
	
	//@Test
	public void testAddUserRole(){
		
	}
	
	
	
	
}
