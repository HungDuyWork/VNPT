package com.test.vnpt.mapper;

import java.util.HashMap;
import java.util.Map;

public class AccountTypeMapper {

    private static final Map<String, Integer> dbDescriptionToTypeMap = new HashMap<>();

    static {
        dbDescriptionToTypeMap.put("TKDB EU", 1);
        dbDescriptionToTypeMap.put("TKDB CTV", 2);
        dbDescriptionToTypeMap.put("TKDB MM", 3);
        dbDescriptionToTypeMap.put("TK THCH", 4);
        dbDescriptionToTypeMap.put("TK IBFT", 5);
        dbDescriptionToTypeMap.put("TK TT", 6);
        dbDescriptionToTypeMap.put("TKDB DN", 7);
        dbDescriptionToTypeMap.put("TK TG", 10);
        dbDescriptionToTypeMap.put("TKTT DV", 11);
    }

    public static Integer getTypeByDbDescription(String dbDescription) {
        return dbDescriptionToTypeMap.getOrDefault(dbDescription, 0); // Trả về 0 nếu không khớp
    }

    public static String getDbDescriptionByType(Integer type) {
        for (Map.Entry<String, Integer> entry : dbDescriptionToTypeMap.entrySet()) {
            if (entry.getValue().equals(type)) {
                return entry.getKey();
            }
        }
        return "Unknown";
    }
}
