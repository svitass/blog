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
import com.blog.dao.RemarkDao;
import com.blog.dao.UserDao;
import com.blog.entity.Remark;
import com.blog.entity.User;
import com.blog.model.RemarkVO;
import com.blog.service.RemarkService;
import com.blog.utils.NavieBayes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Title: RemarkServiceImpl
 * Description:
 * @author 杨惠
 * @date 2020年5月23日
 */
@Service
@Transactional
public class RemarkServiceImpl implements RemarkService {

	@Autowired
	private RemarkDao remarkDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	
	/* 分页查询评论信息
	 * @see com.blog.service.RemarkService#queryRemark(int, int, int)
	 */
	public PageInfo queryRemark(int blogId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Remark> remarkList=remarkDao.queryRemark(blogId);
		List<RemarkVO> remarks=new ArrayList<RemarkVO>();
		if(remarkList!=null){
			int length=remarkList.size();
			Remark remark=null;
			RemarkVO remarkVO=null;
			User author=null;
			for(int i=0;i<length;i++){
				remarkVO=new RemarkVO();
				remark=remarkList.get(i);
				author=userDao.queryUserById(remark.getUserid());
				String time=remark.getTime();
				int len=time.length();
				time=time.substring(0, len-2);
				remark.setTime(time);
				remarkVO.setRemark(remark);
				remarkVO.setAuthor(author);
				remarks.add(remarkVO);
			}
		}
		PageInfo pageInfo=new PageInfo(remarkList);
		pageInfo.setList(remarks);
		return pageInfo;
	}

	/* 添加博客评论
	 * @see com.blog.service.RemarkService#addRemark(com.blog.entity.Remark)
	 */
	public void addRemark(Remark remark) {
		// 获取当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        remark.setTime(time);
        int attitude=0;
        String comment=remark.getComment();
        NavieBayes nb=new NavieBayes(comment);
        String classify=nb.getClassify();
        System.out.println("分类结果"+classify);
        if(classify.equals("积极")){
        	attitude = 1;
        	System.out.println("分类结果"+classify);
        }else{
        	attitude = -1;
        	System.out.println("分类结果"+classify);
        }
        remark.setAttitude(attitude);
        remarkDao.addRemark(remark);
        //博客评论数加1
        int blogId=remark.getBlogid();
        blogDao.addRemarkCount(blogId);
	}
	
}
