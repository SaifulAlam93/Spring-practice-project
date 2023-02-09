//package com.home.project.controller;
//
//
//import com.home.project.dto.AssignedTaskDto;
//import com.home.project.entity.AssignedTask;
//import com.home.project.service.AssignedTaskService;
//import com.home.project.urlConstants.Response;
//import com.home.project.urlConstants.UrlConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping(UrlConstants.AssignedTaskController.ROOT)
//public class AssignedTaskController {
//
//	@Autowired
//    private AssignedTaskService assignedTaskService;
//
//	@PostMapping(UrlConstants.AssignedTaskController.GET_ALL)
//	public Response create(@RequestBody AssignedTaskDto assignedTaskDto) {
//		return assignedTaskService.create(assignedTaskDto);
//	}
//
//	@GetMapping(UrlConstants.AssignedTaskController.GET_ALL)
//	public Response getAll() {
//		return assignedTaskService.getAll();
//	}
//
//	@GetMapping(UrlConstants.AssignedTaskController.GET_SCHEDULE_WISE_TASK)
//	public Response getScheduleWiseTaskDetails() {
//		return assignedTaskService.getScheduleWiseTaskDetails();
//	}
//}
