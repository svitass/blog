/**
 * 
 */
package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import com.blog.service.UserService;

/**
* Title: UserServiceImpl  
* Description:  
* @author 杨惠  
* @date 2020年3月15日  
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	/**
	 * 根据用户id查找用户信息
	 */
	public User queryUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=userDao.queryUserById(userId);
		String time=user.getRegistertime();
		int length=time.length();
		time=time.substring(0, length-2);
		user.setRegistertime(time);
		return user;
	}

	/* 添加用户信息
	 * @see com.blog.service.UserService#insertUser(com.blog.entity.User)
	 */
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}

	/* 根据手机查找用户信息
	 * @see com.blog.service.UserService#queryUserByPhone(java.lang.String)
	 */
	public User queryUserByPhone(String phone) {
		// TODO Auto-generated method stub
		User user=userDao.queryUserByPhone(phone);
		return user;
	}

	/* 修改用户信息
	 * @see com.blog.service.UserService#updateUser(com.blog.entity.User)
	 */
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	/* 修改用户头像地址
	 * @see com.blog.service.UserService#updateUserImage(int, java.lang.String)
	 */
	public void updateUserImage(int userId, String url) {
		// TODO Auto-generated method stub
		userDao.updateUserImage(userId, url);
	}

}
