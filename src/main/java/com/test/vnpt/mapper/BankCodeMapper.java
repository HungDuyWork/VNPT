package com.test.vnpt.mapper;

import java.util.Map;

public class BankCodeMapper {
    private static final Map<String, String> BANK_CODE_TO_MANH = Map.ofEntries(
            Map.entry("AGR", "05.791"), // Ngân hàng Nông nghiệp và PTNT Việt Nam
            Map.entry("BIDV", "02.13"), // NH TMCP Đầu tư và Phát triển VN
            Map.entry("EIB", "33.37"), // Ngân hàng TMCP Xuất nhập khẩu Việt Nam
            Map.entry("HDB", "35"), // Ngân hàng TMCP Phát triển TP. HCM
            Map.entry("IVB", "15.01"), // Ngân hàng TNHH Indovina
            Map.entry("LPB", "11.05"), // Ngân hàng TMCP Bưu điện Liên Việt
            Map.entry("MB", "25.21"), // Ngân hàng TMCP Quân Đội
            Map.entry("MSB", "03.21"), // Ngân hàng TMCP Hàng Hải Việt Nam
            Map.entry("SCB", "29.01"), // Ngân hàng TMCP Sài Gòn
            Map.entry("SEA", "41.09"), // Ngân hàng TMCP Đông Nam Á
            Map.entry("SHB", "28.03"), // Ngân hàng TMCP Sài Gòn - Hà Nội
            Map.entry("STB", "30.280"), // Ngân hàng TMCP Sài Gòn Thương Tín
            Map.entry("TCB", "17.09"), // Ngân hàng TMCP Kỹ thương VN
            Map.entry("TPB", "40"), // Ngân hàng TMCP Tiên Phong
            Map.entry("VCB", "04.11"), // Ngân hàng TMCP Ngoại thương Việt Nam
            Map.entry("VIB", "06.20"), // Ngân hàng TMCP Quốc tế Việt Nam
            Map.entry("VPB", "32.60"), // Ngân Hàng TMCP Việt Nam Thịnh Vượng
            Map.entry("VTB", "01.13") // Ngân hàng TMCP Công thương Việt Nam
    );

    public static String getMaNh(String bankCode) {
        return BANK_CODE_TO_MANH.get(bankCode);
    }

    public static boolean isValidBankCode(String bankCode) {
        return BANK_CODE_TO_MANH.containsKey(bankCode);
    }
}