package com.capgemini.pfe.service;

import com.capgemini.pfe.dto.UserDto;
import io.micrometer.common.util.StringUtils;
import com.capgemini.pfe.webClientApi.UserApi;

import java.util.List;

public class UserMapper {

    public static UserDto mapApiToDto(UserApi usrApi) {
        UserDto userDto = new UserDto();
        userDto.setId(usrApi.getId());
        userDto.setAge(99);
        if (!StringUtils.isEmpty(usrApi.getName()) && usrApi.getName().split("\\s+").length > 1) {
            String firstName = usrApi.getName().split("\\s+")[0];
            String lastName = usrApi.getName().split("\\s+")[1];
            userDto.setFirstName(firstName);
            userDto.setLastName(lastName);
        } else {
            userDto.setFirstName(usrApi.getUsername());
            userDto.setLastName(usrApi.getName());
        }
        return userDto;
    }

    public static List<UserDto> mapApiToDto(List<UserApi> userApis) {
        return userApis.stream().map(UserMapper::mapApiToDto).toList();
    }
}
