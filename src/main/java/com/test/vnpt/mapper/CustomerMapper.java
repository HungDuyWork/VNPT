package com.test.vnpt.mapper;

import com.test.vnpt.dto.response.BankAccountResponse;
import com.test.vnpt.dto.response.StatementReconcileResponse;
import com.test.vnpt.entity.BankConfigEntity;
import com.test.vnpt.entity.RsTransResultEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<BankAccountResponse> toBankAccount(List<BankConfigEntity> entities);
    List<StatementReconcileResponse> findStatementReconcile(List<RsTransResultEntity> entityList);

}
