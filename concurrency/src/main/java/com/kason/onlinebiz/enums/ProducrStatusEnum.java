package com.kason.onlinebiz.enums;

import lombok.Getter;

@Getter
public enum ProducrStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;
    private Integer code;
    private String message;

    ProducrStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
