package com.icia.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService service;
	private ModelAndView mav;
	
	private void mav() {
		if(mav == null) {
			mav = new ModelAndView();
		}
	}
	
	@RequestMapping(value = "/commentWrite", method = RequestMethod.POST)
	private ModelAndView commentWrite(@ModelAttribute CommentDTO dto) {
		mav();
		if(service.commentWrite(dto)) {
			mav.setViewName("redirect:/commentList?cbnumber="+dto.getCbnumber());
		}
		return mav;
	}
	
	@RequestMapping(value = "/commentList", method = RequestMethod.GET)
	private @ResponseBody List<CommentDTO> commentList(@ModelAttribute CommentDTO dto) {
		return service.commentList(dto);
	}
}
