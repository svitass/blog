/**
 * 
 */
package com.blog.entity;

/**
* Title: Friends  
* Description: 粉丝信息 
* @author 杨惠  
* @date 2020年4月4日  
 */
public class Friends {
	int id;
	int fansid;  //粉丝
	int userid;  //用户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFansid() {
		return fansid;
	}
	public void setFansid(int fansid) {
		this.fansid = fansid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Friends [id=" + id + ", fansid=" + fansid + ", userid=" + userid + "]";
	}
}
