package com.icia.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sql;

	public MemberDAO() {
		
	}

	public boolean idCheck(MemberDTO dto) {
		boolean result = false;
		result = sql.selectOne("Member.idCheck", dto).equals("1");
		return result;
	}

	public boolean idpwCheck(MemberDTO dto) {
		boolean result = false;
		result = sql.selectOne("Member.idpwCheck", dto).equals("1");
		return result;
	}

	public boolean join(MemberDTO dto) {
		boolean result = false;
		result = (sql.insert("Member.join", dto)==1)?true:false;
		return result;
	}
}