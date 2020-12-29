package com.icia.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private MemberService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO dto) {
		if(service.login(dto)) {
			return "home";
		}else {
			return "MemberLogin";
		}
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute MemberDTO dto) {
		if(service.join(dto)) {
			return "MemberLogin";
		}else {
			return "MemberJoin";
		}
	}
	
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String toLogin() {
		
		return "MemberLogin";
	}
	
	@RequestMapping(value = "/toJoin", method = RequestMethod.GET)
	public String toJoin() {
		
		return "MemberJoin";
	}
	
}