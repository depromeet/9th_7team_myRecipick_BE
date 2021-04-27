package com.myrecipick.core.domain.user;

import java.util.UUID;


public class User {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public static String tableName = User.class.getSimpleName().toLowerCase();
}
