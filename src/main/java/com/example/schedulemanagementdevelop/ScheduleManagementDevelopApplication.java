package com.example.schedulemanagementdevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing   //BaseEntity 클래스의 생성일자와 수정일자 관리용
@SpringBootApplication
public class ScheduleManagementDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleManagementDevelopApplication.class, args);
    }

}
