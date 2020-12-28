package com.icia.spring_201228;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.spring_201228.service.Spring_201228_Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	ModelAndView mav;
	@Autowired
	private Spring_201228_Service service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/spring_201228_1", method = RequestMethod.GET)
	public String spring_201228_1() {
		
		return "spring_201228_1";
	}
	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public ModelAndView param(@RequestParam("param1") String param1,
						@RequestParam("param2") String param2) {
		System.out.println(param1);
		System.out.println(param2);
		
		this.mav = new ModelAndView();
		mav.addObject("mav1", param1);
		mav.addObject("mav2", param2);
		mav.setViewName("spring_201228_2");
		
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@RequestParam("data1") String data1) {
		service.insert(data1);
		return "home";
	}
}
