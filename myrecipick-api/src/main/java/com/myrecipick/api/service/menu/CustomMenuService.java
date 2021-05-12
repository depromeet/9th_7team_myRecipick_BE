package com.myrecipick.api.service.menu;

import com.myrecipick.core.domain.menu.Menu;
import com.myrecipick.core.domain.option.Option;
import com.myrecipick.core.domain.option.OptionGroup;
import com.myrecipick.core.domain.option.OptionGroupType;
import com.myrecipick.core.domain.option.OptionPolicy;
import com.myrecipick.core.domain.option.OptionType;
import com.myrecipick.core.my.menu.CustomMenu;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomMenuService {

    public CustomMenuService() {
    }

    public Flux<Menu> findAllByUserId(UUID userId) {
        return Flux.just(
            createMenu("아보카도"),
            createMenu("베이컨"),
            createMenu("치즈"),
            createMenu("루꼴라"),
            createMenu("카야버터")
        );
    }

    //mock data helper
    private Menu createMenu(String name) {
        Menu menu = new Menu();
        menu.setId(UUID.randomUUID());
        menu.setBrandId(UUID.randomUUID());
        menu.setName(name);
        menu.setIsShow(true);
        menu.setCreatedDate(LocalDateTime.now());
        menu.setUpdatedDate(LocalDateTime.now());
        return menu;
    }

    public Mono<CustomMenu> findById(UUID userId) {

        CustomMenu customMenu = new CustomMenu();
        customMenu.setId(UUID.randomUUID());
        customMenu.setMenuId(UUID.randomUUID());
        customMenu.setUserId(userId);
        customMenu.setName("스테이크 & 치즈");
        customMenu.setShow(true);
        customMenu.setCreatedDate(LocalDateTime.now());
        customMenu.setUpdatedDate(LocalDateTime.now());

        List<OptionGroup> optionGroups = List.of(
            optionGroup("빵 길이", List.of("15cm"))
            , optionGroup("빵", List.of("화이트"))
            , optionGroup("야채", List.of("양파", "토마토", "피망"))
            , optionGroup("소스", List.of("허니머스타드", "스윗어니언")));
        customMenu.setOptionGroups(optionGroups);
        return Mono.just(customMenu);
    }

    //mock data helper
    private OptionGroup optionGroup(String optionGroupName, List<String> optionNames) {
        OptionPolicy policy = new OptionPolicy(1, 1);

        List<Option> options = optionNames.stream().map(name -> {
            Option option = new Option();
            option.setName(name);
            option.setType(OptionType.SELECT);
            return option;
        }).collect(Collectors.toList());

        OptionGroup optionGroup = new OptionGroup();
        optionGroup.setId(UUID.randomUUID());
        optionGroup.setName(optionGroupName);
        optionGroup.setType(OptionGroupType.SINGLE);
        optionGroup.setPolicy(policy);
        optionGroup.setOptions(options);
        return optionGroup;
    }
}
