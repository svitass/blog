/**
 * 
 */
package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogDao;
import com.blog.dao.FriendsDao;
import com.blog.entity.Friends;
import com.blog.entity.User;
import com.blog.model.UserVO;
import com.blog.service.FriendsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* Title: FriendsServiceImpl  
* Description:  
* @author 杨惠  
* @date 2020年4月7日  
 */
@Service
@Transactional
public class FriendsServiceImpl implements FriendsService{
	@Autowired
	private FriendsDao friendsDao;
	@Autowired
	private BlogDao blogDao;
	
	/* 查询用户关注的人数
	 * @see com.blog.service.FriendsService#countFollow(int)
	 */
	public int countFollow(int id) {
		// TODO Auto-generated method stub
		int count=friendsDao.countFollow(id);
		return count;
	}

	/* 查找用户的粉丝数
	 * @see com.blog.service.FriendsService#countFans(int)
	 */
	public int countFans(int id) {
		// TODO Auto-generated method stub
		int num=friendsDao.countFans(id);
		return num;
	}

	/* 查询用户关注的的用户信息
	 * @see com.blog.service.FriendsService#queryFollows(int)
	 */
	public PageInfo queryFollows(int id,int pageNum,int pageSize) {
		// 分页
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList=friendsDao.queryFollows(id);
		List<UserVO> userVOList=new ArrayList<UserVO>();
		if(userList!=null){
			int len=userList.size();
			UserVO userVO;
			User user;
			for(int i=0;i<len;i++){
				userVO=new UserVO();
				user=userList.get(i);
				int userid=user.getId();
				int followNum=friendsDao.countFollow(userid); 
				int fansNum=friendsDao.countFans(userid); 
				int blogNum=blogDao.countBlog(userid); 
				int blogLiked=blogDao.countBlogLiked(userid);
				userVO.setUser(user);
				userVO.setFollowNum(followNum);
				userVO.setFansNum(fansNum);
				userVO.setBlogNum(blogNum);
				userVO.setBlogLiked(blogLiked);
				userVO.setFollow(true);
				userVOList.add(userVO);
			}
		}
		PageInfo pageInfo=new PageInfo(userList);
		pageInfo.setList(userVOList);
		return pageInfo;
	}

	/* 查询用户的粉丝信息
	 * @see com.blog.service.FriendsService#queryFans(int, int, int)
	 */
	public PageInfo queryFans(int id, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList=friendsDao.queryFans(id);
		List<UserVO> userVOList=new ArrayList<UserVO>();
		if(userList!=null){
			int len=userList.size();
			UserVO userVO;
			User user;
			for(int i=0;i<len;i++){
				userVO=new UserVO();
				user=userList.get(i);
				int userid=user.getId();
				int followNum=friendsDao.countFollow(userid); 
				int fansNum=friendsDao.countFans(userid); 
				int blogNum=blogDao.countBlog(userid); 
				int blogLiked=blogDao.countBlogLiked(userid);
				userVO.setUser(user);
				userVO.setFollowNum(followNum);
				userVO.setFansNum(fansNum);
				userVO.setBlogNum(blogNum);
				userVO.setBlogLiked(blogLiked);
				Friends friend=friendsDao.getFollow(id, userid);
				if(friend!=null){
					userVO.setFollow(true);
				}else{
					userVO.setFollow(false);
				}
				userVOList.add(userVO);
			}
		}
		PageInfo pageInfo=new PageInfo(userList);
		pageInfo.setList(userVOList);
		return pageInfo;
	}

	/* 取消关注
	 * @see com.blog.service.FriendsService#deleteFollow(int, int)
	 */
	public boolean deleteFollow(int userId, int followId) {
		// TODO Auto-generated method stub
		int result=friendsDao.deleteFollow(userId, followId);
		if(result==0) return false;
		return true;
	}

	/* 增加关注
	 * @see com.blog.service.FriendsService#insertFollow(int, int)
	 */
	public boolean insertFollow(int userId, int followId) {
		// TODO Auto-generated method stub
		Friends friends=friendsDao.getFollow(userId, followId);
		if(friends!=null) return false;
		int result=friendsDao.insertFollow(userId, followId);
		if(result==0) return false;
		return true;
	}

	/* 编号为fansId的用户是否关注了编号为userId的用户
	 * @see com.blog.service.FriendsService#getFollow(int, int)
	 */
	public boolean getFollow(int fansId, int userId) {
		// TODO Auto-generated method stub
		Friends friends=friendsDao.getFollow(fansId, userId);
		if(friends==null) return false;
		return true;
	}

	/* 获取编号为blogerId的用户的关注信息，同时查询编号为userId的用户对bloger关注用户的关注情况
	 * @see com.blog.service.FriendsService#queryFollows(int, int, int, int)
	 */
	public PageInfo queryFollows(int blogerId, int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList=friendsDao.queryFollows(blogerId);
		List<UserVO> userVOList=new ArrayList<UserVO>();
		if(userList!=null){
			int len=userList.size();
			UserVO userVO;
			User user;
			for(int i=0;i<len;i++){
				userVO=new UserVO();
				user=userList.get(i);
				int userid=user.getId();
				int followNum=friendsDao.countFollow(userid); 
				int fansNum=friendsDao.countFans(userid); 
				int blogNum=blogDao.countBlog(userid); 
				int blogLiked=blogDao.countBlogLiked(userid);
				userVO.setUser(user);
				userVO.setFollowNum(followNum);
				userVO.setFansNum(fansNum);
				userVO.setBlogNum(blogNum);
				userVO.setBlogLiked(blogLiked);
				boolean isFollow=getFollow(userId,userid);
				userVO.setFollow(isFollow);
				userVOList.add(userVO);
			}
		}
		PageInfo pageInfo=new PageInfo(userList);
		pageInfo.setList(userVOList);
		return pageInfo;
	}

	/* 获取编号为blogerId的用户的粉丝信息，同时查询编号为userId的用户对bloger粉丝用户的关注情况
	 * @see com.blog.service.FriendsService#queryFans(int, int, int, int)
	 */
	public PageInfo queryFans(int blogerId, int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList=friendsDao.queryFans(blogerId);
		List<UserVO> userVOList=new ArrayList<UserVO>();
		if(userList!=null){
			int len=userList.size();
			UserVO userVO;
			User user;
			for(int i=0;i<len;i++){
				userVO=new UserVO();
				user=userList.get(i);
				int userid=user.getId();
				int followNum=friendsDao.countFollow(userid); 
				int fansNum=friendsDao.countFans(userid); 
				int blogNum=blogDao.countBlog(userid); 
				int blogLiked=blogDao.countBlogLiked(userid);
				userVO.setUser(user);
				userVO.setFollowNum(followNum);
				userVO.setFansNum(fansNum);
				userVO.setBlogNum(blogNum);
				userVO.setBlogLiked(blogLiked);
				boolean isFollow=getFollow(userId,userid);
				userVO.setFollow(isFollow);
				userVOList.add(userVO);
			}
		}
		PageInfo pageInfo=new PageInfo(userList);
		pageInfo.setList(userVOList);
		return pageInfo;
	}

}
