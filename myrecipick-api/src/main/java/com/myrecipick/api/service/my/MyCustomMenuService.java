package com.myrecipick.api.service.my;

import com.myrecipick.core.domain.my.MyCustomMenuRepository;
import com.myrecipick.core.domain.menu.Menu;
import com.myrecipick.core.domain.my.MyCustomMenu;
import com.myrecipick.core.domain.my.MyMenu;
import com.myrecipick.core.domain.my.MyOption;
import com.myrecipick.core.domain.my.MyOptionGroup;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
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
        return Flux.just(
            createMenu("아보카도"),
            createMenu("베이컨"),
            createMenu("치즈"),
            createMenu("루꼴라"),
            createMenu("카야버터")
        );
    }

    //mock data helper
    private MyCustomMenu createMenu(String name) {
        return getMyCustomMenuMono(UUID.randomUUID()).block();
    }

    public Mono<MyCustomMenu> findById(UUID userId) {
        return getMyCustomMenuMono(userId);
    }

    private Mono<MyCustomMenu> getMyCustomMenuMono(UUID userId) {
        MyCustomMenu myCustomMenu = new MyCustomMenu();
        myCustomMenu.setId(UUID.randomUUID());
        myCustomMenu.setUserId(userId);
        myCustomMenu.setName("커스텀 스테이크");
        myCustomMenu.setCreatedDate(LocalDateTime.now());
        myCustomMenu.setUpdatedDate(LocalDateTime.now());

        myCustomMenu.setMenu(MyMenu.builder().name("스테이크 & 치즈")
        .image("")
        .id(UUID.randomUUID()).build());

        List<MyOptionGroup> optionGroups = List.of(
            optionGroup("빵", List.of("화이트"))
            , optionGroup("치즈", List.of("양파", "토마토", "피망"))
            , optionGroup("야채", List.of("양파", "토마토", "피망"))
            , optionGroup("소스", List.of("허니머스타드", "스윗어니언")));
        myCustomMenu.setOptionGroups(optionGroups);
        return Mono.just(myCustomMenu);
    }

    //mock data helper
    private MyOptionGroup optionGroup(String optionGroupName, List<String> optionNames) {
        List<MyOption> options = optionNames.stream()
            .map(name -> new MyOption(name, ""))
            .collect(Collectors.toList());

        return MyOptionGroup
            .builder()
            .id(UUID.randomUUID())
            .name(optionGroupName)
            .options(options)
            .image("")
            .build();
    }
}
