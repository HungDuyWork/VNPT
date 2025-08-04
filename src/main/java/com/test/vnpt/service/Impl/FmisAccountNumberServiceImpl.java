package com.test.vnpt.service.Impl;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.request.CreateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;
import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.mapper.AccountTypeMapper;
import com.test.vnpt.mapper.BankCodeMapper;
import com.test.vnpt.mapper.UserMapper;
import com.test.vnpt.repository.FmisAccountNumberRepository;
import com.test.vnpt.service.FmisAccountNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FmisAccountNumberServiceImpl implements FmisAccountNumberService {
    @Autowired
    private FmisAccountNumberRepository fmisAccountNumberRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<String> getAllBankCodes() {
        return fmisAccountNumberRepository.findAllDistinctBankCodes();
    }

    @Override
    public List<AccountFilterResponse> filterAccounts(AccountFilterRequest request) {
        List<FmisAccountNumber> entities =  fmisAccountNumberRepository.filterAccounts(
                request.getBankCode(),
                (request.getStatus() == null) ? -1 : request.getStatus().getValue(),
                (request.getFmisAccountType() == null) ? -1 : request.getFmisAccountType().getValue(),
                request.getAccountNumber()
        );
        return userMapper.toResponseList(entities);
    }

    @Override
    public AccountResponse findAccount(String accountNumber) {
        FmisAccountNumber account = fmisAccountNumberRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        return userMapper.toAcountResponse(account);
    }

    @Override
    public void createAccount(CreateAccountRequest request) {
        if (fmisAccountNumberRepository.existsByAccountNumber(request.getAccountNumber())) {
            throw new IllegalArgumentException("Tài khoản đã tồn tại");
        }
        // Kiểm tra mã ngân hàng
        String maNh = BankCodeMapper.getMaNh(request.getBankCode());
        // Kiểm tra loại tài khoản
        Integer type = AccountTypeMapper.getTypeByDbDescription(request.getDescription());
        FmisAccountNumber entity = FmisAccountNumber.builder()
                .bankCode(request.getBankCode())
                .maNh(maNh)
                .accountNumber(request.getAccountNumber())
                .description(request.getDescription())
                .status(1) // Hoạt động
                .fmisAccountId(1) // sandbox
                .uploadStatus(0)
                .uploadAgainStatus(0)
                .type(type)
                .description(request.getDescription())
                .build();
        System.out.println("Trying to save ID: " + entity.getId());


        fmisAccountNumberRepository.save(entity);
        System.out.println("Saved entity with ID: " + entity.getId());

    }

}
