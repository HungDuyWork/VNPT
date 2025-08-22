package com.test.vnpt.service.Impl;

import com.test.vnpt.dto.request.FmisSyncRequest;
import com.test.vnpt.repository.FmisSyncRepository;
import com.test.vnpt.service.FmisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FmisServiceImpl implements FmisService {
    @Autowired
    private FmisSyncRepository fmisSyncRepository;
    @Override
    public List<?> findFmis(FmisSyncRequest request) {
        return fmisSyncRepository.findFmisSync(request);
    }
}
