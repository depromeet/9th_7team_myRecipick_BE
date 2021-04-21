package com.myrecipick.api.route.option;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.myrecipick.api.route.option.dto.GetOptionGroupResponse;
import com.myrecipick.api.service.option.OptionService;
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
public class OptionRoute {

    private final OptionService optionService;

    public OptionRoute(OptionService optionService) {
        this.optionService = optionService;
    }

    @Bean
    RouterFunction<ServerResponse> optionRoutes() {
        return route().GET("/v1/menus/{menuId}/options", this.findByMenuId(), findByMenuIdAPI()).build();
    }

    private HandlerFunction<ServerResponse> findByMenuId() {
        return req -> ok()
            .body(optionService.findByMenuId(UUID.fromString(req.pathVariable("menuId")))
                .collectList()
                .map(GetOptionGroupResponse::ok), GetOptionGroupResponse.class);
    }

    private Consumer<Builder> findByMenuIdAPI() {
        return ops -> ops.tag("brand")
            .operationId("findByMenuId").summary("메뉴 옵션 조회 API").tags(new String[]{"옵션 API"})
            .parameter(parameterBuilder().in(ParameterIn.PATH).example(UUID.randomUUID().toString()).name("menuId").description("메뉴 Id"))
            .response(responseBuilder().responseCode("200").implementation(GetOptionGroupResponse.class));
    }

}
