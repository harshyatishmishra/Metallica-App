package com.matallica.NotificationService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.matallica.NotificationService.Entity.TradingEntity;

@Controller
@CrossOrigin("*")
public class NotificationServiceController {

	@Autowired
    private SimpMessagingTemplate template;

    /**Sends message to web socket.
     * 
     * @param te
     */
    public void sendMsgWS(TradingEntity te) {
        this.template.convertAndSend("/metallica", te);
    }
}
