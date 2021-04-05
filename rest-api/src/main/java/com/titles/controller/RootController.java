package com.titles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RootController {

    @RequestMapping("/")
    public final String root() {
        return "redirect:directors";
    }
}
