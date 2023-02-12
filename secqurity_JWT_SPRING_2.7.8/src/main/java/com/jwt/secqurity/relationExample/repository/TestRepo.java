package com.jwt.secqurity.relationExample.repository;

import com.jwt.secqurity.relationExample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long id);
}
