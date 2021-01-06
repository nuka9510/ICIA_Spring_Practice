package com.icia.memberBoard.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberBoard.dto.BoardDTO;
import com.icia.memberBoard.service.BoardService;

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
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	private ModelAndView boardList() {
		mav();
		mav.addObject("boardList", service.boardList());
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	private ModelAndView boardWrite(@RequestParam("main") String main,
									@ModelAttribute BoardDTO dto) throws IllegalStateException, IOException {
		mav();
		if(service.boardWrite(dto)) {
			mav.setViewName("redirect:/"+main+"?main="+main);
		}else {
			mav.setViewName("redirect:/./?main=boardWrite");
		}
		return mav;
	}
	
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	private ModelAndView boardView(@ModelAttribute BoardDTO dto) {
		mav();
		mav.addObject("boardView", service.boardView(dto));
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/boardDel", method = RequestMethod.GET)
	private ModelAndView boardDel(@RequestParam("main") String main,
									@ModelAttribute BoardDTO dto) {
		mav();
		if(service.boardDel(dto)) {
			mav.setViewName("redirect:/"+main+"?main="+main);	
		}else {
			mav.setViewName("redirect:/boardView?main=boardView&bnumber="+dto.getBnumber());
		}
		return mav;
	}
}
