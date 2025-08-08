package com.test.vnpt.service;

import jakarta.servlet.http.HttpServletResponse;

public interface ExcelExportService {
    void exportBooksToExcel(HttpServletResponse response);

}
