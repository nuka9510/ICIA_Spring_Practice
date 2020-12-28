package com.icia.spring_201228.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.spring_201228.dao.Spring_201228_DAO;

@Service
public class Spring_201228_Service {
	@Autowired
	private Spring_201228_DAO dao;
	
	public Spring_201228_Service() {
		
	}

	public void insert(String data1) {
		dao.insert(data1);
	}
	
	
}
