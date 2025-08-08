package com.test.vnpt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum PreStatus {
    CO(1, "Có"),
    KHONG(0, "Không");

    private final int code;
    private final String description;

    public static PreStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(PreStatus.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Mã trạng thái không hợp lệ: " + code));
    }
}
