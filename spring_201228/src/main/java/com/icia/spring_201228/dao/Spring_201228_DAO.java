package com.icia.spring_201228.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.spring_201228.dto.Spring_201228_DTO;

@Repository
public class Spring_201228_DAO {
	@Autowired
	private SqlSessionTemplate sql;
	
	public Spring_201228_DAO() {
		
	}

	public void insert(String data1) {
		sql.insert("Test.insertDB", data1);
	}

	public String selectDB() {
		return sql.selectOne("Test.selectDB");
	}

	public void insert(Spring_201228_DTO dto) {
		sql.insert("Test.insertDB_2", dto);
	}
	
}