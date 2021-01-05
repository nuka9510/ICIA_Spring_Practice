package com.icia.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.dto.SearchDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public boolean boardWrite(BoardDTO dto) {
		boolean result = false;
		result = (sql.insert("Board.boardWrite", dto)==1)?true:false;
		return result;
	}

	public List<BoardDTO> boardList(PageDTO pagedto, SearchDTO searchdto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagedto);
		map.put("search", searchdto);
		return sql.selectList("Board.boardList", map);
	}

	public BoardDTO boardView(BoardDTO dto) {
		BoardDTO result = sql.selectOne("Board.boardView", dto);
		if(result != null) {
			sql.update("Board.boardHits", dto);
		}
		return result;
	}

	public BoardDTO boardInfo(BoardDTO dto) {
		return sql.selectOne("Board.boardView", dto);
	}
	
	public boolean boardMod(BoardDTO dto) {
		boolean result = false;
		result = (sql.update("Board.boardMod", dto)==1)?true:false;
		return result;
	}

	public boolean boardDel(BoardDTO dto) {
		boolean result = false;
		result = (sql.delete("Board.boardDel", dto)==1)?true:false;
		return result;
	}

	public int boardListCount(SearchDTO searchdto) {
		return sql.selectOne("Board.boardListCount", searchdto);
	}

}
