/**
 * 
 */
package com.blog.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogDao;
import com.blog.dao.ClassifyDao;
import com.blog.dao.ImageDao;
import com.blog.dao.LikeDao;
import com.blog.dao.RemarkDao;
import com.blog.dao.UserDao;
import com.blog.entity.BlogInfo;
import com.blog.entity.Classify;
import com.blog.entity.Remark;
import com.blog.entity.User;
import com.blog.model.BlogVO;
import com.blog.service.BlogService;
import com.blog.utils.TextPreprocessing;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* Title: BlogService  
* Description:  
* @author 杨惠  
* @date 2020年4月7日  
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private ImageDao imageDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ClassifyDao classifyDao;
	@Autowired
	private RemarkDao remarkDao;
	@Autowired
	private LikeDao likeDao;
	
	/* 统计指定用户的博客数量
	 * @see com.blog.service.BlogService#countBlog(int)
	 */
	public int countBlog(int userid) {
		// TODO Auto-generated method stub
		int num=blogDao.countBlog(userid);
		return num;
	}

	/* 统计用户博客被点赞的数量
	 * @see com.blog.service.BlogService#countBlogLiked(int)
	 */
	public int countBlogLiked(int userid) {
		// TODO Auto-generated method stub
		int num=blogDao.countBlogLiked(userid);
		return num;
	}

	/* 分页获取指定用户的博客信息
	 * @see com.blog.service.BlogService#queryBlogsByUserid(int, int, int)
	 */
	public PageInfo queryBlogsByUserid(int userid, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<BlogInfo> blogs=blogDao.queryBlogsByUserid(userid);
		List<BlogVO> blogVOs=new ArrayList<BlogVO>();
		if(blogs!=null){
			int len=blogs.size();
			for(int i=0;i<len;i++){
				BlogInfo blog=blogs.get(i);
				BlogVO blogVO=new BlogVO();
				String time=blog.getTime();
				int length=time.length();
				time=time.substring(0, length-2);
				blog.setTime(time);
				blogVO.setBlog(blog);
				List<String> imgUrls=imageDao.queryImageUrls(blog.getId());
				User blogger=userDao.queryUserById(userid);
				blogVO.setImgUrls(imgUrls);
				blogVO.setBlogger(blogger);
				blogVOs.add(blogVO);
			}
		}
		PageInfo pageInfo=new PageInfo(blogs);
		pageInfo.setList(blogVOs);
		return pageInfo;
	}

	/* 分页获取用户的点赞博文信息
	 * @see com.blog.service.BlogService#queryLikedBlogs(int, int, int)
	 */
	public PageInfo queryLikedBlogs(int userid, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<BlogInfo> blogs=blogDao.queryLikedBlogs(userid);
		List<BlogVO> blogVOs=new ArrayList<BlogVO>();
		if(blogs!=null){
			int len=blogs.size();
			for(int i=0;i<len;i++){
				BlogInfo blog=blogs.get(i);
				BlogVO blogVO=new BlogVO();
				String time=blog.getTime();
				int length=time.length();
				time=time.substring(0, length-2);
				blog.setTime(time);
				blogVO.setBlog(blog);
				List<String> imgUrls=imageDao.queryImageUrls(blog.getId());
				User blogger=userDao.queryUserById(userid);
				blogVO.setImgUrls(imgUrls);
				blogVO.setBlogger(blogger);
				blogVOs.add(blogVO);
			}
		}
		PageInfo pageInfo=new PageInfo(blogs);
		pageInfo.setList(blogVOs);
		return pageInfo;
	}

	/* 分页获取指定类别下的博客信息
	 * @see com.blog.service.BlogService#queryBlogByClassify(int, int, int)
	 */
	public PageInfo queryBlogByClassify(int classifyid, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<BlogInfo> blogs=blogDao.queryBlogByClassify(classifyid);
		List<BlogVO> blogVOs=new ArrayList<BlogVO>();
		if(blogs!=null){
			int len=blogs.size();
			for(int i=0;i<len;i++){
				BlogInfo blog=blogs.get(i);
				BlogVO blogVO=new BlogVO();
				String time=blog.getTime();
				int length=time.length();
				time=time.substring(0, length-2);
				blog.setTime(time);
				blogVO.setBlog(blog);				
				List<String> imgUrls=imageDao.queryImageUrls(blog.getId());
				int userid=blog.getUserid();
				User blogger=userDao.queryUserById(userid);
				blogVO.setImgUrls(imgUrls);
				blogVO.setBlogger(blogger);
				blogVOs.add(blogVO);
				
			}
		}
		PageInfo pageInfo=new PageInfo(blogs);
		pageInfo.setList(blogVOs);
		return pageInfo;
	}

	public List<BlogInfo> queryBlogByClassify(int classifyid) {
		// TODO Auto-generated method stub
		List<BlogInfo> blogs=blogDao.queryBlogByClassify(classifyid);
		return blogs;
	}

	public int countBlogByClassify(int classifyid) {
		// TODO Auto-generated method stub
		int blogNum=blogDao.countBlogByClassify(classifyid);
		return blogNum;
	}
	/*
	 * 根据时间逆序查找博客（用于首页博客显示：展示最新发表的博客）
	 * @see com.blog.service.BlogService#queryBlogsByTime(int, int)
	 */
	public PageInfo queryBlogsByTime(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<BlogInfo> blogs=blogDao.queryBlogByDate();
		List<BlogVO> blogVOs=new ArrayList<BlogVO>();
		if(blogs!=null){
			int len=blogs.size();
			for(int i=0;i<len;i++){
				BlogInfo blog=blogs.get(i);
				BlogVO blogVO=new BlogVO();
				String time=blog.getTime();
				int length=time.length();
				time=time.substring(0, length-2);
				blog.setTime(time);
				blogVO.setBlog(blog);
				List<String> imgUrls=imageDao.queryImageUrls(blog.getId());
				int userid=blog.getUserid();
				User blogger=userDao.queryUserById(userid);
				blogVO.setImgUrls(imgUrls);
				blogVO.setBlogger(blogger);
				blogVOs.add(blogVO);
			}
		}
		PageInfo pageInfo=new PageInfo(blogs);
		pageInfo.setList(blogVOs);
		return pageInfo;
	}

	/*
	 * 根据关键字查找博客
	 * @see com.blog.service.BlogService#queryBlogsByKey(java.lang.String, int, int)
	 */
	public PageInfo queryBlogsByKey(String key, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		if(key==null) key="";
		PageHelper.startPage(pageNum, pageSize);
		List<BlogInfo> blogs=blogDao.queryBlogByKey(key);
		List<BlogVO> blogVOs=new ArrayList<BlogVO>();
		if(blogs!=null){
			int len=blogs.size();
			for(int i=0;i<len;i++){
				BlogInfo blog=blogs.get(i);
				BlogVO blogVO=new BlogVO();
				String time=blog.getTime();
				int length=time.length();
				time=time.substring(0, length-2);
				blog.setTime(time);
				blogVO.setBlog(blog);
				List<String> imgUrls=imageDao.queryImageUrls(blog.getId());
				int userid=blog.getUserid();
				User blogger=userDao.queryUserById(userid);
				blogVO.setImgUrls(imgUrls);
				blogVO.setBlogger(blogger);
				blogVOs.add(blogVO);
			}
		}
		PageInfo pageInfo=new PageInfo(blogs);
		pageInfo.setList(blogVOs);
		return pageInfo;

	}

	/*
	 * 查找指定博客的详细信息
	 * @see com.blog.service.BlogService#queryBlogById(int)
	 */
	public BlogVO queryBlogById(int id) {
		// 博客浏览量加1
		blogDao.addScanCount(id);
		// 查询博客详情
		BlogVO blogVO=new BlogVO();
		BlogInfo blogInfo=blogDao.queryBlogById(id);
		if(blogInfo==null) return null;
		String time=blogInfo.getTime();
		int length=time.length();
		time=time.substring(0, length-2);
		blogInfo.setTime(time);
		List<String> imgUrls=imageDao.queryImageUrls(id);
		int userId=blogInfo.getUserid();
		User blogger=userDao.queryUserById(userId);
		int classifyId=blogInfo.getClassifyid();
		Classify classify=classifyDao.queryClassifyById(classifyId);
		blogVO.setBlog(blogInfo);
		blogVO.setImgUrls(imgUrls);
		blogVO.setBlogger(blogger);
		blogVO.setClassify(classify);
		return blogVO;
	}

	/* 博客推荐
	 * @see com.blog.service.BlogService#blogRecommend(java.lang.String)
	 */
	public List<BlogInfo> blogRecommend(String title) {
		// TODO Auto-generated method stub
		TextPreprocessing tp=new TextPreprocessing();
		List<String> keys=tp.JieBa(title);
		int len=keys.size();
		List<BlogInfo> blogs=blogDao.queryBlogByTitle(keys, len);
		//获取推荐的博客
		List<BlogInfo> result=getRecommendBlogs(blogs);
		return result;
	}

	/* 博客推荐（筛选）
	 * @see com.blog.service.BlogService#getRecommendBlogs(java.util.List)
	 */
	public List<BlogInfo> getRecommendBlogs(List<BlogInfo> allBlogs) {
		// TODO Auto-generated method stub
		double scanWeight=0.5;  //浏览的权重
		double likeWeight=1;  //点赞的权重
		double commentWeight=2;  //评论的权重
		Map<BlogInfo,Double> blogsGrade=new HashMap<BlogInfo,Double>();  //保存每篇博客的评分
		List<BlogInfo> recommendBlogs=new ArrayList<BlogInfo>();   //待推荐的博客
		int length=allBlogs.size();
		for(int i=0;i<length;i++){
			BlogInfo blog=allBlogs.get(i);
			String time=blog.getTime();
			int timeLen=time.length();
			time=time.substring(0, timeLen-2);
			blog.setTime(time);
			int scanNum=blog.getScanCount();
			int likeNum=blog.getLikeCount();
			double score=(scanWeight*scanNum)+(likeWeight*likeNum);
			int blogId=blog.getId();
			List<Remark> remarks=remarkDao.queryRemark(blogId);
			if(remarks!=null){
				int len=remarks.size();
				for(int j=0;j<len;j++){
					int attitude=remarks.get(j).getAttitude();
					score=score+(commentWeight*attitude);
				}
			}
			blogsGrade.put(blog, score);
		}
		List<Map.Entry<BlogInfo,Double>> list = new ArrayList<Map.Entry<BlogInfo,Double>>(blogsGrade.entrySet()); //转换为list
	    list.sort(new Comparator<Map.Entry<BlogInfo,Double>>() {
	    	public int compare(Map.Entry<BlogInfo,Double> o1, Map.Entry<BlogInfo,Double> o2) {
	    		return o2.getValue().compareTo(o1.getValue());
	        }
	    });
	    int len=list.size();
		if(len<5){
			for (int i=0;i<len;i++) {
			    recommendBlogs.add(list.get(i).getKey());
		     }  
		}else{
			//获取评分前5的博客
		    for (int i=0;i<5;i++) {
		    	recommendBlogs.add(list.get(i).getKey());
	        }  
		}
	       
	    return recommendBlogs;
	}

	/* 删除指定博客
	 * @see com.blog.service.BlogService#deleteBlogById(int)
	 */
	public void deleteBlogById(int blogId) {
		// TODO Auto-generated method stub
		blogDao.deleteBlogById(blogId);
		imageDao.deleteImages(blogId);
		likeDao.deleteLikes(blogId);
		remarkDao.deleteRemark(blogId);
	}

	/* 增加博客信息
	 * @see com.blog.service.BlogService#addBlog(com.blog.entity.BlogInfo)
	 */
	public void addBlog(BlogInfo blog) {
		//获取博客发布时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        blog.setTime(time);
        blog.setRemarkCount(0);
        blog.setLikeCount(0);
        blog.setScanCount(0);
        blogDao.insertBlog(blog);
	}

	/* 修改博客信息
	 * @see com.blog.service.BlogService#updateBlog(com.blog.entity.BlogInfo)
	 */
	public void updateBlog(BlogInfo blog) {
		// TODO Auto-generated method stub
		blogDao.updateBlog(blog);
	}
	
	
}
