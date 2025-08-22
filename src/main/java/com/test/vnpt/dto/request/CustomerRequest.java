package com.test.vnpt.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    String bankName;
    String accountNumber;
    String reconcileCode;
    String transactionVnpt;
    BigDecimal fromAmount;
    BigDecimal toAmount;
    int page;
    int size;
}
