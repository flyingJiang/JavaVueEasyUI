package com.flying.api.controller;

import com.flying.model.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class LoginController {

    @RequestMapping(value = "/Login", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean Login(@RequestBody User user){
        System.out.println("userName: " +  user.toString());
        return Boolean.TRUE;
    }
}
