package com.fatihhernn.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    // @MessageMapping : dışarıdan gelen mesajları
    // @Payload : gelen request payload dında WsMessage diye bir entity bekliyor olacağız bunu da dışarıya açan MessageMapping
    // gelen messajları herkese gönderir : @sendTo => parametre olarak hangi kanala göndereceğini veririr
    // @sendToUser : belli bir kullnıcıya message gönderir.

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    //@SendTo("/topic")
    //@SendToUser("")
    public void chatEndPoint(@Payload WsMessage wsMessage){
        System.out.println(wsMessage);

        //tüm clientlara yolla
        simpMessagingTemplate.convertAndSend("/topic",wsMessage);

    }
}
