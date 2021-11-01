package com.fatihhernn.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {


    public String sendMessage(String param){
        System.out.println("Metot mesaj verdi :  "+param);
        return param;
    }


}
