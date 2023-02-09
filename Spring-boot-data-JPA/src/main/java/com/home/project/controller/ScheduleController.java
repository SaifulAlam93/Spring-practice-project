//package com.home.project.controller;
//
//
//import com.home.project.dto.ScheduleDto;
//import com.home.project.service.ScheduleService;
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
//@RequestMapping(UrlConstants.ScheduleController.ROOT)
//public class ScheduleController {
//
//    @Autowired
//    private ScheduleService scheduleService;
//
//    @PostMapping(UrlConstants.ScheduleController.GET_ALL)
//    public Response create(@RequestBody ScheduleDto scheduleDto) {
//        return scheduleService.create(scheduleDto);
//    }
//
//}
