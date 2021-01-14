/**
 * 
 */
package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.entity.Classify;
import com.blog.entity.User;
import com.blog.model.UserVO;
import com.blog.service.BlogService;
import com.blog.service.ClassifyService;
import com.blog.service.FriendsService;
import com.blog.service.UserService;
import com.blog.utils.MD5Encoder;
import com.blog.utils.R;

/**
* Title: UserController  
* Description:  用户信息控制类
* @author 杨惠  
* @date 2020年3月15日  
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FriendsService friendsService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private ClassifyService classifyService;
	
	/**
	 * 根据用户id获取用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("/get")
	public R getUser(int userId){
		System.out.println("userId="+userId+",开始查找...");
		User user=userService.queryUserById(userId);
		System.out.println("查找结果为："+user);
		return R.ok().put("user", user);
	}
	
	/**
	 * 获取其他用户的用户信息
	 * @param blogerId
	 * @param userId
	 * @return
	 */
	@RequestMapping("/others")
	public R getUserInfo(int blogerId,int userId){
		User user=userService.queryUserById(blogerId);
		if(user==null) return R.error("该用户不存在！");
		UserVO userVO=new UserVO();
		userVO.setUser(user);
		int id=user.getId();
		int followNum=friendsService.countFollow(id);
		int fansNum=friendsService.countFans(id);
		int blogNum=blogService.countBlog(id);
		int blogLiked=blogService.countBlogLiked(id);
		userVO.setFollowNum(followNum);
		userVO.setFansNum(fansNum);
		userVO.setBlogNum(blogNum);
		userVO.setBlogLiked(blogLiked);
		boolean isFollow=friendsService.getFollow(userId, blogerId);
		userVO.setFollow(isFollow);
		return R.ok().put("userVO", userVO);
	}
	
	/**
	 * 个人中心--获取用户基本信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/personal")
	public R personalCenter(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		System.out.println("输出已登录用户信息user:\n"+user);
		if(user==null) return R.error("请先登录！");
		UserVO userVO=new UserVO();
		int id=user.getId();
		user=userService.queryUserById(id);
		userVO.setUser(user);
		int followNum=friendsService.countFollow(id);
		int fansNum=friendsService.countFans(id);
		int blogNum=blogService.countBlog(id);
		int blogLiked=blogService.countBlogLiked(id);
		userVO.setFollowNum(followNum);
		userVO.setFansNum(fansNum);
		userVO.setBlogNum(blogNum);
		userVO.setBlogLiked(blogLiked);
		System.out.println(userVO);
		return R.ok().put("userVO", userVO);
	}
	
	@RequestMapping("/getId")
	public R getUserid(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		System.out.println("输出已登录用户信息user:\n"+user);
		if(user==null) return R.error("请先登录！");
		int id=user.getId();
		return R.ok().put("id", id);
	}
	
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public R addUser(User user){
		//检查该账号是否已经注册
		User u=userService.queryUserByPhone(user.getPhone());
		if(u==null){
			String pwd=user.getPassword();
			try {
				pwd=MD5Encoder.getEncryptedPwd(pwd);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("加密密码失败！");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("加密密码失败！");
			}
			user.setPassword(pwd);
			user.setEmail("");
			user.setDescription("");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String registertime=df.format(new Date());// new Date()为获取当前系统时间
			user.setRegistertime(registertime);
			System.out.println("获取到的用户信息为\n"+user.toString());
			userService.insertUser(user);
			//添加用户博客类别
			String phone=user.getPhone();
			user=userService.queryUserByPhone(phone);
			int userid=user.getId();
			Classify classify=new Classify();
			classify.setName("其他");
			classify.setUserid(userid);
			classifyService.insertClassify(classify);
		}else{
			return R.error("该手机号已注册！");
		}
		return R.ok();
	}
	
	@RequestMapping("/update")
	public R updateUser(HttpServletRequest request,User user){	
		System.out.println("修改用户信息:\n"+user);
		userService.updateUser(user);
		user=userService.queryUserByPhone(user.getPhone());
		request.getSession().setAttribute("user", user);
		return R.ok();
	}
	
	@RequestMapping("/image")
	public R updateImage(MultipartFile file, HttpServletRequest request,HttpServletResponse response){	
		User user=(User) request.getSession().getAttribute("user");
		System.out.println("上传头像打印用户信息：\n"+user);
		String trueFileName=file.getOriginalFilename();
		System.out.println("输出trueFileName:"+trueFileName);
		String suffix=trueFileName.substring(trueFileName.lastIndexOf("."));
		String fileName=System.currentTimeMillis()+"_"+suffix;
		System.out.println("输出fileName:"+fileName);
		//String path=request.getSession().getServletContext().getRealPath("/img/user/");
		String path="E:/HBuilder/HbuilderProjects/Blog/userImg/user/";
		System.out.println("输出path:"+path);
		File targetFile=new File(path,fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		//保存
		try{
			file.transferTo(targetFile);
			String url="../userImg/user/"+fileName;
			//修改数据库里用户的头像地址
			int userId=user.getId();
			userService.updateUserImage(userId, url);
		//	String url=path+fileName;
			System.out.println("打印出url:"+url);
			return R.ok().put("url", url);
		}catch(Exception e){
			e.printStackTrace();
			return R.error("文件过大");
		}
	}
	
}
