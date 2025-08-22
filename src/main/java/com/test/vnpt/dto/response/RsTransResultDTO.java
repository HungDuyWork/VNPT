package com.test.vnpt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RsTransResultDTO {
    private String bankName;
    private String accountNumber;
    private String statementCode;
    private String statementBank;
    private String transactionVnpt;
    private BigDecimal amount;
    private String reconcileCode;
    private String moreInfo;
    private String taxCode;
    private LocalDate valueDate;
    private String fmisIdGd;
}
