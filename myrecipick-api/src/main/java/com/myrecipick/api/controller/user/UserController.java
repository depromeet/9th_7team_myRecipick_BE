package com.myrecipick.api.controller.user;

import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.api.service.user.UserService;
import com.myrecipick.core.domain.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public Mono<ServiceResponse> createUser(@RequestBody User user) {
        return Mono.just(user)
            .map(userService::createUser)
            .map(res -> new ServiceResponse(HttpStatus.CREATED, "생성성공"));
    }

}
