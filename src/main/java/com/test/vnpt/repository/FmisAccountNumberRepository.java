package com.test.vnpt.repository;

import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.repository.custom.FmisAccountNumberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FmisAccountNumberRepository extends JpaRepository<FmisAccountNumber, Long>, FmisAccountNumberRepositoryCustom {

    @Query(value = "SELECT DISTINCT BANK_CODE FROM FMIS_ACCOUNT_NUMBER WHERE BANK_CODE IS NOT NULL", nativeQuery = true)
    List<String> findAllDistinctBankCodes();

    @Query(value = "SELECT * FROM FMIS_ACCOUNT_NUMBER WHERE ACCOUNT_NUMBER = :accountNumber", nativeQuery = true)
    FmisAccountNumber findByAccountNumber(@Param("accountNumber") String accountNumber);
    // Kiểm tra xem tài khoản đã tồn tại hay chưa
    boolean existsByAccountNumberAndBankCode(String accountNumber, String bankCode);
    // 5. Tìm Tài Khoản bằng AccountNumber + BankCode để update
    FmisAccountNumber findByAccountNumberAndBankCode(String accountNumber, String bankCode);
}

