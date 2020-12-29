package com.icia.member.service;

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
		boolean result = dao.join(dto);
		return result;
	}
}