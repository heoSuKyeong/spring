package com.test.spring.persistence;

public class SpringDAOImpl implements SpringDAO{
	
	@Override
	public int getCount() {
		
		return 100;  //select 작업 결과라고 가정
	}
}
