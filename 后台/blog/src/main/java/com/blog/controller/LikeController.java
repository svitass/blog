package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.service.LikeService;
import com.blog.utils.R;

/**
 * Title: LikeController
 * Description: 点赞控制类
 * @author 杨惠
 * @date 2020年5月24日
 */
@RestController
@RequestMapping("/like")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	@RequestMapping("/isLiked")
	public R isLiked(int blogId, int userId){
		boolean result=likeService.isLiked(blogId, userId);
		return R.ok().put("isLiked", result);
	}
	
	@RequestMapping("/add")
	public R addLike(int blogId, int userId){
		likeService.addLike(blogId, userId);
		return R.ok();
	}
	
	@RequestMapping("/cancel")
	public R cancelLike(int blogId, int userId){
		likeService.cancelLike(blogId, userId);
		return R.ok();
	}
	
}
