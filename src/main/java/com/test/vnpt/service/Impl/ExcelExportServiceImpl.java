package com.test.vnpt.service.Impl;

import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.repository.FmisAccountNumberRepository;
import com.test.vnpt.service.ExcelExportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelExportServiceImpl implements ExcelExportService {
    private final FmisAccountNumberRepository fmisAccountNumberRepository;

    @Override
    public void exportBooksToExcel(HttpServletResponse response) {
        try(Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Bank");
            int rowCount = 0;

            CellStyle redStyle = workbook.createCellStyle();
            redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle yellowStyle = workbook.createCellStyle();
            yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle greenStyle = workbook.createCellStyle();
            greenStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Row header = sheet.createRow(rowCount++);
            String[] headers = {
                    "ID", "Số tài khoản", "Ngày tạo", "Trạng thái", "Mã ngân hàng",
                    "ID tài khoản FMIS", "Trạng thái upload", "Trạng thái upload lại",
                    "Mã NH", "Loại", "Mô tả", "ID tài khoản tham chiếu",
                    "Tên ngân hàng", "Chi nhánh ngân hàng", "Địa chỉ ngân hàng", "Chủ thể"
            };

            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
            }

            List<FmisAccountNumber> entities = fmisAccountNumberRepository.findAll();
            for (FmisAccountNumber entity : entities) {
                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue(entity.getId());
                row.createCell(1).setCellValue(entity.getAccountNumber());
                if (entity.getCreateDate() != null) {
                    row.createCell(2).setCellValue(entity.getCreateDate());
                }
                if (entity.getStatus() != null) {
                    row.createCell(3).setCellValue(entity.getStatus());
                }
                if (entity.getBankCode() != null) {
                    row.createCell(4).setCellValue(entity.getBankCode());
                }
                if (entity.getFmisAccountId() != null) {
                    row.createCell(5).setCellValue(entity.getFmisAccountId());
                }
                if (entity.getUploadStatus() != null) {
                    row.createCell(6).setCellValue(entity.getUploadStatus());
                }
                if (entity.getUploadAgainStatus() != null) {
                    row.createCell(7).setCellValue(entity.getUploadAgainStatus());
                }
                if (entity.getMaNh() != null) {
                    row.createCell(8).setCellValue(entity.getMaNh());
                }
                if (entity.getType() != null) {
                    row.createCell(9).setCellValue(entity.getType());
                }
                if (entity.getDescription() != null) {
                    row.createCell(10).setCellValue(entity.getDescription());
                }
                if (entity.getRefAccnoId() != null) {
                    row.createCell(11).setCellValue(entity.getRefAccnoId());
                }
                if (entity.getBankName() != null) {
                    row.createCell(12).setCellValue(entity.getBankName());
                }
                if (entity.getBankBranch() != null) {
                    row.createCell(13).setCellValue(entity.getBankBranch());
                }
                if (entity.getBankAddress() != null) {
                    row.createCell(14).setCellValue(entity.getBankAddress());
                }
                if (entity.getChuThe() != null) {
                    row.createCell(15).setCellValue(entity.getChuThe());
                }

            Cell statusCell = row.createCell(3);
            if(entity.getStatus() != null) {
                statusCell.setCellValue(entity.getStatus());
                if(entity.getStatus() == - 1) {
                    statusCell.setCellStyle(redStyle);
                } else if (entity.getStatus() == 0) {
                    statusCell.setCellStyle(yellowStyle);
                } else if (entity.getStatus() == 1) {
                    statusCell.setCellStyle(greenStyle);
                }
            } else {
                statusCell.setCellValue("");
            }
            }
            for(int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=books.xlsx");

            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi xuất Excel: " + e.getMessage());
        }
    }
}
