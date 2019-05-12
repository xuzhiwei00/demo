package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserService;


public class TestUser {
	@Test
	public void testUserbyid(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService = ac.getBean("userService",IUserService.class);
	    User user = userService.getUserById(1);
	    System.out.println(user);
	
	}
	@Test
	public void testupdataUser(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService = ac.getBean("userService",IUserService.class);
	    userService.updateUser(4, "manger", 1, "111111111", null);
	
	}
	@Test
	public void testchangePassword(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService = ac.getBean("userService",IUserService.class);
	    System.out.println(userService.changePassword(7, "111111", "111111"));
	
	}
	@Test
	public void testselectById(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
	   userMapper.updateImageById("/upload/aaa.png", 6);;
	   
	}
	@Test
	public void testupdatePassword(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
	    User user = new User();
	    
	    user.setId(3);
	    user.setUsername("admin1314");
	    user.setEmail("1213@qq.com");
	    user.setPhone("adjfdjfi");
	    user.setGender(1);
	    userMapper.update(user);
	   
	
	}
	@Test
	public void testLogin(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService = ac.getBean("userService",IUserService.class);
		User user = userService.login("admin12", "1234");
		System.out.println(user);
	}
	@Test
	public void testCheckPhone(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserService userService = ac.getBean("userService",UserService.class);
		System.out.println(userService.checkPhone("124578965"));
	}
	@Test
	public void testCheckUsername(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserService userService = ac.getBean("userService",UserService.class);
		System.out.println(userService.checkUsername("admin@qq.com"));
	}
	@Test
	public void testCheckEmail(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserService userService = ac.getBean("userService",UserService.class);
		System.out.println(userService.checkMail("adin@qq.com"));
	}
	@Test
	public void testselectPhone(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		System.out.println(userMapper.selectByPhone("123456"));
	}
	@Test
	public void testEmail(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		System.out.println(userMapper.selectByEmail("admin@qq.com"));
	}
	@Test
	public void testRegist() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserService userService = ac.getBean("userService",UserService.class);
		User user = new User();
        user.setUsername("admin9527");
        user.setPassword("123");
        user.setEmail("admin@qq.com");
        user.setPhone("124578965");
        
	userService.register(user);

	}
	@Test
	public void testInsert(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
            User user = new User();
            user.setUsername("admin");
            user.setPassword("123");
            user.setEmail("admin@qq.com");
            user.setPhone("124578965");
            
		userMapper.insert(user);
		
	}
	@Test
	public void selectByUsername(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		User user = userMapper.selectByUsername("admin");
		
		System.out.println(user.toString());
		
	}

}
