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
            sb.append(ch.toUpperCase());
            String lowerCaseCh = ch.toLowerCase();
            for (int j = 1; j < i + 1; j++) {
                sb.append(lowerCaseCh);
            }
        }
        return sb.toString();
    }
}
