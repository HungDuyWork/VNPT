package com.test.vnpt.service.Impl;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.request.CreateAccountRequest;
import com.test.vnpt.dto.request.UpdateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;
import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.mapper.AccountTypeMapper;
import com.test.vnpt.mapper.BankCodeMapper;
import com.test.vnpt.mapper.UserMapper;
import com.test.vnpt.repository.FmisAccountNumberRepository;
import com.test.vnpt.service.FmisAccountNumberService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

import static com.test.vnpt.mapper.AccountTypeMapper.getDbDescriptionByType;

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

        List<FmisAccountNumber> entities = fmisAccountNumberRepository.filterAccounts(
                request.getBankCode(),
                request.getStatus(),
                request.getFmisAccountType(),
                request.getAccountNumber(),
                request.getPage(),
                request.getSize()
        );
        return userMapper.toResponseList(entities);
    }


    @Override
    public AccountResponse createAccount(CreateAccountRequest request) {
        if (fmisAccountNumberRepository.existsByAccountNumberAndBankCode(request.getAccountNumber(), request.getBankCode())) {
            throw new IllegalArgumentException("Tài khoản đã tồn tại");
        }
        // Kiểm tra mã ngân hàng
        String maNh = BankCodeMapper.getMaNh(request.getBankCode());
        // Kiểm tra loại tài khoản
        String description = getDbDescriptionByType(request.getType());
        FmisAccountNumber entity = FmisAccountNumber.builder()
                .bankCode(request.getBankCode())
                .maNh(maNh)
                .accountNumber(request.getAccountNumber())
                .description(description)
                .status(1) // Hoạt động
                .fmisAccountId(request.getFmisAccountId())
                .uploadStatus(0)
                .uploadAgainStatus(0)
                .type(request.getType())
                .createDate(new Date())
                .build();
        fmisAccountNumberRepository.save(entity);
        return userMapper.toResponse(entity);
    }


    @Override
    @Transactional
    public AccountResponse updateAccount(String accountNumber, String bankCode, UpdateAccountRequest request) {
        FmisAccountNumber account = fmisAccountNumberRepository.findByAccountNumberAndBankCode(accountNumber, bankCode);
        if (account == null) {
            throw new EntityNotFoundException("Tài khoản không tồn tại");
        }

        if (!request.getAccountNumber().equals(accountNumber)
                && fmisAccountNumberRepository.existsByAccountNumberAndBankCode(request.getAccountNumber(), bankCode)) {
            throw new IllegalArgumentException("Số tài khoản đã tồn tại");
        }
        account.setAccountNumber(request.getAccountNumber());
        account.setType(request.getType());
        account.setDescription(AccountTypeMapper.getDbDescriptionByType(request.getType()));
        account.setMaNh(request.getMaNh());
        account.setFmisAccountId(Integer.valueOf(request.getFmisAccountId()));
        account.setStatus(Integer.valueOf(request.getStatus()));

        fmisAccountNumberRepository.save(account);
        return userMapper.toResponse(account);
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
