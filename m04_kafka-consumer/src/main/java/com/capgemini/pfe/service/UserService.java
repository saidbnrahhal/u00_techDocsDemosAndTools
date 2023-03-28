package com.capgemini.pfe.service;

import com.capgemini.pfe.dto.UserDto;
import com.capgemini.pfe.v1.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class UserService {

    private List<UserDto> userDtoList = new ArrayList<>();

    public UserDto add(UserRecord userRecord) {
        UserDto userDto = new UserDto();
        userDto.setId(userRecord.getId());
        userDto.setFirstName(userRecord.getFirstName());
        userDto.setLastName(userRecord.getLastName());
        userDto.setAge(userRecord.getAge());
        userDtoList.add(userDto);
        return userDto;
    }

    public List<UserDto> getUserDtoList() {
        return userDtoList;
    }
}
