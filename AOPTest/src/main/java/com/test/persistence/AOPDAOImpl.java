package com.test.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class AOPDAOImpl implements AOPDAO{
	
	//sql 생략
	
	@Override
	public void list() {
		//업무 구현 하지않고 흔적 남기기용
		System.out.println("DAO.list()");
	}
	
	@Override
	public void add() {
		//업무 구현 하지않고 흔적 남기기용
		System.out.println("DAO.add()");
	}

	@Override
	public void view() {
		//업무 구현 하지않고 흔적 남기기용
		System.out.println("DAO.view()");
	}
}
