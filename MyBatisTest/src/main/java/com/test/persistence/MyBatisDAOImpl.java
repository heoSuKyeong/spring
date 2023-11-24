package com.test.persistence;

import java.util.HashMap;
import java.util.List;

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
	
	@Override
	public void m1() {
		
		//update tblMyBatis set age = age + 1;
		//excuteUpdate / excuteQuery > insert,update,delete,selectOne,selectList 으로 세분화 되었다.
		//적용된 행의 갯수를 반환(피드백)한다.
		int result = this.template.update("mybatis.m1");
		
		System.out.println("적용된 행의 개수: " + result);
		
	}
	
	@Override
	public int m2(String seq) {
		
		//delete from tblMyBatis where seq = ?
		return this.template.delete("mybatis.m2", seq);
		
	}
	
	@Override
	public int m3(MyBatisDTO dto) {
		
		//insert
		//데이터를 보낼 때는 하나이던, 여러개이던 인자값을 하나만 넘길 수 있다. 그래서 여러개의 값을 넘길 때는 dto로 포장해서 넘긴다.
		return this.template.insert("mybatis.m3", dto);
	}
	
	@Override
	public int m4(HashMap<String, String> map) {
		//update
		return this.template.update("mybatis.m4", map);
	}
	
	@Override
	public int m5() {
		//selectOne 실행한 결과값은 담는 매개변수의 자료형에 따라 변한다.
		//String 변수에 담으면 String으로 반환하고, int 변수에 담으면 int로 반환한다. 
		//resultset에 담아서 조회할 필요 없이 selectOne 하나의 메서드로 해결할 수 있다.
		//int result = this.template.selectOne("mybatis.m5");
		
		return this.template.selectOne("mybatis.m5");
	}
	
	@Override
	public MyBatisDTO m6(String seq) {
		return this.template.selectOne("mybatis.m6", seq);
	}
	
	@Override
	public List<String> m7() {

		/*
		String sql = "";
		stat = conn.createStatment();
		rs = stat.excuteQuery(sql);
		
		List<String> names = new ArrayList<String>();
		
		while(rs.next()) {
			names.add(rs.getString("name"));
		}
		
		return list;
		
		 */
		
		return this.template.selectList("mybatis.m7");
	}
	
	@Override
	public List<String> m8() {
		
		/*
		String sql = "";
		stat = conn.createStatment();
		rs = stat.excuteQuery(sql);
		
		List<MyBatisDTO> names = new ArrayList<MyBatisDTO>();
		
		while(rs.next()) {
			MyBatisDTO dto = new MyBatisDTO();
			dto.setSeq(rs.getString("seq"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getString("age"));
			
			list.add(dto);
		}
		
		return list;
		
		 */

		return this.template.selectList("mybatis.m8");
	}
	
	@Override
	public int m9(String table) {
		return this.template.selectOne("mybatis.m9", table);
	}

	@Override
	public int m10() {
		return this.template.selectOne("mybatis.m10");
	}
	
	@Override
	public List<MyBatisDTO> m11(String word) {
		return this.template.selectList("mybatis.m11", word);
	}
	
	@Override
	public List<String> m12(String type) {
		return this.template.selectList("mybatis.m12", type);
	}
	
	@Override
	public List<MyBatisDTO> m13(HashMap<String, String> map) {
		return this.template.selectList("mybatis.m13", map);
	}
}
