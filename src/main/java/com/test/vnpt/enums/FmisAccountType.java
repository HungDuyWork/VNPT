package com.test.vnpt.enums;

import java.util.Objects;

public enum FmisAccountType {
    ALL(-1),
    SANDBOX(1),
    LIVE(2);

    private final Integer value;
    FmisAccountType(Integer value) { this.value = value; }
    public Integer getValue() { return value; }

    public static String fromValue(Integer value) {
        for (FmisAccountType type : values()) {
            if (Objects.equals(type.getValue(), value)) {
                return type.name(); // Trả về "LIVE", "SANDBOX"
            }
        }
        return "Unknown";
    }
    public static FmisAccountType fromName(String name) {
        for (FmisAccountType type : values()) {
            if (Objects.equals(type.name(), name)) {
                return type;
            }
        }
        return null;
    }


}
