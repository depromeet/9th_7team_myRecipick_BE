package com.myrecipick.api.controller.my.controller;

import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.api.controller.my.controller.dto.CreateMyCustomMenuRequest;
import com.myrecipick.api.controller.my.controller.dto.CreateMyCustomMenuResponse;
import com.myrecipick.api.controller.my.controller.dto.DeleteMyCustomMenuResponse;
import com.myrecipick.api.controller.my.controller.dto.GetCustomMenuListResponse;
import com.myrecipick.api.controller.my.controller.dto.GetCustomMenuResponse;
import com.myrecipick.api.service.my.MyCustomMenuService;
import java.net.URI;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class MyCustomMenuController {
    private final MyCustomMenuService myCustomMenuService;

    public MyCustomMenuController(MyCustomMenuService myCustomMenuService) {
        this.myCustomMenuService = myCustomMenuService;
    }

    @GetMapping("/my/custom-menus")
    public Mono<ServiceResponse> findAllByUserId(@RequestHeader UUID userId) {
        return myCustomMenuService.findAllByUserId(userId)
            .collectList()
            .map(GetCustomMenuListResponse::ok);
    }

    @GetMapping("/my/custom-menus/{customMenuId}")
    public Mono<ServiceResponse> findByUserId(@PathVariable UUID customMenuId) {
        return myCustomMenuService.findById(customMenuId)
            .map(GetCustomMenuResponse::ok);
    }

    @PostMapping("/my/custom-menus")
    public Mono<ResponseEntity<ServiceResponse>> save(@RequestHeader UUID userId,
        @RequestBody CreateMyCustomMenuRequest request) {
        return myCustomMenuService.save(request.toEntity(userId))
            .map(CreateMyCustomMenuResponse::ok)
            .map(response -> ResponseEntity.created(URI.create("/v1/my/custom-menus/" + response.getData().getId()))
                .body(response));
    }


    @DeleteMapping("/my/custom-menus/{customMenuId}")
    public Mono<ServiceResponse> delete(@PathVariable UUID customMenuId,
        @RequestHeader UUID userId) {
        return myCustomMenuService.delete(customMenuId)
            .map(id -> DeleteMyCustomMenuResponse.ok());
    }

}
