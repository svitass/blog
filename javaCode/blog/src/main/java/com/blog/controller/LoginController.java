/**
 * 
 */
package com.blog.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.controller.BaseController;
import com.blog.entity.User;
import com.blog.service.UserService;
import com.blog.utils.MD5Encoder;
import com.blog.utils.R;

/**
* Title: LoginController  
* Description: 用户登录类 
* @author 杨惠  
* @date 2020年4月6日  
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController{
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 * @param phone
	 * @param password
	 * @return
	 */
	@RequestMapping("/load")
	public R load(String phone,String password,HttpServletRequest request){
		User user=userService.queryUserByPhone(phone);
		if(user!=null){
			String pwd=user.getPassword();
			try {
				boolean isLoad=MD5Encoder.validPassword(password, pwd);
				if(!isLoad){
					return R.error(500,"密码不正确！");
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			return R.error(500, "用户不存在！");
		}
		request.getSession().setAttribute("user", user);
		int userId=user.getId();
		return R.ok().put("userId", userId);
	}
}
