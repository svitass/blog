/**
 * 
 */
package com.blog.entity;

/**
* Title: Bloginfo  
* Description:  博客基本信息
* @author 杨惠  
* @date 2020�?4�?2�?  
 */
public class BlogInfo {
	private int id;  //博客id
	private String title;  //博客标题
	private String time;  //发布时间
	private String content;  //博客内容
	private int remarkCount;  //评论次数
	private int scanCount;  //浏览次数
	private int likeCount;  //点赞次数
	private int userid;  //用户id
	private int classifyid;  //类别id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRemarkCount() {
		return remarkCount;
	}
	public void setRemarkCount(int remarkCount) {
		this.remarkCount = remarkCount;
	}
	public int getScanCount() {
		return scanCount;
	}
	public void setScanCount(int scanCount) {
		this.scanCount = scanCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getClassifyid() {
		return classifyid;
	}
	public void setClassifyid(int classifyid) {
		this.classifyid = classifyid;
	}
	@Override
	public String toString() {
		return "BlogInfo [id=" + id + ", title=" + title + ", time=" + time + ", content=" + content + ", remarkCount="
				+ remarkCount + ", scanCount=" + scanCount + ", likeCount=" + likeCount + ", userid=" + userid
				+ ", classifyid=" + classifyid + "]";
	}
}
