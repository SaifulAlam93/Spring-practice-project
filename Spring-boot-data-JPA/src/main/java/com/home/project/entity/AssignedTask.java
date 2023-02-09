//package com.home.project.entity;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.home.project.urlConstants.BaseModel;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class AssignedTask extends BaseModel {
//
//
//	@ManyToOne
//	@JoinColumn(name="SCHEDULE_ID",referencedColumnName = "id")
//	private Schedule schedule;
//
//	@ManyToOne
//	@JoinColumn(name="TASK_ID",referencedColumnName = "id")
//	private Task task;
//
//
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@ToString.Exclude
//	private List<Player> playerList;
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//		AssignedTask that = (AssignedTask) o;
//		return getId() != null && Objects.equals(getId(), that.getId());
//	}
//
//	@Override
//	public int hashCode() {
//		return getClass().hashCode();
//	}
//}
