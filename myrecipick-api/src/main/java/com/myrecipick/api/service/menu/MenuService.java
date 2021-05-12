package com.myrecipick.api.service.menu;

import com.myrecipick.core.domain.menu.Menu;
import com.myrecipick.core.domain.menu.MenuRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public Flux<Menu> findAllByBrandId(UUID brandId) {
        return repository.findAllByBrandId(brandId);
    }

    public Mono<Menu> findById(UUID menuId) {
        return repository.findByMenuId(menuId);
    }
}
