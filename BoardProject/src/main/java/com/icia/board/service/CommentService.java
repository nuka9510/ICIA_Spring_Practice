package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dao.CommentDAO;
import com.icia.board.dto.CommentDTO;

@Service
public class CommentService {

	@Autowired
	private CommentDAO dao;

	public boolean commentWrite(CommentDTO dto) {
		return dao.commentWrite(dto);
	}

	public List<CommentDTO> commentList(CommentDTO dto) {
		return dao.commentList(dto);
	}
}
