package com.myrecipick.api.controller.brand;

import com.myrecipick.api.controller.brand.dto.GetBrandsResponse;
import com.myrecipick.api.service.brand.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/v1/brands")
    public Mono<GetBrandsResponse> getBrands() {
        return brandService.findAll()
            .collectList()
            .map(GetBrandsResponse::ok);
    }
}
