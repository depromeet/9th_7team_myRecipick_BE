package com.myrecipick.core.domain.option;

import java.util.Map;
import java.util.UUID;

public class OptionGroupPolicy {

    private UUID id;
    private String name;
    private Map<String, Object> policy;

    public OptionGroupPolicy() {
    }

    public OptionGroupPolicy(UUID id, String name, Map<String, Object> policy) {
        this.id = id;
        this.name = name;
        this.policy = policy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getPolicy() {
        return policy;
    }

    public void setPolicy(Map<String, Object> policy) {
        this.policy = policy;
    }


}
