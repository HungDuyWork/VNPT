package com.test.vnpt.controller;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.request.CreateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;
import com.test.vnpt.service.FmisAccountNumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/accounts")
public class UserController {
    @Autowired
    private FmisAccountNumberService fmisAccountNumberService;

    //1. Tìm Mã Ngân Hàng
    @GetMapping("/find-bank-code")
    public ResponseEntity<List<String>> getBankCodes() {
        List<String> codes = fmisAccountNumberService.getAllBankCodes();
        return ok(codes);
    }

    // 2. Lọc Tài Khoản
    @PostMapping("/filter")
    public ResponseEntity<List<AccountFilterResponse>> filter(@RequestBody AccountFilterRequest request) {
        return ok(fmisAccountNumberService.filterAccounts(request));
    }
    // 3. Tạo Tài Khoản
    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        try {
            fmisAccountNumberService.createAccount(request);
            return ResponseEntity.ok("Tạo tài khoản thành công");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // 4. Tìm Tài Khoản bằng AccountNumber
    @GetMapping("/find-account/{accountNumber}")
    public ResponseEntity<AccountResponse> findAccount(@PathVariable String accountNumber) {
        return ok(fmisAccountNumberService.findAccount(accountNumber));
    }
}
