package com.test.spring.persistence;

import com.test.spring.domain.SpringDTO;

public class SpringDAOImpl implements SpringDAO{
	
	@Override
	public int getCount() {
		
		return 100;  //select 작업 결과라고 가정
	}
	
	@Override
	public int add(SpringDTO dto) {

		//DB에 Insert 했다고 가정
		System.out.println("insert 완료");
		System.out.println(dto);
		
		return 1;
	}
}
