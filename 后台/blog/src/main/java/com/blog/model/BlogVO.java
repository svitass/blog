/**
 * 
 */
package com.blog.model;

import java.util.List;

import com.blog.entity.BlogInfo;
import com.blog.entity.Classify;
import com.blog.entity.User;

/**
* Title: BlogVO  
* Description:  
* @author 杨惠  
* @date 2020年4月23日  
 */
public class BlogVO {
	private BlogInfo blog;   //博客基本信息
	private List<String> imgUrls;   //博客图片
	private User blogger;    //博客作者
	private Classify classify;  //博客类别
	public BlogInfo getBlog() {
		return blog;
	}
	public void setBlog(BlogInfo blog) {
		this.blog = blog;
	}
	public List<String> getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}
	
	public User getBlogger() {
		return blogger;
	}
	public void setBlogger(User blogger) {
		this.blogger = blogger;
	}
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
	@Override
	public String toString() {
		return "BlogVO [blog=" + blog + ", imgUrls=" + imgUrls + ", blogger=" + blogger + ", classify=" + classify
				+ "]";
	}
	
}
