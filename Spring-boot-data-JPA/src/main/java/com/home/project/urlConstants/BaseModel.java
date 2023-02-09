package com.home.project.urlConstants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Boolean active;

//    @CreatedDate
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    private Integer createdBy;

//    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Integer updatedBy;

    @PrePersist
    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseModel baseModel = (BaseModel) o;
        return id != null && Objects.equals(id, baseModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
