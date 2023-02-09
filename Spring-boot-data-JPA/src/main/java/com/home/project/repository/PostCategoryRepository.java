package com.home.project.repository;

import com.home.project.entity.PostCategory;
import com.home.project.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
}
