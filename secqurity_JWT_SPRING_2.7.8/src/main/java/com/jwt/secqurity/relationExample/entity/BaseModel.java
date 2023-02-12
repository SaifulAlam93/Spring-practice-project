package com.jwt.secqurity.relationExample.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Version
    //private Long version;

    private Boolean active;

    /*@Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)*/
    @CreatedDate
    private LocalDateTime createdAt;

    private Integer createdBy;

	/*@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;*/

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private Integer updatedBy;

    @PrePersist
    public void prePersist() {
        this.active = true;
        //this.createdAt = new Date();
    }

	/*@PreUpdate
	public void preUpdate() {
		//this.active = true;
		this.updatedAt = new Date();
	}*/

}
