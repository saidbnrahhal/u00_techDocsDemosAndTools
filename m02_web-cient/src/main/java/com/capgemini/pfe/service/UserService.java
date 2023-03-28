package com.capgemini.pfe.service;

import com.capgemini.pfe.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.pfe.webClientApi.UserApiFinder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserApiFinder userApiFinder;

    public List<UserDto> getUserFromApiAndDoMapping() {
        return UserMapper.mapApiToDto(userApiFinder.getUserApiList());
    }
}
