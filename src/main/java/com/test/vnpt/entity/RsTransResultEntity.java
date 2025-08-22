package com.test.vnpt.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "RS_TRANS_RESULT")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class RsTransResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rs_trans_result_seq")
    @SequenceGenerator(name = "rs_trans_result_seq", sequenceName = "S_RS_TRANS_RESULT", allocationSize = 1)
    @Column(name = "ID")
    Long id;

    @Column(name = "STATEMENT_CODE", length = 500)
    String statementCode;

    @Column(name = "TRANSACTION_VNPT", length = 500)
    String transactionVnpt;

    @Column(name = "STATEMENT_BANK", length = 500)
    String statementBank;

    @Column(name = "TRANS_DATE")
    LocalDateTime transDate;

    @Column(name = "AMOUNT")
    BigDecimal amount;

    @Column(name = "FEE")
    BigDecimal fee;

    @Column(name = "BANK_ID")
    Long bankId;

    @Column(name = "RECONCILE_CODE", length = 500)
    String reconcileCode;

    @Column(name = "TYPE")
    Long type;

    @Column(name = "ACCOUNT_NUMBER", length = 500)
    String accountNumber;

    @Column(name = "BANK_CONFIG_ID")
    Long bankConfigId;

    @Column(name = "MORE_INFO", length = 4000)
    String moreInfo;

    @Column(name = "CORE_TYPE", length = 500)
    String coreType;

    @Column(name = "STATUS")
    Long status;

    @Column(name = "CREATE_DATE")
    LocalDateTime createDate;

    @Column(name = "LAST_UPDATE")
    LocalDateTime lastUpdate;

    @Column(name = "RECONCILE_DATA", length = 255)
    String reconcileData;

    @Column(name = "MERCHANT_ID")
    Long merchantId;

    @Column(name = "TAX_CODE", length = 20)
    String taxCode;

    @Column(name = "TRANSACTION_TYPE", length = 50)
    String transactionType;

    @Column(name = "MERCHANT_TRANSACTION_ID", length = 500)
    String merchantTransactionId;

    @Column(name = "PROVIDER_ID", length = 500)
    String providerId;

    @Column(name = "CREDIT_AMOUNT")
    BigDecimal creditAmount;

    @Column(name = "DEBIT_AMOUNT")
    BigDecimal debitAmount;

    @Column(name = "VALUE_DATE")
    Date valueDate;

    @Column(name = "FMIS_STATUS")
    Long fmisStatus;

    @Column(name = "FMIS_ID_GD", length = 100)
    String fmisIdGd;

    @Column(name = "CUSTOMER_ID", length = 500)
    String customerId;

    @Column(name = "FMIS_STATUS_DESC", length = 200)
    String fmisStatusDesc;

    @Column(name = "SO_CHUNG_TU", length = 100)
    String soChungTu;

    @Column(name = "FMIS_TIME")
    LocalDateTime fmisTime;

    @Column(name = "REF_RESULT_ID")
    Long refResultId;

    @Column(name = "FMIS_ACCOUNT_ID")
    Long fmisAccountId;

    @Column(name = "SERVICE_TYPE", length = 50)
    String serviceType;

    @Column(name = "RECONCILE_DATE")
    LocalDateTime reconcileDate;

    @Column(name = "UPDATE_BY", length = 200)
    String updateBy;

    @Column(name = "FMIS_ID_GD_SUM", length = 100)
    String fmisIdGdSum;

    @Column(name = "REF_FILE_INFO_ID")
    Long refFileInfoId;

    @Column(name = "TRANSACTION_ID_TO_PARTER", length = 500)
    String transactionIdToParter;

    @Column(name = "TRANSACTION_ID_FROM_PARTNER", length = 500)
    String transactionIdFromPartner;

    @Column(name = "PARTNER_TRANSACTION_ID", length = 500)
    String partnerTransactionId;

    @Column(name = "SERVICE_ID", length = 50)
    String serviceId;

    @Column(name = "SEND_WALLET_NUMBER", length = 500)
    String sendWalletNumber;

    @Column(name = "SEND_WALLET_TYPE", length = 50)
    String sendWalletType;

    @Column(name = "SEND_WALLET_NAME", length = 500)
    String sendWalletName;

    @Column(name = "ORGANIZATION", length = 500)
    String organization;

    @Column(name = "RECEIVE_WALLET_NUMBER", length = 500)
    String receiveWalletNumber;

    @Column(name = "RECEIVE_WALLET_NAME", length = 500)
    String receiveWalletName;

    @Column(name = "CHANNEL_ID", length = 50)
    String channelId;

    @Column(name = "FINAL_AMOUNT")
    BigDecimal finalAmount;

    @Column(name = "TRANSACTION_STATUS")
    Long transactionStatus;

    @Column(name = "CONNECT_TYPE", length = 500)
    String connectType;

    @Column(name = "SEND_EMAIL", length = 500)
    String sendEmail;

    @Column(name = "RECEIVE_EMAIL", length = 500)
    String receiveEmail;

    @Column(name = "DESCRIPTION", length = 2000)
    String description;

    @Column(name = "RESPONSE_DESCRIPTION", length = 2000)
    String responseDescription;

    @Column(name = "REF_TRRANSACTION_ID_TO_PARTNER", length = 500)
    String refTrransactionIdToPartner;

    @Column(name = "TRANS_TYPE_NAME", length = 500)
    String transTypeName;

    @Column(name = "PARTNER_ID")
    Long partnerId;

    @Column(name = "PROVINCE_CODE", length = 500)
    String provinceCode;

    @Column(name = "ADDITION_INFO", length = 2000)
    String additionInfo;
}