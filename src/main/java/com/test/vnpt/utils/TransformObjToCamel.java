package com.test.vnpt.utils;

import lombok.SneakyThrows;
import org.hibernate.transform.ResultTransformer;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformObjToCamel implements ResultTransformer {

    @SneakyThrows
    @Override
    public Object transformTuple(
            Object[] tuple,
            String[] aliases) {
        int idx = 0;
        Map<String, Object> res = new HashMap<>();
        for (Object o : tuple) {
            if (o instanceof BigDecimal) {
                BigDecimal bd = (BigDecimal) o;
                if (bd.stripTrailingZeros().scale() <= 0) o = bd.longValue();
                else o = bd.doubleValue();
            }
            if (o instanceof Clob)  o = ((Clob) o).getSubString(1, (int) ((Clob) o).length());
            res.put(convertLowerCamelCase(aliases[idx++].toLowerCase()), o);
        }
        return res;
    }

    @Override
    public List transformList(List tuples) {
        return tuples;
    }

    public static String convertLowerCamelCase(String text) {
        Pattern p = Pattern.compile("_([a-zA-Z])");
        Matcher m = p.matcher(text.toLowerCase());
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);
        return sb.toString();
    }
}

