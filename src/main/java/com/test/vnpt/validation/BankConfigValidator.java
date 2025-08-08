package com.test.vnpt.validation;

import com.test.vnpt.dto.request.BankConfigCreateRequest;
import com.test.vnpt.dto.request.BankConfigSaveRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class BankConfigValidator {

    public void validateCreate(BankConfigCreateRequest request) {
        validateCommon(request.getBankName(), request.getAccountNumber(), request.getBankId(),
                request.getFileName(), request.getFormatDateFile(), request.getFormatDateData(),
                request.getLengthTraceSp(), request.getColumnConfig());

        Integer type = request.getType();
        if (type == 2 || type == 3) {
            validateSecondaryFile(request.getFileNameSp(), request.getFormatDateFileSp(),
                    request.getFormatDateDataSp(), request.getColumnConfigSp());
        }
    }

    public void validateSave(BankConfigSaveRequest request) {
        validateCommon(request.getBankName(), request.getAccountNumber(), request.getBankId(),
                request.getFileName(), request.getFormatDateFile(), request.getFormatDateData(),
                request.getLengthTraceSp(), null); // BankConfigSaveRequest không có columnConfig
    }


    private void validateCommon(String bankName, String accountNumber, String bankId,
                                String fileName, String formatDateFile, String formatDateData,
                                String lengthTraceSp, String columnConfig) {

        if (bankName != null && bankName.contains(" ")) {
            throw new IllegalArgumentException("Ngân hàng nhập không được chứa dấu cách");
        }

        if (accountNumber != null && accountNumber.contains(" ")) {
            throw new IllegalArgumentException("Số tài khoản không được chứa dấu cách");
        }

        if (bankId != null && !bankId.matches("\\d+")) {
            throw new IllegalArgumentException("Mã ngân hàng tại core chỉ được nhập toàn bộ bằng dạng số");
        }

        if (!StringUtils.hasText(fileName)) {
            throw new IllegalArgumentException("Tên file sao kê không được để trống.");
        }

        validateDateFormat(formatDateFile, "Ngày định dạng file sao kê");
        validateDateFormat(formatDateData, "Ngày định dạng dữ liệu sao kê");

        if (lengthTraceSp != null && !lengthTraceSp.matches("\\d+")) {
            throw new IllegalArgumentException("Độ dài chuỗi ký tự chỉ được nhập toàn bộ bằng dạng số");
        }

        if (columnConfig != null && !columnConfig.matches("\\d+")) {
            throw new IllegalArgumentException("Cấu hình cột phải là dạng số");
        }
    }

    private void validateSecondaryFile(String fileNameSp, String formatDateFileSp,
                                       String formatDateDataSp, String columnConfigSp) {
        if (!StringUtils.hasText(fileNameSp)) {
            throw new IllegalArgumentException("Tên file sao kê trung gian không được để trống.");
        }

        validateDateFormat(formatDateFileSp, "Ngày định dạng file sao kê trung gian");
        validateDateFormat(formatDateDataSp, "Ngày định dạng dữ liệu sao kê trung gian");

        if (columnConfigSp == null || !columnConfigSp.matches("\\d+")) {
            throw new IllegalArgumentException("Cấu hình cột trung gian phải là dạng số");
        }
    }

    private void validateDateFormat(String value, String fieldName) {
        if (!StringUtils.hasText(value)) {
            throw new IllegalArgumentException(fieldName + " không được để trống.");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            formatter.parse(value);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(fieldName + " không đúng định dạng ddMMyyyy.");
        }
    }
}

