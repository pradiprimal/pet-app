package com.petapplication.controller;

import com.petapplication.responseDTO.SingleValueResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pradip
 */
@RestController
public class WebSocketController {

    @MessageMapping("/pet")
    @SendTo("/topic/pet-count")
    public SingleValueResponse testSocket(String message) {
        System.out.println("=======================================================" + message);
        SingleValueResponse response = new SingleValueResponse(message);
        return response;
    }
}
