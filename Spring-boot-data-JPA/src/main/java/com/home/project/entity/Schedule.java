//package com.home.project.entity;
//
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.home.project.urlConstants.BaseModel;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.Entity;
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//@Entity
//@Getter
//@Setter
//@ToString
//public class Schedule extends BaseModel {
//    public Schedule() {
//    }
//    public Schedule(Long id) {
//        super.setId(id);
//    }
//    public Schedule(String scheduleName, LocalDateTime scheduleStartTime, LocalDateTime scheduleEndTime) {
//        this.scheduleName = scheduleName;
//        this.scheduleStartTime = scheduleStartTime;
//        this.scheduleEndTime = scheduleEndTime;
//    }
//
//    private String scheduleName;
//
////    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime scheduleStartTime;
//
//
////    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime scheduleEndTime;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Schedule schedule = (Schedule) o;
//        return getId() != null && Objects.equals(getId(), schedule.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
