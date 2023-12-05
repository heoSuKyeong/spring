package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping(value = "/index.do")
	public String index() {
		//모든 사용자 접근 가능
		return "index";

	}
	
	@GetMapping(value = "/member/member.do")
	public String member() {
		//회원 및 관리자 접근 가능
		return "member/member";
		
	}
	
	@GetMapping(value = "/admin/adming.do")
	public String admin() {
		//관리자 전용
		return "admin/admin";

	}

}
