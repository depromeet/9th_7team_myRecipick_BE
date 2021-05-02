package com.myrecipick.api.controller.menu;

import com.myrecipick.api.controller.menu.dto.GetMenuListResponse;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.api.service.menu.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class CustomMenuController {
    private final MenuService menuService;

    public CustomMenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public Mono<ServiceResponse> findAllByUserId(@RequestHeader UUID userId) {
        return menuService.findAllByUserId(userId)
            .collectList()
            .map(GetMenuListResponse::ok);
    }
}
