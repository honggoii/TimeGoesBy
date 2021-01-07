package com.honggoii.timegoesby.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    //Entity 생성 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate
    //Entity 최종 변경 시간 자동 저장
    private LocalDateTime modifiedDate;

}
