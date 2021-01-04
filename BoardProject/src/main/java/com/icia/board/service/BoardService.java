package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public boolean boardWrite(BoardDTO dto) throws IllegalStateException, IOException {
		dto.setBfilename(System.currentTimeMillis()+"_"+dto.getBfile().getOriginalFilename());
		
		if(!dto.getBfile().isEmpty()) {
			dto.getBfile().transferTo(new File("D:\\ICIA\\Jong Won\\spring\\BoardProject\\src\\main\\webapp\\resources\\uploadFile\\"+dto.getBfilename()));
		}

		return dao.boardWrite(dto);
	}

	public List<BoardDTO> boardList(PageDTO pagedto) {
		pagedto.calcPage(dao.boardListCount(), 3, 5);
		return dao.boardList(pagedto);
	}

	public BoardDTO boardView(BoardDTO dto) {
		return dao.boardView(dto);
	}

	public BoardDTO boardInfo(BoardDTO dto) {
		return dao.boardInfo(dto);
	}

	public boolean boardMod(BoardDTO dto) {
		return dao.boardMod(dto);
	}

	public boolean boardDel(BoardDTO dto) {
		return dao.boardDel(dto);
	}

}
