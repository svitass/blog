package com.blog.dao;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.Like;

/**
* Title: LikeDao  
* Description:  对博客点赞信息进行操作
* @author 杨惠  
* @date 2020年4月23日  
 */
public interface LikeDao {

	Like queryLike(@Param("blogId")int blogId,@Param("userId")int userId);
	
	void insertLike(@Param("blogId")int blogId,@Param("userId")int userId);
	
	void deleteLike(@Param("blogId")int blogId,@Param("userId")int userId);
	
	void deleteLikes(int blogId);
	
}
