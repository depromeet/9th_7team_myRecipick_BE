package com.myrecipick.api.controller.menu;

import com.myrecipick.api.controller.menu.dto.GetCustomMenuListResponse;
import com.myrecipick.api.controller.menu.dto.GetCustomMenuResponse;
import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.api.service.menu.CustomMenuService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class CustomMenuController {
    private final CustomMenuService customMenuService;

    public CustomMenuController(CustomMenuService customMenuService) {
        this.customMenuService = customMenuService;
    }

    @GetMapping("/customMenu")
    public Mono<ServiceResponse> findAllByUserId(@RequestHeader UUID userId) {
        return customMenuService.findAllByUserId(userId)
            .collectList()
            .map(GetCustomMenuListResponse::ok);
    }

    @GetMapping("/customMenu/{customMenuId}")
    public Mono<ServiceResponse> findByUserId(@PathVariable UUID customMenuId) {
        return customMenuService.findById(customMenuId)
            .map(GetCustomMenuResponse::ok);
    }
}
