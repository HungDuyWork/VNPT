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
public class UpdateAccountRequest {
    @NotBlank(message = "Số tài khoản không được để trống")
    @Pattern(
            regexp = "^[0-9.\\s]+$",
            message = "Số tài khoản chỉ được bao gồm ký tự số, dấu chấm và khoảng trắng"
    )
    String accountNumber; // Số tài khoản
    Integer type; // Mô tả
    String maNh;
    Integer status; // Trạng thái tài khoản (hoạt động, không hoạt động)
    Integer fmisAccountId; // Loại tài khoản FMIS (Sandbox, Live)
}
