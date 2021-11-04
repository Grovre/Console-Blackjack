package com.company;

import java.util.Arrays;

public class Deck {

    private Card[] deck = new Card[52];
    private int topOfDeck = 0;

    // Constructor dynamically sets the Card[] deck array an unshuffled deck. Shuffle with shuffle() method
    public Deck() {
        for(int suit = 1; suit < 5; suit++) {
            for(int value = 1; value < 14; value++) {
                deck[(suit-1) * 13 + (value-1)] = new Card(value, suit);
            }
            System.out.println();
        }
    }

    // Shuffles the deck by taking the first Card object in the original deck and putting it into a random index, then taking the next Card object and doing the same and so on
    public void shuffle() {
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
            str.append(card.getValue()).append(card.getCardSuitString()).append(", ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 2));
        System.out.println(str);
    }

}
