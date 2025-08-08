package com.test.vnpt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum ConfigStatus {
    ACTIVE(1, "Hoạt động"),
    INACTIVE(0, "Không hoạt động");

    private final int code;
    private final String description;

    public static ConfigStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(ConfigStatus.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Mã trạng thái không hợp lệ: " + code));
    }
}
