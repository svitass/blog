package com.blog.entity;

/**
* Title: User  
* Description: 用户类  
* @author 杨惠  
* @date 2020年3月15日  
 */
public class User {
	private int id;  //用户id
	private String name; //用户名
	private String password; //用户密码	
	private String phone; //用户电话
	private String email; //用户邮箱
	private String image; //用户头像
	private String registertime; //注册时间
	private String description; //用户简介
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", image=" + image + ", registertime=" + registertime + ", description=" + description + "]";
	}
}
