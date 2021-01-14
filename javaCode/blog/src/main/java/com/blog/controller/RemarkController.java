package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.Remark;
import com.blog.entity.User;
import com.blog.service.RemarkService;
import com.blog.utils.R;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/remark")
public class RemarkController {
	@Autowired
	private RemarkService remarkService;
	
	/**
	 * 分页获取评论信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("/get")
	public R getReamrk(int blogId,int pageNum){
		PageInfo page=remarkService.queryRemark(blogId, pageNum, 10);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/add")
	public R addRemark(Remark remark){
		remarkService.addRemark(remark);
		return R.ok();
	}
	
}
