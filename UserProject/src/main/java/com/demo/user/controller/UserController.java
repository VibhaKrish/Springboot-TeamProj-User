package com.demo.user.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.user.model.User;
import com.demo.user.service.UserService;



@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Users found successfully.");
        ResponseEntity<List<User>> response = new ResponseEntity<>(userList, headers, status);
        LOG.info("Total users found: " + userList.size());
        return response;
    }

    @GetMapping("get-user-by-id/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "userId") Integer userId) {
        User user = userService.getUserById(userId);
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "User found successfully.");
        ResponseEntity<User> response = new ResponseEntity<>(user, headers, status);
        LOG.info(user.toString());
        return response;
    }

    @PostMapping("add-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User addedUser = userService.addUser(user);
        HttpStatus status = HttpStatus.CREATED;
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "User created successfully.");
        ResponseEntity<User> response = new ResponseEntity<>(addedUser, headers, status);
        LOG.info(addedUser.toString());
        return response;
    }
}
