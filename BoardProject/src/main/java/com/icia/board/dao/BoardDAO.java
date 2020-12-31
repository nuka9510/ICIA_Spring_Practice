package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public boolean boardWrite(BoardDTO dto) {
		boolean result = false;
		result = (sql.insert("Board.boardWrite", dto)==1)?true:false;
		return result;
	}

	public List<BoardDTO> boardList() {
		return sql.selectList("Board.boardList");
	}

	public BoardDTO boardView(BoardDTO dto) {
		BoardDTO result = sql.selectOne("Board.boardView", dto);
		if(result != null) {
			sql.update("Board.boardHits", dto);
		}
		return result;
	}

}
