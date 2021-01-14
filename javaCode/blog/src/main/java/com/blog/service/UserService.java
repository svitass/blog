/**
 * 
 */
package com.blog.service;

import com.blog.entity.User;

/**
* Title: UserService  
* Description:  对用户的操作进行处理
* @author 杨惠  
* @date 2020年3月15日  
 */
public interface UserService {
	
	User queryUserById(Integer userId);
	
	void insertUser(User user);
	
	User queryUserByPhone(String phone);
	
	void updateUser(User user);
	
	void updateUserImage(int userId,String url);
	
}
