/**
 * 
 */
package com.blog.entity;

/**
* Title: Classify  
* Description: 类别基本信息  
* @author 杨惠  
* @date 2020年4月2日  
 */
public class Classify {
	private int id;  //类别id
	private String name;  //类别名
	private String description;  //类别描述
	private int userid;  //用户id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Classify [id=" + id + ", name=" + name + ", description=" + description + ", userid=" + userid + "]";
	}
}
