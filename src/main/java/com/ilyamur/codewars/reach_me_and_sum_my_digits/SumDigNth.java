package com.ilyamur.codewars.reach_me_and_sum_my_digits;

public class SumDigNth {

    public static long sumDigNthTerm(long initval, long[] patternl, int nthterm) {
        long acc = initval;
        for (int i = 0; i < nthterm - 1; i++) {
            acc += patternl[i % patternl.length];
        }
        return sumDigits(acc);
    }

    private static long sumDigits(long n) {
        long curr = n % 10;
        long next = n / 10;
        return (next > 0) ? curr + sumDigits(next) : curr;
    }
}
