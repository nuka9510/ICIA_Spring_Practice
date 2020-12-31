package com.icia.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired MemberDAO dao;

	public MemberService() {
		
	}

	public boolean login(MemberDTO dto) {
		boolean result = false;
		if(dao.idCheck(dto)) {
			if(dao.idpwCheck(dto)) {
				result = true;
			}
		}
		return result;
	}

	public boolean join(MemberDTO dto) {
		return dao.join(dto);
	}

	public List<MemberDTO> memberList() {
		return dao.memberList();
	}

	public MemberDTO memberInfo(MemberDTO dto) {
		return dao.memberInfo(dto);
	}

	public boolean memberDel(MemberDTO dto) {
		return dao.memberDel(dto);
	}

	public boolean memberMod(MemberDTO dto) {
		return dao.memberMod(dto);
	}

	public String idDuplicate(MemberDTO dto) {
		return dao.idDuplicate(dto);
	}
}