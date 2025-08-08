package com.test.vnpt.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankConfigSaveRequest {
    String bankName;
    String accountNumber;
    String serviceType;
    String bankId;
    String bankCode;
    List<Integer> reconcileDataCodes;
    Long merchantId;
    Integer preStatus;


    // ---------- Vùng Cấu hình file ----------
    String fileName;
    String formatDateFile;
    String formatDateData;
    String fileExtension;
    String separator;
    String preFileName;
    String lengthTraceSp;

    // ----- THONG TIN CHUNG FILE TRUNG GIAN-------------

    String preSftpHost; // IP sFTP file tiền xử lý
    Integer preSftpPort; // Port sFTP file tiền xử lý
    String preSftpUser; // Username sFTP file tiền xử lý
    String preSftpPass; // Password sFTP file tiền xử lý
    String afterFileName; // File name sau xử lý
    String afterFilePath; // Đường dẫn file sau xử lý
}
