package com.company;

import java.util.Arrays;

public class Cards {

    /*
    1 = A
    2 = 2
    3 = 3
    ...
    10 = 10
    11 = J
    12 = Q
    13 = K
     */

    private int[] spades = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] clovers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] hearts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] diamonds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    private int[] spadesWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] cloversWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] heartsWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] diamondsWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    private final String spade = "♠";
    private final String clover = "♣";
    private final String heart = "♥";
    private final String diamond = "♦";

    public Cards(boolean hasJoker) {

        if(hasJoker) {
            spades = spadesWithJoker;
            clovers = cloversWithJoker;
            hearts = heartsWithJoker;
            diamonds = diamondsWithJoker;
        }

    }

    @Override
    public String toString() {
        return "Cards{" +
                "spades=" + Arrays.toString(spades) +
                ", clovers=" + Arrays.toString(clovers) +
                ", hearts=" + Arrays.toString(hearts) +
                ", diamonds=" + Arrays.toString(diamonds) +
                ", spadesWithJoker=" + Arrays.toString(spadesWithJoker) +
                ", cloversWithJoker=" + Arrays.toString(cloversWithJoker) +
                ", heartsWithJoker=" + Arrays.toString(heartsWithJoker) +
                ", diamondsWithJoker=" + Arrays.toString(diamondsWithJoker) +
                ", spade='" + spade + '\'' +
                ", clover='" + clover + '\'' +
                ", heart='" + heart + '\'' +
                ", diamond='" + diamond + '\'' +
                '}';
    }



}
