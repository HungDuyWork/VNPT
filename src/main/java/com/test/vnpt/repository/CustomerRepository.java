package com.test.vnpt.repository;

import com.test.vnpt.dto.response.BankAccountResponse;
import com.test.vnpt.entity.BankConfigEntity;
import com.test.vnpt.repository.custom.RsTransResultRefundRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<BankConfigEntity, Long> {

    @Query("""
    SELECT DISTINCT new com.test.vnpt.dto.response.BankAccountResponse(
        b.bankName, 
        b.accountNumber
    )
    FROM BankConfigEntity b
""")
    List<BankAccountResponse> findDistinctBankConfigs();
}
