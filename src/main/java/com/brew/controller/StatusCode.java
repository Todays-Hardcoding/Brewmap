package com.brew.controller;

import lombok.Getter;

@Getter
public enum StatusCode {
	OK(200, "OK"),
	BAD_REQUEST(400, "BAD_REQUEST"),
	NOT_FOUND(404, "NOT_FOUND"),
	INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR");
	
	private int stauts;
	private String code;
	
	StatusCode(int status, String code) {
		this.stauts = status;
		this.code = code;
	}

}
