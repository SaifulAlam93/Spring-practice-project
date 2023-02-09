//package com.home.project.controller;
//
//import com.home.project.dto.PlayerDto;
//import com.home.project.service.PlayersService;
//import com.home.project.urlConstants.Response;
//import com.home.project.urlConstants.UrlConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(UrlConstants.PlayersController.ROOT)
//public class PlayersController {
//
//    @Autowired
//    private PlayersService playersService;
//
//    @PostMapping(UrlConstants.PlayersController.GET_ALL)
//    public Response create(@RequestBody PlayerDto playerDto) {
//        return playersService.create(playerDto);
//    }
//}
//
