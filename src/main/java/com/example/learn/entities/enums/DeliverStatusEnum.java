package com.example.learn.entities.enums;

import lombok.Getter;

@Getter
public enum DeliverStatusEnum {
    PENDING(1, "PENDING"),
    ACCEPTED(2, "ACCEPTED"),
    REJECTED(3, "REJECTED");

    private final int code;
    private final String description;

    DeliverStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ResourceTypeEnum valueOf(int code) {
        for (ResourceTypeEnum value : ResourceTypeEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ResourceType code");
    }
}
