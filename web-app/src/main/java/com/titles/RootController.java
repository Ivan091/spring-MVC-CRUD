package com.titles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RootController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    @RequestMapping("/")
    public final String root(Model model) {
        return "titles";
    }

    @RequestMapping("/d")
    public final String d(Model model) {
        return "directors";
    }
}
