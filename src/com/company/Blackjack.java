package com.company;

public class Blackjack {

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
    private final String spade = "♠";
    private int[] clovers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private final String clover = "♣";
    private int[] hearts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private final String heart = "♥";
    private int[] diamonds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private final String diamond = "♦";

    // Constructor to begin a new game as an object
    public Blackjack() {
        for(int card : spades) {
            System.out.println(card);
        }
    }

    // Resets the whole deck back to 1-14
    public void resetDeck() {
        int[] spades = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] clovers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] hearts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] diamonds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    }

    // Shuffle method that shuffles the whole deck
    /*public void shuffleAll() {


        Math.random() * (max - min + 1) + min
    }*/
}
