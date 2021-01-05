package com.icia.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.dto.SearchDTO;
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
	private ModelAndView boardWrite(@ModelAttribute BoardDTO dto) throws IllegalStateException, IOException {
		mav();
		if(service.boardWrite(dto)) {
			mav.setViewName("redirect:/boardList?nowPage=1");
		}else {
			mav.setViewName("redirect:/toBoardWrite");
		}
		return mav;
	}
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	private ModelAndView boardList(@ModelAttribute PageDTO pagedto,
									@ModelAttribute SearchDTO searchdto) {
		mav();
		mav.addObject("boardList", service.boardList(pagedto, searchdto));
		mav.addObject("page", pagedto);
		mav.setViewName("board/BoardList");
		return mav;
	}
	
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	private ModelAndView boardView(@ModelAttribute BoardDTO dto,
									@ModelAttribute PageDTO pagedto) {
		mav();
		mav.addObject("boardView", service.boardView(dto));
		mav.addObject("page", pagedto);
		mav.setViewName("board/BoardView");
		return mav;
	}
	
	@RequestMapping(value = "/toBoardMod", method = RequestMethod.GET)
	private ModelAndView toBoardMod(@ModelAttribute BoardDTO dto) {
		mav();
		mav.addObject("boardInfo", service.boardInfo(dto));
		mav.setViewName("board/BoardMod");
		return mav;
	}
	
	@RequestMapping(value = "/boardMod", method = RequestMethod.POST)
	private ModelAndView boardMod(@ModelAttribute BoardDTO dto) {
		mav();
		if(service.boardMod(dto)) {
			mav.setViewName("redirect:/boardView?bnumber="+dto.getBnumber());
		}else {
			mav.setViewName("redirect:/toBoardMod?bnumber="+dto.getBnumber());
		}
		return mav;
	}
	
	@RequestMapping(value = "/boardDel", method = RequestMethod.GET)
	private ModelAndView boardDel(@ModelAttribute BoardDTO dto) {
		mav();
		if(service.boardDel(dto)) {
			mav.setViewName("redirect:/boardList");
		}else {
			mav.setViewName("redirect:/boardView?bnumber="+dto.getBnumber());
		}
		return mav;
	}
}
