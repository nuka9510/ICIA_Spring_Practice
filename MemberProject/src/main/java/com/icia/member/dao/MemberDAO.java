package com.icia.member.dao;

import java.util.List;

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

	public List<MemberDTO> memberList() {
		return sql.selectList("Member.memberList");
	}

	public MemberDTO memberInfo(MemberDTO dto) {
		return sql.selectOne("Member.memberInfo", dto);
	}

	public boolean memberDel(MemberDTO dto) {
		boolean result = false;
		result = (sql.delete("Member.memberDel", dto)==1)?true:false; 
		return result;
	}

	public boolean memberMod(MemberDTO dto) {
		boolean result = false;
		result = (sql.update("Member.memberMod", dto)==1)?true:false;
		return result;
	}

	public String idDuplicate(MemberDTO dto) {
		String result = (sql.selectOne("Member.idDuplicate", dto).equals("0"))?"true":"false";
		return result;
	}
}