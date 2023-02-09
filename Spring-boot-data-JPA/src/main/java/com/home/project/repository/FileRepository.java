package com.home.project.repository;

import com.home.project.entity.FileUpload;
import com.home.project.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileUpload, Long> {



}
