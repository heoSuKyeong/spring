package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	
}
