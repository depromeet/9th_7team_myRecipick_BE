package com.myrecipick.core.domain.option;

import java.util.Map;
import java.util.UUID;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class OptionPolicy {

    private int min;
    private int max;

    public OptionPolicy() {
    }

    public OptionPolicy(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static OptionPolicy of(Map<String, AttributeValue> policy) {
        OptionPolicy optionPolicy = new OptionPolicy();
        optionPolicy.setMin(Integer.parseInt(policy.get("min").s()));
        optionPolicy.setMax(Integer.parseInt(policy.get("max").s()));

        return optionPolicy;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public static void main(String args[]) {
        for(int i = 0; i < 400; i++) {
            System.out.println(UUID.randomUUID());
        }
    }
}

