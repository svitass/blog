/**
 * 
 */
package com.blog.service;

import java.util.List;

import com.blog.entity.BlogInfo;
import com.blog.model.BlogVO;
import com.github.pagehelper.PageInfo;

/**
* Title: BlogService  
* Description: 对博客的信息进行操作  
* @author 杨惠  
* @date 2020年4月7日  
 */
public interface BlogService {

	int countBlog(int userid);
	
	int countBlogLiked(int userid);
	
	PageInfo queryBlogsByUserid(int userid,int pageNum,int pageSize);
	
	PageInfo queryLikedBlogs(int userid,int pageNum,int pageSize);
	
	PageInfo queryBlogByClassify(int classifyid,int pageNum,int pageSize);
	
	List<BlogInfo> queryBlogByClassify(int classifyid);
	
	int countBlogByClassify(int classifyid);
	
	PageInfo queryBlogsByTime(int pageNum,int pageSize);
	
	PageInfo queryBlogsByKey(String key,int pageNum,int pageSize);
	
	BlogVO queryBlogById(int id);
	
	List<BlogInfo> blogRecommend(String title);
	
	List<BlogInfo> getRecommendBlogs(List<BlogInfo> allBlogs);
	
	void deleteBlogById(int blogId);
	
	void addBlog(BlogInfo blog);
	
	void updateBlog(BlogInfo blog);
}
