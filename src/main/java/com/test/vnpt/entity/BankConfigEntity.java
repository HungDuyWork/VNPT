package com.test.vnpt.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@Table(name = "RS_BANK_CONFIG")
public class BankConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_config_seq")
    @SequenceGenerator(name = "bank_config_seq", sequenceName = "SEQ_FMIS_REQ_ID", allocationSize = 1)
    @Column(name = "ID")
    Long id;

    @Column(name = "BANK_ID")
    Long bankId;

    @Column(name = "BANK_NAME")
    String bankName;

    @Column(name = "ACCOUNT_NUMBER")
    String accountNumber;

    @Column(name = "COLUMN_CONFIG")
    String columnConfig;

    @Column(name = "FILE_NAME")
    String fileName;

    @Column(name = "FILE_EXTENSION")
    String fileExtension;

    @Column(name = "SEPARATOR")
    String separator;

    @Column(name = "FORMAT_DATE_FILE")
    String formatDateFile;

    @Column(name = "FORMAT_DATE_DATA")
    String formatDateData;

    @Column(name = "COLUMN_CONFIG_SP")
    String columnConfigSp;

    @Column(name = "FILE_NAME_SP")
    String fileNameSp;

    @Column(name = "FILE_EXTENSION_SP")
    String fileExtensionSp;

    @Column(name = "FORMAT_DATE_FILE_SP")
    String formatDateFileSp;

    @Column(name = "FORMAT_DATE_DATA_SP")
    String formatDateDataSp;

    @Column(name = "SUPPORT_STATUS")
    Integer supportStatus;

    @Column(name = "STATUS")
    Integer status;

    @Column(name = "SERVICE_TYPE")
    String serviceType;

    @Column(name = "RECONCILE_DATA")
    String reconcileData;

    @Column(name = "MERCHANT_ID")
    Long merchantId;

    @Column(name = "ROW_DATA")
    Integer rowData;

    @Column(name = "ROW_DATA_SP")
    Integer rowDataSp;

    @Column(name = "RECONCILE_DATE")
    @Temporal(TemporalType.DATE)
    Date reconcileDate;

    @Column(name = "SEPARATOR_SP")
    String separatorSp;

    @Column(name = "LENGTH_TRACE_SP")
    String lengthTraceSp;

    @Column(name = "PRE_PATH")
    String prePath;

    @Column(name = "PRE_FILE_NAME")
    String preFileName;

    @Column(name = "PRE_DATE")
    @Temporal(TemporalType.DATE)
    Date preDate;

    @Column(name = "PRE_SFTP_HOST")
    String preSftpHost;

    @Column(name = "PRE_SFTP_PORT")
    Integer preSftpPort;

    @Column(name = "PRE_SFTP_USER")
    String preSftpUser;

    @Column(name = "PRE_SFTP_PASS")
    String preSftpPass;

    @Column(name = "AFTER_FILE_NAME")
    String afterFileName;

    @Column(name = "AFTER_FILE_PATH")
    String afterFilePath;

    @Column(name = "PRE_STATUS")
    Integer preStatus;

    @Column(name = "RECONCILE_TYPE")
    Integer reconcileType;

    @Column(name = "AMOUNT_REFUND_STATUS")
    Integer amountRefundStatus;

    @Column(name = "FORMAT_DATE_VALUE_DATA")
    String formatDateValueData;

    @Column(name = "FORMAT_RECONCILE_DATE")
    String formatReconcileDate;

    @Column(name = "FMIS_API_VER")
    String fmisApiVer;

    @Column(name = "SERVICE_CONFIG")
    String serviceConfig;

    @Column(name = "BANK_CONFIG_SUPPORT_ID")
    Long bankConfigSupportId;

    @Column(name = "FILE_QUANTITY")
    Integer fileQuantity;

    @Column(name = "PRE_DATE_FORMAT")
    String preDateFormat;

    @Column(name = "PRE_ZIP_FILE_NAME")
    String preZipFileName;

    @Column(name = "CDR_CONNECT_CHANNEL")
    Integer cdrConnectChannel;

    @Lob
    @Column(name = "QUERY")
    String query;

    @Column(name = "PRE_ZIP_FORMAT_DATE")
    String preZipFormatDate;

    @Column(name = "SFTP_DATE_CONFIG")
    Integer sftpDateConfig;

    @Column(name = "BANK_CODE")
    String bankCode;
}