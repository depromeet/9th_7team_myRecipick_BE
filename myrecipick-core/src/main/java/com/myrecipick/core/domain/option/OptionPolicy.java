package com.myrecipick.core.domain.option;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class OptionPolicy {

    private int min;
    private int max;
    private boolean canCheckAll;

    public OptionPolicy() {
    }

    public OptionPolicy(int min, int max, boolean canCheckAll) {
        this.min = min;
        this.max = max;
        this.canCheckAll = canCheckAll;
    }

    public static OptionPolicy of(Map<String, AttributeValue> policy) {
        OptionPolicy optionPolicy = new OptionPolicy();
        optionPolicy.min = Integer.parseInt(policy.get("min").s());
        optionPolicy.max = Integer.parseInt(policy.get("max").s());
        optionPolicy.canCheckAll = policy.get("canCheckAll").bool();

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

    public boolean isCanCheckAll() {
        return canCheckAll;
    }
}