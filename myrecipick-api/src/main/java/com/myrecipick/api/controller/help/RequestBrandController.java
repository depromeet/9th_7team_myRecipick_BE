package com.myrecipick.api.controller.help;

import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.api.controller.help.dto.SaveRequestBrandRequest;
import com.myrecipick.api.controller.help.dto.SaveRequestBrandResponse;
import com.myrecipick.api.service.help.RequestBrandService;
import com.myrecipick.core.domain.help.RequestBrand;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RequestBrandController {

    private final RequestBrandService requestBrandService;

    public RequestBrandController(RequestBrandService requestBrandService) {
        this.requestBrandService = requestBrandService;
    }

    @PostMapping("/v1/help/request-brands")
    public Mono<ServiceResponse> requestBrands(@RequestHeader UUID userId,
        @RequestBody SaveRequestBrandRequest request) {
        return requestBrandService.save(RequestBrand.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .requestBrand(request.getRequestBrand())
                .createdDate(LocalDateTime.now())
                .build())
            .map(item -> SaveRequestBrandResponse.ok());
    }
}
