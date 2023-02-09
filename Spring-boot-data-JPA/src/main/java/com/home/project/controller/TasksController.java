//package com.home.project.controller;
//
//
//import com.home.project.dto.TaskDto;
//import com.home.project.service.TasksService;
//import com.home.project.urlConstants.Response;
//import com.home.project.urlConstants.UrlConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping(UrlConstants.TasksController.ROOT)
//public class TasksController {
//
//    @Autowired
//    private TasksService tasksService;
//
//    @PostMapping(UrlConstants.TasksController.GET_ALL)
//    public Response create(@RequestBody TaskDto taskDto) {
//        return tasksService.create(taskDto);
//    }
//
//
//}
