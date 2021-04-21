package com.myrecipick.api.route.menu;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.myrecipick.api.route.brand.dto.GetBrandsResponse;
import com.myrecipick.api.route.menu.dto.GetMenuResponse;
import com.myrecipick.api.route.menu.dto.GetMenusResponse;
import com.myrecipick.api.service.menu.MenuService;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import java.util.UUID;
import java.util.function.Consumer;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MenuRoute {

    private final MenuService menuService;

    public MenuRoute(MenuService menuService) {
        this.menuService = menuService;
    }

    @Bean
    RouterFunction<ServerResponse> menuRoutes() {
        return route().GET("/v1/brands/{brandId}/menus", this.findAllByBrandId(), findAllByBrandIdAPI()).build()
            .and(route().GET("/v1/menus/{menuId}", this.findById(), findByIdAPI()).build());
    }

    private HandlerFunction<ServerResponse> findAllByBrandId() {
        return req -> ok()
            .body(menuService.findAllByBrandId(UUID.fromString(req.pathVariable("brandId")))
                .collectList()
                .map(GetMenusResponse::ok), GetMenusResponse.class);
    }

    private HandlerFunction<ServerResponse> findById() {
        return req -> ok()
            .body(menuService.findById(UUID.fromString(req.pathVariable("menuId")))
                .map(GetMenuResponse::ok), GetBrandsResponse.class);
    }

    private Consumer<Builder> findAllByBrandIdAPI() {
        return ops -> ops.tag("menu")
            .operationId("findAll").summary("브랜드의 모든 매뉴 조회 API").tags(new String[]{"매뉴 API"})
            .parameter(parameterBuilder().in(ParameterIn.PATH).example(UUID.randomUUID().toString()).name("brandId").description("브랜드 Id"))
            .response(responseBuilder().responseCode("200").implementation(GetMenusResponse.class));
    }


    private Consumer<Builder> findByIdAPI() {
        return ops -> ops.tag("brand")
            .operationId("findAll").summary("매뉴 조회 API").tags(new String[]{"매뉴 API"})
            .parameter(parameterBuilder().in(ParameterIn.PATH).example(UUID.randomUUID().toString()).name("menuId").description("메뉴 Id"))
            .response(responseBuilder().responseCode("200").implementation(GetMenusResponse.class));
    }
}
