package com.test.vnpt.mapper;

import com.test.vnpt.dto.request.UpdateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;
import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.enums.AccountStatus;
import com.test.vnpt.enums.FmisAccountType;
import org.mapstruct.*;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<AccountFilterResponse> toResponseList(List<FmisAccountNumber> accounts);
    AccountResponse toResponse(FmisAccountNumber account);
}
