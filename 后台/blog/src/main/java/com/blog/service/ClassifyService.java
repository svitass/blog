package com.blog.service;


import java.util.List;

import com.blog.entity.Classify;
import com.github.pagehelper.PageInfo;

/**
* Title: ClassifyService  
* Description:  
* @author 杨惠  
* @date 2020年4月24日  
 */
public interface ClassifyService {
	
	PageInfo queryClassify(int userid,int pageNum,int pageSize);
	
	List<Classify> queryClassify(int userid);
	
	Classify queryClassifyByName(String name,int userid);
	
	void insertClassify(Classify classify);
	
	void updateClassify(Classify classify);
	
	void deleteClassify(int id);
	
	Classify queryClassifyById(int id);
	
	List<Classify> queryAllClassify(int userid);
	
}
