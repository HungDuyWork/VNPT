package com.test.vnpt.mapper;

import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.enums.AccountStatus;
import com.test.vnpt.enums.FmisAccountType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "status", expression = "java(com.test.vnpt.enums.AccountStatus.fromValue(account.getStatus()))")
    @Mapping(target = "fmisAccountId", expression = "java(com.test.vnpt.enums.FmisAccountType.fromValue(account.getFmisAccountId()))")
    AccountFilterResponse toResponse(FmisAccountNumber account);

    List<AccountFilterResponse> toResponseList(List<FmisAccountNumber> accounts);

    @Named("statusToLabel")
    static String mapStatus(Integer status) {
        return AccountStatus.fromValue(status);
    }

    @Named("fmisToLabel")
    static String mapFmis(Integer fmisId) {
        return FmisAccountType.fromValue(fmisId);
    }
}
