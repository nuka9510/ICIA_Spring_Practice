package com.icia.memberBoard.dto;

import lombok.Data;

@Data
public class SearchDTO {

	private String searchType;
	private String searchWord;
	private String searchOrder;
}
