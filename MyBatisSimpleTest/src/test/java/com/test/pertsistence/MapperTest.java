package com.test.pertsistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTest {
	
	//이전 SqlSEssionTemplate를 짖정한 것을 TestMapper 인터페이스가 담당
	//인터페이스는 객체를 생성하지 못하는데 어떻게 참조할 수 있을까?
	//스프링이 알아서 상속받는 객체(자식클래스)를 내부적으로 생성한다.
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void testMapper() {
		
		assertNotNull(mapper);
		//어떤일을 수행해야하는지 구현체를 만들지않았음 그래도 결과값이 나옴
		System.out.println(mapper.getTime());
		System.out.println(mapper.getTime2());
	}

}
