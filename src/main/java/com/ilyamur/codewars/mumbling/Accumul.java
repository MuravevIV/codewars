package com.ilyamur.codewars.mumbling;

public class Accumul {

    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0) {
                sb.append('-');
            }
            String rs = new String(new char[i + 1]).replace("\0", Character.toString(chars[i]));
            sb.append(capitalize(rs));
        }
        return sb.toString();
    }

    private static String capitalize(String s) {
        String lcs = s.toLowerCase();
        return lcs.substring(0, 1).toUpperCase() + lcs.substring(1);
    }
}
