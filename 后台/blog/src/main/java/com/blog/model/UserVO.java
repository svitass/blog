/**
 * 
 */
package com.blog.model;

import com.blog.entity.User;

/**
* Title: UserVO  
* Description: 个人中心--用户信息  
* @author 杨惠  
* @date 2020年4月7日  
 */
public class UserVO {
	private User user; //用户基本信息
	private int followNum; //用户关注人数
	private int fansNum; //用户粉丝人数
	private int blogNum; //用户文章数量
	private int blogLiked; //用户获赞数量
	private boolean isFollow=false; //当前用户是否关注了该用户
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFollowNum() {
		return followNum;
	}
	public void setFollowNum(int followNum) {
		this.followNum = followNum;
	}
	public int getFansNum() {
		return fansNum;
	}
	public void setFansNum(int fansNum) {
		this.fansNum = fansNum;
	}
	public int getBlogNum() {
		return blogNum;
	}
	public void setBlogNum(int blogNum) {
		this.blogNum = blogNum;
	}
	public int getBlogLiked() {
		return blogLiked;
	}
	public void setBlogLiked(int blogLiked) {
		this.blogLiked = blogLiked;
	}
	public boolean isFollow() {
		return isFollow;
	}
	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}
	@Override
	public String toString() {
		return "UserVO [user=" + user + ", followNum=" + followNum + ", fansNum=" + fansNum + ", blogNum=" + blogNum
				+ ", blogLiked=" + blogLiked + ", isFollow=" + isFollow + "]";
	}
	
}
