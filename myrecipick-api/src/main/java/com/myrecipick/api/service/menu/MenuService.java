package com.myrecipick.api.service.menu;

import com.myrecipick.core.domain.menu.Menu;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MenuService {

    public MenuService() {
    }

    public Flux<Menu> findAllByBrandId(UUID brandId) {
        Menu menu1 = new Menu();
        menu1.setId(UUID.randomUUID());
        menu1.setBrandId(brandId);
        menu1.setName("비엘티");
        menu1.setIsShow(true);
        menu1.setCreatedDate(LocalDateTime.now());
        menu1.setUpdatedDate(LocalDateTime.now());


        Menu menu2 = new Menu();
        menu2.setId(UUID.randomUUID());
        menu2.setBrandId(brandId);
        menu2.setName("로스트 치킨");
        menu2.setIsShow(true);
        menu2.setCreatedDate(LocalDateTime.now());
        menu2.setUpdatedDate(LocalDateTime.now());


        Menu menu3 = new Menu();
        menu3.setId(UUID.randomUUID());
        menu3.setBrandId(brandId);
        menu3.setName("스테이크 & 치즈");
        menu3.setIsShow(true);
        menu3.setCreatedDate(LocalDateTime.now());
        menu3.setUpdatedDate(LocalDateTime.now());


        return Flux.just(menu1, menu2, menu3);
    }

    public Mono<Menu> findById(UUID menuId) {

        Menu menu3 = new Menu();
        menu3.setId(UUID.randomUUID());
        menu3.setBrandId(UUID.randomUUID());
        menu3.setName("스테이크 & 치즈");
        menu3.setIsShow(true);
        menu3.setCreatedDate(LocalDateTime.now());
        menu3.setUpdatedDate(LocalDateTime.now());

        return Mono.just(menu3);
    }
}
