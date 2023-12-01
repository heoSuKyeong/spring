package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.AddressDTO;
import com.test.persistence.AddressDAO;

@RestController
public class RESTController {

	@Autowired
	private AddressDAO dao;
	/*
	public String m1() {
		
		//return "m1";
		
		//@RestController를 사용하면 요청 메서드의 반환값에 자동으로 ResponseBody가 적용된다.
	}
	*/
	
	//CRUD + REST
	
	//추가하기
	//1. http://localhost:8090/rest/address
	//2. POST
	//3. return int 
	
	//@RequestMapping(value="/address", method=RequestMethod.POST)
	@PostMapping(value="/address")
	public int add(@RequestBody AddressDTO dto) {

		return dao.add(dto);
	}
	
	//목록보기
	//REST API는 설계부터 하는 것이 편하다.
	//1. 요청 주소 : http://localhost:8090/rest/address
	//2. 요청 메소드 : GET
	//3. 리턴 타입 : List<DTO>
	@GetMapping(value = "/address")		//주소는 같지만 요청하는 방식이 다르다.
	public List<AddressDTO> list() {

		return dao.list();

	}
	
	
	//수정하기
	//1. 요청 주소 : http://localhost:8090/rest/address/primaryKey
	//2. 요청 메소드 : PUT or PATCH (PUT을 주로 사용한다.)
	//3. 리턴 타입 : int
	//브라우저는 put, patch를 요청할 수 없어 client tool를 사용해야한다.
	
	//@RequestMapping(value="/address/{seq}", method=RequestMethod.PUT)		//경로 변수(PathVariable) : 경로의 일부처럼 표현되었다고하여 경로 변수라고 불린다.
	@PutMapping(value="/address/{seq}")
	public int edit(@RequestBody AddressDTO dto, @PathVariable String seq) { 	//@PathVariable 은 @RequestParam 사용법과 유사하다.
		
		//한번 더 포장
		dto.setSeq(seq);
		
		return dao.edit(dto);
	}
	
	//삭제하기
	//1. 요청 주소 : http://localhost:8090/rest/address/primaryKey
	//2. 요청 메소드 : DELETE
	//3. 리턴 타입 : int
	
	@DeleteMapping(value="/address/{seq}")
	public int del(@PathVariable String seq) {
		
		return dao.del(seq);
	}
	
	//검색하기(=상세보기)
	//
	@GetMapping(value = "/address/{seq}")
	public AddressDTO get(@PathVariable("seq") String seq) {
		return dao.get(seq);
	}
}
