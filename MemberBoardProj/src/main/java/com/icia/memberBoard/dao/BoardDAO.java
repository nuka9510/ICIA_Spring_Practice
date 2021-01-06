package com.icia.memberBoard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberBoard.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<BoardDTO> boardList() {
		return sql.selectList("Board.boardList");
	}

	public boolean boardWrite(BoardDTO dto) {
		return (sql.insert("Board.boardWrite", dto)==1)?true:false;
	}

	public BoardDTO boardView(BoardDTO dto) {
		sql.update("Board.hitsUpdate", dto);
		return sql.selectOne("Board.boardView", dto);
	}

	public boolean boardDel(BoardDTO dto) {
		return (sql.delete("Board.boardDel", dto)==1)?true:false;
	}

}
