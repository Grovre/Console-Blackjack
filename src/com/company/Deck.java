package com.company;

import java.util.Arrays;

public class Deck {

    private Card[] deck = new Card[52];
    private int topOfDeck = 0;

    // Constructor dynamically sets the Card[] deck array an unshuffled deck. Shuffle with shuffle() method
    public Deck() {
        long start = System.currentTimeMillis();
        for(int suit = 1; suit < 5; suit++) {
            for(int value = 1; value < 14; value++) {
                deck[(suit-1) * 13 + (value-1)] = new Card(value, suit);
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.println("Duration to create deck dynamically: " + (end-start) + " ms");
    }

    // Shuffles the deck by taking the first Card object in the original deck and putting it into a random index, then taking the next Card object and doing the same and so on
    public void shuffle() {
        long start = System.currentTimeMillis();
        int testCount = 0;
        Card[] temp = new Card[deck.length];
        for(int i = 0; i < temp.length; i++) {
            testCount++;
            int randomIndex = (int) (Math.random() * temp.length - 0.5);
            if(temp[randomIndex] == null) {
                temp[randomIndex] = deck[i];
            } else {
                i--;
            }
        }
        System.out.println("Tested all indexes " + testCount + " times to shuffle");
        deck = temp;
        long end = System.currentTimeMillis();
        System.out.println("It took " + (end-start) + " ms to shuffle");
    }

    public Card[] getDeck() {
        return deck;
    }

    public Card getTopOfDeck() {
        topOfDeck++;
        return deck[topOfDeck-1];
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + Arrays.toString(deck) +
                '}';
    }

    // Doesn't return anything, just prints a good ol' string of the deck in order for you
    public void cleanToString() {
        StringBuilder str = new StringBuilder();
        for(Card card : deck) {
            String value;
            if(card.getValue() == 11) {
                value = "J";
            } else if(card.getValue() == 12) {
                value = "Q";
            } else if(card.getValue() == 13) {
                value = "K";
            }
            str.append(card.getValue()).append(card.showCardSuit()).append(", ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 2));
        System.out.println(str);
    }

}
