package com.example.schedulemanagementdevelop.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {         // 회원가입 요청 내용

    private final String username;      //아이디
    private final String password;      //비밀번호
    private final String email;         //이메일


    // 생성자 추가
    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
