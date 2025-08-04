package com.test.vnpt.service.Impl;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.entity.FmisAccountNumber;
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
}
