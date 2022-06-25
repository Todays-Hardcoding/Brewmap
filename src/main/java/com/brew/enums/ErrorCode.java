package com.brew.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"), //입력값 오류
    METHOD_NOT_ALLOWED(405, "C002", " Method Not Allowed"), //존재하지않는 메소드
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"), //엔티티를 찾을 수 없음
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"), // 서버에러
    INVALID_TYPE_VALUE(400, "C005", "Invalid Type Value"), // 유효하지않은 타입
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"), //권한 필요
    INVALID_INPUT_FILE_TYPE(400, "C007" ,"Invalid Input File Type"), //유효하지않은 파일 타입
    INVALID_INPUT_DATE(400, "C008", " Invalid Input Date"), // 유효하지않은 날짜값
    CANNOT_BE_REGISTRATION(400, "C009", "Cannot be Registration"), //등록할 수 없는 값
    CANNOT_BE_REMOVE(400, "C010", "Cannot be Remove"), //삭제할 수 없는 값
    CANNOT_ACCESS_PAGE(400, "C011", "Cannot Access Page"), //접근 불가 페이지
    DUPLICATE_VALUE(400, "C012", "Duplicate Value"), //중복값 제한

    // Login
    DUPLICATED_ID(400, "L001", "DUPLICATED_ID"), // 중복된 아이디
    LOGIN_FAILED(403, "L002", "LOGIN_FAILED"), // 로그인 실패

    // Board
    DELETE_BY_UNAUTH_USER(400, "B001", "DELETE_BY_UNAUTH_USER"), // 다른 유저가 글 지우려 함
    INVALID_PARAM(400, "B002", "INVALID_PARAM"), // 적절하지 않은 파라미터

    // Member
    USER_NOT_FOUND(403, "M000", "User Not Found"), //유저를 찾을 수 없음
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"), //이메일 중복됨
    LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid"), //유효하지않은 로그인정보
    PASSWORD_MISMATCH(400, "M003", "Password mismatch"), //비밀번호 틀림
    PASSWORD_FORMAT_NOT_CORRECT(400, "M004", "Password format is Not Correct"), //비밀번호 형식이 올바르지않음

    // Admin
    ID_DUPLICATION(400, "A001", "ID is Duplication"), //아이디 중복
    CANNOT_BE_CHANGED(400, "A002","Cannot be Changed"), // 변경할 수 없는 값

    //File
    INVALID_EXTENSION(400, "F001", "Invalid Extension"), //허용되지않은 확장자명

    ;

    private final String code;
    private final String message;
    private int status;

    private ErrorCode(final int status, final String code, final String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
    public boolean equals(String code) {
        return this.code.equals(code);
    }
    public static ErrorCode of(String code) {
        return Arrays.stream(ErrorCode.values())
                .filter(user -> user.equals(code))
                .findAny()
                .orElse(INTERNAL_SERVER_ERROR);
    }
}