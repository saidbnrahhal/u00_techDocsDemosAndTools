package com.capgemini.pfe.controller;

import com.capgemini.pfe.dto.UserDto;
import com.capgemini.pfe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public UserDto addGame(@RequestBody UserDto userDto) {
        return userService.add(userDto);
    }

}
