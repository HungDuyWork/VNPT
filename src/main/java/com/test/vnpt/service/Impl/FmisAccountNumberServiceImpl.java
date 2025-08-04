package com.test.vnpt.service.Impl;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.request.CreateAccountRequest;
import com.test.vnpt.dto.request.UpdateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;
import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.enums.AccountStatus;
import com.test.vnpt.enums.FmisAccountType;
import com.test.vnpt.mapper.AccountTypeMapper;
import com.test.vnpt.mapper.BankCodeMapper;
import com.test.vnpt.mapper.UserMapper;
import com.test.vnpt.repository.FmisAccountNumberRepository;
import com.test.vnpt.service.FmisAccountNumberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
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
        Integer statusValue = AccountStatus.fromLabel(request.getStatus()) != null
                ? AccountStatus.fromLabel(request.getStatus()).getValue()
                : -1;

        Integer fmisValue = FmisAccountType.fromName(request.getFmisAccountType()) != null
                ? FmisAccountType.fromName(request.getFmisAccountType()).getValue()
                : -1;

        List<FmisAccountNumber> entities = fmisAccountNumberRepository.filterAccounts(
                request.getBankCode(),
                statusValue,
                fmisValue,
                request.getAccountNumber()
        );

        return userMapper.toResponseList(entities);
    }

    @Override
    public AccountResponse findAccount(String accountNumber) {
        FmisAccountNumber account = fmisAccountNumberRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Tài khoản không tồn tại");
        }
        return userMapper.toAcountResponse(account);
    }

    @Override
    public void createAccount(CreateAccountRequest request) {
        if (fmisAccountNumberRepository.existsByAccountNumberAndBankCode(request.getAccountNumber(), request.getBankCode())) {
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
                .createDate(new Date())
                .build();

        fmisAccountNumberRepository.save(entity);
    }

    @Override
    public AccountResponse getAccountByAccountNumberAndBankCode(String accountNumber, String bank) {
        FmisAccountNumber account = fmisAccountNumberRepository.findByAccountNumberAndBankCode(accountNumber, bank);
        return userMapper.toAcountResponse(account);
    }

    @Override
    public void updateAccount(String accountNumber, String bankCode, UpdateAccountRequest request) {
        FmisAccountNumber account = fmisAccountNumberRepository.findByAccountNumberAndBankCode(accountNumber, bankCode);
        if (account == null) {
            throw new EntityNotFoundException("Tài khoản không tồn tại");
        }

        if (!request.getAccountNumber().equals(accountNumber)
                && fmisAccountNumberRepository.existsByAccountNumberAndBankCode(request.getAccountNumber(), bankCode)) {
            throw new IllegalArgumentException("Số tài khoản đã tồn tại");
        }
        // Cập nhật thông tin tài khoản
        userMapper.updateAccountFromRequest(request, account);
    }

    @Override
    public void deleteAccount(String accountNumber, String bankCode) {
        FmisAccountNumber account = fmisAccountNumberRepository.findByAccountNumberAndBankCode(accountNumber, bankCode);
        if (account == null) {
            throw new EntityNotFoundException("Tài khoản không tồn tại");
        } else {
            account.setStatus(-1); // Đánh dấu là không hoạt động
        }
    }
}
