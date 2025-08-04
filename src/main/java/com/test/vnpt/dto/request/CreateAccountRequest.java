package com.test.vnpt.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountRequest {
    String bankCode;
    @NotBlank(message = "Số tài khoản không được để trống")
    @Pattern(
            regexp = "^[0-9.\\s]+$",
            message = "Số tài khoản chỉ được bao gồm ký tự số, dấu chấm và khoảng trắng"
    )
    String accountNumber; // Số tài khoản

    String description; // Mô tả
    String fmisAccountId;
}
