package com.petapplication.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author pradip
 */
@Component
public class WebSocketNotificationPushSchedular {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @Scheduled(fixedRate = 500)
    public void pushNotification() {
        simpMessagingTemplate.convertAndSend("/topic/pet-count", Math.round(Math.random() * 100));
    }
}
