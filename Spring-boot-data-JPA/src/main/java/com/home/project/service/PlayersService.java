//package com.home.project.service;
//
//import com.home.project.dto.PlayerDto;
//import com.home.project.entity.Player;
//import com.home.project.repository.PlayersRepository;
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
//public class PlayersService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(PlayersService.class);
//
//    @Autowired
//    PlayersRepository playersRepository;
//
//
//    private final String root = "Player";
//
//    public Response create(PlayerDto playerDto) {
//        try {
//            Player player = new Player();
//            BeanUtils.copyProperties(playerDto, player);
//            player = playersRepository.save(player);
//
//            BeanUtils.copyProperties(player, playerDto);
//
//            return ResponseUtils.getSuccessResponse(HttpStatus.OK, playerDto,
//                    String.format("%s created successfully", root));
//        } catch (Exception e) {
//            LOGGER.info("Exception Occur in Player creation OC {} ", e.getMessage());
//            return ResponseUtils.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error occured");
//        }
//    }
//
//
//}
//
