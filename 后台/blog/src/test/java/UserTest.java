

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.BlogDao;
import com.blog.dao.UserDao;
import com.blog.entity.BlogInfo;
import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.utils.NavieBayes;
import com.blog.utils.TextPreprocessing;
import com.github.pagehelper.PageInfo;

/**
* Title: UserTest  
* Description:  
* @author 杨惠  
* @date 2020年3月15日  
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mybatis-config.xml","classpath:spring-context.xml","classpath:spring-mvc.xml"})

public class UserTest {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private BlogService blogService;
	/**
	 * 
	 */
	public UserTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Test
	public void testComment(){
		String str="写的真的太差了";
		NavieBayes nb=new NavieBayes(str);
		System.out.println(nb.getClassify());
	}
	
}
