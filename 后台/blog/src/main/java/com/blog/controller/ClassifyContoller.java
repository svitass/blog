/**
 * 
 */
package com.blog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.Classify;
import com.blog.service.BlogService;
import com.blog.service.ClassifyService;
import com.blog.utils.R;
import com.github.pagehelper.PageInfo;

/**
* Title: ClassifyContoller  
* Description:  
* @author 杨惠  
* @date 2020年4月24日  
 */
@RestController
@RequestMapping("/category")
public class ClassifyContoller {
	
	@Autowired
	private ClassifyService classifyService;
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/get")
	public R getCategory(int id,int pageNum){
		PageInfo page=classifyService.queryClassify(id, pageNum, 10);
		return R.ok().put("page", page);
	}

	@RequestMapping("/getCategories")
	public R userCategory(int userId){
		List<Classify> classifyList=classifyService.queryClassify(userId);
		return R.ok().put("classifyList", classifyList);
	}
	
	@RequestMapping("/all")
	public R allCategory(int userId){
		List<Classify> classifyList=classifyService.queryAllClassify(userId);
		return R.ok().put("classifyList", classifyList);
	}
	
	@RequestMapping("/blogs")
	public R getBlogs(int id,int pageNum){
		PageInfo page=blogService.queryBlogByClassify(id, pageNum, 10);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/add")
	public R addCategory(Classify classify){
		String name=classify.getName();
		int userid=classify.getUserid();
		Classify record=classifyService.queryClassifyByName(name, userid);
		if(record!=null) return R.error("该类别已经存在！");
		classifyService.insertClassify(classify);
		return R.ok();
	}
	
	@RequestMapping("/update")
	public R updateCategory(Classify classify){
		String name=classify.getName();
		int userid=classify.getUserid();
		Classify record=classifyService.queryClassifyByName(name, userid);
		if(record!=null){
			int recordId=record.getId();
			int classifyId=classify.getId();
			if(recordId!=classifyId) return R.error("该类别已经存在！"); 
		}
		classifyService.updateClassify(classify);
		return R.ok();
	}
	
	@RequestMapping("/delete")
	public R deleteCategory(int id){
		int blogNum=blogService.countBlogByClassify(id);
		if(blogNum>0) return R.error("该类别下还有博客！");
		classifyService.deleteClassify(id);
		return R.ok();
	}
	
	@RequestMapping("/detail")
	public R detail(int id){
		Classify classify=classifyService.queryClassifyById(id);
		return R.ok().put("classify",classify);
	}
	
}
