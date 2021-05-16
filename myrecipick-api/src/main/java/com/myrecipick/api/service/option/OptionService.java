package com.myrecipick.api.service.option;

import com.myrecipick.core.domain.option.MenuOptionGroup;
import com.myrecipick.core.domain.option.MenuOptionGroupBlockRepository;
import com.myrecipick.core.domain.option.OptionGroup;
import com.myrecipick.core.domain.option.OptionGroupBlockRepository;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OptionService {
    private static final Comparator<Integer> comp = Integer::compare;

    private final MenuOptionGroupBlockRepository menuOptionGroupBlockRepository;
    private final OptionGroupBlockRepository optionGroupBlockRepository;

    public OptionService(
        MenuOptionGroupBlockRepository menuOptionGroupBlockRepository,
        OptionGroupBlockRepository optionGroupBlockRepository) {
        this.menuOptionGroupBlockRepository = menuOptionGroupBlockRepository;
        this.optionGroupBlockRepository = optionGroupBlockRepository;
    }

    public Flux<OptionGroup> findByMenuId(UUID menuId) {
        List<MenuOptionGroup> menuOptionGroups = menuOptionGroupBlockRepository.findByMenuId(menuId);
        List<OptionGroup> collect = menuOptionGroups.stream()
            .map(item -> optionGroupBlockRepository.findById(item.getOptionGroupId()))
            .filter(item -> item != OptionGroup.EMPTY)
            .sorted((item1, item2) -> comp.compare(item1.getOrder(), item2.getOrder()))
            .collect(Collectors.toList());

        return Flux.fromIterable(collect);
    }
}
