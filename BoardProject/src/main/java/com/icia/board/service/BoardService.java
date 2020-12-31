package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public boolean boardWrite(BoardDTO dto) {
		return dao.boardWrite(dto);
	}

	public List<BoardDTO> boardList() {
		return dao.boardList();
	}

	public BoardDTO boardView(BoardDTO dto) {
		return dao.boardView(dto);
	}

}
