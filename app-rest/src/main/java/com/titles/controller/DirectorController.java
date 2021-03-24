package com.titles.controller;

import com.titles.model.Director;
import com.titles.service.ServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@ImportResource(locations = {"classpath:db.xml"})
public class DirectorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    private final ServiceDao<Director> directorServiceDao;

    @Autowired
    public DirectorController(ServiceDao<Director> directorServiceDao) {
        this.directorServiceDao = directorServiceDao;
    }

    @RequestMapping("/directors")
    public final String directors(Model model) {
        model.addAttribute("directors", directorServiceDao.findAll());
        return "directors";
    }

    @GetMapping("/director/{id}")
    public final String director(@PathVariable int id, Model model) {
        return "director";
    }
}