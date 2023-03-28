package com.capgemini.pfe.service;

import com.capgemini.pfe.v1.UserRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaConsumer {

    private String TOPIC = "u3_user_v1";


    @Autowired
    private UserService userService;

    @KafkaListener(topics = "u3_user_v1", groupId = "group_id")
    public void consume(ConsumerRecord<String, UserRecord> record) {
        System.out.println("-----New message from TOPIC consumed key:"+ record.key());
        System.out.println("-----Value:"+ record.value().toString());
        userService.add(record.value());
    }
}
