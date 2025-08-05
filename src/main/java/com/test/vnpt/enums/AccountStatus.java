package com.test.vnpt.enums;


import java.util.Objects;

public enum AccountStatus {
    ALL(-1, "Tất cả"),
    ACTIVE(1, "Hoạt động"),
    INACTIVE(0, "Không hoạt động");

    private final int value;
    private final String label;

    AccountStatus(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() { return value; }

    public String getLabel() { return label; }

}
