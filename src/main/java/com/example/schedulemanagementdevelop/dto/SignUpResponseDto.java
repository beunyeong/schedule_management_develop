package com.example.schedulemanagementdevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {                // 회원가입 응답 내용

    private final Long id;
    private final String username;

    public SignUpResponseDto(Long id, String username) {
        this.id = id;
        this.username = username;

    }



}
