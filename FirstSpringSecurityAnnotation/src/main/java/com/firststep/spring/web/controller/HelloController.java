package com.firststep.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daniel on 9/18/2014.
 */
@Controller
public class HelloController {
    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is welcome page!");
        return "hello";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is protected page - Admin Page!");
        return "admin";
    }

    @RequestMapping(value = "/dba**", method = RequestMethod.GET)
    public String dbaPage(Model model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is protected page - Database Page!");
        return "admin";
    }
}
