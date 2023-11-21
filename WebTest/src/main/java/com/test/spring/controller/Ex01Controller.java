package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Ex01Controller implements Controller{
	
	//doGet,doPost == handleRequest
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//업무 진행
		
		//뷰 호출(JSP)
		//이전에는 RequsetDispatcher 에서 forward()를 이용하였다.
		
		//Spring MVC 프로젝트에서는 ModelAndView 사용
		
		ModelAndView mv = new ModelAndView();
		
		//mv.setViewName("/WEB-INF/views/ex01.jsp");
		mv.setViewName("ex01");
		
		// /WEB-INF/views/ + ex01 + .jsp
		
		request.setAttribute("name", "susukkang");
		mv.addObject("age", 26);	//권장
		
		
		return mv;
	}

}
