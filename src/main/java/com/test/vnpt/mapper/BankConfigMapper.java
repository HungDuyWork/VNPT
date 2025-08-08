package com.test.vnpt.mapper;

import com.test.vnpt.dto.request.BankConfigCreateRequest;
import com.test.vnpt.dto.request.BankConfigSaveRequest;
import com.test.vnpt.dto.response.BankResponse;
import com.test.vnpt.entity.BankConfigEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankConfigMapper {
    BankConfigEntity toAddBank(BankConfigCreateRequest request);
    BankConfigEntity toAddBankRequest(BankConfigSaveRequest request);
    List<BankResponse> toAddBankResponse(List<BankConfigEntity> entity);
}
