/**
 * 
 */
package com.blog.entity;

/**
* Title: remark  
* Description:  评论基本信息
* @author 杨惠  
* @date 2020年4月2日  
 */
public class Remark {
	private int id; //评论id
	private String comment; //评论内容
	private String time;  //评论时间
	private int attitude; //评论态度
	private int userid;  //用户id
	private int blogid;  //博客id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAttitude() {
		return attitude;
	}
	public void setAttitude(int attitude) {
		this.attitude = attitude;
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
		return "remark [id=" + id + ", comment=" + comment + ", time=" + time + ", attitude=" + attitude + ", userid="
				+ userid + ", blogid=" + blogid + "]";
	}
}
