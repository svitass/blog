/**
 * 
 */
package com.blog.dao;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.User;

/**
* Title: UserDao  
* Description:  对用户信息进行操作
* @author 杨惠  
* @date 2020年3月15日  
 */
public interface UserDao {
	
	User queryUserById(Integer userId);
	
	int insertUser(User user);
	
	User queryUserByPhone(@Param("phone")String phone);
	
	int updateUser(User user);
	
	int updateUserImage(@Param("userId")int userId,@Param("url")String url);
}
