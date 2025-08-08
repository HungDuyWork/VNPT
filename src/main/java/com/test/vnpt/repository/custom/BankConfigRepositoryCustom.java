package com.test.vnpt.repository.custom;

import com.test.vnpt.entity.BankConfigEntity;

import java.util.List;

public interface BankConfigRepositoryCustom {
    public List<BankConfigEntity> findAccount(String bankName, String accountNumber, String serviceType, Integer status, Integer page, Integer size);
}
