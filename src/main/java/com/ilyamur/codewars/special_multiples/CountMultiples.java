package com.ilyamur.codewars.special_multiples;

import java.util.ArrayList;
import java.util.List;

public class CountMultiples {

    public static long countSpecMult(long n, long mxval) {
        Integer primesProduct = getPrimes(n).stream()
                .reduce(1, (a, b) -> a * b);
        return (mxval - 1) / primesProduct;
    }

    private static List<Integer> getPrimes(long maxCount) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int i = 1;
        while (count < maxCount) {
            i++;
            int iSqrt = (int) Math.sqrt(i);
            boolean bPrime = true;
            for (int j = 2; j <= iSqrt; j += 1) {
                if (i % j == 0) {
                    bPrime = false;
                }
            }
            if (bPrime) {
                count++;
                result.add(i);
            }
        }
        return result;
    }
}
