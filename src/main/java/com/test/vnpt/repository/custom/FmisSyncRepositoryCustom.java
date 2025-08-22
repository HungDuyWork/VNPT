package com.test.vnpt.repository.custom;

import com.test.vnpt.dto.request.FmisSyncRequest;

import java.util.List;

public interface FmisSyncRepositoryCustom {
    List<?> findFmisSync(FmisSyncRequest request);
}
