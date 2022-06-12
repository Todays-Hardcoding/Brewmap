package com.brew.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
	LOGIN_FAILED(404, "LOGIN_FAILED"),
	DUPLICATED_ID(505, "DUPLICATED_ID");
	
	private int status;
	private String code;
	
	ErrorCode(int status, String code) {
		this.status = status;
		this.code = code;
	}

}
