package com.test.vnpt.enums;

import java.util.Objects;

public enum FmisAccountType {
    ALL(-1),
    SANDBOX(1),
    LIVE(2);

    private final Integer value;
    FmisAccountType(Integer value) { this.value = value; }
    public Integer getValue() { return value; }



}
