package com.icia.memberBoard.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	private ModelAndView signIn(@RequestParam("main") String main,
								@ModelAttribute MemberDTO dto) {
		mav();
		if(service.signIn(dto)) {
			session.setAttribute("signInId", dto.getMid());
			mav.setViewName("redirect:/"+main+"?main="+main);
		}else {
			mav.setViewName("redirect:/./?main=signIn&from="+main);
		}
		return mav;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	private ModelAndView signUp(@RequestParam("from") String from,
								@ModelAttribute MemberDTO dto) throws IllegalStateException, IOException {
		mav();
		if(service.signUp(dto)) {
			mav.setViewName("home");
		}else {
			mav.setViewName("redirect:/./?main=signUp&from="+from);
		}
		return mav;
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	private @ResponseBody String idCheck(@ModelAttribute MemberDTO dto) {
		return service.idCheck(dto);
	}
	
	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	private ModelAndView signOut() {
		mav();
		session.invalidate();
		mav.setViewName("redirect:/./");
		return mav;
	}
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	private ModelAndView memberList() {
		mav();
		mav.addObject("memberList", service.memberList());
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
	private ModelAndView memberInfo(@ModelAttribute MemberDTO dto) {
		mav();
		mav.addObject("memberInfo", service.memberInfo(dto));
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/memberDel", method = RequestMethod.GET)
	private ModelAndView memberDel(@RequestParam("main") String main,
									@ModelAttribute MemberDTO dto) {
		mav();
		service.memberDel(dto);
		mav.setViewName("redirect:/memberList?main="+main);
		return mav;
	}
}
