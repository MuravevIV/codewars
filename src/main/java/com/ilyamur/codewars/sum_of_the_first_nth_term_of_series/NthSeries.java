package com.ilyamur.codewars.sum_of_the_first_nth_term_of_series;

import java.text.DecimalFormat;

public class NthSeries {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    public static String seriesSum(int n) {
        double nn = 0.0;
        for (int i = 0; i < n; i++) {
            nn += 1.0 / (i * 3 + 1);
        }
        return DECIMAL_FORMAT.format(nn);
    }

    public static String seriesSum2(int n) {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (i * 3 + 1);
        }
        return String.format("%.2f", sum);
    }
}
