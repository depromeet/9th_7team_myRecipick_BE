package com.myrecipick.api.service.user;

import com.myrecipick.core.domain.user.User;
import com.myrecipick.core.domain.user.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(User user) {
        userRepository.save(user);
        return Mono.just(user);
    }
}
