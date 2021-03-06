package com.icia.memberBoard.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {

	private int bnumber;
	private String bwriter;
	private String bpassword;
	private String btitle;
	private String bcontents;
	private String bdate;
	private int bhits;
	private String bfilename;
	private MultipartFile bfile;
}
