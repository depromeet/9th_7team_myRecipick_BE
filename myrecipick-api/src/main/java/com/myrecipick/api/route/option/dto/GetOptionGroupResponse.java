package com.myrecipick.api.route.option.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.core.domain.option.OptionGroup;
import java.util.List;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetOptionGroupResponse extends ServiceResponse {

    @JsonInclude(Include.NON_NULL)
    private List<OptionGroup> data;

    public GetOptionGroupResponse() {
    }

    public GetOptionGroupResponse(HttpStatus status, String message,
        List<OptionGroup> data) {
        super(status, message);
        this.data = data;
    }

    public static GetOptionGroupResponse ok(List<OptionGroup> data) {
        GetOptionGroupResponse getOptionGroupResponse = new GetOptionGroupResponse();
        getOptionGroupResponse.status = HttpStatus.OK;
        getOptionGroupResponse.data = data;

        return getOptionGroupResponse;
    }

    public List<OptionGroup> getData() {
        return data;
    }
}
