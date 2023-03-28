package com.capgemini.pfe.service;

import com.capgemini.pfe.dto.UserDto;
import com.capgemini.pfe.webClientApi.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.pfe.webClientApi.UserApiFinder;

import java.util.List;

@Service
public class UserService {



    public void publish(UserApi userApi) {
        System.out.println("New user received from API:");
        System.out.println(userApi.toString());
        System.out.println("After translation to ours user:");
        System.out.println(UserMapper.mapApiToDto(userApi).toString());
    }
}
