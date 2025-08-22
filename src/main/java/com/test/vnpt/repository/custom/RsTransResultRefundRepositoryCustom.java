package com.test.vnpt.repository.custom;

import com.test.vnpt.dto.request.CustomerRequest;
import com.test.vnpt.dto.response.RsTransResultDTO;
import com.test.vnpt.entity.RsTransResultEntity;

import java.util.List;

public interface RsTransResultRefundRepositoryCustom {
    public List<RsTransResultDTO> find(CustomerRequest request);
}
