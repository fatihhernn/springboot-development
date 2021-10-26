package com.fatihhernn.handler;

import com.fatihhernn.model.Notification;
import com.fatihhernn.procuder.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
public class NotificationSender {

    @Autowired
    private NotificationProducer producer;

    public void getThread(){
        Thread thread=new Thread(()->{
            while (true){
                Notification notification=new Notification();
                notification.setNotificationId(UUID.randomUUID().toString());
                notification.setCreatedDate(new Date());
                notification.setMessage("FATIH EREN'DEN GELEN BIR MESAJINIZ VAR ...!");
                notification.setSeen(false);
                producer.sendToQueue(notification);

                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        });
        thread.setName("Notification sender");
        thread.start();
    }

    @PostConstruct
    public void init() {
        getThread();

    }

}
