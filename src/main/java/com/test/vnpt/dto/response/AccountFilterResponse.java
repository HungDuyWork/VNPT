package com.test.vnpt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountFilterResponse {
    String bankCode;   // Mã ngân hàng
    String accountNumber; // Số tài khoản
    String maNh; // Mã ngân hàng
    String description; // Loại tài khoản
    String status; // Trạng thái tài khoản (hoạt động, không hoạt động)
    String fmisAccountId; // Loại tài khoản FMIS (Sandbox, Live)
}
