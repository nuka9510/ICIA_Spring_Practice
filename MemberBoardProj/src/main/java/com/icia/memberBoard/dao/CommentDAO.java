package com.icia.memberBoard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberBoard.dto.CommentDTO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public boolean commentWrite(CommentDTO dto) {
		return (sql.insert("Comment.commentWrite", dto)==1)?true:false;
	}

	public List<CommentDTO> commentList(CommentDTO dto) {
		return sql.selectList("Comment.commentList", dto);
	}

	public boolean commentDel(CommentDTO dto) {
		return (sql.delete("Comment.commentDel", dto)==1)?true:false;
	}
}
