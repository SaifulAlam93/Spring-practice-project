package com.jwt.secqurity.relationExample.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Employee extends BaseModel{
    private String nameT1;

    @ManyToOne
    @JoinColumn(name = "test_entity_id", referencedColumnName = "id",nullable = true)
    private Department department;

    //@OneToMany(mappedBy = "orderEntity")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eMPLOYEE")
    @ToString.Exclude
    private List<TestEntity3> testEntity3s;


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Collection<TestEntity4> testEntity4s;


    @ManyToMany
    @JoinTable(
            name = "testEntityLike",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "test_entity4_id"))
    @ToString.Exclude
    Set<TestEntity4> testEntity4Set;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return getId() != null && Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
