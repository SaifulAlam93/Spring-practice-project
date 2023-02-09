package com.home.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {
    private Long id;

    private String scheduleName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime scheduleStartTime;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime scheduleEndTime;
}
