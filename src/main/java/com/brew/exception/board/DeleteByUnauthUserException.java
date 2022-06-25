package com.brew.exception.board;

import com.brew.enums.ErrorCode;
import com.brew.exception.CustomException;
import com.brew.exception.ErrorResponse;

public class DeleteByUnauthUserException extends CustomException {
    private static final long serialVersionUID = -2116671122895194101L;

    public DeleteByUnauthUserException(ErrorResponse.CustomFieldError customFieldError){
        super(ErrorCode.DELETE_BY_UNAUTH_USER, customFieldError);
    }
}