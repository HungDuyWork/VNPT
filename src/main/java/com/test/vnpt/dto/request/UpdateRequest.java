package com.test.vnpt.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateRequest {
    String bankName;
    String accountNumber;
    String serviceType;
    Long bankId;
    String bankCode;
    Integer reconcileType;
    List<Integer> reconcileDataCodes;
    Long merchantId;
    Integer preStatus;
    Integer status;
    String fileName;
    String formatDateFile;
    String formatDateData;
    String fileExtension;
    String separator;
    String preFileName;
    String lengthTraceSp;
    String columnConfig;
    String preSftpHost;
    Integer preSftpPort;
    String preSftpUser;
    String preSftpPass;
    String afterFileName;
    String afterFilePath;
    String fileNameSp;
    String formatDateFileSp;
    String formatDateDataSp;
    String fileExtensionSp;
    String separatorSp;
    String columnConfigSp;
}
