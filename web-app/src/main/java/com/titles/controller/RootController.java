package com.titles.controller;

import com.titles.model.Director;
import com.titles.service.ServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RootController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    private final ServiceDao<Director> directorServiceDao;

    public RootController(@Qualifier("serviceDirectorDefault") ServiceDao<Director> directorServiceDao) {
        this.directorServiceDao = directorServiceDao;
    }

    @RequestMapping("/")
    public final String root(Model model) {
        model.addAttribute("name", directorServiceDao.findById(1).orElseThrow().toString());
        return "titles";
    }

    @RequestMapping("/d")
    public final String d(Model model) {
        return "directors";
    }
}
