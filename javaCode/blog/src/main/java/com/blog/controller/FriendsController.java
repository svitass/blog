package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.service.FriendsService;
import com.blog.utils.R;
import com.github.pagehelper.PageInfo;

/**
* Title: FriendsController  
* Description:  
* @author 杨惠  
* @date 2020年4月21日  
 */
@RestController
@RequestMapping("/friends")
public class FriendsController {

	@Autowired
	private FriendsService friendsService;
	
	@RequestMapping("/follows")
	public R getFollows(int id,int pageNum){
		PageInfo page=friendsService.queryFollows(id, pageNum, 10);
		return R.ok().put("page", page);
	}

	@RequestMapping("/otherFollows")
	public R getOtherFollows(int blogerId,int userId,int pageNum){
		PageInfo page=friendsService.queryFollows(blogerId, userId, pageNum, 10);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/fans")
	public R getFans(int id,int pageNum){
		PageInfo page=friendsService.queryFans(id, pageNum, 10);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/otherFans")
	public R getFans(int blogerId,int userId,int pageNum){
		PageInfo page=friendsService.queryFans(blogerId, userId, pageNum, 10);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/delete")
	public R deleteFollow(int userId,int followId){
		boolean result=friendsService.deleteFollow(userId, followId);
		if(result) return R.ok();
		return R.error("他还不是你的关注好友！");
	}
	
	@RequestMapping("/add")
	public R addFollow(int userId,int followId){
		boolean result=friendsService.insertFollow(userId, followId);
		if(result) return R.ok();
		return R.error("你已经关注过他了！");
	}
}
