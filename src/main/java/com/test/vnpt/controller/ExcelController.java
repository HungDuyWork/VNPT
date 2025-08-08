package com.test.vnpt.controller;

import com.test.vnpt.service.ExcelExportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/excel")
@RequiredArgsConstructor
public class ExcelController {
    @Autowired
    private ExcelExportService excelExportService;

    @GetMapping("/export-books")
    public void exportBooks(HttpServletResponse response) {
        excelExportService.exportBooksToExcel(response);
    }
}
