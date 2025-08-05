package com.test.vnpt.service;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.request.CreateAccountRequest;
import com.test.vnpt.dto.request.UpdateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;

import java.util.List;

public interface FmisAccountNumberService {
    List<String> getAllBankCodes();
    // 1. Tìm kiếm
    List<AccountFilterResponse> filterAccounts(AccountFilterRequest request);
    // 4. Tạo Tài Khoản
    AccountResponse createAccount(CreateAccountRequest request);
    // 6. Update Tài Khoản
    AccountResponse updateAccount(String accountNumber, String bankCode, UpdateAccountRequest request);
    // 7. Xoá Tài Khoản
    void deleteAccount(String accountNumber, String bankCode);
}
