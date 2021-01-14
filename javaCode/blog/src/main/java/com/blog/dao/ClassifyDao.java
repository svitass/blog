package com.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.Classify;

/**
* Title: ClassifyDao  
* Description: 对博客类别信息进行操作 
* @author 杨惠  
* @date 2020年4月24日  
 */
public interface ClassifyDao {

	List<Classify> queryClassify(int userid);
	
	Classify queryClassifyByName(@Param("name")String name,@Param("userid")int userid);
	
	void insertClassify(Classify classify);
	
	void updateClassify(Classify classify);
	
	void deleteClassify(int id);
	
	Classify queryClassifyById(int id);
	
}
