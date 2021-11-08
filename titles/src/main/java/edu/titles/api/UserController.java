package edu.titles.api;

import edu.titles.api.dto.UserDto;
import edu.titles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public final class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDto.Base user) {
        if (userService.isRegistered(user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Void> register(@RequestBody UserDto.Base user) {
        if (userService.register(user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
