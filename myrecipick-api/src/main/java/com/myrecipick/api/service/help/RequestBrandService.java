package com.myrecipick.api.service.help;

import com.myrecipick.core.domain.help.RequestBrand;
import com.myrecipick.core.domain.help.RequestBrandRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RequestBrandService {
    private final RequestBrandRepository repository;

    public RequestBrandService(RequestBrandRepository repository) {
        this.repository = repository;
    }

    public Mono<UUID> save(RequestBrand requestBrand) {
        return repository.save(requestBrand);
    }
}
