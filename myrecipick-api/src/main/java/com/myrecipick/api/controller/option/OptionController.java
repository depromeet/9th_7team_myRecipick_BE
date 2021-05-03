package com.myrecipick.api.controller.option;

import com.myrecipick.api.controller.option.dto.GetOptionGroupResponse;
import com.myrecipick.api.service.option.OptionService;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/v1/menus/{menuId}/options")
    public Mono<GetOptionGroupResponse> getOptions(@PathVariable("menuId") UUID menuId) {
        return optionService.findByMenuId(menuId)
            .collectList()
            .map(GetOptionGroupResponse::ok);
    }

}
