package com.test.vnpt.repository.custom;

import com.test.vnpt.entity.FmisAccountNumber;

import java.util.List;

public interface FmisAccountNumberRepositoryCustom {
    public List<FmisAccountNumber> filterAccounts(String bankCode, Integer status, Integer fmisAccountId, String accountNumber, int page, int size);
}
