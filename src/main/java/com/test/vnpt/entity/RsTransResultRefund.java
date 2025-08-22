package com.test.vnpt.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "RS_TRANS_RESULT_REFUND")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class RsTransResultRefund {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rs_trans_result_refund_seq")
    @SequenceGenerator(name = "rs_trans_result_refund_seq", sequenceName = "S_RS_TRANS_RESULT_REFUND", allocationSize = 1)
    @Column(name = "ID")
    Long id;

    @Column(name = "STATEMENT_CODE", length = 200)
    String statementCode;

    @Column(name = "TRANSACTION_VNPT", length = 500)
    String transactionVnpt;

    @Column(name = "STATEMENT_BANK", length = 200)
    String statementBank;

    @Column(name = "TRANS_DATE")
    LocalDateTime transDate;

    @Column(name = "AMOUNT")
    BigDecimal amount;

    @Column(name = "FEE")
    BigDecimal fee;

    @Column(name = "BANK_ID")
    Long bankId;

    @Column(name = "RECONCILE_CODE", length = 20)
    String reconcileCode;

    @Column(name = "TYPE")
    Long type;

    @Column(name = "ACCOUNT_NUMBER", length = 200)
    String accountNumber;

    @Column(name = "BANK_CONFIG_ID")
    Long bankConfigId;

    @Column(name = "MORE_INFO", length = 4000)
    String moreInfo;

    @Column(name = "CORE_TYPE", length = 50)
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

    @Column(name = "DEBIT_AMOUNT")
    BigDecimal debitAmount;

    @Column(name = "VALUE_DATE")
    LocalDateTime valueDate;

    @Column(name = "RS_TRANS_RESULT_ID")
    Long rsTransResultId;

    @Column(name = "FMIS_STATUS")
    Long fmisStatus;

    @Column(name = "CUSTOMER_ID", length = 255)
    String customerId;

    @Column(name = "FMIS_ID_GD", length = 100)
    String fmisIdGd;

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

    @Column(name = "REF_REFUND_ID")
    Long refRefundId;

    @Column(name = "REF_FILE_INFO_ID")
    Long refFileInfoId;

    @Column(name = "CREDIT_AMOUNT")
    BigDecimal creditAmount;
}