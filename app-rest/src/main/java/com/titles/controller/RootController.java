package com.titles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RootController {

    @RequestMapping("/")
    public final String root() {
        return "redirect:directors";
    }
}
