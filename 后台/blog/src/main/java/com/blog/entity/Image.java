/**
 * 
 */
package com.blog.entity;

/**
* Title: Image  
* Description: 图片基本信息 
* @author 杨惠  
* @date 2020年4月2日  
 */
public class Image {
	private int id; //图片id
	private String url;  //图片地址
	private int blogid;  //博客id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + ", blogid=" + blogid + "]";
	}
}
