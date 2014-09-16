package com.firststep.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 9/16/2014.
 */
@Controller
public class HelloWorldController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public List<String> ListJson(){
        List<String> lst = new ArrayList<String>();
        lst.add("Hello");
        lst.add("Json");
        lst.add("World");
        lst.add("!");
        return lst;
    }
}
