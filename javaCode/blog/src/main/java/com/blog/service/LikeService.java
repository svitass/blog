/**
 * 
 */
package com.blog.service;

import org.apache.ibatis.annotations.Param;

/**
 * Title: LikeService
 * Description: 对博客点赞业务进行逻辑处理
 * @author 杨惠
 * @date 2020年5月24日
 */
public interface LikeService {
	
	boolean isLiked(int blogId,int userId);
	
	void addLike(int blogId,int userId);
	
	void cancelLike(int blogId,int userId);
	
	
}
