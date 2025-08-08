package com.test.vnpt.service;

import com.test.vnpt.dto.request.BankConfigCreateRequest;
import com.test.vnpt.dto.request.BankConfigRequest;
import com.test.vnpt.dto.request.BankConfigSaveRequest;
import com.test.vnpt.dto.request.UpdateRequest;
import com.test.vnpt.dto.response.BankResponse;
import com.test.vnpt.entity.BankConfigEntity;

import java.util.List;

public interface BankConfigService {
    List<BankConfigEntity> findAccount(BankConfigRequest request);
    BankConfigEntity addBankConfig(BankConfigCreateRequest request);
    BankConfigEntity addBank(BankConfigSaveRequest request);
    BankConfigEntity updateBankConfig(Long id, UpdateRequest request);
    String deleteBank(Long id);
    List<BankResponse> getBank();
}
