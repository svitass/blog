/**
 * 
 */
package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogDao;
import com.blog.dao.LikeDao;
import com.blog.entity.Like;
import com.blog.service.LikeService;

/**
 * Title: LikeServiceImpl
 * Description:
 * @author 杨惠
 * @date 2020年5月24日
 */
@Service
@Transactional
public class LikeServiceImpl implements LikeService{
	@Autowired
	private LikeDao likeDao;
	@Autowired
	private BlogDao blogDao;
	
	/* 当前用户是否关注过指定博客
	 * @see com.blog.service.LikeService#isLiked(int, int)
	 */
	public boolean isLiked(int blogId, int userId) {
		// TODO Auto-generated method stub
		Like like=likeDao.queryLike(blogId, userId);
		if(like==null) return false;
		return true;
	}

	/* 点赞博客
	 * @see com.blog.service.LikeService#addLike(int, int)
	 */
	public void addLike(int blogId, int userId) {
		// TODO Auto-generated method stub
		likeDao.insertLike(blogId, userId);
		//博客点赞数加1
		blogDao.addLikeCount(blogId);
	}

	/* 取消点赞
	 * @see com.blog.service.LikeService#cancelLike(int, int)
	 */
	public void cancelLike(int blogId, int userId) {
		// TODO Auto-generated method stub
		likeDao.deleteLike(blogId, userId);
		//博客点赞数减1
		blogDao.decreaseLikeCount(blogId);
	}

	

}
