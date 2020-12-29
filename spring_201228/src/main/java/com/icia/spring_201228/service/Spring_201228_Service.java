package com.icia.spring_201228.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.spring_201228.dao.Spring_201228_DAO;
import com.icia.spring_201228.dto.Spring_201228_DTO;

@Service
public class Spring_201228_Service {
	@Autowired
	private Spring_201228_DAO dao;
	
	private ModelAndView mav;
	
	public Spring_201228_Service() {
		
	}

	public void insert(String data1) {
		dao.insert(data1);
	}

	public ModelAndView selectDB() {
		String selectResult = dao.selectDB();
		mav = new ModelAndView();
		mav.addObject("selectDB", selectResult);
		mav.setViewName("home");
		return mav;
	}

	public void insert(Spring_201228_DTO dto) {
		dao.insert(dto);
	}
	
}