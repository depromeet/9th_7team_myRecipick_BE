package com.myrecipick.service.brand;

import com.myrecipick.domain.brand.BrandRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return brandRepository.findAll()
            .collect(Collectors.toList())
            .flatMap(brands -> ServerResponse.ok().body(BodyInserters.fromValue(brands)));
    }
}
