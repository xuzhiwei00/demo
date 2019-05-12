package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.ClassNameAlreadyExistException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExsitException;

@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;

	public void register(User user) {
		if(userMapper.selectByUsername(user.getUsername())==null
				){
			userMapper.insert(user);
		}else{
			throw new ClassNameAlreadyExistException("用户名已经存在");
		}
		
	}

	public boolean checkMail(String email) {
		
		return userMapper.selectByEmail(email)>0;
	}

	public boolean checkPhone(String phone) {
		// TODO Auto-generated method stub
		return userMapper.selectByPhone(phone)>0;
	}

	public boolean checkUsername(String username) {
		User user = userMapper.selectByUsername(username);
		if(user==null){
			System.out.println("false");
			return false;
		}else{
			System.out.println("true");
			return true;
		}
		
	}

	public User login(String username, String password) {
	    User user = userMapper.selectByUsername(username);
	    if(user==null){
	    	throw new UserNotFoundException("用户名不存在");
	    }else{
	    	if(user.getPassword().equals(password)){
	    		return user;
	    	}else{
	    		throw new PasswordNotMatchException("用户名密码错误");
	    	}
	    }
		
	}

	public boolean changePassword(Integer id, String oldPassword, String newPassword) {
		User user = userMapper.selectById(id);
		if(user!=null){
			if(user.getPassword().equals(oldPassword)){
				User user2 = new User();
				user2.setPassword(newPassword);
				user2.setId(id);
				userMapper.update(user2);
				return true;
			}else{
				throw new PasswordNotMatchException("密码不匹配");
			}
		}else {
			throw new UserNotFoundException("用户名没找到");
		}
		
	}

	public void updateUser(Integer id, String username, Integer gender, String phone, String email) {
		User user = new User();
		User user2 = userMapper.selectByUsername(username);
		
		if(user2==null){
			user.setUsername(username);
			
		}else{
			User user3 = userMapper.selectById(id);
			if(user3!=null){
				//用户名重名问题
				if(user3.getUsername().equals(username)){
					
				}else{
					throw new UsernameAlreadyExsitException("用户名已经存在");
				}
			}
			
		}
		user.setId(id);
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		userMapper.update(user);
	}

	public User getUserById(Integer id) {
		
		return userMapper.selectById(id);
	}

	public void updateImageById(String image, Integer id) {
		userMapper.updateImageById(image, id);
		
	}
	
	

}
