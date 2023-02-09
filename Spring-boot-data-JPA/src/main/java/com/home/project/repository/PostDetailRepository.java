package com.home.project.repository;

import com.home.project.entity.PostDetails;
import com.home.project.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailRepository extends JpaRepository<PostDetails, Long> {
}
