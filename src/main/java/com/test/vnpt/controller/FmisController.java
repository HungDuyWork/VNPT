package com.test.vnpt.controller;

import com.test.vnpt.dto.request.FmisSyncRequest;
import com.test.vnpt.dto.response.ApiResponse;
import com.test.vnpt.service.FmisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fmis")
public class FmisController {

    @Autowired
    private FmisService fmisService;

    // 1. Tim kiem
    @GetMapping
    ApiResponse<List<?>> findFmis(@RequestBody FmisSyncRequest request) {
        return ApiResponse.<List<?>>builder()
                .message("ok")
                .result(fmisService.findFmis(request))
                .build();
    }
}
