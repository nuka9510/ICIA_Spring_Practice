package com.icia.memberBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.memberBoard.dao.BoardDAO;
import com.icia.memberBoard.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public List<BoardDTO> boardList() {
		return dao.boardList();
	}

	public boolean boardWrite(BoardDTO dto) throws IllegalStateException, IOException {
		if(!dto.getBfile().isEmpty()) {
			dto.setBfilename(System.currentTimeMillis()+"_"+dto.getBfile().getOriginalFilename());
			dto.getBfile().transferTo(new File("D:\\ICIA\\Jong Won\\spring\\MemberBoardProj\\src\\main\\webapp\\resources\\uploadFile\\"+dto.getBfilename()));
		}else {
			dto.setBfilename("");
		}
		return dao.boardWrite(dto);
	}

	public BoardDTO boardView(BoardDTO dto) {
		return dao.boardView(dto);
	}

	public boolean boardDel(BoardDTO dto) {
		return dao.boardDel(dto);
	}

}
