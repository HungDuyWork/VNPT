package com.test.vnpt.controller;

import com.test.vnpt.dto.request.AccountFilterRequest;
import com.test.vnpt.dto.request.CreateAccountRequest;
import com.test.vnpt.dto.request.UpdateAccountRequest;
import com.test.vnpt.dto.response.AccountFilterResponse;
import com.test.vnpt.dto.response.AccountResponse;
import com.test.vnpt.dto.response.ApiResponse;
import com.test.vnpt.service.FmisAccountNumberService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
    ApiResponse<List<String>> getBankCodes() {
        List<String> codes = fmisAccountNumberService.getAllBankCodes();
        return ApiResponse.<List<String>>builder()
                .result(codes)
                .build();
    }

    // 2. tìm kiếm
    @PostMapping("/filter")
    ApiResponse<List<AccountFilterResponse>> filterAccounts(@RequestBody @Valid AccountFilterRequest request) {
        return ApiResponse.<List<AccountFilterResponse>>builder()
                .result(fmisAccountNumberService.filterAccounts(request))
                .build();
    }
    // 3. Thêm tài khoản
    @PostMapping("/create")
    ApiResponse<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        return ApiResponse.<AccountResponse>builder()
                .result(fmisAccountNumberService.createAccount(request))
                .build();
    }

    // 5. Update Tài Khoản
    @PutMapping("/{accountNumber}/{bankCode}")
    ApiResponse<AccountResponse> updateAccount(@PathVariable String accountNumber, @PathVariable String bankCode, @Valid @RequestBody UpdateAccountRequest request) {
        return ApiResponse.<AccountResponse>builder()
                .result(fmisAccountNumberService.updateAccount(accountNumber, bankCode, request))
                .build();
    }
    // 6. Xoá Tài Khoản
    @DeleteMapping("/{accountNumber}/{bankCode}")
    public ResponseEntity<?> deleteAccount(@PathVariable String accountNumber, @PathVariable String bankCode) {
        try {
            fmisAccountNumberService.deleteAccount(accountNumber, bankCode);
            return ResponseEntity.ok("Xoá tài khoản thành công");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
