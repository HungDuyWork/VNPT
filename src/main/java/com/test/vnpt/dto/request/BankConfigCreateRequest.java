package com.test.vnpt.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankConfigCreateRequest {
    // ---------- Thong tin chung ----------
    Integer type; // Loai so khop
    String bankName;
    String accountNumber;
    String serviceType;
    String bankId;
    String bankCode;
    List<Integer> reconcileDataCodes;
    Long merchantId;
    Integer preStatus;
    Integer status;
    // ---------- Cau hinh file sao ke ----------
    String fileName;
    String formatDateFile;
    String formatDateData;
    String fileExtension;
    String separator;
    String preFileName;
    String columnConfig;
    String lengthTraceSp;
    // ---------- Cau hinh file trung gian ----------
    String fileNameSp;
    String formatDateFileSp;
    String formatDateDataSp;
    String fileExtensionSp;
    String separatorSp;
    String columnConfigSp;

}
