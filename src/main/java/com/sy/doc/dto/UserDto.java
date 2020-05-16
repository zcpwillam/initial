package com.sy.doc.dto;

import com.sy.doc.model.User;
import lombok.Data;

/**
 * @program: demo
 * @description:
 * @author: zhangchenpeng
 * @create: 2020-05-17 20:33
 **/

public class UserDto {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Long id;
    private String name;
    private Integer age;
    private String sex;

    private final String Male = "male";
    private final String Female = "female";

    public UserDto(User user) {
        this.id = user.getId();
        this.age = user.getAge();
        this.name = user.getRealname();
        this.sex = user.getSex() == 0 ? Male : Female;
    }

    public UserDto() {

    }
}
