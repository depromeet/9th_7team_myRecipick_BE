package com.myrecipick.api.controller.home;

import com.myrecipick.api.controller.home.dto.RecommendCustomMenuCollectionResponse;
import com.myrecipick.api.service.home.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public Mono<String> hello() {
        return homeService.hello();
    }

    @GetMapping({"/home", "/v1/home"})
    public Mono<RecommendCustomMenuCollectionResponse> home() {
        return homeService.findCollection();
    }
}
