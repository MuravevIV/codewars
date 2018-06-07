package com.ilyamur.codewars.reverse_or_rotate;

class RevRot {

    public static String revRot(String strng, int sz) {
        if (sz > strng.length()) {
            return "";
        }
        if (strng.isEmpty()) {
            return "";
        }
        if (sz < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int beginIndex = 0; beginIndex < strng.length(); beginIndex += sz) {
            int endIndex = beginIndex + sz;
            if (endIndex > strng.length()) {
                break;
            }
            String ss = strng.substring(beginIndex, endIndex);
            int sum = 0;
            for (int j = 0; j < ss.length(); j++) {
                sum += Integer.valueOf(Character.toString(ss.charAt(j)));
            }
            if (sum % 2 == 0) {
                sb.append(rev(ss));
            } else {
                sb.append(rot(ss));
            }
        }
        return sb.toString();
    }

    private static String rev(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }

    private static String rot(String s) {
        return s.substring(1) + s.charAt(0);
    }

    public static String revRot2(String strng, int sz) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = strng.length(); (i + sz < len) && (sz > 0); i += sz) {
            String ss = strng.substring(i, i + sz);
            int sum = 0;
            for (char ch : ss.toCharArray()) {
                sum += Character.getNumericValue(ch);
            }
            if (sum % 2 == 0) {
                sb.append((new StringBuilder(ss)).reverse());
            } else {
                sb.append(ss.substring(1)).append(ss.charAt(0));
            }
        }
        return sb.toString();
    }
}
