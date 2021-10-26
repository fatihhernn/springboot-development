package com.fatihhernn.listener;

import com.fatihhernn.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "fatihcompany-queue")
    public void handleMessage(Notification notification){
        System.out.println("Mesaj alındı...");
        System.out.println(notification.toString());
    }
}
