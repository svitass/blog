/**
 * 
 */
package com.blog.dao;

import java.util.List;

/**
* Title: ImageDao  
* Description:  对博客的图片信息进行操作
* @author 杨惠  
* @date 2020年4月23日  
 */
public interface ImageDao {

	List<String> queryImageUrls(int blogid);
	
	void deleteImages(int blogId);
}
