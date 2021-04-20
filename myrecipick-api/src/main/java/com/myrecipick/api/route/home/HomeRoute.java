package com.myrecipick.api.route.home;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

import com.myrecipick.api.service.home.HomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HomeRoute {

    private final HomeService homeService;

    public HomeRoute(HomeService homeService) {
        this.homeService = homeService;
    }

    @Bean
    RouterFunction<ServerResponse> homeRoutes() {
        return route().GET("/", homeService::hello,
            ops -> ops.beanClass(HomeService.class).beanMethod("hello")).build();
    }

}
