package com.test.vnpt.service;

import com.test.vnpt.dto.request.FmisSyncRequest;

import java.util.List;

public interface FmisService {
    List<?> findFmis(FmisSyncRequest request);
}
