package com.test.vnpt.controller;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.service.FmisAccountNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class UserController {
    @Autowired
    private FmisAccountNumberService fmisAccountNumberService;

    //1. Tìm Mã Ngân Hàng
    @GetMapping("/find-bank-code")
    public ResponseEntity<List<String>> getBankCodes() {
        List<String> codes = fmisAccountNumberService.getAllBankCodes();
        return ResponseEntity.ok(codes);
    }
    // 2. Lọc Tài Khoản
    @PostMapping("/filter")
    public ResponseEntity<List<AccountFilterResponse>> filter(@RequestBody AccountFilterRequest request) {
        return ResponseEntity.ok(fmisAccountNumberService.filterAccounts(request));
    }

}
