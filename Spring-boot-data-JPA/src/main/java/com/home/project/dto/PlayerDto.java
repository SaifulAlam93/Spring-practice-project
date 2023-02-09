package com.home.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;


@Data
public class PlayerDto {

    private String userName;

    private String fullName;

    private String address;

    private String email;

    private String mobile;
}
