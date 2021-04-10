package com.myrecipick;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.myrecipick.service.brand.BrandService;
import com.myrecipick.service.home.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Routes {

    private final HelloWorldService helloWorldService;
    private final BrandService brandService;

    public Routes(HelloWorldService helloWorldService, BrandService brandService) {
        this.helloWorldService = helloWorldService;
        this.brandService = brandService;
    }

    @Bean
    RouterFunction<ServerResponse> customers() {
        return route(GET("/").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), helloWorldService::hello)
            .andRoute(GET("/brands"), brandService::findAll);
    }
}
