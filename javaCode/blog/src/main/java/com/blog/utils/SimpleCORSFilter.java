/**
 * 
 */
package com.blog.utils;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* Title: SimpleCORSFilter  
* Description:  跨域配置类
* @author 杨惠  
* @date 2020年4月6日  
 */
public class SimpleCORSFilter implements Filter {
    private boolean isCross = false;

    public void destroy() {
        isCross = false;
    }
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String isCrossStr = filterConfig.getInitParameter("IsCross");
        isCross = isCrossStr.equals("true") ? true : false;
        System.out.println(isCrossStr);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 if (isCross) {
	            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	      //      System.out.println("拦截请求: " + httpServletRequest.getServletPath());
	            httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
	            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	            httpServletResponse.setHeader("Access-Control-Max-Age", "0");
	            httpServletResponse.setHeader("Access-Control-Allow-Headers",
	                    "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
	            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
	            httpServletResponse.setHeader("XDomainRequestAllowed", "1");
	        }
	        chain.doFilter(request, response);
	}
}
