package com.ilyamur.codewars.printer_errors;

public class Printer {

    public static String printerError(String s) {
        long num = s.chars().filter(ch -> ch > ((int) 'm')).count();
        return String.format("%s/%s", num, s.length());
    }

    public static String printerError2(String s) {
        long errs = s.chars().filter(ch -> ch > 'm').count();
        return errs + "/" + s.length();
    }

    public static String printerError3(String s) {
        return s.replaceAll("[a-m]", "").length() + "/" + s.length();
    }
}
