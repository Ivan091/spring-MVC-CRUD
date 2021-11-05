package com.titles.controller;

import com.titles.model.UserDto;
import com.titles.service.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public final class UserController {

    @Autowired
    private UserDtoService userDtoService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDto userDto){
        if (userDtoService.isRegistered(userDto)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
