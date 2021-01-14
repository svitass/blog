package com.blog.model;

import java.util.List;

import com.blog.entity.BlogInfo;
import com.blog.entity.Classify;

/**
* Title: ClassifyVO  
* Description:  封装页面展示的博客类别信息
* @author 杨惠  
* @date 2020年4月24日  
 */
public class ClassifyVO {
	private Classify classify;
	private int blogNum; //该类别下的博客数量
	private List<BlogInfo> blogs;  //该类别下的部分博文
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
	public int getBlogNum() {
		return blogNum;
	}
	public void setBlogNum(int blogNum) {
		this.blogNum = blogNum;
	}
	public List<BlogInfo> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<BlogInfo> blogs) {
		this.blogs = blogs;
	}
	@Override
	public String toString() {
		return "ClassifyVO [classify=" + classify + ", blogNum=" + blogNum + ", blogs=" + blogs + "]";
	}
	
}
