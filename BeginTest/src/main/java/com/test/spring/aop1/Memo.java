package com.test.spring.aop1;

public interface Memo {
	
	//각 업무들이 언제 발생했는지 기록하는 log 파일을 만들어야 한다.(보조업무)
	
	//메모쓰기
	void add(String memo);
	
	//메모 읽기
	String read(int seq) throws Exception;
	
	//메모 수정
	boolean edit(int seq, String memo);
	
	//메모 삭제
	boolean del(int seq);
	
	
	
}
