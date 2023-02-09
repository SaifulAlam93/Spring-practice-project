//package com.home.project.entity;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.*;
//import org.hibernate.Hibernate;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.PrePersist;
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//@Entity
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class Player {
//
//
//	@Id
//	@Column(name = "USER_ID", nullable = false)
//	private String userName;
//
//
//	private Boolean active;
//
//
//	@CreatedDate
//	private LocalDateTime createdAt;
//
//	private Integer createdBy;
//
//
//	@LastModifiedDate
//	private LocalDateTime updatedAt;
//
//	private Integer updatedBy;
//
//	@PrePersist
//	public void prePersist() {
//		this.active = true;
//	}
//
//	private String fullName;
//
//	private String address;
//
//	@Column(name = "EMAIL", nullable = false, unique = true)
//	private String email;
//
//	@Column(name = "MOBILE", nullable = true)
//	private String mobile;
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//		Player player = (Player) o;
//		return userName != null && Objects.equals(userName, player.userName);
//	}
//
//	@Override
//	public int hashCode() {
//		return getClass().hashCode();
//	}
//}
