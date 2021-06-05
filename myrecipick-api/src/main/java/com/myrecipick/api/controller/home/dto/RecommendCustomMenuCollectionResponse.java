package com.myrecipick.api.controller.home.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.home.RecommendCustomMenuCollection;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class RecommendCustomMenuCollectionResponse extends ServiceResponse {

    private RecommendCustomMenuCollection data;

    public static RecommendCustomMenuCollectionResponse ok(RecommendCustomMenuCollection data) {
        RecommendCustomMenuCollectionResponse response = new RecommendCustomMenuCollectionResponse();
        response.status = HttpStatus.OK;
        response.data = data;
        return response;
    }

    public RecommendCustomMenuCollection getData() {
        return data;
    }
}
