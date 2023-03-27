package com.capgemini.pfe.service;

import com.capgemini.pfe.dto.UserDto;
import com.capgemini.pfe.v1.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserKafkaProducer userKafkaProducer;

    public UserDto add(UserDto userDto) {
        System.out.println("------Receiving user-------");
        System.out.println(userDto.toString());
        UserRecord userRecord = UserRecord.newBuilder()
                .setId(userDto.getId())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setAge(userDto.getAge())
                .build();
        userKafkaProducer.sendMessage(userRecord);
        return userDto;
    }
}
