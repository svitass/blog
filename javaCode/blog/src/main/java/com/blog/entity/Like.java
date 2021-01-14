/**
 * 
 */
package com.blog.entity;

/**
* Title: Like  
* Description:  点赞信息
* @author 杨惠  
* @date 2020年4月2日  
 */
public class Like {
	private int id; //点赞id
	private int userid;  //用户id
	private int blogid;  //博客id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	@Override
	public String toString() {
		return "Like [id=" + id + ", userid=" + userid + ", blogid=" + blogid + "]";
	}
}
