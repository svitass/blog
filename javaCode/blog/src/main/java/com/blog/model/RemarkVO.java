/**
 * 
 */
package com.blog.model;

import com.blog.entity.Remark;
import com.blog.entity.User;

/**
 * Title: RemarkVO
 * Description: 封装页面展示的博客评论信息
 * @author 杨惠
 * @date 2020年5月23日
 */
public class RemarkVO {
	private Remark remark;  //评论信息
	private User author;   //评论者信息
	public Remark getRemark() {
		return remark;
	}
	public void setRemark(Remark remark) {
		this.remark = remark;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "RemarkVO [remark=" + remark + ", author=" + author + "]";
	}
	
}
