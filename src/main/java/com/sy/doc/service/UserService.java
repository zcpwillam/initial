package com.sy.doc.service;

import com.sy.doc.dto.UserDto;
import com.sy.doc.mapper.UserMapper;
import com.sy.doc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @program: demo
 * @description:
 * @author: zhangchenpeng
 * @create: 2020-05-17 20:32
 **/
@Component
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDto getUserById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (Objects.nonNull(user)) {
            UserDto userDto = new UserDto(user);
            return userDto;
        } else {
            return new UserDto();
        }

    }
}
