package com.home.project.dto;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleWiseTaskDto {
    private ScheduleDto schedule;

    List<AssignedTaskDto> assignedTaskDtos;

}
