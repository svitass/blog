/**
 * 
 */
package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogDao;
import com.blog.dao.ClassifyDao;
import com.blog.entity.BlogInfo;
import com.blog.entity.Classify;
import com.blog.model.ClassifyVO;
import com.blog.service.ClassifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* Title: ClassifyServiceImpl  
* Description:  
* @author 杨惠  
* @date 2020年4月24日  
 */
@Service
@Transactional
public class ClassifyServiceImpl implements ClassifyService{
	@Autowired
	private ClassifyDao classifyDao;
	@Autowired
	private BlogDao blogDao;
	/* 分页获取用户的博客类别信息
	 * @see com.blog.service.ClassifyService#queryClassify(int, int, int)
	 */
	public PageInfo queryClassify(int userid, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Classify> classifyList=classifyDao.queryClassify(userid);
		List<ClassifyVO> classifyVOList=new ArrayList<ClassifyVO>();
		if(classifyList!=null){
			int len=classifyList.size();
			for(int i=0;i<len;i++){
				Classify classify=classifyList.get(i);
				int blogNum=blogDao.countBlogByClassify(classify.getId());
				ClassifyVO classifyVO=new ClassifyVO();
				classifyVO.setClassify(classify);
				classifyVO.setBlogNum(blogNum);
				//取该类别下的前10条博文数据展示
		//		PageHelper.startPage(1, 10);
				List<BlogInfo> blogs=blogDao.queryBlogByClassify(classify.getId());
				classifyVO.setBlogs(blogs);
				classifyVOList.add(classifyVO);
			}
		}
		PageInfo pageInfo=new PageInfo(classifyList);
		pageInfo.setList(classifyVOList);
		return pageInfo;
	}
	/*
	 * 获取用户的博客类别信息（只需获取部分）
	 * @see com.blog.service.ClassifyService#queryClassify(int)
	 */
	public List<Classify> queryClassify(int userid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 5);
		List<Classify> classifyList=classifyDao.queryClassify(userid);
		return classifyList;
	}
	/*
	 * 获取指定类别信息
	 * @see com.blog.service.ClassifyService#queryClassifyByName(java.lang.String, int)
	 */
	public Classify queryClassifyByName(String name, int userid) {
		// TODO Auto-generated method stub
		Classify classify=classifyDao.queryClassifyByName(name, userid);
		return classify;
	}
	/*
	 * 新增一条博客类别记录
	 * @see com.blog.service.ClassifyService#insertClassify(com.blog.entity.Classify)
	 */
	public void insertClassify(Classify classify) {
		// TODO Auto-generated method stub
		classifyDao.insertClassify(classify);
	}
	/*
	 * 修改指定博客类别信息
	 * @see com.blog.service.ClassifyService#updateClassify(com.blog.entity.Classify)
	 */
	public void updateClassify(Classify classify) {
		// TODO Auto-generated method stub
		classifyDao.updateClassify(classify);
	}
	/*
	 * 删除指定博客类别信息
	 * @see com.blog.service.ClassifyService#deleteClassify(int)
	 */
	public void deleteClassify(int id) {
		// TODO Auto-generated method stub
		classifyDao.deleteClassify(id);
	}
	
	/*
	 * 根据类别id查询指定博客类别
	 * @see com.blog.service.ClassifyService#queryClassifyById(int)
	 */
	public Classify queryClassifyById(int id) {
		// TODO Auto-generated method stub
		Classify classify=classifyDao.queryClassifyById(id);
		return classify;
	}
	
	/* 查询指定用户所有的类别
	 * @see com.blog.service.ClassifyService#queryAllClassify(int)
	 */
	public List<Classify> queryAllClassify(int userid) {
		// TODO Auto-generated method stub
		List<Classify> classifyList=classifyDao.queryClassify(userid);
		return classifyList;
	}
	
	
	
}
