package com.ilyamur.codewars.find_the_missing_letter;

import java.util.stream.IntStream;

public class Kata {

    public static void main(String args[]) {
        // Kata.findMissingLetter(new char[] { 'a','b','c','d','f' });
        Kata.findMissingLetter(new char[] { 'O','Q','R','S' });
    }

    public static char findMissingLetter(char[] arr) {
        return IntStream.range(0, arr.length)
                .mapToObj(i -> (int) arr[i])
                .reduce((a, b) -> (a + 1 < b) ? a : b)
                .map(n -> (char) (n + 1))
                .get();
    }
}
