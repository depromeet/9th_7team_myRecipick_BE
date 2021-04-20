package com.myrecipick.api.service.brand;

import com.myrecipick.core.domain.brand.Brand;
import com.myrecipick.core.domain.brand.BrandRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Flux<Brand> findAll() {
        return brandRepository.findAll();
    }
}
