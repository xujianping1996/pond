package com.jianping.pond.controller;

import com.jianping.pond.entity.UserInfo;
import com.jianping.pond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @RequestMapping("/testController")
    public List<UserInfo> testController(){
        return userService.getAllUser();
    }

}
