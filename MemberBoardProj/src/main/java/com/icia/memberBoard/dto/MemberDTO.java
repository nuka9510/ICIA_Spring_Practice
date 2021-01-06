package com.icia.memberBoard.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberDTO {

	private String mid;
	private String mpassword;
	private String mname;
	private String mbirth;
	private String mphone;
	private String memail;
	private MultipartFile mprofile;
	private String mprofilename;
	private String mpostcode;
	private String maddress;
	private String mdetailAddress;
	private String mextraAddress;
}
