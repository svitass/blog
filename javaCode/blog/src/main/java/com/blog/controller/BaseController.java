/**
 * 
 */
package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.blog.entity.User;

/**
* Title: BaseController  
* Description:  获取已登录的身份
* @author 杨惠  
* @date 2020年4月6日  
 */
public class BaseController {

	/**
	 * 获取request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return requestAttributes == null ? null : requestAttributes
				.getRequest();
	}

	/**
	 * 获取session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return getRequest().getSession(false);
	}

	/**
	 * 获取当前登录的用户
	 * @return
	 */
	protected User getUser(){
		return (User) getRequest().getSession().getAttribute("user");
	}
}
