package com.test.vnpt.service.Impl;

import com.test.vnpt.dto.request.BankConfigCreateRequest;
import com.test.vnpt.dto.request.BankConfigRequest;
import com.test.vnpt.dto.request.BankConfigSaveRequest;
import com.test.vnpt.dto.request.UpdateRequest;
import com.test.vnpt.dto.response.BankResponse;
import com.test.vnpt.entity.BankConfigEntity;
import com.test.vnpt.mapper.BankConfigMapper;
import com.test.vnpt.repository.BankConfigRepository;
import com.test.vnpt.service.BankConfigService;
import com.test.vnpt.validation.BankConfigValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankConfigServiceImpl implements BankConfigService {
    @Autowired
    private BankConfigRepository bankConfigRepository;
    @Autowired
    private BankConfigMapper bankConfigMapper;
    @Autowired
    private BankConfigValidator validator;
    @Override
    public List<BankConfigEntity> findAccount(BankConfigRequest request) {
        List<BankConfigEntity> bankConfigEntities = bankConfigRepository.findAccount(
                request.getBankName(),
                request.getAccountNumber(),
                request.getServiceType(),
                request.getStatus(),
                request.getPage(),
                request.getSize()
        );
        return bankConfigEntities;
    }

    @Override
    public BankConfigEntity addBankConfig(BankConfigCreateRequest request) {
        validator.validateCreate(request);
        BankConfigEntity entity = new BankConfigEntity();
        BeanUtils.copyProperties(request, entity);

        entity.setSupportStatus(1);
        entity.setCdrConnectChannel(10);

        return bankConfigRepository.save(entity);
    }

    @Override
    public BankConfigEntity addBank(BankConfigSaveRequest request) {
        validator.validateSave(request);
        BankConfigEntity entity = bankConfigMapper.toAddBankRequest(request);
        entity.setSupportStatus(1);
        entity.setCdrConnectChannel(10);
        return bankConfigRepository.save(entity);
    }

    @Override
    public BankConfigEntity updateBankConfig(Long id,UpdateRequest request) {
        BankConfigEntity entityToUpdate = bankConfigRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tài khoản không tồn tại."));
        BeanUtils.copyProperties(request,entityToUpdate);

        return bankConfigRepository.save(entityToUpdate);

    }

    @Override
    public String deleteBank(Long id) {
        BankConfigEntity entity = bankConfigRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tài khoản không tồn tại."));
        bankConfigRepository.delete(entity);
        return "Xoá tài khoản thành công";
    }

    @Override
    public List<BankResponse> getBank() {
        List<BankConfigEntity> entity = bankConfigRepository.findAll();
        return bankConfigMapper.toAddBankResponse(entity);
    }

}
