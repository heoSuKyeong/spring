package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.spring.persistence.SpringDAO;
import com.test.spring.persistence.SpringDAOImpl;

public class Ex02Controller implements Controller{
	
	//1. 멤버변수 승격 
	private SpringDAO dao;
	
	//2. 생성자 생성
	public Ex02Controller(SpringDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//업무 중 DB작업을 할 때 DAO에게 위임을 한다. > Ex02Controller 객체가 SpringDAO 객체를 의존하고 있다. > 스프링이 생성하도록 바꿔준다.
		//SpringDAO dao = new SpringDAOImpl();
		
		int count = dao.getCount();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("count", count);
		mv.setViewName("ex02");
		
		return mv;
	}
}
