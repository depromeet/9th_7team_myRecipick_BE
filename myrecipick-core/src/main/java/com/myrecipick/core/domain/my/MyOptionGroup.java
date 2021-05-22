package com.myrecipick.core.domain.my;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MyOptionGroup {

    private UUID id;
    private String name;
    private List<MyOption> options;
    
    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MyOption> getOptions() {
        return options;
    }


    public String makeDescription() {
        return options.stream()
            .map(MyOption::getName)
        .collect(Collectors.joining(", "));
    }

    public static final class Builder {

        private UUID id;
        private String name;
        private List<MyOption> options;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder options(List<MyOption> options) {
            this.options = options;
            return this;
        }

        public MyOptionGroup build() {
            MyOptionGroup myOptionGroup = new MyOptionGroup();

            myOptionGroup.id = this.id;
            myOptionGroup.name = this.name;
            myOptionGroup.options = this.options;
            return myOptionGroup;
        }
    }
}
