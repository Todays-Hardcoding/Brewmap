package com.brew.exception.user;

import com.brew.enums.ErrorCode;
import com.brew.exception.CustomException;
import com.brew.exception.ErrorResponse;

public class DuplicateIdException extends CustomException {
    private static final long serialVersionUID = -2116671122895194101L;

    public DuplicateIdException(ErrorResponse.CustomFieldError customFieldError){
        super(ErrorCode.DUPLICATED_ID, customFieldError);
    }
}
