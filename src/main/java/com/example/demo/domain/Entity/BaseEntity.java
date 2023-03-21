package com.example.demo.domain.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Setter
@Getter
@Accessors(chain = true)
@MappedSuperclass
@Access(AccessType.FIELD)
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    public static final String SKIP_DELETED_CLAUSE = "deleted = false";

    @Version
    @JsonIgnore
    private int version = 0;

    @JsonIgnore
    private boolean deleted = false;

    @CreatedDate
    @Column(updatable = false, name = "created_at")
    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant createdAt;

}
