package com.icia.memberBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.memberBoard.dao.MemberDAO;
import com.icia.memberBoard.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public boolean signIn(MemberDTO dto) {
		return dao.signIn(dto);
	}

	public boolean signUp(MemberDTO dto) throws IllegalStateException, IOException {
		if(!dto.getMprofile().isEmpty()) {
			dto.setMprofilename(System.currentTimeMillis()+"_"+dto.getMprofile().getOriginalFilename());
			dto.getMprofile().transferTo(new File("D:\\ICIA\\Jong Won\\spring\\MemberBoardProj\\src\\main\\webapp\\resources\\memberProfile\\"+dto.getMprofilename()));
		}else {
			dto.setMprofilename("");
		}
		return dao.signUp(dto);
	}

	public String idCheck(MemberDTO dto) {
		return dao.idCheck(dto);
	}

	public List<MemberDTO> memberList() {
		return dao.memberList();
	}

	public MemberDTO memberInfo(MemberDTO dto) {
		return dao.memberInfo(dto);
	}

	public void memberDel(MemberDTO dto) {
		dao.memberDel(dto);
	}

}
