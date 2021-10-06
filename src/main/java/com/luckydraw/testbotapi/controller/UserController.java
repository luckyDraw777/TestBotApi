package com.luckydraw.testbotapi.controller;

import com.luckydraw.testbotapi.model.User;
import com.luckydraw.testbotapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class    UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/api/user/{chatId}")
    public User getByChatId(@PathVariable(value = "chatId") Long id){
        return service.getByChatId(id);
    }

    @PostMapping(value = "/api/user/new", consumes = "application/json", produces = "application/json")
    public User save(@Valid @RequestBody User user){
        return service.save(user);
    }

    @PostMapping(value = "/api/user/update")
    public User update(@Valid @RequestBody User user){
        return service.save(user);
    }
}
