package com.test.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.AddressDTO;

@Repository
public class AddressDAOImpl implements AddressDAO{
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public int add(AddressDTO dto) {
		return this.template.insert("rest.add", dto);
	}
	
	@Override
	public List<AddressDTO> list() {
		return this.template.selectList("rest.list");
	}
	
	@Override
	public int edit(AddressDTO dto) {
		return this.template.update("rest.edit", dto);
	}
	
	@Override
	public int del(String seq) {
		return this.template.delete("rest.del", seq);
	}
	
	@Override
	public AddressDTO get(String seq) {
		return this.template.selectOne("rest.get", seq);
	}
	
}
