//package com.home.project.service;
//
//import com.home.project.dto.*;
//import com.home.project.entity.AssignedTask;
//import com.home.project.entity.Player;
//import com.home.project.entity.Schedule;
//import com.home.project.entity.Task;
//import com.home.project.repository.AssignedTaskRepository;
//import com.home.project.repository.PlayersRepository;
//import com.home.project.repository.ScheduleRepository;
//import com.home.project.repository.TasksRepository;
//import com.home.project.urlConstants.Response;
//import com.home.project.urlConstants.ResponseUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class AssignedTaskService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(AssignedTaskService.class);
//    private final String root = "Assigned task";
//    @Autowired
//    AssignedTaskRepository assignedTaskRepository;
//    @Autowired
//    TasksRepository tasksRepository;
//    @Autowired
//    PlayersRepository playersRepository;
//    @Autowired
//    ScheduleRepository scheduleRepository;
//
//    public Response create(AssignedTaskDto assignedTaskDto) {
//        try {
//            AssignedTask assignedTask = new AssignedTask();
//
//            BeanUtils.copyProperties(assignedTaskDto, assignedTask, "playerList");
//
//            if (assignedTaskDto.getTask() != null) {
//                Optional<Task> optionalTask = tasksRepository.findById(assignedTaskDto.getTask().getId());
//                optionalTask.ifPresent(assignedTask::setTask);
//            }
//            if (assignedTaskDto.getSchedule() != null) {
//                Optional<Schedule> optionalSchedule = scheduleRepository.findById(assignedTaskDto.getSchedule().getId());
//                optionalSchedule.ifPresent(assignedTask::setSchedule);
//            }
//            if (assignedTaskDto.getPlayerList() != null) {
//                assignedTask.setPlayerList(getPlayerList(assignedTaskDto.getPlayerList()));
//            }
//
//            assignedTask = assignedTaskRepository.save(assignedTask);
//            return ResponseUtils.getSuccessResponse(HttpStatus.OK, getResponseDto(assignedTask), String.format("%s assigned successfully", root));
//        } catch (Exception e) {
//            LOGGER.info("Exception Occur in assigning task {} ", e.getMessage());
//            return ResponseUtils.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
//        }
//    }
//
//    private List<Player> getPlayerList(List<PlayerDto> playerDtoList) {
//        List<Player> playerList = new ArrayList<>();
//        for (PlayerDto playerDto : playerDtoList) {
//            Optional<Player> optionalPlayer = playersRepository.findById(playerDto.getUserName());
//            optionalPlayer.ifPresent(playerList::add);
//        }
//        return playerList;
//    }
//
//    private List<PlayerDto> getPlayerDtoList(List<Player> playerList) {
//        List<PlayerDto> playerDtoList = new ArrayList<>();
//        for (Player player : playerList) {
//            PlayerDto playerDto = new PlayerDto();
//            BeanUtils.copyProperties(player, playerDto);
//            playerDtoList.add(playerDto);
//        }
//        return playerDtoList;
//    }
//
//    public Response getAll() {
//        try {
//
//            List<AssignedTask> assignedTasks = assignedTaskRepository.findAllByActiveTrue();
//
//            return ResponseUtils.getSuccessResponse(HttpStatus.OK, getResponseDtoList(assignedTasks), String.format("All %ses", root));
//        } catch (Exception e) {
//            LOGGER.info("Exception Occur in GetAll assigning task {} ", e.getMessage());
//            return ResponseUtils.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
//        }
//    }
//
//
//    private List<AssignedTaskDto> getResponseDtoList(List<AssignedTask> assignedTasks) {
//        List<AssignedTaskDto> responseDtoList = new ArrayList<>();
//        assignedTasks.forEach(assignedTask -> {
//            AssignedTaskDto assignedTaskDto = new AssignedTaskDto();
//            BeanUtils.copyProperties(assignedTask, assignedTaskDto, "playerList");
//            if (assignedTask.getTask() != null) {
//                TaskDto taskDto = new TaskDto();
//                BeanUtils.copyProperties(assignedTask.getTask(), taskDto);
//                assignedTaskDto.setTask(taskDto);
//            }
//            if (assignedTask.getSchedule() != null) {
//                ScheduleDto scheduleDto = new ScheduleDto();
//                BeanUtils.copyProperties(assignedTask.getSchedule(), scheduleDto);
//                assignedTaskDto.setSchedule(scheduleDto);
//            }
//            if (assignedTask.getPlayerList() != null) {
//                assignedTaskDto.setPlayerList(getPlayerDtoList(assignedTask.getPlayerList()));
//            }
//            responseDtoList.add(assignedTaskDto);
//        });
//        return responseDtoList;
//    }
//
//    private AssignedTaskDto getResponseDto(AssignedTask assignedTask) {
//
//        AssignedTaskDto assignedTaskDto = new AssignedTaskDto();
//        BeanUtils.copyProperties(assignedTask, assignedTaskDto, "playerList");
//
//        if (assignedTask.getTask() != null) {
//            TaskDto taskDto = new TaskDto();
//            BeanUtils.copyProperties(assignedTask.getTask(), taskDto);
//            assignedTaskDto.setTask(taskDto);
//        }
//        if (assignedTask.getSchedule() != null) {
//            ScheduleDto scheduleDto = new ScheduleDto();
//            BeanUtils.copyProperties(assignedTask.getSchedule(), scheduleDto);
//            assignedTaskDto.setSchedule(scheduleDto);
//        }
//
//        if (assignedTask.getPlayerList() != null) {
//            assignedTaskDto.setPlayerList(getPlayerDtoList(assignedTask.getPlayerList()));
//        }
//
//        return assignedTaskDto;
//    }
//
//    public Response getScheduleWiseTaskDetails() {
//        try {
//            List<ScheduleWiseTaskDto> scheduleWiseTaskDtos = new ArrayList<>();
//
//            List<Schedule> scheduleList = scheduleRepository.findAllByActiveTrue();
//            scheduleList.forEach(schedule -> {
//                List<AssignedTask> assignedTasks = assignedTaskRepository.findAllByActiveTrueAndScheduleId(schedule.getId());
//
//                if (!assignedTasks.isEmpty()) {
//                    ScheduleWiseTaskDto scheduleWiseTaskDto = new ScheduleWiseTaskDto();
//                    ScheduleDto scheduleDto = new ScheduleDto();
//                    BeanUtils.copyProperties(schedule, scheduleDto);
//                    scheduleWiseTaskDto.setSchedule(scheduleDto);
//                    scheduleWiseTaskDto.setAssignedTaskDtos(getResponseDtoListForScheduleWiseTaskDetails(assignedTasks));
//                    scheduleWiseTaskDtos.add(scheduleWiseTaskDto);
//                }
//            });
//
//            return ResponseUtils.getSuccessResponse(HttpStatus.OK, scheduleWiseTaskDtos, String.format("All %ses", root));
//        } catch (Exception e) {
//            LOGGER.info("Exception Occur in Get All assigning task {} ", e.getMessage());
//            return ResponseUtils.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
//        }
//
//    }
//
//    private List<AssignedTaskDto> getResponseDtoListForScheduleWiseTaskDetails(List<AssignedTask> assignedTasks) {
//        List<AssignedTaskDto> responseDtoList = new ArrayList<>();
//        assignedTasks.forEach(assignedTask -> {
//            AssignedTaskDto assignedTaskDto = new AssignedTaskDto();
//            BeanUtils.copyProperties(assignedTask, assignedTaskDto, "playerList", "schedule");
//            if (assignedTask.getTask() != null) {
//                TaskDto taskDto = new TaskDto();
//                BeanUtils.copyProperties(assignedTask.getTask(), taskDto);
//                assignedTaskDto.setTask(taskDto);
//            }
//
//            if (assignedTask.getPlayerList() != null) {
//                assignedTaskDto.setPlayerList(getPlayerDtoList(assignedTask.getPlayerList()));
//            }
//            responseDtoList.add(assignedTaskDto);
//        });
//        return responseDtoList;
//    }
//}
