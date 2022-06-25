package com.brew.exception.user;

import com.brew.enums.ErrorCode;
import com.brew.exception.CustomException;
import com.brew.exception.ErrorResponse;

public class LoginFailException extends CustomException {
    private static final long serialVersionUID = -2116671122895194101L;

    public LoginFailException(ErrorResponse.CustomFieldError customFieldError){
        super(ErrorCode.LOGIN_FAILED, customFieldError);
    }
}
