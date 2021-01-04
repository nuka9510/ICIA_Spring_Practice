package com.icia.board.dto;

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
	private MultipartFile bfile;
	private String bfilename;
}
