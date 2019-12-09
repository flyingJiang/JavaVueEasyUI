package com.flying.common.entity;

public enum HSHttpCodeEnum {
    CODE_200("SUCCESS", 200),

    CODE_500("Internal Server Error", 500);

    // ... other http code, please fill by you need

    private String name;
    private int value;

    private HSHttpCodeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
