package com.titles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DirectorController {

    @RequestMapping("/directors")
    public final String directors(Model model) {
        return "hello";
    }
}
