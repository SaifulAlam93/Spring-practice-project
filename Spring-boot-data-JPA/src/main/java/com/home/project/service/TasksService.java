//package com.home.project.service;
//
//import com.home.project.dto.TaskDto;
//import com.home.project.entity.Task;
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
//@Service
//public class TasksService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(TasksService.class);
//
//    @Autowired
//    TasksRepository tasksRepository;
//
//    private final String root = "Task";
//
//    public Response create(TaskDto taskDto) {
//        try {
//            Task task = new Task();
//
//            BeanUtils.copyProperties(taskDto, task);
//            task = tasksRepository.save(task);
//            BeanUtils.copyProperties(task, taskDto);
//
//            return ResponseUtils.getSuccessResponse(HttpStatus.OK, taskDto,
//                    String.format("%s created successfully", root));
//        } catch (Exception e) {
//            LOGGER.info("Exception Occur in Task creation Line OC {} ", e.getMessage());
//            return ResponseUtils.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
//        }
//    }
//
//}
