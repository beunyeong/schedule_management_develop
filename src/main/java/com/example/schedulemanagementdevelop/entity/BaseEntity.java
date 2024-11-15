package com.example.schedulemanagementdevelop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {


    @CreatedDate
    @Column(updatable = false)      //생성일자는 한번 설정 된 이후에는 수정하지 않는다.
    private LocalDateTime createdAt;

    @LastModifiedDate           //엔티티가 수정 될 때 자동으로 수정된 시간으로 업데이트
    private LocalDateTime updatedAt;

}
