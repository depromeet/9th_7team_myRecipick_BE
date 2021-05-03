package com.myrecipick.api.controller.menu;

import com.myrecipick.api.controller.menu.dto.dto.GetMenuResponse;
import com.myrecipick.api.controller.menu.dto.dto.GetMenusResponse;
import com.myrecipick.api.service.menu.MenuService;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping("/v1/brands/{brandId}/menus")
    public Mono<GetMenusResponse> getMenus(@PathVariable("brandId") UUID brandId) {
        return menuService.findAllByBrandId(brandId)
            .collectList()
            .map(GetMenusResponse::ok);
    }

    @GetMapping("/v1/menus/{menuId}")
    public Mono<GetMenuResponse> getMenu(@PathVariable("menuId") UUID menuId) {
        return menuService.findById(menuId)
            .map(GetMenuResponse::ok);
    }
}
