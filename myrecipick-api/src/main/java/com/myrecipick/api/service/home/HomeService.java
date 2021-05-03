package com.myrecipick.api.service.home;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HomeService {

    public Mono<String> hello() {
        return Mono.just("Hello, My Recipick!");
    }
}
