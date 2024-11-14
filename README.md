# schedule_management_develop

## 1. API 명세서
* User
![image](https://github.com/user-attachments/assets/9bd7083f-009a-45ef-b3b7-efe0baee55df)

* Schedule

![image](https://github.com/user-attachments/assets/17f6c50e-03b3-4887-a01c-9fef03618417)




*** 

## 2. ERD
![image](https://github.com/user-attachments/assets/ad07395d-8039-4fbf-8444-4d69a49acafe)




*** 

## 3. SQL 쿼리 작성
**1) Create**

■ 필수 기능 가이드 개발에 필요한 테이블을 생성하는 query를 작성
<pre><code>	 
CREATE schedules users (
id INTEGER(30) NOT NULL,
password VARCHAR(20) NOT NULL,  
title VARCHAR(100) NOT NULL, 
content VARCHAR(100) NOT NULL, 
createdate DATETIME NOT NULL,
updateddate DATETIME NOT NULL,
username VARCHAR(20) NOT NULL
);    
</code></pre>

**2) Insert**

■  일정 생성을 하는 query를 작성
<pre><code>
INSERT INTO schedules (
"title": "LV0 과제 제출",
"content": "API명세서 작성하여 검사 받기",
"createdate": "now()",
"updateddate": "now()"
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
SET title='LV0 과제 검토' --> 할일,작성자명만 수정
WHERE title='LV0 과제 제출';
</code></pre>

**6) Delete**

■  선택한 일정을 삭제하는 query를 작성
<pre><code>
DELETE FROM users
WHERE id = 1;
</code></pre>

*** 

