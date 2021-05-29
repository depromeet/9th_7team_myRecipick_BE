package com.myrecipick.api.controller.my.controller.dto;

import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.my.MyCustomMenu;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.http.HttpStatus;

public class CreateMyCustomMenuResponse extends ServiceResponse {

    private ResponseData data;

    public static CreateMyCustomMenuResponse ok(MyCustomMenu myCustomMenu) {
        CreateMyCustomMenuResponse response = new CreateMyCustomMenuResponse();
        response.status = HttpStatus.CREATED;
        response.data = new ResponseData(myCustomMenu);

        return response;
    }

    public ResponseData getData() {
        return data;
    }

    public static class ResponseData {

        private UUID id;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

        public ResponseData(MyCustomMenu myCustomMenu) {
            this.id = myCustomMenu.getId();
            this.createdDate = myCustomMenu.getCreatedDate();
            this.updatedDate = myCustomMenu.getUpdatedDate();
        }

        public UUID getId() {
            return id;
        }

        public LocalDateTime getCreatedDate() {
            return createdDate;
        }

        public LocalDateTime getUpdatedDate() {
            return updatedDate;
        }
    }

}
