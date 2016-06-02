package com.ilyamur.codewars.bingo_card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BingoCard {

    private static final char[] LETTERS = new char[]{'B', 'I', 'N', 'G', 'O'};
    private static final int OFFSET = 15;
    private static Random RANDOM = new Random();

    public static String[] getCard() {
        Map<Integer, Integer> misfits = new HashMap<>();
        ArrayList<String> objects = new ArrayList<>();
        for (int col = 0; col < LETTERS.length; col++) {
            char letter = LETTERS[col];
            int misfitPos = OFFSET * (col + 1);
            long rowCount = getRowCount(letter);
            for (int row = 0; row < rowCount; row++) {
                int randomPos = OFFSET * col + 1 + RANDOM.nextInt(OFFSET - row);
                Integer number = getNumber(misfits, randomPos);
                misfits.put(randomPos, getNumber(misfits, misfitPos));
                objects.add(Character.toString(letter) + number);
                misfitPos--;
            }
        }
        return objects.toArray(new String[objects.size()]);
    }

    private static int getRowCount(char letter) {
        return (letter == 'N') ? 4 : 5;
    }

    private static Integer getNumber(Map<Integer, Integer> misfits, int numPosition) {
        Integer misfitValue = misfits.get(numPosition);
        return (misfitValue != null) ? misfitValue : numPosition;
    }
}
