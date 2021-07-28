package com.stone.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.UUID;

@Slf4j
public class CoreUtils {

    public static final char UNDERLINE = '_';

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        log.debug("UUID {}", s);
        return s;
    }

    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    /**
     * 自动生成id
     * @return
     */
    public static synchronized Long generateId(){
        Random random = new Random();
        Integer number = random.nextInt(90000)+10000;
        return System.currentTimeMillis()+number;
    }

    /**
     * 驼峰字符串转下划线
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
