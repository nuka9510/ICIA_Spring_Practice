package com.icia.memberBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.memberBoard.dao.BoardDAO;
import com.icia.memberBoard.dto.BoardDTO;
import com.icia.memberBoard.dto.PageDTO;
import com.icia.memberBoard.dto.SearchDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public List<BoardDTO> boardList(PageDTO pdto, SearchDTO sdto) {
		pdto.calcPage(dao.boardListCount(sdto), 5, 10);
		return dao.boardList(pdto, sdto);
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

	public boolean boardMod(BoardDTO dto) {
		return dao.boardMod(dto);
	}

	public BoardDTO boardInfo(BoardDTO dto) {
		return dao.boardInfo(dto);
	}

}
