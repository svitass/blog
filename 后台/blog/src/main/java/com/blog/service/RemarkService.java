package com.blog.service;

import com.blog.entity.Remark;
import com.github.pagehelper.PageInfo;

/**
 * Title: RemarkService
 * Description:
 * @author 杨惠
 * @date 2020年5月23日
 */
public interface RemarkService {
	
	PageInfo queryRemark(int blogId,int pageNum,int pageSize);
	
	void addRemark(Remark remark);
}
