package com.example.learn.entities.enums;

import lombok.Getter;

@Getter
public enum ResourceTypeEnum {

    LESSON_ONLY(1, "LESSON ONLY"),
    LESSON_TASK(2, "LESSON_TASK"),
    FORUM(3, "FORUM"),
    EXTERNAL_LINK(4, "EXTERNAL_LINK");

    private final int code;
    private final String description;

    ResourceTypeEnum(int code, String description) {
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
