package com.myrecipick.core.domain.help;

import java.time.LocalDateTime;
import java.util.UUID;

public class RequestBrand {

    private UUID id;
    private UUID userId;
    private String requestBrand;
    private LocalDateTime createdDate;

    public RequestBrand() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getRequestBrand() {
        return requestBrand;
    }

    public void setRequestBrand(String requestBrand) {
        this.requestBrand = requestBrand;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public static final class Builder {

        private UUID id;
        private UUID userId;
        private String requestBrand;
        private LocalDateTime createdDate;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder requestBrand(String requestBrand) {
            this.requestBrand = requestBrand;
            return this;
        }

        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public RequestBrand build() {
            RequestBrand requestBrand = new RequestBrand();
            requestBrand.setId(this.id);
            requestBrand.setUserId(this.userId);
            requestBrand.setRequestBrand(this.requestBrand);
            requestBrand.setCreatedDate(this.createdDate);
            return requestBrand;
        }
    }
}
