package com.test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.MyBatisDTO;
import com.test.persistence.MyBatisDAO;

@Controller
public class MyBatisController {
	
	@Autowired
	//MyBatisDAO 찾아 인스턴스하여 대입한다. new MyBatisDAO()
	private MyBatisDAO dao;

	@GetMapping(value="/test.do")
	public String test() {
		
		System.out.println("test");
		
		//의존 객체를 Spring DI를 통해 만들기
		//MyBatisDAO dao = new MyBatisDAOImpl();
		
		dao.test();
		
		
		return "list";
	}
	
	@GetMapping(value="/add.do")
	public String add() {
		
		
		return "add";
	}
	
	
	@PostMapping(value="/addok.do")
	public String addok(MyBatisDTO dto, Model model) {
		
		int result = dao.add(dto);
		
		model.addAttribute("result", result);
		
		return "addok";
	}
	
	
	//1. 반환값(x), 매개변수(x)
	//- 정적쿼리
	@GetMapping(value="/m1.do")
	public String m1() {
		
		this.dao.m1();
		return "list";
	}
	
	//2. 반환값(x), 매개변수(o)
	@GetMapping(value="/m2.do")
	public String m2(String seq, Model model) {
		//매개변수 seq 앞에 @RequestParam(name="seq") 생략 되었다. 
		//m2.do?seq=5 와 같이 m2 메소드를 호출한다.
		
		int result = this.dao.m2(seq);
		
		model.addAttribute("result", result);
		
		return "list";
	}
	
	//2. 반환값(x), 매개변수(o)
	@GetMapping(value="/m3.do")
	public String m3(Model model) {
		
		MyBatisDTO dto = new MyBatisDTO();
		dto.setName("수수깡");
		dto.setAge("26");
		dto.setAddress("서울시 강남구");
		dto.setGender("f");
		
		int result = this.dao.m3(dto);
		
		model.addAttribute("result", result);
		
		return "list";
	}
	
	
	//2. 반환값(x), 매개변수(o)
	@GetMapping(value="/m4.do")
	public String m4(Model model) {
		
		//update tblMyBatis set address = ? where seq = ?
		HashMap<String, String>map = new HashMap<String, String>(); 
		
		map.put("seq", "21");
		map.put("address", "서울시 강남구 역삼동");
		
		int result = this.dao.m4(map);
		
		model.addAttribute("result", result);
		
		return "list";
	}
	
	//3. 반환값(O), 매개변수(O,X)
	//3.1 단일값 반환(1행 1열)
	//select count(*) from tblMyBatis;
	
	@GetMapping(value="/m5.do")
	public String m5(Model model) {
		int count = this.dao.m5();
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	//3. 반환값(O), 매개변수(O,X)
	//3.2 레코드 1개 반환(컬럼 n개)
	//select * from tblMyBatis where seq = ?;
	@GetMapping(value="/m6.do")
	public String m6(String seq, Model model) {
		MyBatisDTO dto = this.dao.m6(seq);
		
		model.addAttribute("dto", dto);
		
		return "list";
	}
	
	//3. 반환값(O), 매개변수(O,X)
	//3.3 레코드 N개 반환(컬럼 1개)
	//select name from tblMyBatis;
	@GetMapping(value="/m7.do")
	public String m7(Model model) {
		List<String> names = this.dao.m7();
		
		model.addAttribute("names", names);
		
		return "list";
	}
	
	//3. 반환값(O), 매개변수(O,X)
	//3.4 레코드 N개 반환(컬럼 N개)
	//select * from tblMyBatis;
	@GetMapping(value="/m8.do")
	public String m8(Model model) {
		List<String> list = this.dao.m8();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	@GetMapping(value="/m9.do")
	public String m9(Model model, String table) {
		
		//경우에 따라 조회할 테이블이 다른데 하나의 메소드 안에서 해결하고 싶을 때, 주소에 테이블명도 함께 넘긴다.
		//m9.do?table=테이블명
		//select count(*) from employees
		//select count(*) from tblMyBatis
		
		int count = this.dao.m9(table);
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	
	@GetMapping(value="/m10.do")
	public String m10(Model model) {
		
		int count = this.dao.m10();
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	@GetMapping(value="/m11.do")
	public String m11(Model model, String word) {
		
		//주소 검색 (like 절 사용)
		List<MyBatisDTO> list = this.dao.m11(word);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	//동적쿼리
	@GetMapping(value="/m12.do")
	public String m12(Model model, String type) {
		
		//m12.do?type=1 일때는 select first_name from employees;
		//m12.do?type=2 일 때는 select last_name from employees;
		
		List<String> names = dao.m12(type);
		
		model.addAttribute("names", names);
		
		return "list";
	}
	
	//동적쿼리
	@GetMapping(value="/m13.do")
	public String m13(Model model, String column, String word) {
		
		//이름 검색 시, m13.do?column=name&word=홍길동
		//주소 검색 시, m13.do?column=address&word=역삼
		//나이 검색 시, m13.do?column=age&word=25
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);
		
		List<MyBatisDTO> list = this.dao.m13(map);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	
}
