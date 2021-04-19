package com.myrecipick.routes.home;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

import com.myrecipick.domain.brand.Brand;
import com.myrecipick.service.home.HomeService;
import java.util.function.Consumer;
import org.springdoc.core.fn.builders.operation.Builder;
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


    private Consumer<Builder> findAllBrandAPI() {
        return ops -> ops.tag("brand")
            .operationId("findAll").summary("모든 브랜드 조회 API").tags(new String[]{"브랜드 API"})
            .response(responseBuilder().responseCode("200").implementation(Brand.class));
    }
}
