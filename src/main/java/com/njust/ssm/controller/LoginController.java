package com.njust.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.njust.ssm.po.User;

@Controller
public class LoginController {
	
	@RequestMapping("/loginForm")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("/login/{username}/{password}")
	public String login(HttpServletRequest request,HttpServletResponse response,
			@PathVariable("username") String username,@PathVariable("password") String loginname,
			HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		user.setUsername(username);
		
		request.setAttribute("user", user);
		
		session.setAttribute("user", user);
		
		//注意，这里是跳转到另一个页面,在另一个路径下，那么此时就必须写成全路径，加上"/"
		return "forward:/queryItems.action";
		 
	}
}
