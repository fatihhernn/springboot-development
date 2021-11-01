package com.fatihhernn.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class SecondMessageService {
    public void message(String params){
        System.out.println(params);
    }
}
