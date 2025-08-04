package com.test.vnpt.service;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.entity.FmisAccountNumber;

import java.util.List;

public interface FmisAccountNumberService {
    List<String> getAllBankCodes();
    List<AccountFilterResponse> filterAccounts(AccountFilterRequest request);
}
