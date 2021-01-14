/**
 * 
 */
package com.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.Friends;
import com.blog.entity.User;

/**
* Title: FriendsDao  
* Description:  对用户的关注信息进行操作
* @author 杨惠  
* @date 2020年4月7日  
 */
public interface FriendsDao {

	//查询用户关注的人数
	int countFollow(int id); 
	
	//查询用户的粉丝人数
	int countFans(int id);
	
	//查询用户关注的用户
	List<User> queryFollows(int id);
	
	//查询用户的粉丝
	List<User> queryFans(int id);
	
	//查看指定关注信息
	Friends getFollow(@Param("fansId")int fansId,@Param("userId")int userId);
	
	//取消关注
	int deleteFollow(@Param("userId")int userId,@Param("followId")int followId);
	
	//添加关注
	int insertFollow(@Param("userId")int userId,@Param("followId")int followId);
	
}
