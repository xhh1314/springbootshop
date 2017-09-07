package springbootshop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import shop.ShopApplication;
import shop.bean.User;
import shop.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE,classes=ShopApplication.class)
public class UserPersistent {
	@Autowired
	private UserService userService;

	@Test
	public void insertUserTest(){
		User user=new User();
		user.setEmail("903440799@qq.com");
		user.setName("李浩");
		user.setPassword("lihao19920607");
		userService.register(user);
	
	}

}
