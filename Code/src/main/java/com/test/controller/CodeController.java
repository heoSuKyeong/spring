package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.CodeDTO;
import com.test.persistence.CodeDAO;

@Controller
public class CodeController {

	@Autowired
	private CodeDAO dao;
	
	@GetMapping(value="/add.do")
	public String add() {
		
		return "add";
				
	}
	
	@PostMapping(value="/addok.do")
	public String addok(CodeDTO dto) {
		
		int result = dao.add(dto);
		
		if (result == 1) {
			return "redirect:/list.do";
		} else {
			return "redirect:/add.do";
		}
		
		
	}
	
	@GetMapping(value="/list.do")
	/* required = true 가 기본 값이기에 아무것도 넘어가지않았을 때 에러가 난다. 그래서 false로 설정해줘야 한다. */
	public String list(Model model, @RequestParam(name="language", required = false) List<String> language) {
		
		// 주소가 넘어오는 경우의 수를 여러개 생각할 수 있다. 이럴 때는 파라미터가 여러개 넘어오는 기준으로 작성한다.
		// list.do
		// list.do?language=java
		// list.do?language=java&language=css
		System.out.println(language);
		
		List<CodeDTO> list = dao.list(language);
		
		model.addAttribute("list", list);
		model.addAttribute("language", language);
		
		return "list";
	}
	
	@GetMapping(value="/view.do")
	public String view(Model model, String seq) {
		
		CodeDTO dto = dao.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
	
	
	
	
	
}
