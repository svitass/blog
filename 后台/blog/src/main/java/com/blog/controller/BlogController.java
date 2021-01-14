/**
 * 
 */
package com.blog.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.entity.BlogInfo;
import com.blog.entity.User;
import com.blog.model.BlogVO;
import com.blog.service.BlogService;
import com.blog.utils.R;
import com.github.pagehelper.PageInfo;
import com.alibaba.fastjson.JSONObject;

/**
* Title: BlogController  
* Description:  
* @author 杨惠  
* @date 2020年4月23日  
 */
@RestController
@RequestMapping("/article")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/articles")
	public R getBlogs(int id,int pageNum){
		PageInfo page=blogService.queryBlogsByUserid(id, pageNum, 10);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/likes")
	public R getBlogLikes(int id,int pageNum){
		PageInfo page=blogService.queryLikedBlogs(id, pageNum, 10);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/index")
	public R getIndexBlogs(int pageNum){
		PageInfo page=blogService.queryBlogsByTime(pageNum, 5);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/search")
	public R searchBlogs(String key,int pageNum){
		PageInfo page=blogService.queryBlogsByKey(key, pageNum, 5);
		return R.ok().put("page", page);
	}
	
	@RequestMapping("/detail")
	public R blogDetail(int blogId){
		BlogVO blogVO=blogService.queryBlogById(blogId);
		if(blogVO==null) return R.error("该博客已被删除！");
		return R.ok().put("blogVO", blogVO);
	}
	
	@RequestMapping("/recommend")
	public R blogRecommend(String title){   //博客推荐
		List<BlogInfo> blogs=blogService.blogRecommend(title);
		return R.ok().put("blogs", blogs);
	}
	
	@RequestMapping("/delete")
	public R blogDelete(int blogId){
		blogService.deleteBlogById(blogId);
		return R.ok();
	}
	
	@RequestMapping("/add")
	public R addBlog(BlogInfo blog){
		blogService.addBlog(blog);
		return R.ok();
		
	}
	
	@RequestMapping("/update")
	public R updateBlog(BlogInfo blog){
		System.out.println("输出修改的博客信息：\n"+blog);
		blogService.updateBlog(blog);
		return R.ok();
		
	}
	
	/**
	 * 博客图片上传
	 * @param 
	 * @return
	 */
	@RequestMapping("/images")
	public R addImage(MultipartFile file, HttpServletRequest request,HttpServletResponse response){  
		if(file==null) return R.ok();
		String trueFileName=file.getOriginalFilename();
		System.out.println("输出trueFileName:"+trueFileName);
		String suffix=trueFileName.substring(trueFileName.lastIndexOf("."));
		String fileName=System.currentTimeMillis()+"_"+suffix;
		System.out.println("输出fileName:"+fileName);
		//String path=request.getSession().getServletContext().getRealPath("/img/user/");
		String path="E:/HBuilder/HbuilderProjects/Blog/userImg/blog/";
		System.out.println("输出path:"+path);
		File targetFile=new File(path,fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		//保存
		try{
			file.transferTo(targetFile);
			String url="../userImg/blog/"+fileName;
		//	String url=path+fileName;
			System.out.println("打印出url:"+url);
			return R.ok().put("url", url);
		}catch(Exception e){
			e.printStackTrace();
			return R.error("文件过大");
		}
	}
	
}
