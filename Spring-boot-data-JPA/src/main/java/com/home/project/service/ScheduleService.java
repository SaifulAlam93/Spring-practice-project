//package com.home.project.service;
//
//import com.home.project.dto.ScheduleDto;
//import com.home.project.entity.Schedule;
//import com.home.project.repository.ScheduleRepository;
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
//public class ScheduleService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);
//
//    @Autowired
//    ScheduleRepository scheduleRepository;
//
//
//    private final String root = "Schedule";
//
//    public Response create(ScheduleDto scheduleDto) {
//        try {
//            Schedule schedule = new Schedule();
//            BeanUtils.copyProperties(scheduleDto, schedule);
//            schedule = scheduleRepository.save(schedule);
//
//            BeanUtils.copyProperties(schedule, scheduleDto);
//
//            return ResponseUtils.getSuccessResponse(HttpStatus.OK, scheduleDto, String.format("%s created successfully", root));
//        } catch (Exception e) {
//            LOGGER.info("Exception Occur in Schedule creation End Line OC {} ", e.getMessage());
//            return ResponseUtils.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
//        }
//    }
//
//
//}
//
