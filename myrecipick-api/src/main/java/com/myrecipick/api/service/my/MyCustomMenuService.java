package com.myrecipick.api.service.my;

import com.myrecipick.core.domain.my.MyCustomMenu;
import com.myrecipick.core.domain.my.MyCustomMenuRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MyCustomMenuService {

    private final MyCustomMenuRepository myCustomMenuRepository;

    public MyCustomMenuService(MyCustomMenuRepository myCustomMenuRepository) {
        this.myCustomMenuRepository = myCustomMenuRepository;
    }

    public Flux<MyCustomMenu> findAllByUserId(UUID userId) {
        return myCustomMenuRepository.findAllByUserId(userId);
    }

    public Mono<MyCustomMenu> findById(UUID id) {
        return myCustomMenuRepository.findById(id);
    }

    public Mono<MyCustomMenu> save(MyCustomMenu myCustomMenu) {
        return myCustomMenuRepository.save(myCustomMenu);
    }

    public Mono<UUID> delete(UUID customMenuId) {
        return myCustomMenuRepository.delete(customMenuId);
    }

    public Mono<Boolean> deletes(List<UUID> customMenuId) {
        return myCustomMenuRepository.deletes(customMenuId);
    }
}
