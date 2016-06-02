package com.ilyamur.codewars.mumbling;

public class Accumul {

    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0) {
                sb.append('-');
            }
            String ch = Character.toString(chars[i]);
            for (int j = 0; j < i + 1; j++) {
                sb.append((j == 0) ? ch.toUpperCase() : ch.toLowerCase());
            }
        }
        return sb.toString();
    }
}
