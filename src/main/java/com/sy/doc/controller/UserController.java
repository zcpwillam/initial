package com.sy.doc.controller;

import com.sy.doc.dto.UserDto;
import com.sy.doc.model.User;
import com.sy.doc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public UserDto getUser(Long id) {
        return userService.getUserById(id);
    }
}
