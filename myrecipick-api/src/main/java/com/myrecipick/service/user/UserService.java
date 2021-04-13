package com.myrecipick.service.user;

import com.myrecipick.domain.user.User;
import com.myrecipick.domain.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> createUser(User user) {
        userRepository.save(user);
        return ServerResponse.accepted().build();
    }
}
