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
@Table(name = "FMIS_ACCOUNT_NUMBER")
public class FmisAccountNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fmis_seq")
    @SequenceGenerator(name = "fmis_seq", sequenceName = "SEQ_FMIS_ACCOUNT", allocationSize = 1)
    @Column(name = "ID")
    Long id; // ID chính (khóa chính)

    @Column(name = "ACCOUNT_NUMBER")
    String accountNumber; // Số tài khoản

    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date createDate; // Ngày tạo

    @Column(name = "STATUS")
    Integer status; // Trạng thái tài khoản (1 - Hoạt động, 2 - Không hoạt động)

    @Column(name = "BANK_CODE")
    String bankCode; // Mã ngân hàng

    @Column(name = "FMIS_ACCOUNT_ID")
    Integer fmisAccountId; // Loại tài khoản FMIS (1 - Sandbox, 2 - Live)

    @Column(name = "UPLOAD_STATUS")
    Integer uploadStatus; // Trạng thái upload (0 - chưa upload, 1 - đã upload)

    @Column(name = "UPLOAD_AGAIN_STATUS")
    Integer uploadAgainStatus; // Trạng thái upload lại

    @Column(name = "MA_NH")
    String maNh; // Mã ngân hàng (bổ sung thêm, có thể khác bankCode tùy hệ thống)

    @Column(name = "TYPE")
    Integer type; // Loại tài khoản (hoặc loại dữ liệu, phụ thuộc nghiệp vụ)

    @Column(name = "DESCRIPTION")
    String description; // Mô tả

    @Column(name = "REF_ACCNO_ID")
    Long refAccnoId; // ID tài khoản tham chiếu (nếu có)

    @Column(name = "BANK_NAME")
    String bankName; // Tên ngân hàng

    @Column(name = "BANK_BRANCH")
    String bankBranch; // Chi nhánh ngân hàng

    @Column(name = "BANK_ADDRESS")
    String bankAddress; // Địa chỉ ngân hàng

    @Column(name = "CHU_THE")
    Long chuThe; // Chủ thể liên quan (có thể là ID người dùng, tổ chức,...)
}