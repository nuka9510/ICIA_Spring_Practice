package com.icia.member;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private ModelAndView mav;
	@Autowired
	private MemberService service;
	@Autowired
	private HttpSession session;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	private void mav() {
		if(mav == null) {
			mav = new ModelAndView();
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private ModelAndView home() {
		mav();
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private ModelAndView login(@ModelAttribute MemberDTO dto) {
		mav();
		if(service.login(dto)) {
			session.setAttribute("loginId", dto.getMid());
			mav.setViewName("home");
		}else {
			mav.setViewName("MemberLogin");
		}
		return mav;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	private ModelAndView join(@ModelAttribute MemberDTO dto) {
		mav();
		if(service.join(dto)) {
			mav.setViewName("MemberLogin");
			return mav;
		}else {
			mav.setViewName("MemberJoin");
			return mav;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	private ModelAndView logout() {
		mav();
		session.invalidate();
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	private ModelAndView toLogin() {
		mav();
		mav.setViewName("MemberLogin");
		return mav;
	}
	
	@RequestMapping(value = "/toJoin", method = RequestMethod.GET)
	private ModelAndView toJoin() {
		mav();
		mav.setViewName("MemberJoin");
		return mav;
	}
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	private ModelAndView memberList() {
		mav();
		mav.addObject("memberList", service.memberList());
		mav.setViewName("MemberList");
		return mav;
	}
	
	@RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
	private ModelAndView memberInfo(@ModelAttribute MemberDTO dto) {
		mav();
		mav.addObject("memberInfo", service.memberInfo(dto));
		mav.setViewName("MemberView");
		return mav;
	}
	
	@RequestMapping(value = "/memberDel", method = RequestMethod.GET)
	private ModelAndView memberDel(@ModelAttribute MemberDTO dto) {
		mav();
		mav.addObject("result", service.memberDel(dto));
		mav.setViewName("redirect:/memberList");
		return mav;
	}
	
	@RequestMapping(value = "/toMemberMod", method = RequestMethod.GET)
	private ModelAndView toMemberMod(@ModelAttribute MemberDTO dto) {
		mav();
		mav.addObject("memberInfo", service.memberInfo(dto));
		mav.setViewName("MemberUpdate");
		return mav;
	}
	
	@RequestMapping(value = "/memberMod", method = RequestMethod.POST)
	private ModelAndView memberMod(@ModelAttribute MemberDTO dto) {
		mav();
		if(service.memberMod(dto)) {
			mav.setViewName("home");
		}else {
			mav.setViewName("redirect:/toMemberMod?mid="+dto.getMid());
		}
		return mav;
	}
}