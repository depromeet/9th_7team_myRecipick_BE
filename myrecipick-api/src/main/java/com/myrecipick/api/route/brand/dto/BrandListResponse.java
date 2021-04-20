package com.myrecipick.api.route.brand.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.core.domain.brand.Brand;
import java.util.List;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class BrandListResponse extends ServiceResponse {

    private List<Brand> data;

    public BrandListResponse() {
    }

    public BrandListResponse(HttpStatus status, String message,
        List<Brand> brands) {
        super(status, message);
        this.data = brands;
    }

    public static BrandListResponse ok(List<Brand> brands) {
        BrandListResponse brandListResponse = new BrandListResponse();
        brandListResponse.status = HttpStatus.OK;
        brandListResponse.data = brands;

        return brandListResponse;
    }

    public List<Brand> getData() {
        return data;
    }
}
