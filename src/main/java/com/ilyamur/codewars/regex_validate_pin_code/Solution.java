package com.ilyamur.codewars.regex_validate_pin_code;

import java.util.regex.Pattern;

public class Solution {

    public static boolean validatePin(String pin) {
        return Pattern.compile("([0-9]{4})|([0-9]{6})").matcher(pin).matches();
    }

    public static boolean validatePin2(String pin) {
        return Pattern.compile("\\d{4}|\\d{6}").matcher(pin).matches();
    }

    public static boolean validatePin3(String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }
}
