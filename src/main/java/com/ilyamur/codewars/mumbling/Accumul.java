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
            String upperCaseCh = ch.toUpperCase();
            String lowerCaseCh = ch.toLowerCase();
            for (int j = 0; j < i + 1; j++) {
                sb.append((j == 0) ? upperCaseCh : lowerCaseCh);
            }
        }
        return sb.toString();
    }
}
