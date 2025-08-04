package com.test.vnpt.repository;

import com.test.vnpt.entity.FmisAccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FmisAccountNumberRepository extends JpaRepository<FmisAccountNumber, Long> {

    @Query(value = "SELECT DISTINCT BANK_CODE FROM FMIS_ACCOUNT_NUMBER WHERE BANK_CODE IS NOT NULL", nativeQuery = true)
    List<String> findAllDistinctBankCodes();

    @Query(value = """ 
    SELECT * FROM FMIS_ACCOUNT_NUMBER f
    WHERE (:bankCode = 'ALL' OR f.BANK_CODE = :bankCode)
      AND (:status = -1 OR f.STATUS = :status)
      AND (:fmisAccountId = -1 OR f.FMIS_ACCOUNT_ID = :fmisAccountId)
      AND (:accountNumber IS NULL OR REGEXP_REPLACE(f.ACCOUNT_NUMBER, '[^0-9]', '') = REGEXP_REPLACE(:accountNumber, '[^0-9]', ''))
    """, nativeQuery = true)
    List<FmisAccountNumber> filterAccounts(@Param("bankCode") String bankCode,
                                           @Param("status") Integer status,
                                           @Param("fmisAccountId") Integer fmisAccountId,
                                           @Param("accountNumber") String accountNumber);

    @Query(value = "SELECT * FROM FMIS_ACCOUNT_NUMBER WHERE ACCOUNT_NUMBER = :accountNumber", nativeQuery = true)
    FmisAccountNumber findByAccountNumber(@Param("accountNumber") String accountNumber);

    boolean existsByAccountNumber(String accountNumber); // Kiểm tra tồn tại tài khoản theo số tài khoản
}

