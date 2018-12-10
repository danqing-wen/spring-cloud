package com.danqing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfg")
public class ConfigController {
    @Value("${foo}")
    String foo;

    @Value("${var}")
    String var;

    @RequestMapping(value = "/foo")
    public String foo(){
        return foo + "——" + var;
    }
}

