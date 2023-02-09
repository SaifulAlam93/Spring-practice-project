package com.home.project.dto;

import lombok.Data;

import java.util.List;

@Data
public class AssignedTaskDto {
	private Long id;

	private ScheduleDto schedule;

	private TaskDto task;

	private List<PlayerDto> playerList;

}
