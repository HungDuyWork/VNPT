package com.test.vnpt.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankConfigRequest {
    String bankName;
    String accountNumber;
    String serviceType;
    Integer status;
    Integer page = 0;
    Integer size = 20;
}
