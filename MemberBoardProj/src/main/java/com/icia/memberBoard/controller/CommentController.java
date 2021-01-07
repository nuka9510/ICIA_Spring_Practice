package com.icia.memberBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberBoard.dto.CommentDTO;
import com.icia.memberBoard.service.CommentService;

@Controller
public class CommentController {

	private ModelAndView mav;
	@Autowired
	private CommentService service;
	
	private void mav() {
		if(mav == null) {
			mav = new ModelAndView();
		}
	}
	
	@RequestMapping(value = "/commentWrite")
	private ModelAndView commentWrite(@ModelAttribute CommentDTO dto) {
		mav();
		if(service.commentWrite(dto)) {
			mav.setViewName("redirect:/commentList?cbnumber="+dto.getCbnumber());
		}
		return mav;
	}
	
	@RequestMapping(value = "/commentList")
	private @ResponseBody List<CommentDTO> commentList(@ModelAttribute CommentDTO dto) {
		return service.commentList(dto);
	}
	
	@RequestMapping(value = "/commentDel")
	private ModelAndView commentDel(@ModelAttribute CommentDTO dto) {
		mav();
		if(service.commentDel(dto)) {
			mav.setViewName("redirect:/commentList?cbnumber="+dto.getCbnumber());
		}
		return mav;
	}
}
