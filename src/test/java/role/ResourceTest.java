package role;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.tencloud.bean.system.jurisdiction.ResDto;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
import com.yidu.tencloud.biz.system.jurisdictionbiz.ResourceService;
import com.yidu.tencloud.dao.system.jurisdiction.ResourceMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring/spring.xml"})
public class ResourceTest {
@Resource ResourceService res;
@Resource ResourceMapper mapper;

	
	//@Test
	public void testAddRes(){
		URLResource resource = new URLResource();
		resource.setResourceId(IDGenderatorUtil.generateId());
		resource.setParentResId(null);
		resource.setResourceCode("123455");
		resource.setResourceType("BDEBD80C0FD74525");
		resource.setResourceName("test authority");
		resource.setResourceUrl("www.baidu.com");
		resource.setRindex(1);
		assertEquals(1,res.addResource(resource));
	}
	
	
	//@Test
	public void testUpdateRes(){
		URLResource resource = new URLResource();
		resource.setResourceUrl("www.youngboy.com");
		resource.setResourceId("BAA0E71F0DA34EE6");
		//断言
		assertEquals(true,res.updateResource(resource));
	}
	
	//@Test
	public void testFinaAll(){
		//assertNotNull(res.findAllResource());
		
		List<URLResource> resources =  res.findAllResource();
	
		//System.err.println(resources);
		for (URLResource urlResource : listToTree(resources)) {
			System.out.println(urlResource.getResourceName());
			List<URLResource> res = urlResource.getResList();
			if(!res.isEmpty()) {
				for (URLResource urlResource2 : res) {
					System.out.println("   "+urlResource2.getResourceName());
					List<URLResource> res2 = urlResource.getResList();
					if(!res.isEmpty()) {
						for (URLResource urlResource3 : res2) {
							System.out.println("      "+urlResource3.getResourceName());
						
						
						}
					}
				
				}
			}
		}
		
		
	}
	
	@Test
	public void testFindGrantedRes() {
		List<URLResource> resList = mapper.findGrantedResourceByUserId("3CF0848FC9F64F47");
		for (URLResource urlResource : resList) {
			System.err.println(urlResource );
		}
		
		//System.err.println(resources);
				for (URLResource urlResource : listToTree(resList)) {
					System.out.println(urlResource.getResourceName());
					List<URLResource> res = urlResource.getResList();
					if(res!=null&&!res.isEmpty()) {
						for (URLResource urlResource2 : res) {
							System.out.println("   "+urlResource2.getResourceName());
							List<URLResource> res2 = urlResource2.getResList();
							if(res2!=null&&!res2.isEmpty()) {
								for (URLResource urlResource3 : res2) {
									System.out.println("      "+urlResource3.getResourceName());
								}
							}
						
						}
					}
				}
		
	}
	
	
	//@Test
	public void testTree() {
		List<ResDto> dtoList = res.findResDtoTree();
		System.out.println(dtoList);
	}
	
	
	
	public List<URLResource> listToTree(List<URLResource> listData){
		//挑出父节点和字节点
		List<URLResource> parentNode = new ArrayList<URLResource>();
		List<URLResource> childrenNode = new ArrayList<URLResource>();
		//分离子节点和父节点
		for (URLResource resource : listData) {
			String pname = resource.getParentResId();
			System.out.println(pname==null||pname.equals(""));
			if (pname==null||pname.equals("")) {
				parentNode.add(resource);
			} else {
				childrenNode.add(resource);
			}
		}
		
		//递归生成树
		for (URLResource resource : parentNode) {
			String primaryKey = resource.getResourceId();
			resource.setResList(getChildren(primaryKey, childrenNode));
		}
		
		return parentNode;
	}

	private List<URLResource> getChildren(String primaryKey, List<URLResource> childrenNode) {
		//子集合
		List<URLResource> cNode = new ArrayList<URLResource>();
		//遍历集合寻找符合主键的记录
		for (URLResource resource : childrenNode) {
			String pname = resource.getParentResId();
			if(pname.equals(primaryKey)) {
				cNode.add(resource);
			}
		}
		
		//递归子集合
		for (URLResource resource : cNode) {
			resource.setResList(getChildren(resource.getResourceId(), childrenNode));
		}
		
		if(cNode.size()==0) {
			return null;
		}
		
		return cNode;
		
		
	}
	
	
	
}
