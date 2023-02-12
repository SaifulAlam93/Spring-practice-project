package com.jwt.secqurity.relationExample.repository;

import com.jwt.secqurity.relationExample.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo2  extends JpaRepository<Department, Long> {
}
