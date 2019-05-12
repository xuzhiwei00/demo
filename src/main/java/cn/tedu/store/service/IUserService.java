package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	
	void updateUser(Integer id,String username,Integer gender,String phone,String email);
	/**
	 * 
	 * @param user
	 */
	void register(User user);
	
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return 如果存在返回true  不存在返回false
	 */
	boolean checkMail(String email);
	/**
	 * 
	 * @param email
	 * @return
	 */
	boolean checkPhone(String phone);
	/**
	 * 
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return   返回user对象
	 */
	
	User login(String username,String password);
	/**
	 * 
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(Integer id,String oldPassword,String newPassword);

	/**
	 * 通过id获取对象
	 * @param id
	 * @return
	 */
	
	User getUserById(Integer id);
	
	
	void updateImageById(String image,Integer id);
}
