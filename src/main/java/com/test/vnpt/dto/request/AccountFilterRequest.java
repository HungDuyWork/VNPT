package com.test.vnpt.dto.request;

import com.test.vnpt.enums.AccountStatus;
import com.test.vnpt.enums.FmisAccountType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountFilterRequest {
    String bankCode;
    String accountNumber;
    Integer status;
    Integer fmisAccountType;
    Integer page = 0;
    Integer size = 20;
}
