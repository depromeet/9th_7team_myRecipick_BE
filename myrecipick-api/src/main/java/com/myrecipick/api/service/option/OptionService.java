package com.myrecipick.api.service.option;

import com.myrecipick.core.domain.option.Option;
import com.myrecipick.core.domain.option.OptionGroup;
import com.myrecipick.core.domain.option.OptionGroupType;
import com.myrecipick.core.domain.option.OptionPolicy;
import com.myrecipick.core.domain.option.OptionType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OptionService {

    public Flux<OptionGroup> findByMenuId(UUID menuId) {

        // Option group 빵 길이
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.setId(UUID.randomUUID());
        optionGroup.setName("빵 길이");
        optionGroup.setType(OptionGroupType.SINGLE);

        OptionPolicy policy= new OptionPolicy(1, 1);
        optionGroup.setPolicy(policy);

        List<Option> options = new ArrayList<>();
        Option option1 = new Option();
        option1.setId(UUID.randomUUID());
        option1.setName("15cm");
        option1.setType(OptionType.SELECT);
        Option option2 = new Option();
        option2.setId(UUID.randomUUID());
        option2.setName("30cm");
        option2.setType(OptionType.SELECT);
        options.add(option1);
        options.add(option2);
        optionGroup.setOptions(options);

        // Option group 빵
        OptionGroup optionGroup1 = new OptionGroup();
        optionGroup1.setId(UUID.randomUUID());
        optionGroup1.setName("빵");
        optionGroup1.setType(OptionGroupType.SINGLE);
        optionGroup1.setPolicy(policy);

        List<Option> options1 = new ArrayList<>();
        Option option3 = new Option();
        option3.setId(UUID.randomUUID());
        option3.setName("화이트");
        option3.setType(OptionType.CHECK);
        Option option4 = new Option();
        option4.setId(UUID.randomUUID());
        option4.setName("허니오트");
        option4.setType(OptionType.CHECK);
        options1.add(option3);
        options1.add(option4);
        optionGroup1.setOptions(options1);


        // Option group 야채
        OptionGroup optionGroup2 = new OptionGroup();
        optionGroup2.setId(UUID.randomUUID());
        optionGroup2.setName("야채");
        optionGroup2.setType(OptionGroupType.MULTI);

        List<Option> options2 = new ArrayList<>();
        Option option5 = new Option();
        option5.setId(UUID.randomUUID());
        option5.setName("양파");
        option5.setType(OptionType.CHECK);
        Option option6 = new Option();
        option6.setId(UUID.randomUUID());
        option6.setName("토마토");
        option6.setType(OptionType.CHECK);
        options2.add(option3);
        options2.add(option4);
        optionGroup2.setOptions(options1);


        return Flux.just(optionGroup, optionGroup1, optionGroup2);
    }
}
