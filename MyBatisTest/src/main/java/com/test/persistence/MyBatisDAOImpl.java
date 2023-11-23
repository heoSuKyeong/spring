package com.test.persistence;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.MyBatisDTO;

@Repository
public class MyBatisDAOImpl implements MyBatisDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void test() {

		System.out.println(template == null);
	}
	
	@Override
	public int add(MyBatisDTO dto) {
		
		/*
		JDBC 에서 
		1. Connection : 연결
		2. Statement
		3. ResultSet : 결과
		
		MyBatis 에서
		1. SqlSessionTemplate 이 모두 담당한다.
		- 반환값이 없을 때
		stat.executeUpdate
		1. template.insert()
		2. template.update()
		3. template.delete()
		
		- 반환값이 있을 때
		stat.executeQuery()
		1. template.selectOne() : 결과셋의 레코드가 1개일 때
		2. template.selectList() : 결과셋의 레코드가 여러개일 때
		
		*/
		
		//this.template.insert("매퍼 네임스페이스.쿼리 id", 인자값)
		return this.template.insert("mybatis.add", dto);
	}
}
