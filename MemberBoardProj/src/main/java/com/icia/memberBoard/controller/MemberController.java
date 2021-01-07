package com.icia.memberBoard.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberBoard.dto.MemberDTO;
import com.icia.memberBoard.service.MemberService;

@Controller
public class MemberController {

	private ModelAndView mav;
	@Autowired
	private MemberService service;
	@Autowired
	private HttpSession session;
	
	private void mav() {
		if(mav == null) {
			mav = new ModelAndView();
		}
	}
	
	@RequestMapping(value = "/signIn")
	private ModelAndView signIn(@RequestParam("main") String main,
								@ModelAttribute MemberDTO dto) {
		mav();
		if(service.signIn(dto)) {
			session.setAttribute("signInId", dto.getMid());
			if(main.equals("signUp")) {
				mav.setViewName("redirect:/./");
			}else {
				mav.setViewName("redirect:/"+main+"?main="+main);	
			}
		}else {
			mav.setViewName("redirect:/./?main=signIn&from="+main);
		}
		return mav;
	}
	
	@RequestMapping(value = "/signUp")
	private ModelAndView signUp(@ModelAttribute MemberDTO dto) throws IllegalStateException, IOException {
		mav();
		if(service.signUp(dto)) {
			mav.setViewName("redirect:/./?main=signIn");
		}else {
			mav.setViewName("redirect:/./?main=signUp");
		}
		return mav;
	}
	
	@RequestMapping(value = "/idCheck")
	private @ResponseBody String idCheck(@ModelAttribute MemberDTO dto) {
		return service.idCheck(dto);
	}
	
	@RequestMapping(value = "/signOut")
	private ModelAndView signOut() {
		mav();
		session.invalidate();
		mav.setViewName("redirect:/./");
		return mav;
	}
	
	@RequestMapping(value = "/memberList")
	private ModelAndView memberList() {
		mav();
		mav.addObject("memberList", service.memberList());
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/memberInfo")
	private ModelAndView memberInfo(@ModelAttribute MemberDTO dto) {
		mav();
		mav.addObject("memberInfo", service.memberInfo(dto));
		mav.addObject("boardCount", service.boardCount(dto));
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/memberDel")
	private ModelAndView memberDel(@RequestParam("main") String main,
									@ModelAttribute MemberDTO dto) {
		mav();
		service.memberDel(dto);
		mav.setViewName("redirect:/memberList?main="+main);
		return mav;
	}
	
	@RequestMapping(value = "/toMemberMod")
	private ModelAndView toMemberMod(@ModelAttribute MemberDTO dto) {
		mav();
		mav.addObject("memberInfo", service.memberInfo(dto));
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/memberMod")
	private ModelAndView memberMod(@ModelAttribute MemberDTO dto) {
		mav();
		if(service.memberMod(dto)) {
			mav.setViewName("home");
		}else {
			mav.setViewName("redirect:/toMemberMod?main=memberMod&mid="+dto.getMid());
		}
		return mav;
	}
}
