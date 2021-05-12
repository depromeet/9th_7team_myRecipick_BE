package com.myrecipick.api.controller.my.menu.controller;

import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.api.controller.my.menu.controller.dto.GetCustomMenuListResponse;
import com.myrecipick.api.controller.my.menu.controller.dto.GetCustomMenuResponse;
import com.myrecipick.api.service.menu.CustomMenuService;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class MyCustomMenuController {
    private final CustomMenuService customMenuService;

    public MyCustomMenuController(CustomMenuService customMenuService) {
        this.customMenuService = customMenuService;
    }

    @GetMapping("/my/custom-menus")
    public Mono<ServiceResponse> findAllByUserId(@RequestHeader UUID userId) {
        return customMenuService.findAllByUserId(userId)
            .collectList()
            .map(GetCustomMenuListResponse::ok);
    }

    @GetMapping("/my/custom-menus/{customMenuId}")
    public Mono<ServiceResponse> findByUserId(@PathVariable UUID customMenuId) {
        return customMenuService.findById(customMenuId)
            .map(GetCustomMenuResponse::ok);
    }
}
