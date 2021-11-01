package com.fatihhernn.dockerization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @GetMapping
    public String sendMessage(){
        return "Docker image içinden merhaba";
    }

}
