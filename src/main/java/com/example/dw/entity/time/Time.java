package com.example.dw.entity.time;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //테이블 매핑x, 자식 Entity 매핑정보를 상속
@EntityListeners(AuditingEntityListener.class)
//JPA에 해당 Entity는 Auditing 기능을 사용한다는 것을 알림
public class Time {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
