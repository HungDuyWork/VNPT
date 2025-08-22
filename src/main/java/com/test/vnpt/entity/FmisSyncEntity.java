package com.test.vnpt.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "FMIS_SYNC")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class FmisSyncEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NGAY", length = 20)
    private String ngay;

    @Column(name = "LOAI_SK", length = 20)
    private String loaiSk;

    @Column(name = "ID_GD", length = 100)
    private String idGd;

    @Column(name = "LOAI_NV", length = 20)
    private String loaiNv;

    @Column(name = "MA_NH_NH", length = 20)
    private String maNhNh;

    @Column(name = "TK_NH_NH", length = 20)
    private String tkNhNh;

    @Column(name = "MA_NH_CH", length = 20)
    private String maNhCh;

    @Column(name = "TK_NH_CH", length = 20)
    private String tkNhCh;

    @Column(name = "MERCHANT", length = 20)
    private String merchant;

    @Column(name = "L_TIEN", length = 20)
    private String lTien;

    @Column(name = "TIEN")
    private BigDecimal tien;

    @Column(name = "REQUEST_STATUS", length = 20)
    private String requestStatus;

    @Column(name = "REQUEST_THONGBAO", length = 200)
    private String requestThongbao;

    @Column(name = "TRANSACTION_STATUS")
    private Integer transactionStatus;

    @Column(name = "TRANSACTION_THONGBAO", length = 1000)
    private String transactionThongbao;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdate;

    @Column(name = "NOI_DUNG", length = 1000)
    private String noiDung;

    @Column(name = "SO_CHUNG_TU", length = 100)
    private String soChungTu;

    @Column(name = "REQUEST_ID")
    private Long requestId;

    @Column(name = "FMIS_TIME")
    private LocalDateTime fmisTime;

    @Column(name = "BANK_CONFIG_ID")
    private Long bankConfigId;

    @Column(name = "FMIS_ACCOUNT_ID")
    private Long fmisAccountId;

    @Column(name = "FMIS_ID_GD_SUM", length = 100)
    private String fmisIdGdSum;

    @Column(name = "FMIS_API_VER", length = 20)
    private String fmisApiVer;

    @Column(name = "SUMMARY_ID", length = 50)
    private String summaryId;

    @Column(name = "RS_TRANS_RESULT_ID")
    private Long rsTransResultId;

    @Column(name = "RS_TRANS_RESULT_AMOUNT")
    private BigDecimal rsTransResultAmount;

    @Column(name = "VAT")
    private BigDecimal vat;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "L_THUE", length = 20)
    private String lThue;

    @Column(name = "THUE_SUAT")
    private BigDecimal thueSuat;

    @Column(name = "RECONCILE_DATE")
    private LocalDateTime reconcileDate;

    @Column(name = "BUT_TOAN", length = 20)
    private String butToan;

    @Column(name = "TRANSACTION_TYPE")
    private Integer transactionType;

    @Column(name = "RECONCILE_TYPE")
    private Integer reconcileType;
}