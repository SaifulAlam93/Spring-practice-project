package com.jwt.secqurity.relationExample.repository;

import com.jwt.secqurity.relationExample.entity.TestEntity3;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo3  extends JpaRepository<TestEntity3, Long> {
}
