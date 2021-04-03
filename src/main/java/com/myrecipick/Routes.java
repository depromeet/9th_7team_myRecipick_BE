package com.myrecipick;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.myrecipick.home.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Routes {

    private final HelloWorldService helloWorldService;

    public Routes(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Bean
    RouterFunction<ServerResponse> customers() {
        return route(GET("/").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), helloWorldService::hello);
    }
}
