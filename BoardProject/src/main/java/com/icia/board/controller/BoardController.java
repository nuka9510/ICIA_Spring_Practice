package com.icia.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {

	private ModelAndView mav;
	@Autowired
	private BoardService service;
	
	private void mav() {
		if(mav == null) {
			mav = new ModelAndView();
		}
	}
	
	@RequestMapping(value = "/toBoardWrite", method = RequestMethod.GET)
	private ModelAndView toBoardWrite() {
		mav();
		mav.setViewName("board/BoardWrite");
		return mav;
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	private ModelAndView boardWrite(@ModelAttribute BoardDTO dto) {
		mav();
		if(service.boardWrite(dto)) {
			mav.setViewName("redirect:/boardList");
		}else {
			mav.setViewName("redirect:/toBoardWrite");
		}
		return mav;
	}
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	private ModelAndView boardList() {
		mav();
		mav.addObject("boardList", service.boardList());
		mav.setViewName("board/BoardList");
		return mav;
	}
	
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	private ModelAndView boardView(@ModelAttribute BoardDTO dto) {
		mav();
		mav.addObject("boardView", service.boardView(dto));
		mav.setViewName("board/BoardView");
		return mav;
	}
}
