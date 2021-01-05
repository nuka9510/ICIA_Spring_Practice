package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.CommentDTO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public boolean commentWrite(CommentDTO dto) {
		boolean result = false;
		result = (sql.insert("Comment.commentWrite", dto)==1)?true:false;
		return result;
	}

	public List<CommentDTO> commentList(CommentDTO dto) {
		return sql.selectList("Comment.commentList", dto);
	}
}
