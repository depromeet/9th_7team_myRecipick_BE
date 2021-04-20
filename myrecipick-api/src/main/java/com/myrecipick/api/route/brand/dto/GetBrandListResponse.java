package com.myrecipick.api.route.brand.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.core.domain.brand.Brand;
import java.util.List;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetBrandListResponse extends ServiceResponse {

    private List<Brand> data;

    public GetBrandListResponse() {
    }

    public GetBrandListResponse(HttpStatus status, String message,
        List<Brand> brands) {
        super(status, message);
        this.data = brands;
    }

    public static GetBrandListResponse ok(List<Brand> brands) {
        GetBrandListResponse getBrandListResponse = new GetBrandListResponse();
        getBrandListResponse.status = HttpStatus.OK;
        getBrandListResponse.data = brands;

        return getBrandListResponse;
    }

    public List<Brand> getData() {
        return data;
    }
}
