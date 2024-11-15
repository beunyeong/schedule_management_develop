package com.example.schedulemanagementdevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity                 //이 어노테이션은 기본 생성자가 필수
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;


    //기본 생성자
    public User() {
    }

    // User을 쉽게 생성하기 위해서 생성자 추가
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }

}
