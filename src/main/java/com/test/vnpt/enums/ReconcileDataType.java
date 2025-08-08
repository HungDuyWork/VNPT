package com.test.vnpt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ReconcileDataType {
    AMOUNT(1, "Số tiền"),
    TRANS_DATE(2, "Ngày giao dịch"),
    CUSTOMER_ID(3, "Mã khách hàng");

    private final int code;
    private final String description;

    public static String getDescriptionByCode(int code) {
        for (ReconcileDataType type : ReconcileDataType.values()) {
            if (type.getCode() == code) {
                return type.getDescription();
            }
        }
        return null;
    }
}