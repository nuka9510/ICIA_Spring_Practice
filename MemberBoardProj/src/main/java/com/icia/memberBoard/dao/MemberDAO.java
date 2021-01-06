package com.icia.memberBoard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberBoard.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public boolean signIn(MemberDTO dto) {
		return (sql.selectOne("Member.signIn", dto).equals("1"))?true:false;
	}

	public boolean signUp(MemberDTO dto) {
		return (sql.insert("Member.signUp", dto)==1)?true:false;
	}

	public String idCheck(MemberDTO dto) {
		return (sql.selectOne("Member.idCheck", dto).equals("0"))?"true":"false";
	}

	public List<MemberDTO> memberList() {
		return sql.selectList("Member.memberList");
	}

	public MemberDTO memberInfo(MemberDTO dto) {
		return sql.selectOne("Member.memberInfo", dto);
	}

	public void memberDel(MemberDTO dto) {
		sql.delete("Member.memberDel", dto);
	}

}
