package com.capgemini.pfe.service;

import com.capgemini.pfe.dto.UserDto;
import com.capgemini.pfe.v1.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaProducer {

    private String TOPIC = "u3_user_v1";
    private final KafkaTemplate<String, UserRecord> kafkaTemplate;

    @Autowired
    public UserKafkaProducer(KafkaTemplate<String, UserRecord> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(UserRecord user) {
        this.kafkaTemplate.send(this.TOPIC,  user);
    }
}
