package com.myrecipick.controller;

import com.myrecipick.domain.user.User;
import com.myrecipick.service.Result;
import com.myrecipick.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users")
    public Mono<Result<User>> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("ddd")
    public Mono<String> ddd(){
        return Mono.just("ddd");
    }
}
