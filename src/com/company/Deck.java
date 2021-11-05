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

    // Iterates through the deck, saving the card at the iteration index and the card at a random index to their own variables. Then it swaps their indexes
    public void shuffle() {
        long start = System.currentTimeMillis();
        for(int i = 0; i < deck.length; i++) {
            int randomIndex = (int) (Math.random() * 52);
            Card card1 = deck[i];
            Card card2 = deck[randomIndex];
            deck[i] = card2;
            deck[randomIndex] = card1;
        }
        long end = System.currentTimeMillis();
        System.out.println("It took " + (end-start) + " ms to shuffle");
        cleanToString();
    }

    @Deprecated
    // Old shuffling method, almost 8 times slower (30/4)
    public void oldShuffle() {
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
        cleanToString();
    }

    public Card[] getDeck() {
        return deck;
    }

    // Top of deck is only used as a way to deal cards, shouldn't need to be called that much if any
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
            str.append(card.showValue()).append(card.showCardSuit()).append(", ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 2));
        System.out.println(str);
    }

}
