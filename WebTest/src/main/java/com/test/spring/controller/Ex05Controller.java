package com.test.spring.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.spring.domain.SpringDTO;
import com.test.spring.persistence.SpringDAO;
import com.test.spring.persistence.SpringDAOImpl;

@Controller
public class Ex05Controller {
	
	//@RequestMapping(value="/ex05.do", method=RequestMethod.GET)
	@GetMapping(value="/ex05.do")
	public String ex05() {
		
		return "ex05";
	}
	/*
	//@RequestMapping(value="/ex05ok.do", method=RequestMethod.POST)
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(HttpServletRequest req, HttpServletResponse resp) {
		
		//데이터 수신
		// Servlet&JSP : req.getParameter(), req.getParameterValues()
		// req를 사용하기 위해 HttpServletRequest 를 파라미터로 넣어준다.
		
		System.out.println(req == null);
		System.out.println(resp == null);
		System.out.println();
		
		String data = req.getParameter("data");
		req.setAttribute("data", data);
		
		return "ex05ok";
	}
	*/
	/*
	//@RequestParam, Model 사용
	@PostMapping(value="/ex05ok.do")
	//<div><input type="text" name="data"></div> 의 name과 연결
	public String ex05ok(@RequestParam(name = "data") String data, Model model) {
		
		
		//System.out.println(data);
		
		//req.setAttribute("data", data) 와 동일
		model.addAttribute("data", data);
		
		return "ex05ok";
	}
	*/
	/*
	@PostMapping(value="/ex05ok.do")
	//텍스트박스의 name과 변수가 같아야 @RequestParam 생략 가능하다.
	public String ex05ok(String data, Model model) {
		model.addAttribute("data", data);
		return "ex05ok";
	}
	*/
	
	/*
	//복합 데이터 수신
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("address") String address, Model model) {
		
		SpringDTO dto = new SpringDTO();
		dto.setName(name);
		dto.setAddress(address);
		dto.setAge(age);
		
		SpringDAO dao = new SpringDAOImpl();
		
		int result = dao.add(dto);
		
		model.addAttribute("result", result);
		
		return "ex05ok";
	}
	*/
	/*
	//복합 데이터를 DTO로 수신
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(SpringDTO dto, String seq, Model model) {
		
		SpringDAO dao = new SpringDAOImpl();
		
		int result = dao.add(dto);
		
		System.out.println(seq);
		
		model.addAttribute("result", result);
		
		return "ex05ok";
	}
	*/
	/*
	//다중 값 수신1
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(Model model, HttpServletRequest req) {
		
		String[] cb = req.getParameterValues("cb");
		
		System.out.println(Arrays.toString(cb));
		
		return "ex05ok";
	}
	*/
	/*
	//다중 값 수신2
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(Model model, @RequestParam("cb") String[] cb) {
		
		System.out.println(Arrays.toString(cb));
		
		return "ex05ok";
	}
	*/
	
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(@ModelAttribute(name="data") String data) {
		
		System.out.println(data);
		
		return "ex05ok";
	}
	
	
	
}
