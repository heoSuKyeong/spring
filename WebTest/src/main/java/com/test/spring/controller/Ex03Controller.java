package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
public class Ex03Controller implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
}
*/

@Controller
@RequestMapping(value="/ex03.do")	//@WebServlet("/ex03.do")와 동일한 역학을 한다.
public class Ex03Controller {
	
	//요청 메서드(doGet/doPost/handleRequest) 자유롭게 생성
	//return 타입도 자유롭다.
	//핸들러(요청 메서드) 메서드의 최소한의 약속으로 @RequestMapping 어노테이션을 붙인다
	
	@RequestMapping
	public String test() {
		//업무 코드
		//JSP 호출하기 : ModelAndView
		
		//ModelAndView 자동으로 생성되며 ViewResolver 가 동작된다.
		return "ex03";
	}
	
	//일반 메서드
	public int sum(int a, int b) {
		
		return a + b;
	}
	
}