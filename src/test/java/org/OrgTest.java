package org;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.system.organizationchartbiz.impl.OrganizationService;
//dddd
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring/spring.xml"})
public class OrgTest {
	
	@Resource OrganizationService organizationService;
	
	//@Test
	public void testAllOrg() {
		List<Organization> orgList = this.organizationService.findAllOrg();
		
		for(Organization org : orgList) {
			System.out.println(org);
		}
		assertNotNull(orgList);
	}
	
	@Test
	public void testUpdateOrg() {
		Organization organization = new Organization();
		organization.setOrgId("ORG0000000000001");
		organization.setEmpName("杨波");
		this.organizationService.updateOrg(organization);
		
	}
	
	
	
}
