package cn.tedu.store.mapper;


import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

/**
 * 用户持久层进行修改
 * @author xuxiaowei
 *
 */
public interface UserMapper {
	/**
	 * 修改个人头像
	 * @param image
	 * @param id
	 */
	void updateImageById(
			@Param("image")String image,
			@Param("id")Integer id);
	/**
	 * 通过id查xun
	 * @param id
	 * @return
	 */
	User selectById(Integer id);
	
	/**
	 * 修改用户数据
	 * @param user
	 */
	void update(User user);
	/**
	 * 向数据可插入数据
	 * @param user
	 */
	void insert(User user);
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	User selectByUsername(String username);
	
	
	/**
	 * 查看邮箱是否为唯一
	 * @param email
	 * @return 若果存在返回1，否则返回0
	 */
	Integer selectByEmail(String email);
	/**
	 * 查询电话号码
	 * @param phone
	 * @return  若果存在返回1，否则返回0
	 */
	Integer selectByPhone(String phone);

}
