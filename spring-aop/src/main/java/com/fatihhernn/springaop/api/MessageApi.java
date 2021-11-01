package com.fatihhernn.springaop.api;

import com.fatihhernn.springaop.service.MessageService;
import com.fatihhernn.springaop.service.SecondMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping
    public ResponseEntity<String> secondMethod(@RequestBody String message){
        secondMessageService.message(message);
        return ResponseEntity.ok(message);
    }


    @PostMapping
    public ResponseEntity<String> exampleMethod(@RequestBody String message){
        return ResponseEntity.ok(messageService.sendMessage(message));
    }

}
