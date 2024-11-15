# schedule_management_develop
## 개요
1. 일정 관리 APP과 로그인 인증 기능 구현
2. Spring Boot와 JPA를 활용하여 일정과 유저 관리, 회원가입 및 로그인 기능 제공
   (1) 일정 Schedule : 생성, 조회, 수정, 삭제 기능 구현
   (2) 사용자 User (CRD) : 생성, 조회, 삭제 기능 구현
   (3) 유저와 일정의 연관 관계 설정(ManyToOne)
   (4) 회원 가입 기능 구현
   (5) 로그인(인증,인가) 기능 구현

## 1. API 명세서
[노션링크] https://www.notion.so/13557d2a94228012b2d5f76d15aaa982
* User
![image](https://github.com/user-attachments/assets/9bd7083f-009a-45ef-b3b7-efe0baee55df)

* Schedule
  
![image](https://github.com/user-attachments/assets/af767f3a-4447-4cc8-a5d1-2e91e1a3d4bc)





*** 

## 2. ERD
![image](https://github.com/user-attachments/assets/ad07395d-8039-4fbf-8444-4d69a49acafe)




*** 

## 3. SQL 쿼리 작성
**1) Create**

■ 필수 기능 가이드 개발에 필요한 테이블을 생성하는 query를 작성
<pre><code>	 
# Create user table
CREATE TABLE user (
user_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '유저 식별자',
username VARCHAR(255) NOT NULL COMMENT '유저명',
email VARCHAR(255) NOT NULL UNIQUE COMMENT  '이메일',
password VARCHAR(255) NOT NULL COMMENT  '비밀번호',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
);
</code></pre>

<pre><code>	 
# Create schedule table
CREATE TABLE Schedule (
schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 식별자',
user_id INT COMMENT '유저 식별자',
title VARCHAR(255) NOT NULL COMMENT '일정 제목',
contents LONGTEXT NOT NULL COMMENT '일정 내용',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '일정 작성일',
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '일정 수정일',
FOREIGN KEY (user_id) REFERENCES User(user_id)  #user_id는 User 테이블의 user_id를 참조한다.
);
</code></pre>

**2) Insert**

■  일정 생성을 하는 query를 작성
<pre><code>
# Insert user
INSERT INTO user (
"username": "baek",
"email": "a@naver.com",
"password": "1234",
"create_date": TIMESTAMP
)
</code></pre>

<pre><code>
# Insert schedule
INSERT INTO user (
"title": 자바공부",
"content": "1주차 강의 복습",
"username": "baek",
"create_date": TIMESTAMP
)
</code></pre>



**3) Select**

■ 전체 일정을 조회하는 query를 작성
<pre><code>
SELECT *
FROM schedules
ORDER BY createdate DESC;
</code></pre>

**4) Select**

■  선택 일정을 조회하는 query를 작성
<pre><code>
SELECT *
FROM schedules
WHERE id='1';
</code></pre>

**5) update**

■  선택한 일정을 수정하는 query를 작성
<pre><code>
UPDATE schedules
SET title='자바 공부'
WHERE title='자바 강의 수강';
</code></pre>

**6) Delete**

■  선택한 일정을 삭제하는 query를 작성
<pre><code>
DELETE FROM users
WHERE id = 1;
</code></pre>

*** 

