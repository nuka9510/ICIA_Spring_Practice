package com.icia.memberBoard.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberBoard.dto.BoardDTO;
import com.icia.memberBoard.dto.PageDTO;
import com.icia.memberBoard.dto.SearchDTO;
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
	
	@RequestMapping(value = "/boardList")
	private ModelAndView boardList(@ModelAttribute PageDTO pdto,
									@ModelAttribute SearchDTO sdto) {
		mav();
		mav.addObject("boardList", service.boardList(pdto, sdto));
		mav.addObject("page", pdto);
		mav.addObject("search", sdto);
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/boardWrite")
	private ModelAndView boardWrite(@RequestParam("main") String main,
									@ModelAttribute BoardDTO dto) throws IllegalStateException, IOException {
		mav();
		if(service.boardWrite(dto)) {
			mav.setViewName("redirect:/"+main+"?main="+main+"&nowPage=1");
		}else {
			mav.setViewName("redirect:/./?main=boardWrite");
		}
		return mav;
	}
	
	@RequestMapping(value = "/boardView")
	private ModelAndView boardView(@ModelAttribute BoardDTO dto) {
		mav();
		mav.addObject("boardView", service.boardView(dto));
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/boardDel")
	private ModelAndView boardDel(@RequestParam("main") String main,
									@ModelAttribute PageDTO pdto,
									@ModelAttribute BoardDTO dto) {
		mav();
		if(service.boardDel(dto)) {
			mav.setViewName("redirect:/"+main+"?main="+main+"&nowPage="+pdto.getNowPage());
		}else {
			mav.setViewName("redirect:/boardView?main=boardView&bnumber="+dto.getBnumber()+"&nowPage="+pdto.getNowPage());
		}
		return mav;
	}
	
	@RequestMapping(value = "/toBoardMod")
	private ModelAndView toBoardMod(@ModelAttribute BoardDTO dto) {
		mav();
		mav.addObject("boardView", service.boardInfo(dto));
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/boardMod")
	private ModelAndView boardMod(@RequestParam("main") String main,
									@ModelAttribute PageDTO pdto,
									@ModelAttribute BoardDTO dto) {
		mav();
		if(service.boardMod(dto)) {
			mav.setViewName("redirect:/"+main+"?main="+main+"&bnumber="+dto.getBnumber()+"&nowPage="+pdto.getNowPage());
		}else {
			mav.setViewName("redirect:/toBoardMod?main=boardMod&bnumber="+dto.getBnumber()+"&nowPage="+pdto.getNowPage());
		}
		return mav;
	}
}
