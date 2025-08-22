package com.test.vnpt.controller;

import com.test.vnpt.dto.request.CustomerRequest;
import com.test.vnpt.dto.response.ApiResponse;
import com.test.vnpt.dto.response.BankAccountResponse;
import com.test.vnpt.dto.response.RsTransResultDTO;
import com.test.vnpt.dto.response.StatementReconcileResponse;
import com.test.vnpt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //1. Tìm kiếm <Mã ngân hàng> - <Số tài khoản>
    @GetMapping("/find-bank-account")
    ApiResponse<List<BankAccountResponse>> findBankAccount() {
        return ApiResponse.<List<BankAccountResponse>>builder()
                .message("Success")
                .result(customerService.findBankAccount())
                .build();
    }
    //2. Trạng thái so khớp
    @GetMapping("/find-statement-reconcile")
    ApiResponse<List<StatementReconcileResponse>> findStatementReconcile() {
        return ApiResponse.<List<StatementReconcileResponse>>builder()
                .message("Success")
                .result(customerService.findStatementReconcile())
                .build();
    }
    //3. Tìm kiếm
    @PostMapping("/find")
    ApiResponse<List<RsTransResultDTO>> find(@RequestBody CustomerRequest request) {
        return ApiResponse.<List<RsTransResultDTO>>builder()
                .message("Success")
                .result(customerService.find(request))
                .build();
    }
    //
    @GetMapping("/test/{id}")
    ApiResponse<?> findTest(@PathVariable Long id) {
        return ApiResponse.builder()
                .result(customerService.findTest(id))
                .build();
    }
}
