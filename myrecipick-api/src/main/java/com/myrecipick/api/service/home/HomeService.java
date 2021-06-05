package com.myrecipick.api.service.home;

import com.myrecipick.api.controller.home.dto.RecommendCustomMenuCollectionResponse;
import com.myrecipick.core.domain.home.RecommendCustomMenuRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HomeService {

    private final RecommendCustomMenuRepository repository;

    public HomeService(RecommendCustomMenuRepository repository) {
        this.repository = repository;
    }

    public Mono<String> hello() {
        return Mono.just("Hello, My Recipick!");
    }

    public Mono<RecommendCustomMenuCollectionResponse> findCollection() {
        return repository.findOne()
            .map(RecommendCustomMenuCollectionResponse::ok);
    }
}
