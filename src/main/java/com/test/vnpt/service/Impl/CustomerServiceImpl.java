package com.test.vnpt.service.Impl;

import com.test.vnpt.dto.request.CustomerRequest;
import com.test.vnpt.dto.response.BankAccountResponse;
import com.test.vnpt.dto.response.RsTransResultDTO;
import com.test.vnpt.dto.response.StatementReconcileResponse;
import com.test.vnpt.entity.RsTransResultEntity;
import com.test.vnpt.mapper.CustomerMapper;
import com.test.vnpt.repository.CustomerRepository;
import com.test.vnpt.repository.RsTransResultRefundRepository;
import com.test.vnpt.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RsTransResultRefundRepository rsTransResultRepository;

    @Override
    public List<BankAccountResponse> findBankAccount() {
        return customerRepository.findDistinctBankConfigs();
    }

    @Override
    public List<StatementReconcileResponse> findStatementReconcile() {
        List<RsTransResultEntity> rsTransResultEntity = rsTransResultRepository.findAll();
        return customerMapper.findStatementReconcile(rsTransResultEntity);
    }

    @Override
    public List<RsTransResultDTO> find(CustomerRequest request) {
        return rsTransResultRepository.find(request);
    }

    @Override
    public RsTransResultEntity findTest(Long id) {
        return rsTransResultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tài khoản không tồn tại."));
    }

}
