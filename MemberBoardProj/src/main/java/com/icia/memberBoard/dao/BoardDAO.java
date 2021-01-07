package com.icia.memberBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberBoard.dto.BoardDTO;
import com.icia.memberBoard.dto.PageDTO;
import com.icia.memberBoard.dto.SearchDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<BoardDTO> boardList(PageDTO pdto, SearchDTO sdto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pdto);
		map.put("search", sdto);
		return sql.selectList("Board.boardList", map);
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

	public int boardListCount(SearchDTO sdto) {
		return sql.selectOne("Board.boardListCount", sdto);
	}

	public boolean boardMod(BoardDTO dto) {
		return (sql.update("Board.boardMod", dto)==1)?true:false;
	}

	public BoardDTO boardInfo(BoardDTO dto) {
		return sql.selectOne("Board.boardView", dto);
	}

}
