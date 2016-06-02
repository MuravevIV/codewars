package com.ilyamur.codewars.bingo_card;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BingoCard {

    private static final Logger LOG = LoggerFactory.getLogger(BingoCard.class);

    private static Random RANDOM = new Random();

    public static String[] getCard() {
        Map<Integer, Integer> misfits = new HashMap<>();
        char[] letters = new char[] {'B', 'I', 'N', 'G', 'O'};
        ArrayList<String> objects = new ArrayList<>(24);
        for (int col = 0; col < 5; col++) {
            char letter = letters[col];
            long rowCount = (letter == 'N') ? 4 : 5;
            int misfitPosition = 15 * (col + 1);
            for (int row = 0; row < rowCount; row++) {
                int numPosition = 15 * col + 1 + RANDOM.nextInt(15 - row);
                Integer numValue = getNumValue(misfits, numPosition);
                misfits.put(numPosition,  getNumValue(misfits, misfitPosition));
                LOG.info("add {}", numValue);
                objects.add(Character.toString(letter) + numValue);
                if (numValue == 58) {
                    System.out.println(numValue);
                }
                misfitPosition--;
            }
        }
        return objects.toArray(new String[24]);
    }

    private static Integer getNumValue(Map<Integer, Integer> misfits, int numPosition) {
        Integer misfitValue = misfits.get(numPosition);
        return (misfitValue != null) ? misfitValue : numPosition;
    }
}
