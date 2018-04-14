package recsipt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.dao.basis.pickandrelaystandard.EmpMapper;
import com.yidu.tencloud.dao.taketosend.businessrecsipt.BusinessRecsiptMapper;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring/spring.xml"})
public class TestAddress {
	
	@Resource EmpBiz r; 
	
	
	@Test
	public void testemp(){
		List<Organization> orgList = r.findOrgByParentId("6EF2D06EB0D44C8C");
		for (Organization organization : orgList) {
			System.out.println(organization);
		}
	}
}
