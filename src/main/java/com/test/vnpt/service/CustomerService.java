package com.test.vnpt.service;

import com.test.vnpt.dto.request.CustomerRequest;
import com.test.vnpt.dto.response.BankAccountResponse;
import com.test.vnpt.dto.response.RsTransResultDTO;
import com.test.vnpt.dto.response.StatementReconcileResponse;
import com.test.vnpt.entity.RsTransResultEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerService {
    List<BankAccountResponse> findBankAccount();
    List<StatementReconcileResponse> findStatementReconcile();
    List<RsTransResultDTO> find(CustomerRequest request);
    RsTransResultEntity findTest(@PathVariable Long id);
}
