package com.ilyamur.codewars.complementary_dna;

import java.util.Arrays;

public class DnaStrand {

    public static String makeComplement(String dna) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dna.length(); i++) {
            char ch = dna.charAt(i);
            if (ch == 'A') {
                sb.append('T');
            } else if (ch == 'T') {
                sb.append('A');
            } else if (ch == 'C') {
                sb.append('G');
            } else if (ch == 'G') {
                sb.append('C');
            }
        }
        return sb.toString();
    }
}
