package role;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.yidu.tencloud.bean.system.user.User;

//@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration({"classpath:spring/spring.xml"})
public class AddRole {
	
	//@Resource RoleMapper mapper;
	
	@Test
	public void addRole() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*User user = new User();
		Method method = BeanUtils.findMethodWithMinimalParameters(user.getClass(), "setUserName");
		method.invoke(user, "张三");
		System.out.println(user.getUserName());*/
		
		String fieldName = "userName";
		String upName = String.valueOf(fieldName.charAt(0)).toUpperCase();
        String methodName = "set"+upName+fieldName.substring(1);
        System.out.println(methodName);
	}
	
	
}
