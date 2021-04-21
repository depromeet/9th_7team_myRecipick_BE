package com.myrecipick.api.route.brand.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.core.domain.brand.Brand;
import java.util.List;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetBrandsResponse extends ServiceResponse {

    private List<Brand> data;

    public GetBrandsResponse() {
    }

    public GetBrandsResponse(HttpStatus status, String message,
        List<Brand> brands) {
        super(status, message);
        this.data = brands;
    }

    public static GetBrandsResponse ok(List<Brand> brands) {
        GetBrandsResponse getBrandListResponse = new GetBrandsResponse();
        getBrandListResponse.status = HttpStatus.OK;
        getBrandListResponse.data = brands;

        return getBrandListResponse;
    }

    public List<Brand> getData() {
        return data;
    }
}
