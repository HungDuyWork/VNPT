package com.test.vnpt.service;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.request.CreateAccountRequest;
import com.test.vnpt.dto.request.UpdateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;
import com.test.vnpt.entity.FmisAccountNumber;

import java.util.List;

public interface FmisAccountNumberService {
    List<String> getAllBankCodes();
    List<AccountFilterResponse> filterAccounts(AccountFilterRequest request);
    // 3. Tìm Tài Khoản
    AccountResponse findAccount(String accountNumber);
    // 4. Tạo Tài Khoản
    void createAccount(CreateAccountRequest request);
    // 5. Tìm Tài Khoản bằng AccountNumber + BankCode để update
    AccountResponse getAccountByAccountNumberAndBankCode(String accountNumber, String bank);
    // 6. Update Tài Khoản
    void updateAccount(String accountNumber, String bankCode, UpdateAccountRequest request);
}
