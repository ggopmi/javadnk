package com.fork.custdnk;

public class CustomUtil {
    public static String myCharsToString(char[] chs, int wordLen) {
        int len = Math.min(chs.length, wordLen);
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }
}
