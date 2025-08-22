package com.test.vnpt.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FmisSyncRequest {
    String bankName;               // BANK-CONFIG
    String accountNumber;         // BANK-CONFIG
    String serviceType;            // BANK-CONFIG
    String loaiSk;                //FMISSYNC
    String fromDate;              // NGAY - FMISSYNC
    String toDate;                // NGAY - FMISSYNC
    String transactionStatus;        // TRANSACTION_STATUS - FMISSYNC
    int page;
    int size;
}
