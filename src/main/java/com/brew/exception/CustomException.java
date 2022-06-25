package com.brew.exception;

import com.brew.enums.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 5249875553031312439L;

    private ErrorCode errorCode;
    private ErrorResponse.CustomFieldError customFieldError;

    public CustomException(ErrorCode errorCode, ErrorResponse.CustomFieldError customFieldError) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.customFieldError = customFieldError;
    }


}