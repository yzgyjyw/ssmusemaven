package com.njust.ssm.exception.resolver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.njust.ssm.exception.CustomerException;

public class CustomerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		
		ex.printStackTrace();
		CustomerException customerException = null;
		if(ex instanceof CustomerException){
			customerException = (CustomerException)ex;
		}else{
			customerException = new CustomerException("未知的错误");
		}
		
		String message = customerException.getMessage();
		request.setAttribute("message", message);
		try {
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return modelAndView;
	}

}
