package com.ilyamur.codewars.bingo_card;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class BingoCard {

    private static final Logger LOG = LoggerFactory.getLogger(BingoCard.class);

    private static Random RANDOM = new Random();

    public static String[] getCard() {
        RANDOM = new Random(1);
        Set<Integer> misfits = new HashSet<>();
        char[] letters = new char[] {'B', 'I', 'N', 'G', 'O'};
        ArrayList<String> objects = new ArrayList<>(24);
        for (int col = 0; col < 5; col++) {
            char letter = letters[col];
            long rowCount = (letter == 'N') ? 4 : 5;
            int misfitPosition = 15 * (col + 1);
            for (int row = 0; row < rowCount; row++) {
                int numPosition = 15 * col + 1 + RANDOM.nextInt(15 - row);
                boolean isMisfits = misfits.contains(numPosition);
                LOG.info("{} -> {}", numPosition, isMisfits);
                Integer numValue = isMisfits ? misfitPosition : numPosition;
                if (numValue == 26) {
                    System.out.println(numValue);
                }
                LOG.info("mark {} as mistfit", numPosition);
                misfits.add(numPosition);
                LOG.info("add {}", numValue);
                objects.add(Character.toString(letter) + numValue);
                misfitPosition--;
            }
        }
        return objects.toArray(new String[24]);
    }
}
