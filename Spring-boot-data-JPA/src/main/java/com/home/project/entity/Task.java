//package com.home.project.entity;
//
//import com.home.project.urlConstants.BaseModel;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import java.util.Objects;
//
//@Entity
//@Getter
//@Setter
//@ToString
//public class Task extends BaseModel {
//
//    public Task() {
//    }
//    public Task(Long id) {
//        super.setId(id);
//    }
//    private String taskTitle;
//
//    private String taskMessage;
//
//    public Task(String taskTitle, String taskMessage) {
//        this.taskTitle = taskTitle;
//        this.taskMessage = taskMessage;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Task task = (Task) o;
//        return getId() != null && Objects.equals(getId(), task.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
