package com.blog.dao;

import java.util.List;

import com.blog.entity.Remark;

/**
 * Title: RemarkDao
 * Description: 对评论信息进行操作
 * @author 杨惠
 * @date 2020年5月23日
 */
public interface RemarkDao {

	List<Remark> queryRemark(int blogId);
	
	void addRemark(Remark remark);
	
	void deleteRemark(int blogId);
}
