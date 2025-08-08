package com.test.vnpt.controller;

import com.test.vnpt.dto.request.BankConfigCreateRequest;
import com.test.vnpt.dto.request.BankConfigRequest;
import com.test.vnpt.dto.request.BankConfigSaveRequest;
import com.test.vnpt.dto.request.UpdateRequest;
import com.test.vnpt.dto.response.ApiResponse;
import com.test.vnpt.dto.response.BankResponse;
import com.test.vnpt.entity.BankConfigEntity;
import com.test.vnpt.service.BankConfigService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AdminController {
    @Autowired
    private BankConfigService bankConfigService;

    //Công cụ quản lý cấu hình so khớp sao kê- Bank
    // 1. Tìm kiếm bank
    @PostMapping("/find")
    ApiResponse<List<BankConfigEntity>> findBankConfig(@Valid @RequestBody BankConfigRequest request) {
        return ApiResponse.<List<BankConfigEntity>>builder()
                .message("success")
                .result(bankConfigService.findAccount(request))
                .build();
    }
    // 2.Thêm mới cấu hình sao kê
    @PostMapping("/add")
    ApiResponse<BankConfigEntity> addBankConfig(@Validated @RequestBody BankConfigCreateRequest request) {
        return ApiResponse.<BankConfigEntity>builder()
                .message("success")
                .result(bankConfigService.addBankConfig(request))
                .build();
    }

    // 3. Thêm mới cấu hình file trung gian
    @PostMapping("/add-trung-gian")
    ApiResponse<BankConfigEntity> addBank(@Validated @RequestBody BankConfigSaveRequest request) {
        return ApiResponse.<BankConfigEntity>builder()
                .message("success")
                .result(bankConfigService.addBank(request))
                .build();
    }
    // 4. Chỉnh sửa/ Xem chi tiết cấu hình theo id
    @PutMapping("/update/{id}")
    ApiResponse<BankConfigEntity> updateBank(@PathVariable Long id ,@Validated @RequestBody UpdateRequest request) {
        return ApiResponse.<BankConfigEntity>builder()
                .message("success")
                .result(bankConfigService.updateBankConfig(id,request))
                .build();

    }
    // 5. Xoá cấu hình so khớp
    @DeleteMapping("/delete")
    ApiResponse<String> deleteBank(@PathVariable Long id) {
        return ApiResponse.<String>builder()
                .message("success")
                .result(bankConfigService.deleteBank(id))
                .build();
    }
    // 6. Lấy toàn bộ danh sách ngân hàng
    @GetMapping("/find-bank-name")
    ApiResponse<List<BankResponse>> findBankName() {
        return ApiResponse.<List<BankResponse>>builder()
                .message("success")
                .result(bankConfigService.getBank())
                .build();
    }
}
