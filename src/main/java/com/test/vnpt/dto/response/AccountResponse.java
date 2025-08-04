package com.test.vnpt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
    String bankCode;
    String accountNumber; // Số tài khoản
    String description; // Mô tả
    String maNh;
    String status;
    String fmisAccountId;
}
