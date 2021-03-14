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
public class DirectorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    private final ServiceDao<Director> directorServiceDao;

    public DirectorController(@Qualifier("serviceDirectorDefault") ServiceDao<Director> directorServiceDao) {
        this.directorServiceDao = directorServiceDao;
    }

    @RequestMapping("/directors")
    public final String directors(Model model) {

        return "directors";
    }

    @RequestMapping("/director")
    public final String director(Model model) {
        return "director";
    }
}
