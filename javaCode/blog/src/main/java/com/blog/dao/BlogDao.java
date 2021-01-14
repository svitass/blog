package com.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.BlogInfo;

/**
* Title: BlogDao  
* Description:  对博客信息进行操作
* @author 杨惠  
* @date 2020年4月7日  
 */
public interface BlogDao {

	int countBlog(int userid);
	
	int countBlogLiked(int userid);
	
	List<BlogInfo> queryBlogsByUserid(int userid);
	
	List<BlogInfo> queryLikedBlogs(int userid);
	
	int countBlogByClassify(int classifyid);
	
	List<BlogInfo> queryBlogByClassify(int classifyid);
	
	List<BlogInfo> queryBlogByDate();
	
	List<BlogInfo> queryBlogByKey(@Param("key")String key);
	
	BlogInfo queryBlogById(int id);
	
	void addScanCount(int id);
	
	List<BlogInfo> queryBlogByTitle(@Param("keys")List<String> keys,@Param("len")int len);  
	
	void deleteBlogById(int blogId);
	
	void addLikeCount(int blogId);
	
	void decreaseLikeCount(int blogId);
	
	void addRemarkCount(int blogId);
	
	void insertBlog(BlogInfo blog);
	
	void updateBlog(BlogInfo blog);
}
