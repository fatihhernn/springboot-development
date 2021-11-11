package com.fatihhernn.redisapp.api;

import com.fatihhernn.redisapp.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    //3. istekte cache temizlenecek
    private int sayac=0;

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if (sayac==3){
            redisCacheService.clearCache();
            sayac=0;
        }
        sayac++;
        return redisCacheService.longRunningMethod();
    }

}
