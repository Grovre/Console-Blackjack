package com.company;

import java.util.Arrays;

public class Cards {

    /*
    1 = SA
    2 = S2
    3 = S3
    ...
    10 = S10
    11 = SJ
    12 = SQ
    13 = SK
    14 = CA
    15 = C2
    16 = C3
    13 cards in a deck
     */

    private int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
    25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
    /*private int[] clubs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] hearts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] diamonds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    private int[] spadesWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] clubsWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] heartsWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] diamondsWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};*/

    private final String spade = "♠";
    private final String clubs = "♣";
    private final String heart = "♥";
    private final String diamond = "♦";
    private final String joker = "J";

    private int topOfDeck = 0;

    public Cards(boolean hasJoker) {

        if(hasJoker) {
            cards = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                    25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                    50, 51, 52, 53, 54};
        }

    }

    @Override
    public String toString() {
        return "Cards{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }

    public String getSuit(int card) {
        if(card < 14) {
            return spade;
        } else if(card < 27) {
            return clubs;
        } else if(card < 40) {
            return diamond;
        } else if(card < 53) {
            return heart;
        } else {
            return joker;
        }
    }

    public void shuffle() {
        int[] shuffledDeck = new int[cards.length]; // Temporary array for shuffling
        for(int i = 0; i < cards.length; i++) { // Loops through all spades 1-13 (or 1-14 if joker) to put it into a random index in the shuffledDeck array
            int pushIndex = (int) (Math.random() * cards.length); // turns pushIndex into a random number 1-13 (or 14)
            if(shuffledDeck[pushIndex] != 0) { // Checks if shuffledDeck array index is empty
                i--;
                continue;
            }
            shuffledDeck[pushIndex] = i+1; // Pushes i into shuffledDeck at pushIndex
        }
        cards = shuffledDeck;
    }

    public int[] dealCard(int cardsToDeal) {
        int[] dealtCards = new int[cardsToDeal];
        for(int i = 0; i < cardsToDeal; i++) {
            dealtCards[i] = cards[i];
        }
        topOfDeck += cardsToDeal;
        return dealtCards;
    }

    public int dealCard() {
        topOfDeck++;
        return cards[topOfDeck--];

    }

    public int[] getCards() {
        return cards;
    }

    public void setCards(int[] newSuit) {
        cards = newSuit;
    }

}
