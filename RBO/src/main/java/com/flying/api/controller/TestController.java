package com.flying.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class TestController {

    @RequestMapping(value = "/demo", method = { RequestMethod.GET, RequestMethod.POST})
    public String getDialog(){
        return "/demo";
    }
}
