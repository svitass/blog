/**
 * 
 */
package com.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import com.github.pagehelper.PageInfo;


/**
* Title: FriendsService  
* Description: 对用户的关注信息进行操作 
* @author 杨惠  
* @date 2020年4月7日  
 */
public interface FriendsService {

	int countFollow(int id);
	
	int countFans(int id);
	
	PageInfo queryFollows(int id,int pageNum,int pageSize);
	
	PageInfo queryFollows(int blogerId,int userId,int pageNum,int pageSize);
	
	PageInfo queryFans(int id,int pageNum,int pageSize);
	
	PageInfo queryFans(int blogerId,int userId,int pageNum,int pageSize);
	
	boolean deleteFollow(int userId,int followId);
	
	boolean insertFollow(int userId,int followId);
	
	boolean getFollow(int fansId,int userId);
	
}
