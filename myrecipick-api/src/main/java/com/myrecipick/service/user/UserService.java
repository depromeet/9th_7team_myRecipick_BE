package com.myrecipick.service.user;

import com.myrecipick.core.domain.user.User;
import com.myrecipick.core.domain.user.UserRepository;
import com.myrecipick.service.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<Result<User>> createUser(User user) {
        userRepository.save(user);
        Result<User> result = Result.of(HttpStatus.CREATED, "유저 등록 성공", user);
        return Mono.just(result);
    }
}
