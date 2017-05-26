package com.njust.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.njust.ssm.po.User;

public class UserAuthentificationInterceptor implements HandlerInterceptor {

	private static final String[] IGNORE_URL = {"/loginForm.action","/login"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
		System.out.println("preHandle...");
		/*请求的url：http://localhost:8080/ssmusemaven/loginForm.action
		 * requestPath的值：/loginForm.action
		 *请求的url： http://localhost:8080/ssmusemaven/login/admin/123456
		 * requestPath的值：/login/admin/123456
		 */
		String requestPath = request.getServletPath();
		
		for(String url : IGNORE_URL){
			if(requestPath.contains(url)){
				return true;
			}
		}
		
		if(request.getSession().getAttribute("user")!=null){
			return true;
		}
		
		request.getRequestDispatcher("/loginForm.action").forward(request, response);
		
		//只有返回true的时候，才会执行下一个interceptor，如果这是最后一个interceptor，那么将会执行controller方法
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
