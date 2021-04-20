package com.myrecipick.api.route.brand;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.myrecipick.api.route.brand.dto.BrandListResponse;
import com.myrecipick.api.service.brand.BrandService;
import java.util.function.Consumer;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class BrandRoute {

    private final BrandService brandService;

    public BrandRoute(BrandService brandService) {
        this.brandService = brandService;
    }

    @Bean
    RouterFunction<ServerResponse> brandRoutes() {
        return route().GET("/v1/brands", this.findAll(), findAllBrandAPI()).build();
    }

    private HandlerFunction<ServerResponse> findAll() {
        return req -> ok()
            .body(brandService.findAll()
                .collectList()
                .map(BrandListResponse::ok), BrandListResponse.class);
    }

    private Consumer<Builder> findAllBrandAPI() {
        return ops -> ops.tag("brand")
            .operationId("findAll").summary("모든 브랜드 조회 API").tags(new String[]{"브랜드 API"})
            .response(responseBuilder().responseCode("200").implementation(BrandListResponse.class));
    }
}
