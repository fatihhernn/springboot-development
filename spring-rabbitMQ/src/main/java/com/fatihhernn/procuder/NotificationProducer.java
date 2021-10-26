package com.fatihhernn.procuder;

import com.fatihhernn.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${fatihhernn.rabbit.routing.name}")
    private String routingName;

    @Value("${fatihhernn.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate; //rabbitMq connection nesnesi sunucuya bunun sayesinde gidiyor


    public void sendToQueue(Notification notification){

        System.out.println("Günderilen bildirim ID : "+notification.getNotificationId());

        //routing key sayesinde hangi exchange ve hangi queue gittiğini biliyor. Config'te binding metodunda yazdık
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }
}
