package com.test.mapper;

import org.apache.ibatis.annotations.Select;

//인터페이스 매퍼
public interface TestMapper {
	
	//어노테이션(SQL 구현)
	@Select("select count(*) from tblAddress")	
	String getTime();
	
	String getTime2();
	
}
