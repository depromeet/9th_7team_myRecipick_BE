package com.myrecipick.core.domain.option;

import java.util.Map;
import java.util.UUID;

public class OptionPolicy {

    private UUID id;
    private String name;
    private Map<String, String> policy;

    public OptionPolicy() {
    }

    public OptionPolicy(UUID id, String name, Map<String, String> policy) {
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

    public Map<String, String> getPolicy() {
        return policy;
    }

    public void setPolicy(Map<String, String> policy) {
        this.policy = policy;
    }


}
